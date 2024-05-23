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
* auto generate AnonymousStructure_01D52BAD13AF54738626B5A28BFE5BC8 structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_01D52BAD13AF54738626B5A28BFE5BC8 {
    public String warehouse_name;
    public Long w_id;
    public String warehouse_area_name;
    public Long wa_id;
    public String shelf_name;
    public Long s_id;
    public Long g_id;
    public String g_name;
    public Long g_quantity;
    public UnitEnum g_unit;
    public BigDecimal g_inboundPrice;

    public String getWarehouse_name() {
        return warehouse_name;
    }

    public void setWarehouse_name(String warehouse_name) {
        this.warehouse_name = warehouse_name;
    }

    public Long getW_id() {
        return w_id;
    }

    public void setW_id(Long w_id) {
        this.w_id = w_id;
    }

    public String getWarehouse_area_name() {
        return warehouse_area_name;
    }

    public void setWarehouse_area_name(String warehouse_area_name) {
        this.warehouse_area_name = warehouse_area_name;
    }

    public Long getWa_id() {
        return wa_id;
    }

    public void setWa_id(Long wa_id) {
        this.wa_id = wa_id;
    }

    public String getShelf_name() {
        return shelf_name;
    }

    public void setShelf_name(String shelf_name) {
        this.shelf_name = shelf_name;
    }

    public Long getS_id() {
        return s_id;
    }

    public void setS_id(Long s_id) {
        this.s_id = s_id;
    }

    public Long getG_id() {
        return g_id;
    }

    public void setG_id(Long g_id) {
        this.g_id = g_id;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public Long getG_quantity() {
        return g_quantity;
    }

    public void setG_quantity(Long g_quantity) {
        this.g_quantity = g_quantity;
    }

    public UnitEnum getG_unit() {
        return g_unit;
    }

    public void setG_unit(UnitEnum g_unit) {
        this.g_unit = g_unit;
    }

    public BigDecimal getG_inboundPrice() {
        return g_inboundPrice;
    }

    public void setG_inboundPrice(BigDecimal g_inboundPrice) {
        this.g_inboundPrice = g_inboundPrice;
    }

}
