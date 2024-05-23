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
* auto generate AnonymousStructure_538C452884504CDF1F5C6F474BB5137B structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_538C452884504CDF1F5C6F474BB5137B {
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_D0ADF7CED03D01CAD016DFC28024138D goods;
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_3A9C61132F0053BED2603755484864E8 shelf;
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_3A9C61132F0053BED2603755484864E8 warehouseArea;

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_D0ADF7CED03D01CAD016DFC28024138D getGoods() {
        return goods;
    }

    public void setGoods(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_D0ADF7CED03D01CAD016DFC28024138D goods) {
        this.goods = goods;
    }

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_3A9C61132F0053BED2603755484864E8 getShelf() {
        return shelf;
    }

    public void setShelf(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_3A9C61132F0053BED2603755484864E8 shelf) {
        this.shelf = shelf;
    }

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_3A9C61132F0053BED2603755484864E8 getWarehouseArea() {
        return warehouseArea;
    }

    public void setWarehouseArea(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_3A9C61132F0053BED2603755484864E8 warehouseArea) {
        this.warehouseArea = warehouseArea;
    }

}
