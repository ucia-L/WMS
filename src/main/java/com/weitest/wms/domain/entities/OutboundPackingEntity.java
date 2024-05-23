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
* auto generate OutboundPackingEntity entity
*
* @author sys
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class OutboundPackingEntity {
    @Label("配货编号")
    public Long id;
    @Label("商品编号")
    public Long outbound_good_id;
    @Label("数量")
    public Long quantity;
    @Label("仓库库区编号")
    public Long warehouseArea_id;
    @Label("货架编号")
    public Long shelf_id;
    @Label("出库暂存区")
    public Long outbound_tmparea_id;
    @Label("状态")
    public Packing_statusEnum status;
    @Label("出库商品名称")
    public String outbound_commodity_name;
    @Label("出库订单编号")
    public Long outBoundOrderID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOutbound_good_id() {
        return outbound_good_id;
    }

    public void setOutbound_good_id(Long outbound_good_id) {
        this.outbound_good_id = outbound_good_id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getWarehouseArea_id() {
        return warehouseArea_id;
    }

    public void setWarehouseArea_id(Long warehouseArea_id) {
        this.warehouseArea_id = warehouseArea_id;
    }

    public Long getShelf_id() {
        return shelf_id;
    }

    public void setShelf_id(Long shelf_id) {
        this.shelf_id = shelf_id;
    }

    public Long getOutbound_tmparea_id() {
        return outbound_tmparea_id;
    }

    public void setOutbound_tmparea_id(Long outbound_tmparea_id) {
        this.outbound_tmparea_id = outbound_tmparea_id;
    }

    public Packing_statusEnum getStatus() {
        return status;
    }

    public void setStatus(Packing_statusEnum status) {
        this.status = status;
    }

    public String getOutbound_commodity_name() {
        return outbound_commodity_name;
    }

    public void setOutbound_commodity_name(String outbound_commodity_name) {
        this.outbound_commodity_name = outbound_commodity_name;
    }

    public Long getOutBoundOrderID() {
        return outBoundOrderID;
    }

    public void setOutBoundOrderID(Long outBoundOrderID) {
        this.outBoundOrderID = outBoundOrderID;
    }

}