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
* auto generate GetShelfCustomizeControllerDto
*
* @author sys
*/
public class GetShelfCustomizeControllerDto {
    
    public ShelfEntity filer;

    public ShelfEntity getFiler() {
        return filer;
    }

    public void setFiler(ShelfEntity filer) {
        this.filer = filer;
    }

}
