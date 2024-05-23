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
* auto generate AnonymousStructure_A0E8F3604290BB6B607983E5884603F3 structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_A0E8F3604290BB6B607983E5884603F3 {
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_99F30D8C7176DAE95894A4AC499E93A2 outBoundGood;

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_99F30D8C7176DAE95894A4AC499E93A2 getOutBoundGood() {
        return outBoundGood;
    }

    public void setOutBoundGood(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_99F30D8C7176DAE95894A4AC499E93A2 outBoundGood) {
        this.outBoundGood = outBoundGood;
    }

}
