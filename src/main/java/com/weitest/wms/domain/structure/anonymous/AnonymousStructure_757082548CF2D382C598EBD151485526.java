package com.weitest.wms.domain.structure.anonymous;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.weitest.wms.annotation.Label;
import com.weitest.wms.domain.*;
import com.weitest.wms.domain.enumeration.*;
import com.weitest.wms.domain.structure.*;
import com.weitest.wms.domain.structure.anonymous.*;
import com.weitest.wms.domain.entities.*;

/**
* auto generate AnonymousStructure_757082548CF2D382C598EBD151485526 structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_757082548CF2D382C598EBD151485526 {
    public Long id;
    public String name;
    public Warehouse_statusEnum status;
    public String createdBy;
    public java.time.ZonedDateTime createdTime;
    public String id_tag;
    public WarehouseArea_categoryEnum category;
    public Long warehouse_id;

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

    public Warehouse_statusEnum getStatus() {
        return status;
    }

    public void setStatus(Warehouse_statusEnum status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public java.time.ZonedDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(java.time.ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public String getId_tag() {
        return id_tag;
    }

    public void setId_tag(String id_tag) {
        this.id_tag = id_tag;
    }

    public WarehouseArea_categoryEnum getCategory() {
        return category;
    }

    public void setCategory(WarehouseArea_categoryEnum category) {
        this.category = category;
    }

    public Long getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Long warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

}
