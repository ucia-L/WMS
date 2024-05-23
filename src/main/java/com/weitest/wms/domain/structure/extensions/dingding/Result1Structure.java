package com.weitest.wms.domain.structure.extensions.dingding;

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
* auto generate Result1Structure structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class Result1Structure {
    public List<Long> parent_id_list = new ArrayList <>();

    public List<Long> getParent_id_list() {
        return parent_id_list;
    }

    public void setParent_id_list(List<Long> parent_id_list) {
        this.parent_id_list = parent_id_list;
    }

}
