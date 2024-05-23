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
* auto generate AnonymousStructure_7234C6E5312DBFBCDE7CA08D9310682F structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class AnonymousStructure_7234C6E5312DBFBCDE7CA08D9310682F {
    public String permission_status;
    public ApplyStatusEnum permission_value;
    public Long count;

    public String getPermission_status() {
        return permission_status;
    }

    public void setPermission_status(String permission_status) {
        this.permission_status = permission_status;
    }

    public ApplyStatusEnum getPermission_value() {
        return permission_value;
    }

    public void setPermission_value(ApplyStatusEnum permission_value) {
        this.permission_value = permission_value;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

}
