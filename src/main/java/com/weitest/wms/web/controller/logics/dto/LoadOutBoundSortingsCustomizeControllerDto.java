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
* auto generate LoadOutBoundSortingsCustomizeControllerDto
*
* @author sys
*/
public class LoadOutBoundSortingsCustomizeControllerDto {
    
    public OutboundPackingEntity packingFilter;
    
    public OutBoundSortingEntity sortingFilter;

    public OutboundPackingEntity getPackingFilter() {
        return packingFilter;
    }

    public void setPackingFilter(OutboundPackingEntity packingFilter) {
        this.packingFilter = packingFilter;
    }

    public OutBoundSortingEntity getSortingFilter() {
        return sortingFilter;
    }

    public void setSortingFilter(OutBoundSortingEntity sortingFilter) {
        this.sortingFilter = sortingFilter;
    }

}
