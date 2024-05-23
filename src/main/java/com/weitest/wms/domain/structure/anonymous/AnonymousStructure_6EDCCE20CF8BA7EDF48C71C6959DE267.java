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
* auto generate AnonymousStructure_6EDCCE20CF8BA7EDF48C71C6959DE267 structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_6EDCCE20CF8BA7EDF48C71C6959DE267 {
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_CFEF30D72E0B3B444C44608CC6C74F6E orders;

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_CFEF30D72E0B3B444C44608CC6C74F6E getOrders() {
        return orders;
    }

    public void setOrders(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_CFEF30D72E0B3B444C44608CC6C74F6E orders) {
        this.orders = orders;
    }

}
