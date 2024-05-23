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
* auto generate GetWarehouseAreaCustomizeControllerDto
*
* @author sys
*/
public class GetWarehouseAreaCustomizeControllerDto {
    
    public WarehouseAreaEntity filer;

    public WarehouseAreaEntity getFiler() {
        return filer;
    }

    public void setFiler(WarehouseAreaEntity filer) {
        this.filer = filer;
    }

}
