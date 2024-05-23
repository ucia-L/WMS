package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate Packaged_statusEnum enum
*
* @author sys
*/
public enum Packaged_statusEnum implements BaseEnum<Packaged_statusEnum, String> {
    FIELD_0("0", "未打包"),
    FIELD_1("1", "已打包"),
    ;
    public final String code;
    public final String desc;

    Packaged_statusEnum(String code, String desc) {
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