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
* auto generate AnonymousStructure_09BDCBA976A138647CE5FAE1CFBDB3A1 structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_09BDCBA976A138647CE5FAE1CFBDB3A1 {
    public List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_D3A798E5313781AC13C96C5E0CDD841E> list = new ArrayList <>();
    public Long total;

    public List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_D3A798E5313781AC13C96C5E0CDD841E> getList() {
        return list;
    }

    public void setList(List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_D3A798E5313781AC13C96C5E0CDD841E> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

}
