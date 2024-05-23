package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate PermissionEnum enum
*
* @author sys
*/
public enum PermissionEnum implements BaseEnum<PermissionEnum, String> {
    FIELD_0("0", " 入库权限"),
    FIELD_1("1", "出库权限"),
    FIELD_2("2", "配送管理权限"),
    FIELD_3("3", "仓内管理权限"),
    FIELD_4("4", "财政管理权限"),
    FIELD_5("5", "管理员权限"),
    ;
    public final String code;
    public final String desc;

    PermissionEnum(String code, String desc) {
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