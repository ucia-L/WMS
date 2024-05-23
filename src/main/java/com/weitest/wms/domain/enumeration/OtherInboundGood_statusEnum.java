package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate OtherInboundGood_statusEnum enum
*
* @author sys
*/
public enum OtherInboundGood_statusEnum implements BaseEnum<OtherInboundGood_statusEnum, String> {
    FIELD_0("0", "未处理"),
    FIELD_1("1", "已入库"),
    FIELD_2("2", "已拒绝"),
    ;
    public final String code;
    public final String desc;

    OtherInboundGood_statusEnum(String code, String desc) {
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