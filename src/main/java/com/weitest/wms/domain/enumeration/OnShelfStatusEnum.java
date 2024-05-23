package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate OnShelfStatusEnum enum
*
* @author sys
*/
public enum OnShelfStatusEnum implements BaseEnum<OnShelfStatusEnum, String> {
    FIELD_4("4", "已上架"),
    FIELD_1("1", "未处理"),
    ;
    public final String code;
    public final String desc;

    OnShelfStatusEnum(String code, String desc) {
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