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
* auto generate OutBoundInspectionEntity entity
*
* @author sys
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class OutBoundInspectionEntity {
    @Label("主键")
    @javax.validation.constraints.NotNull
    public Long id;
    @Label("创建时间")
    @JsonFormat(pattern=DateTimeFormatConfiguration.ZONED_DATETIME_FORMAT, timezone=DateTimeFormatConfiguration.DEFAULT_TIMEZONE)
    public java.time.ZonedDateTime createdTime;
    @Label("更新时间")
    @JsonFormat(pattern=DateTimeFormatConfiguration.ZONED_DATETIME_FORMAT, timezone=DateTimeFormatConfiguration.DEFAULT_TIMEZONE)
    public java.time.ZonedDateTime updatedTime;
    @Label("创建者")
    public String createdBy;
    @Label("更新者")
    public String updatedBy;
    @Label("出库订单编号")
    public Long orderID;
    @Label("货物编号")
    public Long outBoundGoodID;
    @Label("验货状态")
    public Inspection_statusEnum inspection_status;
    @Label("验货员工编号")
    public Long inspectionWorkerID;
    @Label("验货员工姓名")
    public String inspectionWorkerName;
    @Label("验货时间")
    @JsonFormat(pattern=DateTimeFormatConfiguration.ZONED_DATETIME_FORMAT, timezone=DateTimeFormatConfiguration.DEFAULT_TIMEZONE)
    public java.time.ZonedDateTime inspectionTime;
    @Label("备注")
    public String note;

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

    public Inspection_statusEnum getInspection_status() {
        return inspection_status;
    }

    public void setInspection_status(Inspection_statusEnum inspection_status) {
        this.inspection_status = inspection_status;
    }

    public Long getInspectionWorkerID() {
        return inspectionWorkerID;
    }

    public void setInspectionWorkerID(Long inspectionWorkerID) {
        this.inspectionWorkerID = inspectionWorkerID;
    }

    public String getInspectionWorkerName() {
        return inspectionWorkerName;
    }

    public void setInspectionWorkerName(String inspectionWorkerName) {
        this.inspectionWorkerName = inspectionWorkerName;
    }

    public java.time.ZonedDateTime getInspectionTime() {
        return inspectionTime;
    }

    public void setInspectionTime(java.time.ZonedDateTime inspectionTime) {
        this.inspectionTime = inspectionTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}