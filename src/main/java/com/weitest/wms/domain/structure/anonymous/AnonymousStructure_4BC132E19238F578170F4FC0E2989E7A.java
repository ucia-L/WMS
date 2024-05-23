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
* auto generate AnonymousStructure_4BC132E19238F578170F4FC0E2989E7A structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_4BC132E19238F578170F4FC0E2989E7A {
    public List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_E3C62BD932173A0ED274FCAFD69E4C99> list = new ArrayList <>();
    public Long total;

    public List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_E3C62BD932173A0ED274FCAFD69E4C99> getList() {
        return list;
    }

    public void setList(List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_E3C62BD932173A0ED274FCAFD69E4C99> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

}
