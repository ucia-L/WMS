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
* auto generate CommodityEntity entity
*
* @author sys
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class CommodityEntity {
    @Label("主键")
    public Long id;
    @Label("创建时间")
    @JsonFormat(pattern=DateTimeFormatConfiguration.ZONED_DATETIME_FORMAT, timezone=DateTimeFormatConfiguration.DEFAULT_TIMEZONE)
    public java.time.ZonedDateTime createdTime;
    @Label("创建者")
    public String createdBy;
    @Label("商品名称")
    public String name;
    @Label("存储上限")
    public Long storage_upper_limit;
    @Label("存储下限")
    public Long storage_lower_limit;
    @Label("入库价格")
    public BigDecimal inbound_price;
    @Label("出库价格")
    public BigDecimal outbound_price;
    @Label("商品数量")
    public Long quantity;
    @Label("备注")
    public String note;
    @Label("单位")
    public UnitEnum unit;
    @Label("图片")
    public String img_url;
    @Label("更新时间")
    @JsonFormat(pattern=DateTimeFormatConfiguration.ZONED_DATETIME_FORMAT, timezone=DateTimeFormatConfiguration.DEFAULT_TIMEZONE)
    public java.time.ZonedDateTime updatedTime;
    @Label("更新者")
    public String updatedBy;
    @Label("仓库id")
    public Long warehouse_id;

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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStorage_upper_limit() {
        return storage_upper_limit;
    }

    public void setStorage_upper_limit(Long storage_upper_limit) {
        this.storage_upper_limit = storage_upper_limit;
    }

    public Long getStorage_lower_limit() {
        return storage_lower_limit;
    }

    public void setStorage_lower_limit(Long storage_lower_limit) {
        this.storage_lower_limit = storage_lower_limit;
    }

    public BigDecimal getInbound_price() {
        return inbound_price;
    }

    public void setInbound_price(BigDecimal inbound_price) {
        this.inbound_price = inbound_price;
    }

    public BigDecimal getOutbound_price() {
        return outbound_price;
    }

    public void setOutbound_price(BigDecimal outbound_price) {
        this.outbound_price = outbound_price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public UnitEnum getUnit() {
        return unit;
    }

    public void setUnit(UnitEnum unit) {
        this.unit = unit;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public java.time.ZonedDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(java.time.ZonedDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Long getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Long warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

}