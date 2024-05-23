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
* auto generate AnonymousStructure_71AFED732D709AF046E771165E69776D structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_71AFED732D709AF046E771165E69776D {
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_D123A06132C4DD854F4D5F6E40125293 warehouse;

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_D123A06132C4DD854F4D5F6E40125293 getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_D123A06132C4DD854F4D5F6E40125293 warehouse) {
        this.warehouse = warehouse;
    }

}
