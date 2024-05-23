package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate InventoryTask_statusEnum enum
*
* @author sys
*/
public enum InventoryTask_statusEnum implements BaseEnum<InventoryTask_statusEnum, String> {
    FIELD_0("0", "待完成"),
    FIELD_1("1", "已完成"),
    ;
    public final String code;
    public final String desc;

    InventoryTask_statusEnum(String code, String desc) {
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