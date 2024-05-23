package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate StatusEnum enum
*
* @author sys
*/
public enum StatusEnum implements BaseEnum<StatusEnum, String> {
    FIELD_0("0", "未处理"),
    FIELD_1("1", "已入库"),
    FIELD_2("2", "已拒绝"),
    FIELD_3("3", "已出库"),
    FIELD_4("4", "已上架"),
    ;
    public final String code;
    public final String desc;

    StatusEnum(String code, String desc) {
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