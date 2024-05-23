package com.weitest.wms.domain.structure;

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
import com.weitest.wms.domain.entities.*;

/**
* auto generate DataOfEchartsStructure structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class DataOfEchartsStructure {
    @Label("时间")
    public List<java.time.LocalDate> date = new ArrayList <>();
    @Label("货物数量")
    public List<Long> count = new ArrayList <>();

    public List<java.time.LocalDate> getDate() {
        return date;
    }

    public void setDate(List<java.time.LocalDate> date) {
        this.date = date;
    }

    public List<Long> getCount() {
        return count;
    }

    public void setCount(List<Long> count) {
        this.count = count;
    }

}
