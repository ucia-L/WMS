package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate Status_orderEnum enum
*
* @author sys
*/
public enum Status_orderEnum implements BaseEnum<Status_orderEnum, String> {
    FIELD_0("0", "未查看"),
    FIELD_1("1", "核对中"),
    FIELD_2("2", "已完成"),
    FIELD_3("3", "已拒单"),
    ;
    public final String code;
    public final String desc;

    Status_orderEnum(String code, String desc) {
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