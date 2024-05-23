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
* auto generate PackagedEntity entity
*
* @author sys
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class PackagedEntity {
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
    public Long outBoundOrderID;
    @Label("打包状态")
    public Packaged_statusEnum packaged_status;
    @Label("打包员工编号")
    public Long packagedWorkerID;
    @Label("打包员工姓名")
    public String packagedWorkerName;
    @Label("打包时间")
    @JsonFormat(pattern=DateTimeFormatConfiguration.ZONED_DATETIME_FORMAT, timezone=DateTimeFormatConfiguration.DEFAULT_TIMEZONE)
    public java.time.ZonedDateTime packagedTime;
    @Label("箱号")
    public Long box_ID;
    @Label("体积")
    public BigDecimal volume;

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

    public Long getOutBoundOrderID() {
        return outBoundOrderID;
    }

    public void setOutBoundOrderID(Long outBoundOrderID) {
        this.outBoundOrderID = outBoundOrderID;
    }

    public Packaged_statusEnum getPackaged_status() {
        return packaged_status;
    }

    public void setPackaged_status(Packaged_statusEnum packaged_status) {
        this.packaged_status = packaged_status;
    }

    public Long getPackagedWorkerID() {
        return packagedWorkerID;
    }

    public void setPackagedWorkerID(Long packagedWorkerID) {
        this.packagedWorkerID = packagedWorkerID;
    }

    public String getPackagedWorkerName() {
        return packagedWorkerName;
    }

    public void setPackagedWorkerName(String packagedWorkerName) {
        this.packagedWorkerName = packagedWorkerName;
    }

    public java.time.ZonedDateTime getPackagedTime() {
        return packagedTime;
    }

    public void setPackagedTime(java.time.ZonedDateTime packagedTime) {
        this.packagedTime = packagedTime;
    }

    public Long getBox_ID() {
        return box_ID;
    }

    public void setBox_ID(Long box_ID) {
        this.box_ID = box_ID;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

}