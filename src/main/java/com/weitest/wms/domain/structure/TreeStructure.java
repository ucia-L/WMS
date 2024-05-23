package com.weitest.wms.domain.structure;

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
import com.weitest.wms.domain.entities.*;

/**
* auto generate TreeStructure structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class TreeStructure {
    @Label("id-唯一标识")
    public Long id;
    @Label("名称")
    public String name;
    @Label("父级id")
    public Long parentId;
    @Label("仓库id")
    public Long warehouse_id;
    @Label("库区id")
    public Long warehouseArea_id;
    @Label("货架id")
    public Long shelf_id;

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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Long warehouse_id) {
        this.warehouse_id = warehouse_id;
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

}
