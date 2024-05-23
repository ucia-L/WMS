package com.weitest.wms.domain.enumeration;

import com.weitest.wms.domain.enumeration.BaseEnum;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonValue;

/**
* auto generate Refuse_goodEnum enum
*
* @author sys
*/
public enum Refuse_goodEnum implements BaseEnum<Refuse_goodEnum, String> {
    FIELD_0("0", "货物损坏"),
    FIELD_1("1", "货物质量问题"),
    FIELD_2("2", "数量不匹配"),
    FIELD_3("3", "违反退货政策"),
    FIELD_4("4", "超出容量"),
    FIELD_5("5", "无法识别的货物"),
    FIELD_6("6", "缺少必要文件或信息"),
    ;
    public final String code;
    public final String desc;

    Refuse_goodEnum(String code, String desc) {
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