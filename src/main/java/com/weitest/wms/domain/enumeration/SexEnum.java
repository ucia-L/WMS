package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate SexEnum enum
*
* @author sys
*/
public enum SexEnum implements BaseEnum<SexEnum, String> {
    FIELD_boy("boy", "男"),
    FIELD_girl("girl", "女"),
    ;
    public final String code;
    public final String desc;

    SexEnum(String code, String desc) {
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