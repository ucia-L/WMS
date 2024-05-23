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
* auto generate AnonymousStructure_CEE07BDB71ADD026A1700801271CF3DE structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_CEE07BDB71ADD026A1700801271CF3DE {
    public OutBoundSecSortingEntity outBoundSecSorting;
    public OutboundPackingEntity outboundPacking;

    public OutBoundSecSortingEntity getOutBoundSecSorting() {
        return outBoundSecSorting;
    }

    public void setOutBoundSecSorting(OutBoundSecSortingEntity outBoundSecSorting) {
        this.outBoundSecSorting = outBoundSecSorting;
    }

    public OutboundPackingEntity getOutboundPacking() {
        return outboundPacking;
    }

    public void setOutboundPacking(OutboundPackingEntity outboundPacking) {
        this.outboundPacking = outboundPacking;
    }

}
