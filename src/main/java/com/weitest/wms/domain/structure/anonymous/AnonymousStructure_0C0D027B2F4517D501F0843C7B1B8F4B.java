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
* auto generate AnonymousStructure_0C0D027B2F4517D501F0843C7B1B8F4B structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_0C0D027B2F4517D501F0843C7B1B8F4B {
    public Long id;
    public java.time.ZonedDateTime createdTime;
    public java.time.ZonedDateTime updatedTime;
    public String createdBy;
    public String updatedBy;
    public String customer_name;
    public BigDecimal amount;
    public Long goods_num;
    public String responsible_person;
    public java.time.ZonedDateTime expected_date;
    public java.time.ZonedDateTime arrival_date;
    public String notes;
    public Status_orderEnum status;
    public String refuse_reason;
    public String id_tag;
    public String goods_list;
    public String goods_quantity_list;
    public String goods_unit_list;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.time.ZonedDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(java.time.ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public java.time.ZonedDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(java.time.ZonedDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(Long goods_num) {
        this.goods_num = goods_num;
    }

    public String getResponsible_person() {
        return responsible_person;
    }

    public void setResponsible_person(String responsible_person) {
        this.responsible_person = responsible_person;
    }

    public java.time.ZonedDateTime getExpected_date() {
        return expected_date;
    }

    public void setExpected_date(java.time.ZonedDateTime expected_date) {
        this.expected_date = expected_date;
    }

    public java.time.ZonedDateTime getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(java.time.ZonedDateTime arrival_date) {
        this.arrival_date = arrival_date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Status_orderEnum getStatus() {
        return status;
    }

    public void setStatus(Status_orderEnum status) {
        this.status = status;
    }

    public String getRefuse_reason() {
        return refuse_reason;
    }

    public void setRefuse_reason(String refuse_reason) {
        this.refuse_reason = refuse_reason;
    }

    public String getId_tag() {
        return id_tag;
    }

    public void setId_tag(String id_tag) {
        this.id_tag = id_tag;
    }

    public String getGoods_list() {
        return goods_list;
    }

    public void setGoods_list(String goods_list) {
        this.goods_list = goods_list;
    }

    public String getGoods_quantity_list() {
        return goods_quantity_list;
    }

    public void setGoods_quantity_list(String goods_quantity_list) {
        this.goods_quantity_list = goods_quantity_list;
    }

    public String getGoods_unit_list() {
        return goods_unit_list;
    }

    public void setGoods_unit_list(String goods_unit_list) {
        this.goods_unit_list = goods_unit_list;
    }

}
