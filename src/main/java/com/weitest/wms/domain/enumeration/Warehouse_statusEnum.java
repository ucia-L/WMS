package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate Warehouse_statusEnum enum
*
* @author sys
*/
public enum Warehouse_statusEnum implements BaseEnum<Warehouse_statusEnum, String> {
    FIELD_0("0", "启用"),
    FIELD_1("1", "禁用"),
    FIELD_2("2", "盘点中"),
    ;
    public final String code;
    public final String desc;

    Warehouse_statusEnum(String code, String desc) {
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