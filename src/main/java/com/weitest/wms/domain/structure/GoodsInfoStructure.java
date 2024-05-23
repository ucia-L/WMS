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
* auto generate GoodsInfoStructure structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class GoodsInfoStructure {
    public GoodsEntity goods;
    public String warehouse_name;
    public String warehouseArea_name;
    public String shelf_name;

    public GoodsEntity getGoods() {
        return goods;
    }

    public void setGoods(GoodsEntity goods) {
        this.goods = goods;
    }

    public String getWarehouse_name() {
        return warehouse_name;
    }

    public void setWarehouse_name(String warehouse_name) {
        this.warehouse_name = warehouse_name;
    }

    public String getWarehouseArea_name() {
        return warehouseArea_name;
    }

    public void setWarehouseArea_name(String warehouseArea_name) {
        this.warehouseArea_name = warehouseArea_name;
    }

    public String getShelf_name() {
        return shelf_name;
    }

    public void setShelf_name(String shelf_name) {
        this.shelf_name = shelf_name;
    }

}
