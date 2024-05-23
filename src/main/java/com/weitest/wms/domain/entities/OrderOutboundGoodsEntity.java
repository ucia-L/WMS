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
* auto generate OrderOutboundGoodsEntity entity
*
* @author sys
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class OrderOutboundGoodsEntity {
    @Label("售后出库编号")
    public Long id;
    @Label("货物编号")
    public Long good_id;
    @Label("货物名称")
    public String name;
    @Label("货物单位")
    public UnitEnum unit;
    @Label("出库数量")
    public Long outboundCount;
    @Label("出库时间")
    @JsonFormat(pattern=DateTimeFormatConfiguration.ZONED_DATETIME_FORMAT, timezone=DateTimeFormatConfiguration.DEFAULT_TIMEZONE)
    public java.time.ZonedDateTime outboundDate;
    @Label("仓库名")
    public String warehouse_name;
    @Label("货区名")
    public String warehousearea_name;
    @Label("货架名")
    public String shelf_name;
    @Label("售后订单编号")
    public Long order_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGood_id() {
        return good_id;
    }

    public void setGood_id(Long good_id) {
        this.good_id = good_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UnitEnum getUnit() {
        return unit;
    }

    public void setUnit(UnitEnum unit) {
        this.unit = unit;
    }

    public Long getOutboundCount() {
        return outboundCount;
    }

    public void setOutboundCount(Long outboundCount) {
        this.outboundCount = outboundCount;
    }

    public java.time.ZonedDateTime getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(java.time.ZonedDateTime outboundDate) {
        this.outboundDate = outboundDate;
    }

    public String getWarehouse_name() {
        return warehouse_name;
    }

    public void setWarehouse_name(String warehouse_name) {
        this.warehouse_name = warehouse_name;
    }

    public String getWarehousearea_name() {
        return warehousearea_name;
    }

    public void setWarehousearea_name(String warehousearea_name) {
        this.warehousearea_name = warehousearea_name;
    }

    public String getShelf_name() {
        return shelf_name;
    }

    public void setShelf_name(String shelf_name) {
        this.shelf_name = shelf_name;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

}