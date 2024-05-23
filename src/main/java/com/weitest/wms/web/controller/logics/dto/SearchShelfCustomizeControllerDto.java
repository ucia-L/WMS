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
* auto generate SearchShelfCustomizeControllerDto
*
* @author sys
*/
public class SearchShelfCustomizeControllerDto {
    
    public String Cargo_area;

    public String getCargo_area() {
        return Cargo_area;
    }

    public void setCargo_area(String Cargo_area) {
        this.Cargo_area = Cargo_area;
    }

}
