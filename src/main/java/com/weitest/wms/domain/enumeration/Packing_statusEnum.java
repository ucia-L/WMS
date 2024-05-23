package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate Packing_statusEnum enum
*
* @author sys
*/
public enum Packing_statusEnum implements BaseEnum<Packing_statusEnum, String> {
    FIELD_0("0", "待分拣"),
    FIELD_1("1", "待二次分拣"),
    FIELD_2("2", "已分拣"),
    ;
    public final String code;
    public final String desc;

    Packing_statusEnum(String code, String desc) {
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