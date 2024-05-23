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
* auto generate OutBoundSortingEntity entity
*
* @author sys
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class OutBoundSortingEntity {
    @Label("编号")
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
    @Label("配货表编号")
    public Long packingID;
    @Label("分拣状态")
    public Sorting_statusEnum status;
    @Label("分拣员工编号")
    public Long sortingWorkerID;
    @Label("分拣员工姓名")
    public String sortingWorkerName;
    @Label("分拣时间")
    @JsonFormat(pattern=DateTimeFormatConfiguration.ZONED_DATETIME_FORMAT, timezone=DateTimeFormatConfiguration.DEFAULT_TIMEZONE)
    public java.time.ZonedDateTime sortingData;
    @Label("出库暂留区")
    public String outBoundTmpArea;

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

    public Long getPackingID() {
        return packingID;
    }

    public void setPackingID(Long packingID) {
        this.packingID = packingID;
    }

    public Sorting_statusEnum getStatus() {
        return status;
    }

    public void setStatus(Sorting_statusEnum status) {
        this.status = status;
    }

    public Long getSortingWorkerID() {
        return sortingWorkerID;
    }

    public void setSortingWorkerID(Long sortingWorkerID) {
        this.sortingWorkerID = sortingWorkerID;
    }

    public String getSortingWorkerName() {
        return sortingWorkerName;
    }

    public void setSortingWorkerName(String sortingWorkerName) {
        this.sortingWorkerName = sortingWorkerName;
    }

    public java.time.ZonedDateTime getSortingData() {
        return sortingData;
    }

    public void setSortingData(java.time.ZonedDateTime sortingData) {
        this.sortingData = sortingData;
    }

    public String getOutBoundTmpArea() {
        return outBoundTmpArea;
    }

    public void setOutBoundTmpArea(String outBoundTmpArea) {
        this.outBoundTmpArea = outBoundTmpArea;
    }

}