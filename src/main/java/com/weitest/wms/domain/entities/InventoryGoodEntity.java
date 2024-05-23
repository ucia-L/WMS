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
* auto generate InventoryGoodEntity entity
*
* @author sys
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class InventoryGoodEntity {
    @Label("主键")
    public Long id;
    @Label("名称")
    public String name = "";
    @Label("仓库编号")
    public Long warehouse_id;
    @Label("库区编号")
    public Long warehouseArea_id;
    @Label("货架编号")
    public Long shelf_id;
    @Label("货物数量")
    public Long quantity;
    @Label("真实数量")
    public Long real_quantity;
    @Label("收入或支出")
    public BigDecimal income_loss;
    @Label("作业编号")
    public Long task_id;
    @Label("货物编号")
    public Long good_id;
    @Label("单位")
    public UnitEnum unit;
    @Label("仓库名")
    public String w_name;
    @Label("库区名")
    public String wa_name;
    @Label("货架名")
    public String s_name;
    @Label("单价")
    public BigDecimal price;

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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getReal_quantity() {
        return real_quantity;
    }

    public void setReal_quantity(Long real_quantity) {
        this.real_quantity = real_quantity;
    }

    public BigDecimal getIncome_loss() {
        return income_loss;
    }

    public void setIncome_loss(BigDecimal income_loss) {
        this.income_loss = income_loss;
    }

    public Long getTask_id() {
        return task_id;
    }

    public void setTask_id(Long task_id) {
        this.task_id = task_id;
    }

    public Long getGood_id() {
        return good_id;
    }

    public void setGood_id(Long good_id) {
        this.good_id = good_id;
    }

    public UnitEnum getUnit() {
        return unit;
    }

    public void setUnit(UnitEnum unit) {
        this.unit = unit;
    }

    public String getW_name() {
        return w_name;
    }

    public void setW_name(String w_name) {
        this.w_name = w_name;
    }

    public String getWa_name() {
        return wa_name;
    }

    public void setWa_name(String wa_name) {
        this.wa_name = wa_name;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}