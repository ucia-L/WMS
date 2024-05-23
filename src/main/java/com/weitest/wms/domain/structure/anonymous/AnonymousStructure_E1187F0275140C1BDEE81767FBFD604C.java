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
* auto generate AnonymousStructure_E1187F0275140C1BDEE81767FBFD604C structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_E1187F0275140C1BDEE81767FBFD604C {
    public GoodsEntity goods;
    public ShelfEntity shelf;
    public WarehouseAreaEntity warehouseArea;

    public GoodsEntity getGoods() {
        return goods;
    }

    public void setGoods(GoodsEntity goods) {
        this.goods = goods;
    }

    public ShelfEntity getShelf() {
        return shelf;
    }

    public void setShelf(ShelfEntity shelf) {
        this.shelf = shelf;
    }

    public WarehouseAreaEntity getWarehouseArea() {
        return warehouseArea;
    }

    public void setWarehouseArea(WarehouseAreaEntity warehouseArea) {
        this.warehouseArea = warehouseArea;
    }

}
