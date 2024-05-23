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
* auto generate AnonymousStructure_9F8161883D490A0AB37214092BCEC0F7 structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_9F8161883D490A0AB37214092BCEC0F7 {
    public PackagedEntity packaged;
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_27C32852F2BB3841237FD137907EAAF4 outboundOrder;

    public PackagedEntity getPackaged() {
        return packaged;
    }

    public void setPackaged(PackagedEntity packaged) {
        this.packaged = packaged;
    }

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_27C32852F2BB3841237FD137907EAAF4 getOutboundOrder() {
        return outboundOrder;
    }

    public void setOutboundOrder(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_27C32852F2BB3841237FD137907EAAF4 outboundOrder) {
        this.outboundOrder = outboundOrder;
    }

}