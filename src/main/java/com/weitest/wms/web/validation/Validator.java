package com.weitest.wms.web.validation;

import com.weitest.wms.util.CommonFunctionUtil;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.*;
import com.weitest.wms.exception.HttpCodeException;
import com.weitest.wms.util.JacksonUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 验证规则
 */
public class Validator {
    private static final Map<String, ValidationRuleDeclare> ALL_VALIDATION_RULES = new HashMap();
    private static final Map<String, AviatorPattern> PATTERN_CACHE = new ConcurrentHashMap<>();

    static {
        registerFunctions();

        ALL_VALIDATION_RULES.put("required", new ValidationRuleDeclare("{target} != nil", "{target}不能为空"));
        ALL_VALIDATION_RULES.put("filled", new ValidationRuleDeclare("{target} != nil && string.length(string.trim(str({target}))) > 0", "{target}不能为空且字符串不能全为空格"));
        ALL_VALIDATION_RULES.put("notEmpty", new ValidationRuleDeclare("!is_empty({target})", "{target}不能为空"));
        ALL_VALIDATION_RULES.put("empty", new ValidationRuleDeclare("{target} == nil || is_empty({target})", "{target}必须为空"));

        ALL_VALIDATION_RULES.put("max", new ValidationRuleDeclare("{target} == nil || {target}<=max", "{target}不能超过max"));
        ALL_VALIDATION_RULES.put("min", new ValidationRuleDeclare("{target} == nil || {target}>=min", "{target}不能小于min"));
        ALL_VALIDATION_RULES.put("range", new ValidationRuleDeclare("{target} == nil || ({target}>=min && {target}<=max)", "{target}必须在min和max之间"));
        ALL_VALIDATION_RULES.put("maxLength", new ValidationRuleDeclare("{target} == nil || count({target}) <= max", "{target}的长度不能超过max"));
        ALL_VALIDATION_RULES.put("minLength", new ValidationRuleDeclare("{target} == nil || count({target}) >= min", "{target}的长度不能小于min"));
        ALL_VALIDATION_RULES.put("rangeLength", new ValidationRuleDeclare("{target} == nil || (count({target}) <= max && count({target}) >= min)", "{target}的长度必须在min和max之间"));

        // is是浅层比较(引用比较)  equasl是深层比较(值比较) confirmed和equals一样
        ALL_VALIDATION_RULES.put("is", new ValidationRuleDeclare("{target} == nil || {target} == arg", "{target}必须等于arg"));
        ALL_VALIDATION_RULES.put("isNot", new ValidationRuleDeclare("{target} == nil || {target} != arg", "{target}不能等于arg"));
        ALL_VALIDATION_RULES.put("equals", new ValidationRuleDeclare("{target} == nil || equals({target}, arg)", "{target}必须等于arg"));
        ALL_VALIDATION_RULES.put("notEquals", new ValidationRuleDeclare("{target} == nil || !equals({target}, arg)", "{target}不能等于arg"));
        ALL_VALIDATION_RULES.put("confirmed", new ValidationRuleDeclare("{target} == nil || equals({target}, arg)", "{target}必须等于arg"));

        // includes、excludes是集合子集，included、excluded是判断集合中是否存在某一项
        ALL_VALIDATION_RULES.put("includes", new ValidationRuleDeclare("{target} == nil || count(filter({target}, lambda(e)->include(args, e) end)) == count({target})", "{target}有元素不在列表args里"));
        ALL_VALIDATION_RULES.put("excludes", new ValidationRuleDeclare("{target} == nil || count(filter({target}, lambda(e)->include(args, e) end)) == 0", "{target}有元素在列表args里"));
        ALL_VALIDATION_RULES.put("included", new ValidationRuleDeclare("{target} == nil || include(args, {target})", "{target}不在列表项里"));
        ALL_VALIDATION_RULES.put("excluded", new ValidationRuleDeclare("{target} == nil || !include(args, {target})", "{target}不能存在列表项里"));
        ALL_VALIDATION_RULES.put("unique", new ValidationRuleDeclare("{target} == nil || !include(arr, {target})", "{target}必须唯一"));
        ALL_VALIDATION_RULES.put("noDuplicates", new ValidationRuleDeclare("{target} == nil || is_distinct({target})", "{target}不能存在重复值"));

        ALL_VALIDATION_RULES.put("string", new ValidationRuleDeclare("{target} == nil || is_a({target}, String)", "{target}必须是字符串类型"));
        ALL_VALIDATION_RULES.put("number", new ValidationRuleDeclare("{target} == nil || is_a({target}, Number)", "{target}必须是数字"));
        ALL_VALIDATION_RULES.put("numeric", new ValidationRuleDeclare("{target} == nil || is_a({target}, Number) || (true == noSymbols ? {target}=~/\\w+?/ : {target}=~/[-|+]?\\w+(\\.\\w+)?/)", "{target}必须是数字"));
        ALL_VALIDATION_RULES.put("integer", new ValidationRuleDeclare("{target} == nil || is_a({target}, Integer) || is_a({target}, Long)", "{target}必须是整数"));
        // todo force,digits
        ALL_VALIDATION_RULES.put("decimal", new ValidationRuleDeclare("{target} == nil || is_a({target}, Double) || is_a({target}, Float) || is_a({target}, java.math.BigDecimal)", "{target}必须是小数"));
        ALL_VALIDATION_RULES.put("boolean", new ValidationRuleDeclare("{target} == nil || is_a({target}, Boolean)", "{target}必须是布尔值"));
        ALL_VALIDATION_RULES.put("function", new ValidationRuleDeclare("{target} == nil || is_a({target}, java.util.function.Function)", "{target}必须是函数"));
        ALL_VALIDATION_RULES.put("array", new ValidationRuleDeclare("{target} == nil || is_a({target}, java.util.List)", "{target}必须是数组"));
        // todo 下面两个object的不知道啥意思
        ALL_VALIDATION_RULES.put("object", new ValidationRuleDeclare("{target} == nil || is_a({target}, Object)", "{target}必须是对象"));
        ALL_VALIDATION_RULES.put("plainObject", new ValidationRuleDeclare("{target} == nil || is_a({target}, Object)", "{target}必须是简单对象"));
        ALL_VALIDATION_RULES.put("alpha", new ValidationRuleDeclare("{target} == nil || {target}=~/[a-zA-Z]+/", "{target}必须是字母组成"));
        ALL_VALIDATION_RULES.put("alphaDash", new ValidationRuleDeclare("{target} == nil || {target}=~/[a-zA-Z_]+/", "{target}必须是字母或下划线组成"));
        ALL_VALIDATION_RULES.put("alphaNumDash", new ValidationRuleDeclare("{target} == nil || {target}=~/[0-9a-zA-Z_]+/", "{target}必须是字母、数字或下划线组成"));
        ALL_VALIDATION_RULES.put("alphaSpaces", new ValidationRuleDeclare("{target} == nil || {target}=~/[a-zA-Z\\s]+/", "{target}必须是字母或空格组成"));
        ALL_VALIDATION_RULES.put("lowerCase", new ValidationRuleDeclare("{target} == nil || string.case({target}, 'lower') == {target}", "{target}必须全小写"));
        ALL_VALIDATION_RULES.put("upperCase", new ValidationRuleDeclare("{target} == nil || string.case({target}, 'upper') == {target}", "{target}必须全小写"));
        ALL_VALIDATION_RULES.put("without--", new ValidationRuleDeclare("{target} == nil || !string.contains({target}, '--')", "{target}不能包括--"));
        ALL_VALIDATION_RULES.put("without__", new ValidationRuleDeclare("{target} == nil || !string.contains({target}, '__')", "{target}不能包括__"));

        // 字符串格式判断
        ALL_VALIDATION_RULES.put("email", new ValidationRuleDeclare("{target} == nil || {target}=~/^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$/", "{target}必须是邮箱"));
        ALL_VALIDATION_RULES.put("ip", new ValidationRuleDeclare("{target} == nil || {target}=~/^((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)/ " +
                "|| {target}=~/^([\\da-fA-F]{1,4}:){7}[\\da-fA-F]{1,4}|:((:[\\da−fA−F]1,4)1,6|:)/", "{target}必须是ip"));
        ALL_VALIDATION_RULES.put("port", new ValidationRuleDeclare("{target} == nil || is_a({target}, Integer) || is_a({target}, Long) || {target}=~/\\w+/", "{target}必须是合法端口"));
        ALL_VALIDATION_RULES.put("halfWidth", new ValidationRuleDeclare("{target} == nil || {target}=~/[\\x00-\\xff]+/", "{target}必须是半角"));
        ALL_VALIDATION_RULES.put("fullWidth", new ValidationRuleDeclare("{target} == nil || {target}=~/[^\\x00-\\xff]+/", "{target}必须是全角"));
        ALL_VALIDATION_RULES.put("macAddress", new ValidationRuleDeclare("{target} == nil || {target}=~/^([0-9a-fA-F]{2}:){5}[0-9a-fA-F]{2}$/", "{target}必须是mac地址"));
        ALL_VALIDATION_RULES.put("ascii", new ValidationRuleDeclare("{target} == nil || {target}=~/[\\x00-\\x7f]+/", "{target}必须是ascii"));
        ALL_VALIDATION_RULES.put("base64", new ValidationRuleDeclare("{target} == nil || {target}=~/^([A-Za-z0-9+\\x2f]{4})*([A-Za-z0-9+\\x2f]{4}|[A-Za-z0-9+\\x2f]{3}=|[A-Za-z0-9+\\x2f]{2}==)$/", "{target}必须是base64编码"));
        ALL_VALIDATION_RULES.put("byteLength", new ValidationRuleDeclare("{target} == nil || byteLength = string.byteLength({target}); byteLength <= max && byteLength >= min", "{target}字节数必须在min和max之间"));
        ALL_VALIDATION_RULES.put("dataURI", new ValidationRuleDeclare("{target} == nil || {target}=~/^([A-Za-z0-9+\\x2f]{4})*([A-Za-z0-9+\\x2f]{4}|[A-Za-z0-9+\\x2f]{3}=|[A-Za-z0-9+\\x2f]{2}==)$/", "{target}必须满足dataURI格式"));
        ALL_VALIDATION_RULES.put("divisibleBy", new ValidationRuleDeclare("{target} == nil || {target} % divisor == 0", "{target}必须能被divisor整除"));

        // 编码判断
        ALL_VALIDATION_RULES.put("hash", new ValidationRuleDeclare("{target} == nil || {target}=~hashPattern(algorithm)", "{target}必须符合algorithm算法编码格式"));
        ALL_VALIDATION_RULES.put("md5", new ValidationRuleDeclare("{target} == nil || {target}=~/^[a-fA-F0-9]{32}$/", "{target}必须符合md5编码格式"));
        ALL_VALIDATION_RULES.put("hex", new ValidationRuleDeclare("{target} == nil || {target}=~/^(0x)?[A-Fa-f0-9]+$/", "{target}必须符合16进制编码格式"));
        ALL_VALIDATION_RULES.put("hexColor", new ValidationRuleDeclare("{target} == nil || {target}=~/^#[A-Fa-f0-9]{6}$/", "{target}必须符合颜色16进制编码格式"));
        ALL_VALIDATION_RULES.put("creditCard", new ValidationRuleDeclare("{target} == nil || {target}=~creditCardPattern(provider)", "{target}必须符合信用卡格式"));
        ALL_VALIDATION_RULES.put("fqdn", new ValidationRuleDeclare("{target} == nil || {target}=~/^(?=^.{3,255}$)[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+$/", "{target}必须是合法的全限定域名"));
        ALL_VALIDATION_RULES.put("ipOrFQDN", new ValidationRuleDeclare("{target} == nil || {target}=~/^((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)/ " +
                "|| {target}=~/^([\\da-fA-F]{1,4}:){7}[\\da-fA-F]{1,4}|:((:[\\da−fA−F]1,4)1,6|:)/ " +
                "|| {target}=~/^(?=^.{3,255}$)[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+$/", "{target}必须是合法IP或全限定域名"));
        ALL_VALIDATION_RULES.put("ipRange", new ValidationRuleDeclare("{target} == nil || ( version == 4 && {target}=~/^((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)/ ) " +
                "|| ( version == 6 && {target}=~/^([\\da-fA-F]{1,4}:){7}[\\da-fA-F]{1,4}|:((:[\\da−fA−F]1,4)1,6|:)/ )", "{target}必须是version版本的ip地址格式"));
        ALL_VALIDATION_RULES.put("isbn", new ValidationRuleDeclare("{target} == nil || ( version==10 && {target}=~/^(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$)[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$/ ) " +
                "|| ( version==13 && {target}=~/^(?:ISBN(?:-13)?:? )?(?=[0-9]{13}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)97[89][- ]?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9]$/ )",
                "{target}必须是合法的国际标准书号（ISBN）"));
        ALL_VALIDATION_RULES.put("issn", new ValidationRuleDeclare("{target} == nil || {target}=~/^\\d{4}-?\\d{3}[\\dX]$/", "{target}必须是合法的国际标准连续出版物号（ISSN）"));
        ALL_VALIDATION_RULES.put("isin", new ValidationRuleDeclare("{target} == nil || {target}=~/\\b[A-Z]{2}[A-Z0-9]{9}[0-9]\\b/", "{target}必须是合法的国际证券识别码（ISIN）"));
        ALL_VALIDATION_RULES.put("iso8601", new ValidationRuleDeclare("{target} == nil || (true == strict && string.indexOf({target}, '-02-29') > 0 ? false : {target}=~/^\\d{4}-\\d{2}-\\d{2}$/)", "{target}必须是符合ISO 8601规范"));
        ALL_VALIDATION_RULES.put("iso31661Alpha2", new ValidationRuleDeclare("{target} == nil || {target}=~/^[A-Za-z]{2}$/", "{target}必须是合法的ISO-31661 Alpha-2国家代码"));
        ALL_VALIDATION_RULES.put("iso31661Alpha3", new ValidationRuleDeclare("{target} == nil || {target}=~/^[A-Za-z]{3}$/", "{target}必须是合法的ISO-31661 Alpha-3国家代码"));
        ALL_VALIDATION_RULES.put("json", new ValidationRuleDeclare("{target} == nil || string.isJson({target})", "{target}必须是json格式"));
        ALL_VALIDATION_RULES.put("jwt", new ValidationRuleDeclare("{target} == nil || {target}=~/^[A-Za-z0-9-_=]+.[A-Za-z0-9-_=]+.?[A-Za-z0-9-_.+\\x2f=]*$/", "{target}必须是jwt格式"));
        ALL_VALIDATION_RULES.put("latLong", new ValidationRuleDeclare("{target} == nil || {target}=~/^[\\-\\+]?(0(\\.\\d{1,10})?|([1-9](\\d)?)(\\.\\d{1,10})?|1[0-7]\\d{1}(\\.\\d{1,10})?|180\\.0{1,10})$/", "{target}必须是经纬度格式"));
        // locale、strict
        ALL_VALIDATION_RULES.put("mobile", new ValidationRuleDeclare("{target} == nil || isMobilePhone(locale, strict, {target})", "{target}必须是手机号"));
        ALL_VALIDATION_RULES.put("mongoId", new ValidationRuleDeclare("{target} == nil || {target}=~/[a-zA-Z0-9]{24}/", "{target}必须是mongodb的objectId"));
        ALL_VALIDATION_RULES.put("postalCode", new ValidationRuleDeclare("{target} == nil || {target}=~postalCodePattern(locale)", "{target}必须是邮政编码"));
        ALL_VALIDATION_RULES.put("url", new ValidationRuleDeclare("{target} == nil || {target}=~/(https?|ftp|file):\\/\\/[-A-Za-z0-9+&@#\\/%?=~_|!:,.;]+[-A-Za-z0-9+&@#\\/%=~_|]/", "{target}必须是url"));
        ALL_VALIDATION_RULES.put("uuid", new ValidationRuleDeclare("{target} == nil || {target}=~/[0-9a-fA-F]{8}(-[0-9a-fA-F]{4}){3}-[0-9a-fA-F]{12}/", "{target}必须是uuid"));
        ALL_VALIDATION_RULES.put("chinese", new ValidationRuleDeclare("{target} == nil || {target}=~/[\\u4e00-\\u9fa5]/ || {target}=~/[^\\x00-\\xff]+/", "{target}必须是中文"));
        ALL_VALIDATION_RULES.put("pattern", new ValidationRuleDeclare("{target} == nil || {target}=~asPattern(re)", "{target}不满足正则格式"));

        ALL_VALIDATION_RULES.put("^az", new ValidationRuleDeclare("{target} == nil || {target}=~/^[a-z].*/", "{target}必须小写字母开头"));
        ALL_VALIDATION_RULES.put("^az09", new ValidationRuleDeclare("{target} == nil || {target}=~/^[a-z0-9].*/", "{target}必须小写字母或数字开头"));
        ALL_VALIDATION_RULES.put("^az09_", new ValidationRuleDeclare("{target} == nil || {target}=~/^[a-z0-9_].*/", "{target}必须小写字母、数字或下划线开头"));
        ALL_VALIDATION_RULES.put("^azAZ", new ValidationRuleDeclare("{target} == nil || {target}=~/^[a-zA-Z].*/", "{target}必须字母开头"));
        ALL_VALIDATION_RULES.put("^azAZ09", new ValidationRuleDeclare("{target} == nil || {target}=~/^[a-zA-Z0-9].*/", "{target}必须字母或数字开头"));
        ALL_VALIDATION_RULES.put("^azAZ09_", new ValidationRuleDeclare("{target} == nil || {target}=~/^[a-zA-Z0-9_].*/", "{target}必须字母、数字或下划线开头"));
        ALL_VALIDATION_RULES.put("az09$", new ValidationRuleDeclare("{target} == nil || {target}=~/.*[a-z0-9]$/", "{target}必须小写字母或数字结尾"));
        ALL_VALIDATION_RULES.put("azAZ09$", new ValidationRuleDeclare("{target} == nil || {target}=~/.*[a-zA-Z0-9]$/", "{target}必须字母或数字结尾"));
        ALL_VALIDATION_RULES.put("^09$", new ValidationRuleDeclare("{target} == nil || {target}=~/[0-9]+/", "{target}必须由数字组成"));
        ALL_VALIDATION_RULES.put("^az09$", new ValidationRuleDeclare("{target} == nil || {target}=~/[a-z0-9]+/", "{target}必须由小写字母或数字组成"));
        ALL_VALIDATION_RULES.put("^az09-$", new ValidationRuleDeclare("{target} == nil || {target}=~/[a-z0-9\\-]+/", "{target}必须由小写字母、数字或中划线组成"));
        ALL_VALIDATION_RULES.put("^az09-.$", new ValidationRuleDeclare("{target} == nil || {target}=~/[a-z0-9\\-\\.]+/", "{target}必须由小写字母、数字、.或中划线组成"));
        ALL_VALIDATION_RULES.put("^azAZ09$", new ValidationRuleDeclare("{target} == nil || {target}=~/[a-zA-Z0-9]+/", "{target}必须由字母或数字组成"));
        ALL_VALIDATION_RULES.put("^azAZ09-$", new ValidationRuleDeclare("{target} == nil || {target}=~/[a-zA-Z0-9\\-]+/", "{target}必须由字母、数字或中划线组成"));
        ALL_VALIDATION_RULES.put("^azAZ09_$", new ValidationRuleDeclare("{target} == nil || {target}=~/[a-zA-Z0-9_]+/", "{target}必须由字母、数字或下划线组成"));
        ALL_VALIDATION_RULES.put("azAZ09-_$", new ValidationRuleDeclare("{target} == nil || {target}=~/[a-zA-Z0-9_\\-]+/", "{target}必须由字母、数字、-或下划线组成"));
        ALL_VALIDATION_RULES.put("^az09-_$", new ValidationRuleDeclare("{target} == nil || {target}=~/[a-z0-9_\\-]+/", "{target}必须由小写字母、数字、-或下划线组成"));
    }

