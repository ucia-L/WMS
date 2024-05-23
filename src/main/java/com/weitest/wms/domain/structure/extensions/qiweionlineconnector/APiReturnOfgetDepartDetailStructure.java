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
* auto generate APiReturnOfgetDepartDetailStructure structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class APiReturnOfgetDepartDetailStructure {
    public Long errcode;
    public String errmsg;
    public com.weitest.wms.domain.structure.extensions.qiweionlineconnector.DepartmentStructure department;

    public Long getErrcode() {
        return errcode;
    }

    public void setErrcode(Long errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public com.weitest.wms.domain.structure.extensions.qiweionlineconnector.DepartmentStructure getDepartment() {
        return department;
    }

    public void setDepartment(com.weitest.wms.domain.structure.extensions.qiweionlineconnector.DepartmentStructure department) {
        this.department = department;
    }

}
