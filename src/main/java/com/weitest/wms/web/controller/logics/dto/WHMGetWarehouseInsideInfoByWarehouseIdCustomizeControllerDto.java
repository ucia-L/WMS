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
* auto generate WHMGetWarehouseInsideInfoByWarehouseIdCustomizeControllerDto
*
* @author sys
*/
public class WHMGetWarehouseInsideInfoByWarehouseIdCustomizeControllerDto {
    
    public WarehouseAreaEntity filter;
    
    public Long warehouse_id;

    public WarehouseAreaEntity getFilter() {
        return filter;
    }

    public void setFilter(WarehouseAreaEntity filter) {
        this.filter = filter;
    }

    public Long getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Long warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

}
