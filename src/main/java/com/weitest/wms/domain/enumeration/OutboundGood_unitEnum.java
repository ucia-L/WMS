package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate OutboundGood_unitEnum enum
*
* @author sys
*/
public enum OutboundGood_unitEnum implements BaseEnum<OutboundGood_unitEnum, String> {
    FIELD_0("0", "个"),
    FIELD_1("1", "件"),
    FIELD_2("2", "只"),
    ;
    public final String code;
    public final String desc;

    OutboundGood_unitEnum(String code, String desc) {
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