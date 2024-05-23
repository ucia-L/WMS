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
* auto generate AfterSalesOrderEntity entity
*
* @author sys
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AfterSalesOrderEntity {
    @Label("售后单号")
    public Long id;
    @Label("顾客名称")
    public String customer_name;
    @Label("负责人")
    public String responsible;
    @Label("总金额")
    public BigDecimal total_amount;
    @Label("货物条目数量")
    public Long number_of_cargo_entries;
    @Label("备注")
    public String notes;
    @Label("编号")
    public String id_tag;
    @Label("订单时间")
    @JsonFormat(pattern=DateTimeFormatConfiguration.ZONED_DATETIME_FORMAT, timezone=DateTimeFormatConfiguration.DEFAULT_TIMEZONE)
    public java.time.ZonedDateTime order_dateTime;
    @Label("售后订单状态")
    public Status_orderEnum status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    public Long getNumber_of_cargo_entries() {
        return number_of_cargo_entries;
    }

    public void setNumber_of_cargo_entries(Long number_of_cargo_entries) {
        this.number_of_cargo_entries = number_of_cargo_entries;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getId_tag() {
        return id_tag;
    }

    public void setId_tag(String id_tag) {
        this.id_tag = id_tag;
    }

    public java.time.ZonedDateTime getOrder_dateTime() {
        return order_dateTime;
    }

    public void setOrder_dateTime(java.time.ZonedDateTime order_dateTime) {
        this.order_dateTime = order_dateTime;
    }

    public Status_orderEnum getStatus() {
        return status;
    }

    public void setStatus(Status_orderEnum status) {
        this.status = status;
    }

}