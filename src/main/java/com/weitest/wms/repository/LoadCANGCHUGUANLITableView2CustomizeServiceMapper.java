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
* auto generate LoadCANGCHUGUANLITableView2CustomizeService Mapper
*
* @author sys
*/
public interface LoadCANGCHUGUANLITableView2CustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_46B102641248613FF08FAE8B2E5F02F5> getAnonymousStructure_BC7B3AE84F9C5B2486014DB3333180BF(@Param("filter") GoodsEntity filter,@Param("size") Long size,@Param("sort") String sort,@Param("page") Long page,@Param("order") String order);
Long countAnonymousStructure_BC7B3AE84F9C5B2486014DB3333180BF(@Param("filter") GoodsEntity filter,@Param("size") Long size,@Param("sort") String sort,@Param("page") Long page,@Param("order") String order);

}
