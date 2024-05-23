package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate AccountCategoryEnum enum
*
* @author sys
*/
public enum AccountCategoryEnum implements BaseEnum<AccountCategoryEnum, String> {
    FIELD_0("0", "直接出库"),
    FIELD_1("1", "售后出库"),
    FIELD_2("2", "订单出库"),
    FIELD_3("3", "货物盘点"),
    ;
    public final String code;
    public final String desc;

    AccountCategoryEnum(String code, String desc) {
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