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
* auto generate WarehouseEntity entity
*
* @author sys
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class WarehouseEntity {
    @Label("主键")
    public Long id;
    @Label("仓库名称")
    public String name;
    @Label("仓库编号")
    public String id_tag;
    @Label("仓库创建时间")
    @JsonFormat(pattern=DateTimeFormatConfiguration.ZONED_DATETIME_FORMAT, timezone=DateTimeFormatConfiguration.DEFAULT_TIMEZONE)
    public java.time.ZonedDateTime createdTime;
    @Label("仓库创建者")
    public String createdBy;
    @Label("状态")
    public Warehouse_statusEnum status;
    @Label("余额")
    public BigDecimal balance;
    public Long capacity = 0L;
    public Long current_quantity = 0L;

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

    public String getId_tag() {
        return id_tag;
    }

    public void setId_tag(String id_tag) {
        this.id_tag = id_tag;
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

    public Warehouse_statusEnum getStatus() {
        return status;
    }

    public void setStatus(Warehouse_statusEnum status) {
        this.status = status;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public Long getCurrent_quantity() {
        return current_quantity;
    }

    public void setCurrent_quantity(Long current_quantity) {
        this.current_quantity = current_quantity;
    }

}