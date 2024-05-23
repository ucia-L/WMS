package com.weitest.wms.web.controller.logics.dto;

import java.io.Serializable;
import com.weitest.wms.domain.*;
import com.weitest.wms.domain.enumeration.*;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.sql.Blob;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import com.weitest.wms.domain.entities.*;
import com.weitest.wms.domain.structure.*;

/**
* auto generate LoadShippingCustomizeControllerDto
*
* @author sys
*/
public class LoadShippingCustomizeControllerDto {
    
    public OutboundOrderEntity OrderFilter;
    
    public ShippingEntity ShipFilter;

    public OutboundOrderEntity getOrderFilter() {
        return OrderFilter;
    }

    public void setOrderFilter(OutboundOrderEntity OrderFilter) {
        this.OrderFilter = OrderFilter;
    }

    public ShippingEntity getShipFilter() {
        return ShipFilter;
    }

    public void setShipFilter(ShippingEntity ShipFilter) {
        this.ShipFilter = ShipFilter;
    }

}
