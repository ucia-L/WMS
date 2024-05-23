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
* auto generate AnonymousStructure_C4FA1D15D6667A010FD16DE68FF5F6F8 structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_C4FA1D15D6667A010FD16DE68FF5F6F8 {
    public List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_46C8A8E71B06F587D170236042B53479> list = new ArrayList <>();
    public Long total;

    public List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_46C8A8E71B06F587D170236042B53479> getList() {
        return list;
    }

    public void setList(List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_46C8A8E71B06F587D170236042B53479> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

}
