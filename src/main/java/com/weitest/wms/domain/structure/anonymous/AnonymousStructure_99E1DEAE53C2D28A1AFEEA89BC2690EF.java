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
* auto generate AnonymousStructure_99E1DEAE53C2D28A1AFEEA89BC2690EF structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_99E1DEAE53C2D28A1AFEEA89BC2690EF {
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_FC8C5AA76D6EBC241E0F4EE65043445B warehouseArea;

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_FC8C5AA76D6EBC241E0F4EE65043445B getWarehouseArea() {
        return warehouseArea;
    }

    public void setWarehouseArea(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_FC8C5AA76D6EBC241E0F4EE65043445B warehouseArea) {
        this.warehouseArea = warehouseArea;
    }

}
