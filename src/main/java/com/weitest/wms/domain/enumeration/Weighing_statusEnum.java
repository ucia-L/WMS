package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate Weighing_statusEnum enum
*
* @author sys
*/
public enum Weighing_statusEnum implements BaseEnum<Weighing_statusEnum, String> {
    FIELD_0("0", "未称重"),
    FIELD_1("1", "已称重"),
    ;
    public final String code;
    public final String desc;

    Weighing_statusEnum(String code, String desc) {
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