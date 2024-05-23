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
* auto generate AnonymousStructure_1E957FBA34F48431FB8E43537F5AB7E6 structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_1E957FBA34F48431FB8E43537F5AB7E6 {
    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_99F30D8C7176DAE95894A4AC499E93A2 shelf;

    public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_99F30D8C7176DAE95894A4AC499E93A2 getShelf() {
        return shelf;
    }

    public void setShelf(com.weitest.wms.domain.structure.anonymous.AnonymousStructure_99F30D8C7176DAE95894A4AC499E93A2 shelf) {
        this.shelf = shelf;
    }

}
