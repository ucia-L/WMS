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
* auto generate AnonymousStructure_946782E67B818EC2F9357CB1045A1E1A structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_946782E67B818EC2F9357CB1045A1E1A {
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_BB4FB965175BDE58FCF4E5B9A7C8F1CE goods;

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_BB4FB965175BDE58FCF4E5B9A7C8F1CE getGoods() {
        return goods;
    }

    public void setGoods(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_BB4FB965175BDE58FCF4E5B9A7C8F1CE goods) {
        this.goods = goods;
    }

}
