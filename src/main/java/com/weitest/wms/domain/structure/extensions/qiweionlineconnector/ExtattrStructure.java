package com.weitest.wms.domain.structure.extensions.qiweionlineconnector;

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
* auto generate ExtattrStructure structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class ExtattrStructure {
    public List<com.weitest.wms.domain.structure.extensions.qiweionlineconnector.Attrs2Structure> attrs = new ArrayList <>();

    public List<com.weitest.wms.domain.structure.extensions.qiweionlineconnector.Attrs2Structure> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<com.weitest.wms.domain.structure.extensions.qiweionlineconnector.Attrs2Structure> attrs) {
        this.attrs = attrs;
    }

}
