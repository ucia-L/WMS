package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate Message_statusEnum enum
*
* @author sys
*/
public enum Message_statusEnum implements BaseEnum<Message_statusEnum, String> {
    FIELD_0("0", "未查看"),
    FIELD_1("1", "已查看"),
    ;
    public final String code;
    public final String desc;

    Message_statusEnum(String code, String desc) {
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