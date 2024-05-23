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
* auto generate OrderInboundGoodsStructure structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class OrderInboundGoodsStructure {
    @Label("订单")
    public OrdersEntity order;
    @Label("货物")
    public List<InBoundGoodEntity> goods = new ArrayList <>();

    public OrdersEntity getOrder() {
        return order;
    }

    public void setOrder(OrdersEntity order) {
        this.order = order;
    }

    public List<InBoundGoodEntity> getGoods() {
        return goods;
    }

    public void setGoods(List<InBoundGoodEntity> goods) {
        this.goods = goods;
    }

}
