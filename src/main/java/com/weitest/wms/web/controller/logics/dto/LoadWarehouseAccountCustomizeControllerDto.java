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
* auto generate LoadWarehouseAccountCustomizeControllerDto
*
* @author sys
*/
public class LoadWarehouseAccountCustomizeControllerDto {
    
    public WarehouseAccountEntity filter;
    
    public java.time.ZonedDateTime startTime;
    
    public java.time.ZonedDateTime endTime;
    
    public Long warehouse_id;

    public WarehouseAccountEntity getFilter() {
        return filter;
    }

    public void setFilter(WarehouseAccountEntity filter) {
        this.filter = filter;
    }

    public java.time.ZonedDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(java.time.ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public java.time.ZonedDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(java.time.ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    public Long getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Long warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

}
