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
* auto generate AnonymousStructure_9D03344DB7AB35A991C54E50A80AE1F9 structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_9D03344DB7AB35A991C54E50A80AE1F9 {
    public LCAPRolePerMapping lCAPRolePerMapping;
    public LCAPPermission lCAPPermission;

    public LCAPRolePerMapping getLCAPRolePerMapping() {
        return lCAPRolePerMapping;
    }

    public void setLCAPRolePerMapping(LCAPRolePerMapping lCAPRolePerMapping) {
        this.lCAPRolePerMapping = lCAPRolePerMapping;
    }

    public LCAPPermission getLCAPPermission() {
        return lCAPPermission;
    }

    public void setLCAPPermission(LCAPPermission lCAPPermission) {
        this.lCAPPermission = lCAPPermission;
    }

}
