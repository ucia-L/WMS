package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate OutBoundGoods_statusEnum enum
*
* @author sys
*/
public enum OutBoundGoods_statusEnum implements BaseEnum<OutBoundGoods_statusEnum, String> {
    FIELD_0("0", "待称重"),
    FIELD_1("1", "待验货"),
    FIELD_2("2", "已完成"),
    ;
    public final String code;
    public final String desc;

    OutBoundGoods_statusEnum(String code, String desc) {
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