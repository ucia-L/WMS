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
* auto generate AnonymousStructure_E69C6A05AFC359D00B28F67D0E02C8E5 structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_E69C6A05AFC359D00B28F67D0E02C8E5 {
    public LCAPUserRoleMapping lCAPUserRoleMapping;

    public LCAPUserRoleMapping getLCAPUserRoleMapping() {
        return lCAPUserRoleMapping;
    }

    public void setLCAPUserRoleMapping(LCAPUserRoleMapping lCAPUserRoleMapping) {
        this.lCAPUserRoleMapping = lCAPUserRoleMapping;
    }

}
