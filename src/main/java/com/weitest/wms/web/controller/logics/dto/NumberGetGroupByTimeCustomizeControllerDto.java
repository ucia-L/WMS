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
* auto generate NumberGetGroupByTimeCustomizeControllerDto
*
* @author sys
*/
public class NumberGetGroupByTimeCustomizeControllerDto {
    
    public CategoryEnum category;
    
    public Boolean InOrOut;

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public Boolean getInOrOut() {
        return InOrOut;
    }

    public void setInOrOut(Boolean InOrOut) {
        this.InOrOut = InOrOut;
    }

}
