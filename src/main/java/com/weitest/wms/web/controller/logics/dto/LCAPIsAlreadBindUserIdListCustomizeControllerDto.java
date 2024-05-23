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
* auto generate LCAPIsAlreadBindUserIdListCustomizeControllerDto
*
* @author sys
*/
public class LCAPIsAlreadBindUserIdListCustomizeControllerDto {
    
    public String newUserId;
    
    public Long inputRoleId;

    public String getNewUserId() {
        return newUserId;
    }

    public void setNewUserId(String newUserId) {
        this.newUserId = newUserId;
    }

    public Long getInputRoleId() {
        return inputRoleId;
    }

    public void setInputRoleId(Long inputRoleId) {
        this.inputRoleId = inputRoleId;
    }

}
