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
* auto generate AnonymousStructure_BB4FB965175BDE58FCF4E5B9A7C8F1CE structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_BB4FB965175BDE58FCF4E5B9A7C8F1CE {
    public Long id;
    public CategoryEnum category;
    public String name;
    public StatusEnum status;
    public Long quantity;
    public UnitEnum unit;
    public java.time.ZonedDateTime inbound_date;
    public String inbound_op;
    public java.time.ZonedDateTime outbound_date;
    public String outbound_op;
    public Long inbound_tmp_area;
    public String notes;
    public Long warehouse_id;
    public Long storage_area_id;
    public Long shelf_id;
    public Long order_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
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

    public java.time.ZonedDateTime getInbound_date() {
        return inbound_date;
    }

    public void setInbound_date(java.time.ZonedDateTime inbound_date) {
        this.inbound_date = inbound_date;
    }

    public String getInbound_op() {
        return inbound_op;
    }

    public void setInbound_op(String inbound_op) {
        this.inbound_op = inbound_op;
    }

    public java.time.ZonedDateTime getOutbound_date() {
        return outbound_date;
    }

    public void setOutbound_date(java.time.ZonedDateTime outbound_date) {
        this.outbound_date = outbound_date;
    }

    public String getOutbound_op() {
        return outbound_op;
    }

    public void setOutbound_op(String outbound_op) {
        this.outbound_op = outbound_op;
    }

    public Long getInbound_tmp_area() {
        return inbound_tmp_area;
    }

    public void setInbound_tmp_area(Long inbound_tmp_area) {
        this.inbound_tmp_area = inbound_tmp_area;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Long warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public Long getStorage_area_id() {
        return storage_area_id;
    }

    public void setStorage_area_id(Long storage_area_id) {
        this.storage_area_id = storage_area_id;
    }

    public Long getShelf_id() {
        return shelf_id;
    }

    public void setShelf_id(Long shelf_id) {
        this.shelf_id = shelf_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

}
