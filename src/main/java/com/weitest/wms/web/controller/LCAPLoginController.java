package com.weitest.wms.web.controller;

import com.weitest.wms.domain.enumeration.UserStatusEnumEnum;
import com.weitest.wms.web.ApiReturn;
import com.weitest.wms.iam.auth.AuthManager;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netease.cloud.nuims.auth.api.IAuthService;
import com.netease.cloud.nuims.auth.api.bean.AuthInfo;
import com.netease.cloud.nuims.auth.api.exception.AuthDisabledAccountException;
import com.netease.cloud.nuims.auth.api.exception.AuthException;
import com.netease.cloud.nuims.auth.api.exception.AuthIncorrectCredentialsException;
import com.netease.cloud.nuims.auth.api.exception.AuthUnknownAccountException;
import com.netease.cloud.nuims.auth.common.constants.Constants;
import com.netease.cloud.nuims.auth.domain.authen.AuthService;
import com.netease.cloud.nuims.auth.domain.authen.NormalAuthService;
import com.netease.cloud.nuims.auth.domain.authen.TokenService;
import com.netease.cloud.nuims.auth.domain.limit.security.AesPasswordHandler;
import com.netease.cloud.nuims.plugin.starter.PluginConfigProperties;
import com.netease.cloud.nuims.user.api.IUserService;
import com.netease.cloud.nuims.user.api.bean.UserQueryDTO;
import com.netease.cloud.nuims.user.api.bean.UserResultDTO;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;


/**
 * auto generate LCAPLoginController
 *
 * @author sys
 * 
 */
@RestController
@RequestMapping("api/system")
public class LCAPLoginController {
    private ObjectMapper objectMapper = new ObjectMapper();
    private final Logger log = LoggerFactory.getLogger(LCAPLoginController.class);
    @Resource
    private PluginConfigProperties pluginConfigProperties;
    @Resource
    private AuthService authService;
    @Resource
    private TokenService tokenService;
    @Resource
    private AuthManager authManager;
    /**
     * 已开启的认证方式
     */
    public String authTypes = "Normal";
    @Resource
    private IUserService userService;
    @Resource
    private AesPasswordHandler aesPasswordHandler;

    /**
     * 获取认证相关参数
     * @return
     * @throws AuthException
     */
    @GetMapping("getAppLoginTypes")
    public ApiReturn getAppLoginTypes() throws AuthException {
        Map<String, PluginConfigProperties.Plugin> unionAuthTypes = this.pluginConfigProperties.getList();
        //取出插件配置
        Iterator<String> pluginIterator = unionAuthTypes.keySet().iterator();
        while (pluginIterator.hasNext()) {
            String pluginName = pluginIterator.next();
            PluginConfigProperties.Plugin plugin = this.pluginConfigProperties.getList().get(pluginName);
            if (authService.containService(pluginName)) {
                Map<String, String> pluginConfigMap = plugin.getConfig();
                String authJsUrl = pluginConfigMap.get("authJsUrl");
                IAuthService pluginAuthService = authService.getPluginAuthService(pluginName, pluginConfigMap);
                //如果插件认证方式，则需要取出authPageUrl地址返回
                if (Objects.nonNull(pluginAuthService) && StringUtils.isNotEmpty(pluginAuthService.getAuthPageUrl())) {
                    pluginConfigMap.put("authPageUrl", pluginAuthService.getAuthPageUrl());
                    pluginConfigMap.put("authJsUrl", authJsUrl);
                }
            } else {
                log.error("LoginType={}, not found", pluginName);
            }
        }
        //开启的认证方式
        String[] alreadyOpenAuthTypes = authTypes.split(",");
        for (int i = 0; i < alreadyOpenAuthTypes.length; i++) {
            String authType = alreadyOpenAuthTypes[i];
            unionAuthTypes.putIfAbsent(authType, null);
        }
        return ApiReturn.of(unionAuthTypes, HttpStatus.OK.value());
    }

