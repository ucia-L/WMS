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
* auto generate AnonymousStructure_99B5CB65B3B0BEF2E61F9C64025C5D2A structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_99B5CB65B3B0BEF2E61F9C64025C5D2A {
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_D49C7E59E0261BDC239301D26EB85E5C warehouseArea;

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_D49C7E59E0261BDC239301D26EB85E5C getWarehouseArea() {
        return warehouseArea;
    }

    public void setWarehouseArea(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_D49C7E59E0261BDC239301D26EB85E5C warehouseArea) {
        this.warehouseArea = warehouseArea;
    }

}
