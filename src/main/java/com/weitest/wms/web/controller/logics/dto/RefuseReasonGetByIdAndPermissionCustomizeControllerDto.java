package com.weitest.wms.web.controller.logics.dto;

import java.io.Serializable;
import com.weitest.wms.domain.*;
import com.weitest.wms.domain.enumeration.*;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.sql.Blob;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import com.weitest.wms.domain.entities.*;
import com.weitest.wms.domain.structure.*;

/**
* auto generate RefuseReasonGetByIdAndPermissionCustomizeControllerDto
*
* @author sys
*/
public class RefuseReasonGetByIdAndPermissionCustomizeControllerDto {
    
    public PermissionEnum permission;
    
    public Long id;

    public PermissionEnum getPermission() {
        return permission;
    }

    public void setPermission(PermissionEnum permission) {
        this.permission = permission;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
