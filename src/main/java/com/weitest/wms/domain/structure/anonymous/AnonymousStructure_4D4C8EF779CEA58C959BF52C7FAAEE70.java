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
* auto generate AnonymousStructure_4D4C8EF779CEA58C959BF52C7FAAEE70 structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_4D4C8EF779CEA58C959BF52C7FAAEE70 {
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_4DBD01C689017DAB3FA17AC3837E3C4E warehouseAccount;
    public WarehouseEntity warehouse;

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_4DBD01C689017DAB3FA17AC3837E3C4E getWarehouseAccount() {
        return warehouseAccount;
    }

    public void setWarehouseAccount(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_4DBD01C689017DAB3FA17AC3837E3C4E warehouseAccount) {
        this.warehouseAccount = warehouseAccount;
    }

    public WarehouseEntity getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseEntity warehouse) {
        this.warehouse = warehouse;
    }

}
