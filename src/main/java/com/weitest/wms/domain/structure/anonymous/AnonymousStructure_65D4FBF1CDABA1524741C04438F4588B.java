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
* auto generate AnonymousStructure_65D4FBF1CDABA1524741C04438F4588B structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_65D4FBF1CDABA1524741C04438F4588B {
    public OutBoundInspectionEntity outBoundInspection;
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_9F73B613FDE291645CE50F4B2C81A6D9 outBoundGood;

    public OutBoundInspectionEntity getOutBoundInspection() {
        return outBoundInspection;
    }

    public void setOutBoundInspection(OutBoundInspectionEntity outBoundInspection) {
        this.outBoundInspection = outBoundInspection;
    }

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_9F73B613FDE291645CE50F4B2C81A6D9 getOutBoundGood() {
        return outBoundGood;
    }

    public void setOutBoundGood(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_9F73B613FDE291645CE50F4B2C81A6D9 outBoundGood) {
        this.outBoundGood = outBoundGood;
    }

}
