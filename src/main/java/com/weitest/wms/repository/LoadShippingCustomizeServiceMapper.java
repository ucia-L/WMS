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
* auto generate LoadShippingCustomizeService Mapper
*
* @author sys
*/
public interface LoadShippingCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_23B1B08B16B24AF1DC6A6EE675730B10> getAnonymousStructure_321904DD212F927DB33236654C2F8994(@Param("ShipFilter") ShippingEntity ShipFilter,@Param("OrderFilter") OutboundOrderEntity OrderFilter);
Long countAnonymousStructure_321904DD212F927DB33236654C2F8994(@Param("ShipFilter") ShippingEntity ShipFilter,@Param("OrderFilter") OutboundOrderEntity OrderFilter);

}
