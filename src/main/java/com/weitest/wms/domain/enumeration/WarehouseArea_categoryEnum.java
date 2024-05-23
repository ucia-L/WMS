package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate WarehouseArea_categoryEnum enum
*
* @author sys
*/
public enum WarehouseArea_categoryEnum implements BaseEnum<WarehouseArea_categoryEnum, String> {
    FIELD_0("0", "入库暂存区"),
    FIELD_1("1", "仓内存储区"),
    FIELD_2("2", "出库暂存区"),
    ;
    public final String code;
    public final String desc;

    WarehouseArea_categoryEnum(String code, String desc) {
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