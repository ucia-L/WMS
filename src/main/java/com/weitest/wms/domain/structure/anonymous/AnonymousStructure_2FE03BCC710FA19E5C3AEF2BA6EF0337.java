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
* auto generate AnonymousStructure_2FE03BCC710FA19E5C3AEF2BA6EF0337 structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_2FE03BCC710FA19E5C3AEF2BA6EF0337 {
    public List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_C71057545BF85840FA6BDA8BFC46C794> list = new ArrayList <>();
    public Long total;

    public List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_C71057545BF85840FA6BDA8BFC46C794> getList() {
        return list;
    }

    public void setList(List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_C71057545BF85840FA6BDA8BFC46C794> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

}
