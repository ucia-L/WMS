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
* auto generate ShelfGoodInfoStructure structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class ShelfGoodInfoStructure {
    @Label("货物信息")
    public GoodsEntity goodInfo;
    @Label("入库暂存区名称")
    public String inbound_tmp_name;
    @Label("存储区名称")
    public String storage_name;
    @Label("货架名称")
    public String shelf_name;
    @Label("盘点状态")
    public Warehouse_statusEnum shelfStatus;

    public GoodsEntity getGoodInfo() {
        return goodInfo;
    }

    public void setGoodInfo(GoodsEntity goodInfo) {
        this.goodInfo = goodInfo;
    }

    public String getInbound_tmp_name() {
        return inbound_tmp_name;
    }

    public void setInbound_tmp_name(String inbound_tmp_name) {
        this.inbound_tmp_name = inbound_tmp_name;
    }

    public String getStorage_name() {
        return storage_name;
    }

    public void setStorage_name(String storage_name) {
        this.storage_name = storage_name;
    }

    public String getShelf_name() {
        return shelf_name;
    }

    public void setShelf_name(String shelf_name) {
        this.shelf_name = shelf_name;
    }

    public Warehouse_statusEnum getShelfStatus() {
        return shelfStatus;
    }

    public void setShelfStatus(Warehouse_statusEnum shelfStatus) {
        this.shelfStatus = shelfStatus;
    }

}
