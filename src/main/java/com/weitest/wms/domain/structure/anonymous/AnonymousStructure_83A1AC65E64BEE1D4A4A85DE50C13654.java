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
* auto generate AnonymousStructure_83A1AC65E64BEE1D4A4A85DE50C13654 structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_83A1AC65E64BEE1D4A4A85DE50C13654 {
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_99F30D8C7176DAE95894A4AC499E93A2 warehouseArea;

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_99F30D8C7176DAE95894A4AC499E93A2 getWarehouseArea() {
        return warehouseArea;
    }

    public void setWarehouseArea(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_99F30D8C7176DAE95894A4AC499E93A2 warehouseArea) {
        this.warehouseArea = warehouseArea;
    }

}