    public static void registerFunctions() {
        AviatorEvaluator.addFunction(new AbstractFunction() {
            @Override
            public String getName() {
                return "string.trim";
            }

            @Override
            public AviatorObject call(Map<String, Object> env, AviatorObject arg1) {
                String value = FunctionUtils.getStringValue(arg1, env);
                return new AviatorString(null == value ? null : value.trim());
            }
        });

        AviatorEvaluator.addFunction(new AbstractFunction() {
            @Override
            public String getName() {
                return "string.case";
            }

            @Override
            public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
                String value = FunctionUtils.getStringValue(arg1, env);
                String caseMode = FunctionUtils.getStringValue(arg2, env);
                return "upper".equals(caseMode) ?
                        new AviatorString(null == value ? null : value.toUpperCase()) :
                        new AviatorString(null == value ? null : value.toLowerCase());
            }
        });

        AviatorEvaluator.addFunction(new AbstractFunction() {
            @Override
            public String getName() {
                return "string.byteLength";
            }

            @Override
            public AviatorObject call(Map<String, Object> env, AviatorObject arg1) {
                String value = FunctionUtils.getStringValue(arg1, env);
                return new AviatorBigInt(null == value ? 0 : value.getBytes().length);
            }
        });

        registerFunctions2();
        registerFunctions3();
        registerFunctions4();
        registerFunctions5();
        registerFunctions6();
    }

    // for sonar check Cognitive Complexity
    private static void registerFunctions2() {
        AviatorEvaluator.addFunction(new AbstractFunction() {
            @Override
            public String getName() {
                return "asPattern";
            }

            @Override
            public AviatorObject call(Map<String, Object> env, AviatorObject arg1) {
                String value = FunctionUtils.getStringValue(arg1, env);
                return PATTERN_CACHE.computeIfAbsent(value, v -> new AviatorPattern(value));
            }
        });


        AviatorEvaluator.addFunction(new AbstractFunction() {
            @Override
            public String getName() {
                return "equals";
            }

            @Override
            public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
                Object value1 = arg1 instanceof AviatorJavaType ? FunctionUtils.getJavaObject(arg1, env) : arg1.getValue(env);
                Object value2 = arg2 instanceof AviatorJavaType ? FunctionUtils.getJavaObject(arg2, env) : arg2.getValue(env);

                if (null == value1 || null == value2) {
                    return AviatorBoolean.FALSE;
                }

                if (value1 == value2 || value1.equals(value2)) {
                    return AviatorBoolean.TRUE;
                }

                return AviatorBoolean.valueOf(JacksonUtils.toJson(value1).equals(JacksonUtils.toJson(value2)));
            }
        });

        // 内置函数
        try {
            AviatorEvaluator.addStaticFunctions("CommonFunctionUtil", CommonFunctionUtil.class);
        } catch (IllegalAccessException | NoSuchMethodException e) {
            throw new HttpCodeException(500, e);
        }

        // CreditCard
        AviatorEvaluator.addFunction(new AbstractFunction() {
            @Override
            public String getName() {
                return "creditCardPattern";
            }

            @Override
            public AviatorObject call(Map<String, Object> env, AviatorObject arg1) {
                String provider = FunctionUtils.getStringValue(arg1, env);
                provider = StringUtils.defaultString(provider, "unionpay");

                switch (provider) {
                    case "amex":
                        return PATTERN_CACHE.computeIfAbsent("builtin-creditCard-amex", v -> new AviatorPattern("^3[47][0-9]{13}$"));
                    case "dinersclub":
                        return PATTERN_CACHE.computeIfAbsent("builtin-creditCard-dinersclub", v -> new AviatorPattern("^3(?:0[0-5]|[68][0-9])[0-9]{11}$"));
                    case "discover":
                        return PATTERN_CACHE.computeIfAbsent("builtin-creditCard-discover", v -> new AviatorPattern("^6(?:011|5[0-9][0-9])[0-9]{12,15}$"));
                    case "jcb":
                        return PATTERN_CACHE.computeIfAbsent("builtin-creditCard-jcb", v -> new AviatorPattern("^(?:2131|1800|35\\d{3})\\d{11}$"));
                    case "mastercard":
                        return PATTERN_CACHE.computeIfAbsent("builtin-creditCard-mastercard", v -> new AviatorPattern("^5[1-5][0-9]{2}|(222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}$"));
                    case "unionpay":
                        return PATTERN_CACHE.computeIfAbsent("builtin-creditCard-unionpay", v -> new AviatorPattern("^(6[27][0-9]{14}|^(81[0-9]{14,17}))$"));
                    case "visa":
                        return PATTERN_CACHE.computeIfAbsent("builtin-creditCard-visa", v -> new AviatorPattern("^(?:4[0-9]{12})(?:[0-9]{3,6})?$"));
                    default:
                        throw new HttpCodeException("非法的银行类型: " + provider);

                }
            }
        });
    }

    // for sonar check Cognitive Complexity
    private static void registerFunctions3() {
        // hash
        AviatorEvaluator.addFunction(new AbstractFunction() {
            @Override
            public String getName() {
                return "hashPattern";
            }

            @Override
            public AviatorObject call(Map<String, Object> env, AviatorObject arg1) {
                String algorithm = FunctionUtils.getStringValue(arg1, env);
                algorithm = StringUtils.defaultString(algorithm, "md5");

                switch (algorithm) {
                    case "crc32":
                    case "crc32b":
                        return PATTERN_CACHE.computeIfAbsent("builtin-hash-8", v -> new AviatorPattern("^[a-fA-F0-9]{8}$"));
                    case "md5":
                    case "md4":
                    case "ripemd128":
                    case "tiger128":
                        return PATTERN_CACHE.computeIfAbsent("builtin-hash-32", v -> new AviatorPattern("^[a-fA-F0-9]{32}$"));
                    case "sha1":
                    case "ripemd160":
                    case "tiger160":
                        return PATTERN_CACHE.computeIfAbsent("builtin-hash-40", v -> new AviatorPattern("^[a-fA-F0-9]{40}$"));
                    case "tiger192":
                        return PATTERN_CACHE.computeIfAbsent("builtin-hash-48", v -> new AviatorPattern("^[a-fA-F0-9]{48}$"));
                    case "sha256":
                        return PATTERN_CACHE.computeIfAbsent("builtin-hash-64", v -> new AviatorPattern("^[a-fA-F0-9]{64}$"));
                    case "sha384":
                        return PATTERN_CACHE.computeIfAbsent("builtin-hash-96", v -> new AviatorPattern("^[a-fA-F0-9]{96}$"));
                    case "sha512":
                        return PATTERN_CACHE.computeIfAbsent("builtin-hash-128", v -> new AviatorPattern("^[a-fA-F0-9]{128}$"));
                    default:
                        return PATTERN_CACHE.computeIfAbsent("builtin-hash-32", v -> new AviatorPattern("^[a-fA-F0-9]{32}$"));
                }
            }
        });
    }

    // for sonar check Cognitive Complexity
    private static void registerFunctions4() {
        // 邮编
        AviatorEvaluator.addFunction(new AbstractFunction() {
            @Override
            public String getName() {
                return "postalCodePattern";
            }

            @Override
            public AviatorObject call(Map<String, Object> env, AviatorObject arg1) {
                String locale = FunctionUtils.getStringValue(arg1, env);
                locale = StringUtils.defaultString(locale, "CN");
                switch (locale) {
                    case "AD":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-AD", v -> new AviatorPattern("^AD\\d{3}$"));
                    case "AZ":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-AT", v -> new AviatorPattern("^AZ\\d{4}$"));
                    case "BA":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-BA", v -> new AviatorPattern("^([7-8]\\d{4}$)"));
                    case "BR":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-BR", v -> new AviatorPattern("^\\d{5}-\\d{3}$"));
                    case "BY":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-BY", v -> new AviatorPattern("^2[1-4]\\d{4}$"));
                    case "CA":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-CA", v -> new AviatorPattern("^[ABCEGHJKLMNPRSTVXY]\\d[ABCEGHJ-NPRSTV-Z][\\s\\-]?\\d[ABCEGHJ-NPRSTV-Z]\\d$"));
                    case "CN":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-CN", v -> new AviatorPattern("^(0[1-7]|1[012356]|2[0-7]|3[0-6]|4[0-7]|5[1-7]|6[1-7]|7[1-5]|8[1345]|9[09])\\d{4}$"));
                    case "CZ":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-CZ", v -> new AviatorPattern("^\\d{3}\\s?\\d{2}$"));
                    case "ES":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-ES", v -> new AviatorPattern("^(5[0-2]{1}|[0-4]{1}\\d{1})\\d{3}$"));
                    case "FR":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-FR", v -> new AviatorPattern("^\\d{2}\\s?\\d{3}$"));
                    case "GB":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-GB", v -> new AviatorPattern("^(gir\\s?0aa|[a-z]{1,2}\\d[\\da-z]?\\s?(\\d[a-z]{2})?)$"));
                    case "GR":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-GR", v -> new AviatorPattern("^\\d{3}\\s?\\d{2}$"));
                    case "HR":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-HR", v -> new AviatorPattern("^([1-5]\\d{4}$)"));
                    case "HT":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-HT", v -> new AviatorPattern("^HT\\d{4}$"));
                    case "IE":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-IE", v -> new AviatorPattern("^(?!.*(?:o))[A-Za-z]\\d[\\dw]\\s\\w{4}$"));
                    case "IL":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-IL", v -> new AviatorPattern("^(\\d{5}|\\d{7})$"));
                    case "IN":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-IN", v -> new AviatorPattern("^((?!10|29|35|54|55|65|66|86|87|88|89)[1-9][0-9]{5})$"));
                    case "IR":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-IR", v -> new AviatorPattern("^(?!(\\d)\\1{3})[13-9]{4}[1346-9][013-9]{5}$"));
                    case "JP":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-JP", v -> new AviatorPattern("^\\d{3}\\-\\d{4}$"));
                    case "KR":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-KR", v -> new AviatorPattern("^(\\d{5}|\\d{6})$"));
                    case "LI":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-LI", v -> new AviatorPattern("^(948[5-9]|949[0-7])$"));
                    case "LT":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-LT", v -> new AviatorPattern("^LT\\-\\d{5}$"));
                    case "LV":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-LV", v -> new AviatorPattern("^LV\\-\\d{4}$"));
                    case "MT":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-MT", v -> new AviatorPattern("^[A-Za-z]{3}\\s{0,1}\\d{4}$"));
                    case "NL":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-NL", v -> new AviatorPattern("^\\d{4}\\s?[a-z]{2}$"));
                    case "NP":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-NP", v -> new AviatorPattern("^(10|21|22|32|33|34|44|45|56|57)\\d{3}$|^(977)$"));
                    case "PL":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-PL", v -> new AviatorPattern("^\\d{2}\\-\\d{3}$"));
                    case "PR":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-PR", v -> new AviatorPattern("^00[679]\\d{2}([ -]\\d{4})?$"));
                    case "PT":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-PT", v -> new AviatorPattern("^\\d{4}\\-\\d{3}?$"));
                    case "SE":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-SE", v -> new AviatorPattern("^[1-9]\\d{2}\\s?\\d{2}$"));
                    case "SK":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-SK", v -> new AviatorPattern("^\\d{3}\\s?\\d{2}$"));
                    case "TW":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-TW", v -> new AviatorPattern("^\\d{3}(\\d{2})?$"));
                    case "US":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-US", v -> new AviatorPattern("^\\d{5}(-\\d{4})?$"));
                    case "IS":
                    case "MG":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-three", v -> new AviatorPattern("^\\d{3}$"));
                    case "AT":
                    case "AU":
                    case "BE":
                    case "BG":
                    case "CH":
                    case "DK":
                    case "HU":
                    case "LU":
                    case "NO":
                    case "NZ":
                    case "SI":
                    case "TN":
                    case "ZA":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-four", v -> new AviatorPattern("^\\d{4}$"));
                    case "DE":
                    case "DO":
                    case "DZ":
                    case "EE":
                    case "FI":
                    case "ID":
                    case "IT":
                    case "KE":
                    case "LK":
                    case "MX":
                    case "MY":
                    case "SA":
                    case "TH":
                    case "UA":
                    case "ZM":
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-five", v -> new AviatorPattern("^\\d{5}$"));
                    default:
                        return PATTERN_CACHE.computeIfAbsent("builtin-postalCode-six", v -> new AviatorPattern("^\\d{6}$"));
                }
            }
        });
    }

    // for sonar check Cognitive Complexity
    private static void registerFunctions5() {
        AviatorEvaluator.addFunction(new AbstractFunction() {
            @Override
            public String getName() {
                return "string.isJson";
            }

            @Override
            public AviatorObject call(Map<String, Object> env, AviatorObject arg1) {
                String value = FunctionUtils.getStringValue(arg1, env);
                boolean isObject = false;
                boolean isArray = false;
                if (value.startsWith("{") && value.endsWith("}")) {
                    isObject = true;
                } else if (value.startsWith("[") && value.endsWith("]")) {
                    isArray = true;
                }

                if (!isObject && !isArray) {
                    return AviatorBoolean.FALSE;
                }

                try {
                    if (isObject) {
                        JacksonUtils.fromJson(value, Map.class);
                    } else if (isArray) {
                        JacksonUtils.fromJsonArray(value, Object.class);
                    } else {
                        return AviatorBoolean.FALSE;
                    }

                    return AviatorBoolean.TRUE;
                } catch (Exception e) {
                    return AviatorBoolean.FALSE;
                }
            }
        });
    }

    private static void registerFunctions6() {
        // 手机号码
        AviatorEvaluator.addFunction(new AbstractFunction() {
            @Override
            public String getName() {
                return "isMobilePhone";
            }

            @Override
            public AviatorObject call(Map<String, Object> env, AviatorObject localeAviator, AviatorObject strictAviator,
                                      AviatorObject targetAviator) {
                String locale = FunctionUtils.getStringValue(localeAviator, env);
                locale = StringUtils.defaultString(locale, "zh-CN");
                Boolean strict = FunctionUtils.getBooleanValue(strictAviator, env);
                strict = Boolean.TRUE.equals(strict);
                Object targetObject = FunctionUtils.getJavaObject(targetAviator, env);
                String targetValue = null;
                if (targetObject instanceof String) {
                    targetValue = FunctionUtils.getStringValue(targetAviator, env);
                } else if (targetObject instanceof Number) {
                    targetValue = String.valueOf(FunctionUtils.getNumberValue(targetAviator, env));
                }
                if (null == targetValue) {
                    return AviatorBoolean.FALSE;
                }
                AviatorPattern aviatorPattern = null;
                switch (locale) {
                    case "am-AM":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-am-AM", v -> new AviatorPattern("^(\\+?374|0)((10|[9|7][0-9])\\d{6}$|[2-4]\\d{7}$)"));
                        break;
                    case "ar-AE":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-ar-AE", v -> new AviatorPattern("^((\\+?971)|0)?5[024568]\\d{7}$"));
                        break;
                    case "ar-BH":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-ar-BH", v -> new AviatorPattern("^(\\+?973)?(3|6)\\d{7}$"));
                        break;
                    case "ar-DZ":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-ar-DZ", v -> new AviatorPattern("^(\\+?213|0)(5|6|7)\\d{8}$"));
                        break;
                    case "ar-LB":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-ar-LB", v -> new AviatorPattern("^(\\+?961)?((3|81)\\d{6}|7\\d{7})$"));
                        break;
                    case "ar-EG":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-ar-EG", v -> new AviatorPattern("^((\\+?20)|0)?1[0125]\\d{8}$"));
                        break;
                    case "ar-IQ":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-ar-IQ", v -> new AviatorPattern("^(\\+?964|0)?7[0-9]\\d{8}$"));
                        break;
                    case "ar-JO":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-ar-JO", v -> new AviatorPattern("^(\\+?962|0)?7[789]\\d{7}$"));
                        break;
                    case "ar-KW":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-ar-KW", v -> new AviatorPattern("^(\\+?965)([569]\\d{7}|41\\d{6})$"));
                        break;
                    case "ar-LY":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-ar-LY", v -> new AviatorPattern("^((\\+?218)|0)?(9[1-6]\\d{7}|[1-8]\\d{7,9})$"));
                        break;
                    case "ar-MA":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-ar-MA", v -> new AviatorPattern("^(?:(?:\\+|00)212|0)[5-7]\\d{8}$"));
                        break;
                    case "ar-OM":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-ar-OM", v -> new AviatorPattern("^((\\+|00)968)?(9[1-9])\\d{6}$"));
                        break;
                    case "ar-PS":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-ar-PS", v -> new AviatorPattern("^(\\+?970|0)5[6|9](\\d{7})$"));
                        break;
                    case "ar-SA":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-ar-SA", v -> new AviatorPattern("^(!?(\\+?966)|0)?5\\d{8}$"));
                        break;
                    case "ar-SD":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-ar-SD", v -> new AviatorPattern("^((\\+?249)|0)?(9[012369]|1[012])\\d{7}$"));
                        break;
                    case "ar-SY":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-ar-SY", v -> new AviatorPattern("^(!?(\\+?963)|0)?9\\d{8}$"));
                        break;
                    case "ar-TN":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-ar-TN", v -> new AviatorPattern("^(\\+?216)?[2459]\\d{7}$"));
                        break;
                    case "az-AZ":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-az-AZ", v -> new AviatorPattern("^(\\+994|0)(10|5[015]|7[07]|99)\\d{7}$"));
                        break;
                    case "bs-BA":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-bs-BA", v -> new AviatorPattern("^((((\\+|00)3876)|06))((([0-3]|[5-6])\\d{6})|(4\\d{7}))$"));
                        break;
                    case "be-BY":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-be-BY", v -> new AviatorPattern("^(\\+?375)?(24|25|29|33|44)\\d{7}$"));
                        break;
                    case "bg-BG":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-bg-BG", v -> new AviatorPattern("^(\\+?359|0)?8[789]\\d{7}$"));
                        break;
                    case "bn-BD":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-bn-BD", v -> new AviatorPattern("^(\\+?880|0)1[13456789][0-9]{8}$"));
                        break;
                    case "ca-AD":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-ca-AD", v -> new AviatorPattern("^(\\+376)?[346]\\d{5}$"));
                        break;
                    case "cs-CZ":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-cs-CZ", v -> new AviatorPattern("^(\\+?420)? ?[1-9][0-9]{2} ?[0-9]{3} ?[0-9]{3}$"));
                        break;
                    case "da-DK":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-da-DK", v -> new AviatorPattern("^(\\+?45)?\\s?\\d{2}\\s?\\d{2}\\s?\\d{2}\\s?\\d{2}$"));
                        break;
                    case "de-DE":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-de-DE", v -> new AviatorPattern("^((\\+49|0)1)(5[0-25-9]\\d|6([23]|0\\d?)|7([0-57-9]|6\\d))\\d{7,9}$"));
                        break;
                    case "de-AT":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-de-AT", v -> new AviatorPattern("^(\\+43|0)\\d{1,4}\\d{3,12}$"));
                        break;
                    case "de-CH":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-de-CH", v -> new AviatorPattern("^(\\+41|0)([1-9])\\d{1,9}$"));
                        break;
                    case "de-LU":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-de-LU", v -> new AviatorPattern("^(\\+352)?((6\\d1)\\d{6})$"));
                        break;
                    case "dv-MV":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-dv-MV", v -> new AviatorPattern("^(\\+?960)?(7[2-9]|9[1-9])\\d{5}$"));
                        break;
                    case "el-GR":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-el-GR", v -> new AviatorPattern("^(\\+?30|0)?6(8[5-9]|9(?![26])[0-9])\\d{7}$"));
                        break;
                    case "el-CY":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-el-CY", v -> new AviatorPattern("^(\\+?357?)?(9(9|6)\\d{6})$"));
                        break;
                    case "en-AI":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-AI", v -> new AviatorPattern("^(\\+?1|0)264(?:2(35|92)|4(?:6[1-2]|76|97)|5(?:3[6-9]|8[1-4])|7(?:2(4|9)|72))\\d{4}$"));
                        break;
                    case "en-AU":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-AU", v -> new AviatorPattern("^(\\+?61|0)4\\d{8}$"));
                        break;
                    case "en-AG":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-AG", v -> new AviatorPattern("^(?:\\+1|1)268(?:464|7(?:1[3-9]|[28]\\d|3[0246]|64|7[0-689]))\\d{4}$"));
                        break;
                    case "en-BM":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-BM", v -> new AviatorPattern("^(\\+?1)?441(((3|7)\\d{6}$)|(5[0-3][0-9]\\d{4}$)|(59\\d{5}$))"));
                        break;
                    case "en-BS":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-BS", v -> new AviatorPattern("^(\\+?1[-\\s]?|0)?\\(?242\\)?[-\\s]?\\d{3}[-\\s]?\\d{4}$"));
                        break;
                    case "en-GB":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-GB", v -> new AviatorPattern("^(\\+?44|0)7\\d{9}$"));
                        break;
                    case "en-GG":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-GG", v -> new AviatorPattern("^(\\+?44|0)1481\\d{6}$"));
                        break;
                    case "en-GH":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-GH", v -> new AviatorPattern("^(\\+233|0)(20|50|24|54|27|57|26|56|23|28|55|59)\\d{7}$"));
                        break;
                    case "en-GY":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-GY", v -> new AviatorPattern("^(\\+592|0)6\\d{6}$"));
                        break;
                    case "en-HK":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-HK", v -> new AviatorPattern("^(\\+?852[-\\s]?)?[456789]\\d{3}[-\\s]?\\d{4}$"));
                        break;
                    case "en-MO":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-MO", v -> new AviatorPattern("^(\\+?853[-\\s]?)?[6]\\d{3}[-\\s]?\\d{4}$"));
                        break;
                    case "en-IE":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-IE", v -> new AviatorPattern("^(\\+?353|0)8[356789]\\d{7}$"));
                        break;
                    case "en-IN":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-IN", v -> new AviatorPattern("^(\\+?91|0)?[6789]\\d{9}$"));
                        break;
                    case "en-JM":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-JM", v -> new AviatorPattern("^(\\+?876)?\\d{7}$"));
                        break;
                    case "en-KE":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-KE", v -> new AviatorPattern("^(\\+?254|0)(7|1)\\d{8}$"));
                        break;
                    case "fr-CF":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-fr-CF", v -> new AviatorPattern("^(\\+?236| ?)(70|75|77|72|21|22)\\d{6}$"));
                        break;
                    case "en-SS":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-SS", v -> new AviatorPattern("^(\\+?211|0)(9[1257])\\d{7}$"));
                        break;
                    case "en-KI":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-KI", v -> new AviatorPattern("^((\\+686|686)?)?( )?((6|7)(2|3|8)[0-9]{6})$"));
                        break;
                    case "en-KN":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-KN", v -> new AviatorPattern("^(?:\\+1|1)869(?:46\\d|48[89]|55[6-8]|66\\d|76[02-7])\\d{4}$"));
                        break;
                    case "en-LS":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-LS", v -> new AviatorPattern("^(\\+?266)(22|28|57|58|59|27|52)\\d{6}$"));
                        break;
                    case "en-MT":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-MT", v -> new AviatorPattern("^(\\+?356|0)?(99|79|77|21|27|22|25)[0-9]{6}$"));
                        break;
                    case "en-MU":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-MU", v -> new AviatorPattern("^(\\+?230|0)?\\d{8}$"));
                        break;
                    case "en-NA":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-NA", v -> new AviatorPattern("^(\\+?264|0)(6|8)\\d{7}$"));
                        break;
                    case "en-NG":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-NG", v -> new AviatorPattern("^(\\+?234|0)?[789]\\d{9}$"));
                        break;
                    case "en-NZ":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-NZ", v -> new AviatorPattern("^(\\+?64|0)[28]\\d{7,9}$"));
                        break;
                    case "en-PG":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-PG", v -> new AviatorPattern("^(\\+?675|0)?(7\\d|8[18])\\d{6}$"));
                        break;
                    case "en-PK":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-PK", v -> new AviatorPattern("^((00|\\+)?92|0)3[0-6]\\d{8}$"));
                        break;
                    case "en-PH":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-PH", v -> new AviatorPattern("^(09|\\+639)\\d{9}$"));
                        break;
                    case "en-RW":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-RW", v -> new AviatorPattern("^(\\+?250|0)?[7]\\d{8}$"));
                        break;
                    case "en-SG":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-en-SG", v -> new AviatorPattern("^(\\+65)?[3689]\\d{7}$"));
                        break;
                    case "zh-CN":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-zh-CN", v -> new AviatorPattern("^((\\+|00)86)?(1[3-9]|9[28])\\d{9}$"));
                        break;
                    case "zh-TW":
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-zh-TW", v -> new AviatorPattern("^(\\+?886\\-?|0)?9\\d{8}$"));
                        break;
                    default:
                        aviatorPattern = PATTERN_CACHE.computeIfAbsent("builtin-mobilePhone-zh-CN", v -> new AviatorPattern("^((\\+|00)86)?(1[3-9]|9[28])\\d{9}$"));
                }

                if (strict && !targetValue.startsWith("+")) {
                    return AviatorBoolean.FALSE;
                }

                return AviatorBoolean.valueOf(aviatorPattern.getPattern().matcher(targetValue).find());
            }
        });
    }

    private Expression validationExpression;
    private Map<String, Object> defaultArgs;
    private String errorMsg;

    private Validator() {
    }

    public boolean validate(Map<String, Object> params) {
        Map<String, Object> validationParams = new HashMap<>(null == defaultArgs ? 1 : defaultArgs.size() + 1);
        validationParams.put("_params", params);
        if (null == defaultArgs) {
            return (boolean) validationExpression.execute(validationParams);
        } else {
            validationParams.putAll(defaultArgs);
            return (boolean) validationExpression.execute(validationParams);
        }
    }

    public String errorMsg(Map<String, Object> params) {
        if (StringUtils.isNotBlank(errorMsg)) {
            return errorMsg;
        } else {
            return "参数验证错误";
        }
    }

    public static class ValidationRuleBuilder {
        private Validator validationRule = new Validator();
        private ValidationRuleDeclare ruleDeclare;
        private String targetParam;

        public ValidationRuleBuilder(String ruleName) {
            ValidationRuleDeclare rule = ALL_VALIDATION_RULES.get(ruleName);
            if (null == rule) {
                throw new HttpCodeException("非法的验证规则: " + ruleName);
            }
            this.ruleDeclare = rule;
        }

        public ValidationRuleBuilder withTarget(String targetParam) {
            this.targetParam = targetParam;

            return this;
        }

        public ValidationRuleBuilder withArgument(String name, Object value) {
            if (null == validationRule.defaultArgs) {
                validationRule.defaultArgs = new HashMap<>();
            }
            validationRule.defaultArgs.put(name, value);
            return this;
        }

        public ValidationRuleBuilder withArgument(Map<String, Object> argsMap) {
            if (null == validationRule.defaultArgs) {
                validationRule.defaultArgs = new HashMap<>();
            }
            validationRule.defaultArgs.putAll(argsMap);
            return this;
        }

        public ValidationRuleBuilder withErrorMsg(String errorMsg) {
            validationRule.errorMsg = errorMsg;
            return this;
        }

        public Validator build() {
            if (null == targetParam) {
                throw new HttpCodeException("验证规则必须指定目标参数");
            }

            int FunctionStartIndex = targetParam.indexOf("(");
            int FunctionEndIndex = targetParam.indexOf(")");
            String targetFunction = FunctionStartIndex >= 0 && FunctionEndIndex >= 0 ?
                    targetParam.substring(0, FunctionStartIndex) : null;
            String realTargetParam = FunctionStartIndex >= 0 && FunctionEndIndex >= 0 ?
                    targetParam.substring(FunctionStartIndex + 1, FunctionEndIndex) : targetParam;

            String targetNameInRule = StringUtils.isEmpty(targetFunction) ? "_params." + targetParam :
                    targetFunction + "(_params." + realTargetParam + ")";

            if (StringUtils.isEmpty(validationRule.errorMsg)) {
                validationRule.errorMsg = StringUtils.replace(ruleDeclare.errorMsg, "{target}", targetParam);
            }

            if (null != validationRule.defaultArgs) {
                for (Map.Entry<String, Object> entry : validationRule.defaultArgs.entrySet()) {
                    validationRule.errorMsg = StringUtils.replace(validationRule.errorMsg,  entry.getKey() , String.valueOf(entry.getValue()));
                    if (entry.getValue() instanceof String &&
                            ((String) entry.getValue()).startsWith("CommonFunctionUtil.")) {
                        // 内置函数需要特殊处理
                        ruleDeclare.expression = StringUtils.replace(ruleDeclare.expression, entry.getKey(),
                                String.valueOf(entry.getValue()));
                        validationRule.defaultArgs.remove(entry.getKey());
                    }
                }
            }

            validationRule.validationExpression = AviatorEvaluator
                    .compile(StringUtils.replace(ruleDeclare.expression, "{target}", targetNameInRule), true);
            return validationRule;
        }
    }

    static class ValidationRuleDeclare {
        private String expression;
        private String errorMsg;

        public ValidationRuleDeclare(String expression, String errorMsg) {
            this.expression = expression;
            this.errorMsg = errorMsg;
        }
    }
}
