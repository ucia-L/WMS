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
* auto generate OutBoundWeighingEntity entity
*
* @author sys
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class OutBoundWeighingEntity {
    @Label("称重编号")
    @javax.validation.constraints.NotNull
    public Long id;
    @Label("出库订单编号")
    public Long orderID;
    @Label("货物编号")
    public Long outBoundGoodID;
    @Label("称重员工编号")
    public Long weighingWorkerID;
    @Label("称重员工姓名")
    public String weighingWorkerName;
    @Label("称重时间")
    @JsonFormat(pattern=DateTimeFormatConfiguration.ZONED_DATETIME_FORMAT, timezone=DateTimeFormatConfiguration.DEFAULT_TIMEZONE)
    public java.time.ZonedDateTime weighingTime;
    @Label("货物总重量")
    public BigDecimal weight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Long getOutBoundGoodID() {
        return outBoundGoodID;
    }

    public void setOutBoundGoodID(Long outBoundGoodID) {
        this.outBoundGoodID = outBoundGoodID;
    }

    public Long getWeighingWorkerID() {
        return weighingWorkerID;
    }

    public void setWeighingWorkerID(Long weighingWorkerID) {
        this.weighingWorkerID = weighingWorkerID;
    }

    public String getWeighingWorkerName() {
        return weighingWorkerName;
    }

    public void setWeighingWorkerName(String weighingWorkerName) {
        this.weighingWorkerName = weighingWorkerName;
    }

    public java.time.ZonedDateTime getWeighingTime() {
        return weighingTime;
    }

    public void setWeighingTime(java.time.ZonedDateTime weighingTime) {
        this.weighingTime = weighingTime;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

}