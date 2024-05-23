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
* auto generate AllotOutboundEntity entity
*
* @author sys
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AllotOutboundEntity {
    @Label("调拨出库编号")
    public Long id;
    @Label("货物名称")
    public String name;
    @Label("货物单位")
    public UnitEnum unit;
    @Label("出库数量")
    public Long quantity;
    @Label("原仓库")
    public Long warehouse_Oid;
    @Label("目的仓库")
    public Long warehouse_Tid;
    @Label("原货区")
    public Long warehouseArea_Oid;
    @Label("目的货区")
    public Long warehouseArea_Tid;
    @Label("原架位id")
    public Long shelf_Oid;
    @Label("目的架位id")
    public Long shelf_Tid;
    @Label("调拨时间")
    @JsonFormat(pattern=DateTimeFormatConfiguration.ZONED_DATETIME_FORMAT, timezone=DateTimeFormatConfiguration.DEFAULT_TIMEZONE)
    public java.time.ZonedDateTime allotTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getWarehouse_Oid() {
        return warehouse_Oid;
    }

    public void setWarehouse_Oid(Long warehouse_Oid) {
        this.warehouse_Oid = warehouse_Oid;
    }

    public Long getWarehouse_Tid() {
        return warehouse_Tid;
    }

    public void setWarehouse_Tid(Long warehouse_Tid) {
        this.warehouse_Tid = warehouse_Tid;
    }

    public Long getWarehouseArea_Oid() {
        return warehouseArea_Oid;
    }

    public void setWarehouseArea_Oid(Long warehouseArea_Oid) {
        this.warehouseArea_Oid = warehouseArea_Oid;
    }

    public Long getWarehouseArea_Tid() {
        return warehouseArea_Tid;
    }

    public void setWarehouseArea_Tid(Long warehouseArea_Tid) {
        this.warehouseArea_Tid = warehouseArea_Tid;
    }

    public Long getShelf_Oid() {
        return shelf_Oid;
    }

    public void setShelf_Oid(Long shelf_Oid) {
        this.shelf_Oid = shelf_Oid;
    }

    public Long getShelf_Tid() {
        return shelf_Tid;
    }

    public void setShelf_Tid(Long shelf_Tid) {
        this.shelf_Tid = shelf_Tid;
    }

    public java.time.ZonedDateTime getAllotTime() {
        return allotTime;
    }

    public void setAllotTime(java.time.ZonedDateTime allotTime) {
        this.allotTime = allotTime;
    }

}