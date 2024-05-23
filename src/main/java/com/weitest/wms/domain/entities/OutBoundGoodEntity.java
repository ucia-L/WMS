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
* auto generate OutBoundGoodEntity entity
*
* @author sys
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class OutBoundGoodEntity {
    @Label("出库货物编号")
    public Long id;
    @Label("出库订单编号")
    public Long outbound_order_id;
    @Label("货物名称")
    public String name;
    @Label("货物数量")
    public Long quantity;
    @Label("单位")
    public OutboundGood_unitEnum unit;
    @Label("货物状态")
    public OutBoundGoods_statusEnum status;
    @Label("重量")
    public BigDecimal weight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOutbound_order_id() {
        return outbound_order_id;
    }

    public void setOutbound_order_id(Long outbound_order_id) {
        this.outbound_order_id = outbound_order_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public OutboundGood_unitEnum getUnit() {
        return unit;
    }

    public void setUnit(OutboundGood_unitEnum unit) {
        this.unit = unit;
    }

    public OutBoundGoods_statusEnum getStatus() {
        return status;
    }

    public void setStatus(OutBoundGoods_statusEnum status) {
        this.status = status;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

}