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
* auto generate OutboundOrderEntity entity
*
* @author sys
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class OutboundOrderEntity {
    @Label("出库订单主键")
    public Long id;
    @Label("顾客名称")
    public String customer_name;
    @Label("总金额")
    public BigDecimal amount;
    @Label("货物条目数量")
    public Long goods_num;
    @Label("出库订单创建时间")
    @JsonFormat(pattern=DateTimeFormatConfiguration.ZONED_DATETIME_FORMAT, timezone=DateTimeFormatConfiguration.DEFAULT_TIMEZONE)
    public java.time.ZonedDateTime outbound_order_createdTime;
    @Label("负责人")
    public String responsible_person;
    @Label("状态")
    public Outbound_statusEnum status;
    @Label("错误描述")
    public String error_description;

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

    public java.time.ZonedDateTime getOutbound_order_createdTime() {
        return outbound_order_createdTime;
    }

    public void setOutbound_order_createdTime(java.time.ZonedDateTime outbound_order_createdTime) {
        this.outbound_order_createdTime = outbound_order_createdTime;
    }

    public String getResponsible_person() {
        return responsible_person;
    }

    public void setResponsible_person(String responsible_person) {
        this.responsible_person = responsible_person;
    }

    public Outbound_statusEnum getStatus() {
        return status;
    }

    public void setStatus(Outbound_statusEnum status) {
        this.status = status;
    }

    public String getError_description() {
        return error_description;
    }

    public void setError_description(String error_description) {
        this.error_description = error_description;
    }

}