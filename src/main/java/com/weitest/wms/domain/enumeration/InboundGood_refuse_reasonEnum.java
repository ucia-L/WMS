package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate InboundGood_refuse_reasonEnum enum
*
* @author sys
*/
public enum InboundGood_refuse_reasonEnum implements BaseEnum<InboundGood_refuse_reasonEnum, String> {
    FIELD_0("0", "货物数量不正确"),
    FIELD_1("1", "货物有破损"),
    FIELD_2("2", "货物种类有误"),
    FIELD_3("3", "其他"),
    ;
    public final String code;
    public final String desc;

    InboundGood_refuse_reasonEnum(String code, String desc) {
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