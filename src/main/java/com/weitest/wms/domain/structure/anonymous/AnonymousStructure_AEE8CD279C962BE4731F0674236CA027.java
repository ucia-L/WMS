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
* auto generate AnonymousStructure_AEE8CD279C962BE4731F0674236CA027 structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_AEE8CD279C962BE4731F0674236CA027 {
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_99054F86D63FF4EE6B9C15E8F5BB38E9 goods;
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_C17F1C08552FF64D58AEF610A908B489 warehouseArea;
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_8B12ACBB3885153300DE8C44F298C42F shelf;

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_99054F86D63FF4EE6B9C15E8F5BB38E9 getGoods() {
        return goods;
    }

    public void setGoods(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_99054F86D63FF4EE6B9C15E8F5BB38E9 goods) {
        this.goods = goods;
    }

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_C17F1C08552FF64D58AEF610A908B489 getWarehouseArea() {
        return warehouseArea;
    }

    public void setWarehouseArea(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_C17F1C08552FF64D58AEF610A908B489 warehouseArea) {
        this.warehouseArea = warehouseArea;
    }

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_8B12ACBB3885153300DE8C44F298C42F getShelf() {
        return shelf;
    }

    public void setShelf(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_8B12ACBB3885153300DE8C44F298C42F shelf) {
        this.shelf = shelf;
    }

}
