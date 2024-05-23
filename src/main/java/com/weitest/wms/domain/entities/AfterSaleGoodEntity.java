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
* auto generate AfterSaleGoodEntity entity
*
* @author sys
*/
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AfterSaleGoodEntity {
    @Label("入库货物编号")
    public Long id;
    @Label("售后单号")
    public Long after_sale_id;
    @Label("货物名称")
    public String name;
    @Label("货物数量")
    public Long quantity;
    @Label("单位")
    public UnitEnum unit;
    @Label("入库状态")
    public AfterSalesGood_statusEnum status;
    @Label("备注")
    public String notes;
    @Label("货物类型")
    public GoodCategoryEnum goodCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAfter_sale_id() {
        return after_sale_id;
    }

    public void setAfter_sale_id(Long after_sale_id) {
        this.after_sale_id = after_sale_id;
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

    public UnitEnum getUnit() {
        return unit;
    }

    public void setUnit(UnitEnum unit) {
        this.unit = unit;
    }

    public AfterSalesGood_statusEnum getStatus() {
        return status;
    }

    public void setStatus(AfterSalesGood_statusEnum status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public GoodCategoryEnum getGoodCategory() {
        return goodCategory;
    }

    public void setGoodCategory(GoodCategoryEnum goodCategory) {
        this.goodCategory = goodCategory;
    }

}