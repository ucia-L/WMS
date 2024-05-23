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
* auto generate ShippingEntity entity
*
* @author sys
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class ShippingEntity {
    @Label("主键")
    @javax.validation.constraints.NotNull
    public Long id;
    @Label("更新者")
    public String updatedBy;
    @Label("更新时间")
    @JsonFormat(pattern=DateTimeFormatConfiguration.ZONED_DATETIME_FORMAT, timezone=DateTimeFormatConfiguration.DEFAULT_TIMEZONE)
    public java.time.ZonedDateTime updatedTime;
    @Label("创建者")
    public String createdBy;
    @Label("创建时间")
    @JsonFormat(pattern=DateTimeFormatConfiguration.ZONED_DATETIME_FORMAT, timezone=DateTimeFormatConfiguration.DEFAULT_TIMEZONE)
    public java.time.ZonedDateTime createdTime;
    @Label("出货订单编号")
    public Long outBoundOrderID;
    @Label("发货员工编号")
    public Long shippingWorkerID;
    @Label("发货员工姓名")
    public String shippingWorkerName;
    @Label("发货状态")
    public Shipping_statusEnum shipping_status;
    @Label("快递单号")
    public String express_id;
    @Label("快递公司")
    public String express_company;
    @Label("发货时间")
    @JsonFormat(pattern=DateTimeFormatConfiguration.ZONED_DATETIME_FORMAT, timezone=DateTimeFormatConfiguration.DEFAULT_TIMEZONE)
    public java.time.ZonedDateTime shippingTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
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

    public java.time.ZonedDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(java.time.ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public Long getOutBoundOrderID() {
        return outBoundOrderID;
    }

    public void setOutBoundOrderID(Long outBoundOrderID) {
        this.outBoundOrderID = outBoundOrderID;
    }

    public Long getShippingWorkerID() {
        return shippingWorkerID;
    }

    public void setShippingWorkerID(Long shippingWorkerID) {
        this.shippingWorkerID = shippingWorkerID;
    }

    public String getShippingWorkerName() {
        return shippingWorkerName;
    }

    public void setShippingWorkerName(String shippingWorkerName) {
        this.shippingWorkerName = shippingWorkerName;
    }

    public Shipping_statusEnum getShipping_status() {
        return shipping_status;
    }

    public void setShipping_status(Shipping_statusEnum shipping_status) {
        this.shipping_status = shipping_status;
    }

    public String getExpress_id() {
        return express_id;
    }

    public void setExpress_id(String express_id) {
        this.express_id = express_id;
    }

    public String getExpress_company() {
        return express_company;
    }

    public void setExpress_company(String express_company) {
        this.express_company = express_company;
    }

    public java.time.ZonedDateTime getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(java.time.ZonedDateTime shippingTime) {
        this.shippingTime = shippingTime;
    }

}