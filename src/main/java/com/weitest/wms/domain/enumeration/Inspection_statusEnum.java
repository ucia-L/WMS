package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate Inspection_statusEnum enum
*
* @author sys
*/
public enum Inspection_statusEnum implements BaseEnum<Inspection_statusEnum, String> {
    FIELD_0("0", "未验货"),
    FIELD_1("1", "验货通过"),
    FIELD_2("2", "验货不通过"),
    ;
    public final String code;
    public final String desc;

    Inspection_statusEnum(String code, String desc) {
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