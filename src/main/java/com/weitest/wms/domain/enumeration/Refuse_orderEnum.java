package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate Refuse_orderEnum enum
*
* @author sys
*/
public enum Refuse_orderEnum implements BaseEnum<Refuse_orderEnum, String> {
    FIELD_0("0", "货物损坏"),
    FIELD_1("1", "货物数量不匹配"),
    FIELD_2("2", "仓库超出容量"),
    FIELD_3("3", "缺少必要文件或信息"),
    ;
    public final String code;
    public final String desc;

    Refuse_orderEnum(String code, String desc) {
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