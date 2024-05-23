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
* auto generate AnonymousStructure_90C927AEC6192B24A524A13F9820A290 structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_90C927AEC6192B24A524A13F9820A290 {
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_50E0FE00D9F5A89964C78762252509C4 goods;
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_3A9C61132F0053BED2603755484864E8 warehouse;
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_3A9C61132F0053BED2603755484864E8 warehouseArea;
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_3A9C61132F0053BED2603755484864E8 shelf;

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_50E0FE00D9F5A89964C78762252509C4 getGoods() {
        return goods;
    }

    public void setGoods(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_50E0FE00D9F5A89964C78762252509C4 goods) {
        this.goods = goods;
    }

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_3A9C61132F0053BED2603755484864E8 getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_3A9C61132F0053BED2603755484864E8 warehouse) {
        this.warehouse = warehouse;
    }

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_3A9C61132F0053BED2603755484864E8 getWarehouseArea() {
        return warehouseArea;
    }

    public void setWarehouseArea(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_3A9C61132F0053BED2603755484864E8 warehouseArea) {
        this.warehouseArea = warehouseArea;
    }

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_3A9C61132F0053BED2603755484864E8 getShelf() {
        return shelf;
    }

    public void setShelf(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_3A9C61132F0053BED2603755484864E8 shelf) {
        this.shelf = shelf;
    }

}
