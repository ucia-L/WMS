package com.weitest.wms.domain.structure.anonymous;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.weitest.wms.annotation.Label;
import com.weitest.wms.domain.*;
import com.weitest.wms.domain.enumeration.*;
import com.weitest.wms.domain.structure.*;
import com.weitest.wms.domain.structure.anonymous.*;
import com.weitest.wms.domain.entities.*;

/**
* auto generate AnonymousStructure_A4D859148AAE9F95F73B990BB6297A2A structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_A4D859148AAE9F95F73B990BB6297A2A {
    public Long id;
    public String id_tag;
    public String name;
    public BigDecimal inbound_price;
    public String inbound_op;
    public String note;
    public Long quantity;
    public UnitEnum unit;
    public OtherInboundGood_statusEnum status;
    public java.time.ZonedDateTime inbound_time;
    public String refuse_reason;
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
