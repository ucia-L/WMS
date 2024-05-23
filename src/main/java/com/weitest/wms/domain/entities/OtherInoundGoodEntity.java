package com.weitest.wms.domain.entities;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import java.util.ArrayList;
import java.util.HashMap;
import java.math.BigDecimal;
import java.util.UUID;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;

import com.weitest.wms.domain.entities.*;
import com.weitest.wms.domain.structure.*;
import com.weitest.wms.domain.enumeration.*;
import com.weitest.wms.annotation.Label;
import com.weitest.wms.config.DateTimeFormatConfiguration;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
* auto generate OtherInoundGoodEntity entity
*
* @author sys
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class OtherInoundGoodEntity {
    @Label("主键")
    @javax.validation.constraints.NotNull
    public Long id;
    @Label("货物编号")
    public String id_tag;
    @Label("货物名称")
    public String name;
    @Label("入库价格")
    public BigDecimal inbound_price;
    @Label("入库操作者")
    public String inbound_op;
    @Label("备注")
    public String note;
    @Label("数量")
    public Long quantity;
    @Label("单位")
    public UnitEnum unit;
    @Label("状态")
    public OtherInboundGood_statusEnum status;
    @Label("入库时间")
    @JsonFormat(pattern=DateTimeFormatConfiguration.ZONED_DATETIME_FORMAT, timezone=DateTimeFormatConfiguration.DEFAULT_TIMEZONE)
    public java.time.ZonedDateTime inbound_time;
    @Label("拒绝原因")
    public String refuse_reason;
    @Label("货物类型")
    public GoodCategoryEnum goodCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getId_tag() {
        return id_tag;
    }

    public void setId_tag(String id_tag) {
        this.id_tag = id_tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getInbound_price() {
        return inbound_price;
    }

    public void setInbound_price(BigDecimal inbound_price) {
        this.inbound_price = inbound_price;
    }

    public String getInbound_op() {
        return inbound_op;
    }

    public void setInbound_op(String inbound_op) {
        this.inbound_op = inbound_op;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public UnitEnum getUnit() {
        return unit;
    }

    public void setUnit(UnitEnum unit) {
        this.unit = unit;
    }

    public OtherInboundGood_statusEnum getStatus() {
        return status;
    }

    public void setStatus(OtherInboundGood_statusEnum status) {
        this.status = status;
    }

    public java.time.ZonedDateTime getInbound_time() {
        return inbound_time;
    }

    public void setInbound_time(java.time.ZonedDateTime inbound_time) {
        this.inbound_time = inbound_time;
    }

    public String getRefuse_reason() {
        return refuse_reason;
    }

    public void setRefuse_reason(String refuse_reason) {
        this.refuse_reason = refuse_reason;
    }

    public GoodCategoryEnum getGoodCategory() {
        return goodCategory;
    }

    public void setGoodCategory(GoodCategoryEnum goodCategory) {
        this.goodCategory = goodCategory;
    }

}