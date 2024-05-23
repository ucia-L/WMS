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
* auto generate AnonymousStructure_B14FEEF9F6D4753CB5DD8970359851D8 structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_B14FEEF9F6D4753CB5DD8970359851D8 {
    public OutBoundGoodEntity outBoundGood;
    public OutboundOrderEntity outboundOrder;

    public OutBoundGoodEntity getOutBoundGood() {
        return outBoundGood;
    }

    public void setOutBoundGood(OutBoundGoodEntity outBoundGood) {
        this.outBoundGood = outBoundGood;
    }

    public OutboundOrderEntity getOutboundOrder() {
        return outboundOrder;
    }

    public void setOutboundOrder(OutboundOrderEntity outboundOrder) {
        this.outboundOrder = outboundOrder;
    }

}
