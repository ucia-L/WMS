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
* auto generate AnonymousStructure_1A7FFA1A5C4BC1530DBAB95885F848ED structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_1A7FFA1A5C4BC1530DBAB95885F848ED {
    public String username;
    public Long count;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

}
