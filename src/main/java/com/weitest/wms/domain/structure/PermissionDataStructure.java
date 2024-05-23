package com.weitest.wms.domain.structure;

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
* auto generate PermissionDataStructure structure
*
* @author sys
*/
@JsonAutoDetect(fieldVisibility=JsonAutoDetect.Visibility.ANY, getterVisibility=JsonAutoDetect.Visibility.NONE)
public class PermissionDataStructure {
    @Label("权限类型")
    public PermissionEnum permission_name;
    @Label("权限状态")
    public ApplyStatusEnum permission_status;

    public PermissionEnum getPermission_name() {
        return permission_name;
    }

    public void setPermission_name(PermissionEnum permission_name) {
        this.permission_name = permission_name;
    }

    public ApplyStatusEnum getPermission_status() {
        return permission_status;
    }

    public void setPermission_status(ApplyStatusEnum permission_status) {
        this.permission_status = permission_status;
    }

}