package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate UnitEnum enum
*
* @author sys
*/
public enum UnitEnum implements BaseEnum<UnitEnum, String> {
    FIELD_0("0", "个"),
    FIELD_1("1", "件"),
    FIELD_2("2", "箱"),
    FIELD_3("3", "本"),
    FIELD_4("4", "包"),
    ;
    public final String code;
    public final String desc;

    UnitEnum(String code, String desc) {
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