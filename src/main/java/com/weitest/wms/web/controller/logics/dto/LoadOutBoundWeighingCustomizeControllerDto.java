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
* auto generate LoadOutBoundWeighingCustomizeControllerDto
*
* @author sys
*/
public class LoadOutBoundWeighingCustomizeControllerDto {
    
    public OutBoundWeighingEntity WeighFilter;
    
    public OutBoundGoodEntity GoodFilter;

    public OutBoundWeighingEntity getWeighFilter() {
        return WeighFilter;
    }

    public void setWeighFilter(OutBoundWeighingEntity WeighFilter) {
        this.WeighFilter = WeighFilter;
    }

    public OutBoundGoodEntity getGoodFilter() {
        return GoodFilter;
    }

    public void setGoodFilter(OutBoundGoodEntity GoodFilter) {
        this.GoodFilter = GoodFilter;
    }

}
