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
* auto generate LoadOutBoundSortingsCustomizeService Mapper
*
* @author sys
*/
public interface LoadOutBoundSortingsCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_A8F4B8AFE158D2E0D7A23F1B1832027C> getAnonymousStructure_163CA7474D26B9AC2BAD752F9E8F8A43(@Param("packingFilter") OutboundPackingEntity packingFilter,@Param("sortingFilter") OutBoundSortingEntity sortingFilter);
Long countAnonymousStructure_163CA7474D26B9AC2BAD752F9E8F8A43(@Param("packingFilter") OutboundPackingEntity packingFilter,@Param("sortingFilter") OutBoundSortingEntity sortingFilter);

}
