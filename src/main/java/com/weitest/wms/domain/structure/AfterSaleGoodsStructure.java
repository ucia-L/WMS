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
* auto generate AfterSaleGoodsStructure structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AfterSaleGoodsStructure {
    @Label("售后")
    public AfterSalesOrderEntity afterSales;
    @Label("货物")
    public List<AfterSaleGoodEntity> goods = new ArrayList <>();

    public AfterSalesOrderEntity getAfterSales() {
        return afterSales;
    }

    public void setAfterSales(AfterSalesOrderEntity afterSales) {
        this.afterSales = afterSales;
    }

    public List<AfterSaleGoodEntity> getGoods() {
        return goods;
    }

    public void setGoods(List<AfterSaleGoodEntity> goods) {
        this.goods = goods;
    }

}
