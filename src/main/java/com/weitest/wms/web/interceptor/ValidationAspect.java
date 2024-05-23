package com.weitest.wms.web.interceptor;

import com.weitest.wms.exception.HttpCodeException;
import com.weitest.wms.util.JacksonUtils;
import com.weitest.wms.web.validation.Validation;
import com.weitest.wms.web.validation.ValidationRule;
import com.weitest.wms.web.validation.ValidationRuleGroup;
import com.weitest.wms.web.validation.Validator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);
    private static final String CALL_LOGIC_UUID_HEADER = "lcap-calllogic-uuid";
    private static final Map<String, List<Validator>> validatorCache = new ConcurrentHashMap<>();

    @Pointcut(
            "@annotation(com.weitest.wms.web.validation.Validation)"
    )
    public void validatePointcut() {
        // Method is empty as this is just a Pointcut, the implementations are in the advices.
    }

    @Around("validatePointcut()")
    public Object validateAround(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        if (null == methodSignature.getParameterNames() || methodSignature.getParameterNames().length == 0) {
            LOGGER.info("no parameter need to be validated for method: {}",
                    methodSignature.getDeclaringType() + "." + methodSignature.getMethod().getName() + "()");
            return joinPoint.proceed();
        }

        Validation validation = methodSignature.getMethod().getDeclaredAnnotation(Validation.class);
        ValidationRuleGroup[] validationRuleGroups = validation.value();

        if (null == validationRuleGroups || validationRuleGroups.length == 0) {
            return joinPoint.proceed();
        }

        String callLogicUuid = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest().getHeader(CALL_LOGIC_UUID_HEADER);

        ValidationRuleGroup matchedValidationRuleGroup = searchMatchRuleGroup(validationRuleGroups, callLogicUuid);

        if (null == matchedValidationRuleGroup) {
            throw new HttpCodeException(400, "invalid request");
        }

        Map<String, Object> params = new HashMap<>(joinPoint.getArgs().length);
        for (int i = 0; i < methodSignature.getParameterNames().length; i++) {
            params.put(methodSignature.getParameterNames()[i], joinPoint.getArgs()[i]);
        }

        List<Validator> validators = validatorCache.get(matchedValidationRuleGroup.value());
        if (null != validators) {
            for (Validator validator : validators) {
                if (!validator.validate(params)) {
                    throw new HttpCodeException(400, validator.errorMsg(params));
                }
            }
        } else {
            validateAndCache(matchedValidationRuleGroup, params);
        }

        return joinPoint.proceed();
    }

    private ValidationRuleGroup searchMatchRuleGroup(ValidationRuleGroup[] validationRuleGroups, String callLogicUuid) {
        for (ValidationRuleGroup validationRuleGroup : validationRuleGroups) {
            String requireUuid = validationRuleGroup.value();
            if (StringUtils.isEmpty(requireUuid) || requireUuid.equals(callLogicUuid)) {
                // requireUuid empty for rest api
                return validationRuleGroup;
            }
        }

        return null;
    }

    private void validateAndCache(ValidationRuleGroup matchedValidationRuleGroup, Map<String, Object> params) {
        List<Validator> validators = new ArrayList<>(matchedValidationRuleGroup.rules().length);
        for (ValidationRule validationRule : matchedValidationRuleGroup.rules()) {
            Map<String, Object> argvMap = Collections.EMPTY_MAP;
            if (!StringUtils.isEmpty(validationRule.argvs())) {
                argvMap = JacksonUtils.fromJson(validationRule.argvs(), Map.class);
            }

            Validator validator = new Validator.ValidationRuleBuilder(validationRule.value())
                    .withTarget(validationRule.targetName())
                    .withArgument(argvMap)
                    .withErrorMsg(validationRule.errorMsg())
                    .build();
            validators.add(validator);

            boolean isSuccess = true;
            try {
                isSuccess = validator.validate(params);
            } catch (Exception e) {
                LOGGER.error("validate error", e);
                throw new HttpCodeException(400, validator.errorMsg(params));
            }

            if (!isSuccess) {
                throw new HttpCodeException(400, validator.errorMsg(params));
            }
        }

        validatorCache.putIfAbsent(matchedValidationRuleGroup.value(), validators);
    }
}
