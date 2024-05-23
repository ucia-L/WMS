package com.weitest.wms.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.weitest.wms.domain.enumeration.*;
import com.weitest.wms.domain.*;
import com.weitest.wms.web.interceptor.annotation.*;
import com.weitest.wms.datasource.dynamic.DataSource;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.sql.Blob;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import com.weitest.wms.domain.entities.*;
import com.weitest.wms.domain.structure.*;

/**
* auto generate LoadOutBoundSecSortingsCustomizeService Mapper
*
* @author sys
*/
public interface LoadOutBoundSecSortingsCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_CEE07BDB71ADD026A1700801271CF3DE> getAnonymousStructure_919B1BD35940FF5F19FE0AD0A28FBDBA(@Param("packingFilter") OutboundPackingEntity packingFilter,@Param("sortingFilter") OutBoundSecSortingEntity sortingFilter);
Long countAnonymousStructure_919B1BD35940FF5F19FE0AD0A28FBDBA(@Param("packingFilter") OutboundPackingEntity packingFilter,@Param("sortingFilter") OutBoundSecSortingEntity sortingFilter);

}
