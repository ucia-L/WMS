package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate GoodCategoryEnum enum
*
* @author sys
*/
public enum GoodCategoryEnum implements BaseEnum<GoodCategoryEnum, String> {
    FIELD_0("0", "电子产品"),
    FIELD_1("1", "生活用品"),
    FIELD_2("2", "食品饮料"),
    FIELD_3("3", "学习用品"),
    FIELD_4("4", "体育用品"),
    FIELD_5("5", "文化用品"),
    FIELD_6("6", "花卉"),
    FIELD_7("7", "图书"),
    FIELD_8("8", "冷冻物品"),
    ;
    public final String code;
    public final String desc;

    GoodCategoryEnum(String code, String desc) {
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