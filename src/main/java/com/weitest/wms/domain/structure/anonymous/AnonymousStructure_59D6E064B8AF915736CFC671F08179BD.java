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
* auto generate AnonymousStructure_59D6E064B8AF915736CFC671F08179BD structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_59D6E064B8AF915736CFC671F08179BD {
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_0ED2312EB461507E42D5DF2382F9660D warehouse;

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_0ED2312EB461507E42D5DF2382F9660D getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_0ED2312EB461507E42D5DF2382F9660D warehouse) {
        this.warehouse = warehouse;
    }

}
