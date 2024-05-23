package com.weitest.wms.web.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weitest.wms.config.Constants;
import com.weitest.wms.context.UserContext;
import com.weitest.wms.domain.enumeration.ErrorCodeEnum;
import com.weitest.wms.service.system.UserServiceFactory;
import com.weitest.wms.util.FileUploadUtils;
import com.weitest.wms.web.ApiReturn;
import com.netease.cloud.nuims.auth.api.bean.AuthInfo;
import com.netease.cloud.nuims.auth.domain.authen.AuthService;
import com.netease.cloud.nuims.plugin.starter.PluginConfigProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class AuthFilter implements Filter {
    private final Logger log = LoggerFactory.getLogger(AuthFilter.class);
    private AntPathMatcher matcher = new AntPathMatcher();
    private ObjectMapper objectMapper = new ObjectMapper();
    private List<String> apis = new ArrayList<String>();
    private List<Pattern> patterns = new ArrayList<>();
    private MessageSource messageSource;
    private UserServiceFactory userServiceFactory;
    private AuthService authService;
    private PluginConfigProperties pluginConfigProperties;

    private static final String NORMAL_LOGIN_TYPE = "Normal";

    public AuthFilter(List<String> noAuthPaths, MessageSource messageSource, UserServiceFactory userServiceFactory, AuthService authService, PluginConfigProperties pluginConfigProperties) {
        noAuthPaths2Pattern(noAuthPaths);
        this.userServiceFactory = userServiceFactory;
        this.messageSource = messageSource;
        this.authService = authService;
        this.pluginConfigProperties = pluginConfigProperties;
    }

    private String match(String callPath) {
        for (String api : apis) {
            if (api.equals(callPath)) {
                return api;
            }
        }
        for (String api : apis) {
            if (matcher.match(api, callPath)) {
                return api;
            }
        }
        return null;
    }

    private void noAuthPaths2Pattern(List<String> noAuthPaths) {
        for (String noAuthPathAndMethod : noAuthPaths) {
            // 处理以/id结尾的通用路径场景 /api/get/id:GET   -->  /api/get/[0-9a-zA-Z]+:GET
            if (noAuthPathAndMethod.contains(Constants.AUTH_FILTER_ID_SUFFIX)) {
                noAuthPathAndMethod = noAuthPathAndMethod.replace(Constants.AUTH_FILTER_ID_SUFFIX, "/[0-9a-zA-Z]+:");
            }
            Pattern pattern = Pattern.compile(noAuthPathAndMethod);
            patterns.add(pattern);
        }
    }

    /**
     * 一些登录用的系统接口是不需要白名单鉴权的
     **/
    private boolean isSystemApiPath(String path) {
        return null != path && (path.equals("/api/system") || path.startsWith("/api/system/"));
    }

    private boolean isAuthInterfacePathStartWithApi(String path, String method) {
        if (StringUtils.isEmpty(path) || !path.startsWith(Constants.AUTH_API_PREFIX)
                || path.startsWith(Constants.AUTH_FILTER_API_PROCESS)) {
            return false;
        }

        for (Pattern pattern : patterns) {
            if (pattern.matcher(path + ":" + method).matches()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void init(FilterConfig filterConfig) {
        log.info("init auth filter ...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String path = request.getRequestURI();
        String contextPath = request.getContextPath();
        path = path.substring(contextPath.length());
        String method = request.getMethod().toUpperCase();
        if (!Objects.isNull(UserContext.getIfRemoteUserCenter()) && UserContext.getIfRemoteUserCenter()) {
            if (path.startsWith(Constants.AUTH_API_PREFIX) && Objects.isNull(UserContext.getCurrentUserInfo())) {
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.setContentType(Constants.AUTH_FILTER_HEADER_CONTENT_TYPE);
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                ApiReturn<Object> apiReturn = ApiReturn.of("", HttpStatus.UNAUTHORIZED.value(), ErrorCodeEnum.TOKEN_INVALID.code);
                response.getWriter().write(objectMapper.writeValueAsString(apiReturn));
                return;
            }
        } else if (isAuthInterfacePathStartWithApi(path, method) && !isSystemApiPath(path)) {
            // 以/api开头的路径
            // 检验用户是否登录或Token校验不通过
            if (isUserNotLogin(request)) {
                processNotLoginResponse(path, servletResponse);
                return;
            }
        } else if (FileUploadUtils.isUploadApiPath(path, method)) {
            if (FileUploadUtils.shouldAccessControl(path) && isUserNotLogin(request)) {
                // 访问上传的文件，如果文件是需要登录才能访问的则需要鉴权，鉴权不通过返回默认错误提示图片
                servletRequest.setAttribute(Constants.ERROR_ATTR_PIC, "/file-no-auth.png");
                request.getRequestDispatcher("/error").forward(servletRequest, servletResponse);
                return;
            }

            if (FileUploadUtils.isPathExpiration(path)) {
                // 访问上传的文件，如果文件已过期则返回默认的错误图片
                servletRequest.setAttribute(Constants.ERROR_ATTR_PIC, "/file-expiration.png");
                request.getRequestDispatcher("/error").forward(servletRequest, servletResponse);
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean isUserNotLogin(HttpServletRequest servletRequest) {
        String accessToken = servletRequest.getHeader(Constants.AUTH_FILTER_HEADER_AUTHORIZATION);
        if (StringUtils.isEmpty(accessToken)) {
            // get from cookie if header not exist
            Cookie[] cookies = servletRequest.getCookies();
            if (null != cookies) {
                for (Cookie cookie : cookies) {
                    if (Constants.AUTH_FILTER_HEADER_AUTHORIZATION.equalsIgnoreCase(cookie.getName())) {
                        accessToken = cookie.getValue();
                        break;
                    }
                }
            }
        }
        return Objects.isNull(UserContext.getCurrentUserInfo()) ||
                !userServiceFactory.getTargetService().verifyWrapperToken(servletRequest, accessToken);
    }

    private void processNotLoginResponse(String path, ServletResponse servletResponse) throws IOException {
        if (path.startsWith("/api/user/system/getUser")) {
            processNotLoginResponseV2(servletResponse);
        } else {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.setContentType(Constants.AUTH_FILTER_HEADER_CONTENT_TYPE);
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            ApiReturn<Object> apiReturn = ApiReturn.of("", HttpStatus.UNAUTHORIZED.value(),
                    messageSource.getMessage(ErrorCodeEnum.NO_PERMISSION_ACCESS_RESOURCE.code,
                            null, ErrorCodeEnum.NO_PERMISSION_ACCESS_RESOURCE.code, LocaleContextHolder.getLocale()));
            response.getWriter().write(objectMapper.writeValueAsString(apiReturn));
        }
    }

    private void processNotLoginResponseV2(ServletResponse servletResponse) throws IOException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setContentType(Constants.AUTH_FILTER_HEADER_CONTENT_TYPE);
        response.setStatus(HttpStatus.OK.value());
        response.getWriter().write("");
    }

    @Override
    public void destroy() {
        log.info("destroy auth filter ...");
    }

}