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
* auto generate InboundOrderFilterStructure structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class InboundOrderFilterStructure {
    @Label("订单")
    public OrdersEntity order;
    @Label("开始时间")
    public java.time.ZonedDateTime beginTime;
    @Label("结束时间")
    public java.time.ZonedDateTime endTime;

    public OrdersEntity getOrder() {
        return order;
    }

    public void setOrder(OrdersEntity order) {
        this.order = order;
    }

    public java.time.ZonedDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(java.time.ZonedDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public java.time.ZonedDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(java.time.ZonedDateTime endTime) {
        this.endTime = endTime;
    }

}
