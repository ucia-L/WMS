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
* auto generate AnonymousStructure_4801458D6ADF51D817C73959F167DAA9 structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_4801458D6ADF51D817C73959F167DAA9 {
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_757082548CF2D382C598EBD151485526 warehouseArea;

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_757082548CF2D382C598EBD151485526 getWarehouseArea() {
        return warehouseArea;
    }

    public void setWarehouseArea(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_757082548CF2D382C598EBD151485526 warehouseArea) {
        this.warehouseArea = warehouseArea;
    }

}
