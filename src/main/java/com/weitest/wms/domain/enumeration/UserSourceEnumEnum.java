package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate UserSourceEnumEnum enum
*
* @author sys
*/
public enum UserSourceEnumEnum implements BaseEnum<UserSourceEnumEnum, String> {
    FIELD_Normal("Normal", "普通登录"),
    ;
    public final String code;
    public final String desc;

    UserSourceEnumEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @JsonValue
    public String getJsonValue(){
        return this.code;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }

}