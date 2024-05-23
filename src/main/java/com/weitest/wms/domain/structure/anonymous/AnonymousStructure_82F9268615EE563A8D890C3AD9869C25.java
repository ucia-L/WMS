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
* auto generate AnonymousStructure_82F9268615EE563A8D890C3AD9869C25 structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_82F9268615EE563A8D890C3AD9869C25 {
    public OutBoundWeighingEntity outBoundWeighing;
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_1CFEAF7A89F365EA335D6FAC750A04EC outBoundGood;

    public OutBoundWeighingEntity getOutBoundWeighing() {
        return outBoundWeighing;
    }

    public void setOutBoundWeighing(OutBoundWeighingEntity outBoundWeighing) {
        this.outBoundWeighing = outBoundWeighing;
    }

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_1CFEAF7A89F365EA335D6FAC750A04EC getOutBoundGood() {
        return outBoundGood;
    }

    public void setOutBoundGood(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_1CFEAF7A89F365EA335D6FAC750A04EC outBoundGood) {
        this.outBoundGood = outBoundGood;
    }

}
