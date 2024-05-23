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
* auto generate GetOnShelfGoodCustomizeService Mapper
*
* @author sys
*/
public interface GetOnShelfGoodCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_538C452884504CDF1F5C6F474BB5137B> getAnonymousStructure_DA8A610763611813585B792716CAD46A(@Param("warehouse_id") Long warehouse_id);
Long countAnonymousStructure_DA8A610763611813585B792716CAD46A(@Param("warehouse_id") Long warehouse_id);

}
