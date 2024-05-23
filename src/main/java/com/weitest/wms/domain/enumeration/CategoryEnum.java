package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate CategoryEnum enum
*
* @author sys
*/
public enum CategoryEnum implements BaseEnum<CategoryEnum, String> {
    FIELD_0("0", "订单"),
    FIELD_1("1", "售后"),
    FIELD_2("2", "其他"),
    ;
    public final String code;
    public final String desc;

    CategoryEnum(String code, String desc) {
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