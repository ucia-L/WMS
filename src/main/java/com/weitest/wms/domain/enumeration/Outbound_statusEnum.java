package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate Outbound_statusEnum enum
*
* @author sys
*/
public enum Outbound_statusEnum implements BaseEnum<Outbound_statusEnum, String> {
    FIELD_0("0", "待配货"),
    FIELD_1("1", "待分拣"),
    FIELD_2("2", "待称重"),
    FIELD_3("3", "待验货"),
    FIELD_4("4", "待打包装箱"),
    FIELD_5("5", "待发货"),
    FIELD_6("6", "已完成"),
    ;
    public final String code;
    public final String desc;

    Outbound_statusEnum(String code, String desc) {
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