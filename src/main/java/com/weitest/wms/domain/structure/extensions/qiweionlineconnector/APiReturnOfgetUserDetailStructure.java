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
* auto generate APiReturnOfgetUserDetailStructure structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class APiReturnOfgetUserDetailStructure {
    public Long errcode;
    public String errmsg;
    public List<com.weitest.wms.domain.structure.extensions.qiweionlineconnector.Userlist1Structure> userlist = new ArrayList <>();

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

    public List<com.weitest.wms.domain.structure.extensions.qiweionlineconnector.Userlist1Structure> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<com.weitest.wms.domain.structure.extensions.qiweionlineconnector.Userlist1Structure> userlist) {
        this.userlist = userlist;
    }

}
