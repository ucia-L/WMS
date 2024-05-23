package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate UserStatusEnumEnum enum
*
* @author sys
*/
public enum UserStatusEnumEnum implements BaseEnum<UserStatusEnumEnum, String> {
    FIELD_Normal("Normal", "正常"),
    FIELD_Forbidden("Forbidden", "禁用"),
    ;
    public final String code;
    public final String desc;

    UserStatusEnumEnum(String code, String desc) {
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