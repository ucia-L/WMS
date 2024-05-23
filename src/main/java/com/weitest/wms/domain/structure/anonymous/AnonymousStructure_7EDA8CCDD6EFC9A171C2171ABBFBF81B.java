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
* auto generate AnonymousStructure_7EDA8CCDD6EFC9A171C2171ABBFBF81B structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_7EDA8CCDD6EFC9A171C2171ABBFBF81B {
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_060D5B8B14A2D6DF2D0D4E26D91C1C2F outboundPacking;

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_060D5B8B14A2D6DF2D0D4E26D91C1C2F getOutboundPacking() {
        return outboundPacking;
    }

    public void setOutboundPacking(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_060D5B8B14A2D6DF2D0D4E26D91C1C2F outboundPacking) {
        this.outboundPacking = outboundPacking;
    }

}
