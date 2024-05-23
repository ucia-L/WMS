package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate MessageCategoryEnum enum
*
* @author sys
*/
public enum MessageCategoryEnum implements BaseEnum<MessageCategoryEnum, String> {
    FIELD_0("0", "管理员、仓内管理员"),
    FIELD_1("1", "仓内管理员"),
    ;
    public final String code;
    public final String desc;

    MessageCategoryEnum(String code, String desc) {
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