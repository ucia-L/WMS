package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate Shipping_statusEnum enum
*
* @author sys
*/
public enum Shipping_statusEnum implements BaseEnum<Shipping_statusEnum, String> {
    FIELD_0("0", "未发货"),
    FIELD_1("1", "已发货"),
    ;
    public final String code;
    public final String desc;

    Shipping_statusEnum(String code, String desc) {
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