    /**
     * 认证统一入口
     *
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping("login")
    public ResponseEntity<ApiReturn> login(HttpServletRequest request) throws IOException {
        String requestBodyJson = IOUtils.toString(request.getInputStream(), Charset.defaultCharset());
        Map<String, String> parameterMap = objectMapper.readValue(requestBodyJson, new TypeReference<Map<String, String>>() {});
        // 认证类型
        String loginType = parameterMap.get("LoginType");
        if (StringUtils.isEmpty(loginType)) {
            return new ResponseEntity<>(ApiReturn.of("", HttpStatus.BAD_REQUEST.value(), "LoginType is missing"), HttpStatus.FORBIDDEN);
        }
        try {
            if (NormalAuthService.NAME.equals(loginType)) {
                //组装Normal认证方式参数
                String userName = parameterMap.get(NormalAuthService.KEY_USERNAME);
                if(StringUtils.isEmpty(userName)){
                    return new ResponseEntity<>(ApiReturn.of("", HttpStatus.BAD_REQUEST.value(), "Normal LoginType UserName missing"), HttpStatus.FORBIDDEN);
                }
                UserQueryDTO queryDTO = new UserQueryDTO();
                queryDTO.setUserName(userName);
                queryDTO.setSource(loginType);
                UserResultDTO userResultDTO = userService.getUser(queryDTO);
                if(Objects.isNull(userResultDTO)){
                     throw new AuthUnknownAccountException("UserName or Password");
                }
                if (!UserStatusEnumEnum.FIELD_Normal.getCode().equals(userResultDTO.getStatus())) {
                    log.error("用户状态非法...");
                    return new ResponseEntity<>(
                            ApiReturn.of("", HttpStatus.FORBIDDEN.value(), "AuthDisabledAccount"),
                            HttpStatus.FORBIDDEN);
                }
                parameterMap.put(NormalAuthService.ENCRYPT_PASSWORD, userResultDTO.getPassword());
            }else {
                //解密密码
                if(parameterMap.containsKey(NormalAuthService.KEY_PASSWORD)){
                    parameterMap.put(NormalAuthService.KEY_PASSWORD,aesPasswordHandler.decrypt(parameterMap.get(NormalAuthService.KEY_PASSWORD)));
                }
            }
            AuthInfo authInfo = authService.auth(request, loginType, parameterMap);
            UserResultDTO userResultDTO = handleAuthInfo2LCAPUser(authInfo,loginType);
            HttpHeaders httpHeaders =generatorHttpHeaders(authInfo, loginType, userResultDTO.getUserId(),userResultDTO.getUserName());
            return new ResponseEntity<>(ApiReturn.of(userResultDTO, HttpStatus.OK.value()), httpHeaders, HttpStatus.OK);
        } catch (AuthException e) {
            return handleAuthException(e);
        } catch (Exception e) {
            log.error("Error: {}", ExceptionUtils.getStackTrace(e));
            return new ResponseEntity<>(ApiReturn.of("", HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()), HttpStatus.FORBIDDEN);
        }
    }

    private UserResultDTO handleAuthInfo2LCAPUser(AuthInfo authInfo, String loginType) throws AuthException {
        UserQueryDTO queryDTO = wrapperQueryDTO(authInfo,loginType);
        UserResultDTO userResultDTO = userService.getUser(queryDTO);
        if (Objects.nonNull(userResultDTO)) { // 如果存在，则更新用户信息
            if (!UserStatusEnumEnum.FIELD_Normal.getCode().equals(userResultDTO.getStatus())) {
                log.error("用户状态非法...");
                throw new AuthDisabledAccountException("AuthDisabledAccount");
            }
            userService.updateUser(queryDTO);
        } else { //如果不存在，则插入该用户信息
            //userId 为 （username + source） 的联合体，隔离多认证源同账户的冲突，全局唯一
            queryDTO.setUserId(DigestUtils.md5DigestAsHex((authInfo.getUserName() + loginType).getBytes()));
            queryDTO.setDisplayName(authInfo.getDisplayName());
            queryDTO.setUserName(authInfo.getUserName());
            userResultDTO = userService.addUser(queryDTO);
        }
        return userResultDTO;
    }

    private UserQueryDTO wrapperQueryDTO(AuthInfo authInfo,String loginType) {
        //插入用户
        UserQueryDTO queryDTO = new UserQueryDTO();
        queryDTO.setUserName(authInfo.getUserName());
        queryDTO.setSource(loginType);
        //是否需要关联认证源
        String linkAuthType = authService.getExtendInfo(authInfo, AuthService.LINK_AUTH_TYPE);
        if (StringUtils.isNotEmpty(linkAuthType)) {
            loginType = linkAuthType;
            queryDTO.setSource(loginType);
        }
        return queryDTO;
    }

    private HttpHeaders generatorHttpHeaders(AuthInfo authInfo,String loginType,String userId,String userName){
        //覆盖Token时间
        long expireTime = tokenService.getExpireTime();
        String expireTimeStr = authService.getExtendInfo(authInfo, AuthService.ENTERPRISE_SESSION_TOKNE_EXPIRE);
        if (StringUtils.isNotEmpty(expireTimeStr) && StringUtils.isNumeric(expireTimeStr)) {
            expireTime = Long.parseLong(expireTimeStr);
        }
        String token = tokenService.generateUserToken(loginType, userId,userName, expireTime,false, authInfo.getAuthParam());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(Constants.AUTHENTICATION_HEADER, token);
        return httpHeaders;
    }


    private ResponseEntity handleAuthException(Exception e){
        String errMessage = e.getMessage();
        errMessage = UserLoginFriendlyTips.replace(errMessage);
        log.error("Error: {}",errMessage);
        if (e instanceof AuthDisabledAccountException) {
            return new ResponseEntity<>(ApiReturn.of("", HttpStatus.FORBIDDEN.value(), errMessage), HttpStatus.FORBIDDEN);
        } else if (e instanceof AuthUnknownAccountException) {
            return new ResponseEntity<>(ApiReturn.of("", HttpStatus.FORBIDDEN.value(), errMessage), HttpStatus.FORBIDDEN);
        } else if (e instanceof AuthIncorrectCredentialsException) {
            return new ResponseEntity<>(ApiReturn.of("", HttpStatus.FORBIDDEN.value(), errMessage), HttpStatus.FORBIDDEN);
        } else {
            return new ResponseEntity<>(ApiReturn.of("", HttpStatus.INTERNAL_SERVER_ERROR.value(), errMessage), HttpStatus.FORBIDDEN);
        }
    }

    /**
      * 注销
      *
      * @return
      * @throws AuthException
    */
    @GetMapping("logout")
    public ResponseEntity<ApiReturn> logout(HttpServletRequest request, HttpServletResponse response){
        List<com.weitest.wms.iam.auth.AuthService> matchedAuthServiceList = authManager.getAuthService(request);
        if (CollectionUtils.isNotEmpty(matchedAuthServiceList)) {
            for (int i = 0; i < matchedAuthServiceList.size(); i++) {
                com.weitest.wms.iam.auth.AuthService authService = matchedAuthServiceList.get(i);
                try {
                    authService.clearSession(request,response);
                } catch (Exception e) {
                    log.error("Error: {}", e.getMessage());
                    return new ResponseEntity<>(ApiReturn.of("", HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()), HttpStatus.FORBIDDEN);
                }
            }
        }
        return new ResponseEntity<>(ApiReturn.of("", HttpStatus.OK.value()), HttpStatus.OK);
    }

    enum UserLoginFriendlyTips {
        USERNAME_PWD_ERR("UserName or Password","账号或密码错误"),
        ACCOUNT_LOCK("account is locked!!!","账号被锁定，请稍后再试");
        String raw;
        String dest;
        UserLoginFriendlyTips(String raw, String dest){
            this.raw = raw;
            this.dest= dest;
        }
        public static String replace(String raw){
            UserLoginFriendlyTips[] tips = values();
            for (int i = 0; i < tips.length; i++) {
                UserLoginFriendlyTips t = tips[i];
                if(t.raw.equals(raw)) {
                    return t.dest;
                }
            }
            return raw;
        }
    }
}