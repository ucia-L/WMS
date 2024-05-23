package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate AfterSalesGood_statusEnum enum
*
* @author sys
*/
public enum AfterSalesGood_statusEnum implements BaseEnum<AfterSalesGood_statusEnum, String> {
    FIELD_0("0", "待入库"),
    FIELD_1("1", "已入库"),
    ;
    public final String code;
    public final String desc;

    AfterSalesGood_statusEnum(String code, String desc) {
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