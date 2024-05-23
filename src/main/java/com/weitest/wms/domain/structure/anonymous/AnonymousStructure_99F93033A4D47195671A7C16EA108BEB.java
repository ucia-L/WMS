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
* auto generate AnonymousStructure_99F93033A4D47195671A7C16EA108BEB structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_99F93033A4D47195671A7C16EA108BEB {
    public Long outbound_order_id;
    public BigDecimal allWeight;

    public Long getOutbound_order_id() {
        return outbound_order_id;
    }

    public void setOutbound_order_id(Long outbound_order_id) {
        this.outbound_order_id = outbound_order_id;
    }

    public BigDecimal getAllWeight() {
        return allWeight;
    }

    public void setAllWeight(BigDecimal allWeight) {
        this.allWeight = allWeight;
    }

}
