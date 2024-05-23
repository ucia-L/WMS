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
* auto generate WHMGetShelfInfoByWarehouseAreaIdCustomizeControllerDto
*
* @author sys
*/
public class WHMGetShelfInfoByWarehouseAreaIdCustomizeControllerDto {
    
    public ShelfEntity filter;
    
    public Long warehouseArea_id;

    public ShelfEntity getFilter() {
        return filter;
    }

    public void setFilter(ShelfEntity filter) {
        this.filter = filter;
    }

    public Long getWarehouseArea_id() {
        return warehouseArea_id;
    }

    public void setWarehouseArea_id(Long warehouseArea_id) {
        this.warehouseArea_id = warehouseArea_id;
    }

}
