package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate ApplyStatusEnum enum
*
* @author sys
*/
public enum ApplyStatusEnum implements BaseEnum<ApplyStatusEnum, String> {
    FIELD_0("0", "待审核"),
    FIELD_1("1", "已授权"),
    FIELD_2("2", "拒绝"),
    ;
    public final String code;
    public final String desc;

    ApplyStatusEnum(String code, String desc) {
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