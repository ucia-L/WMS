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
* auto generate LoadCANGCHUGUANLITableView5CustomizeService Mapper
*
* @author sys
*/
public interface LoadCANGCHUGUANLITableView5CustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_B14FEEF9F6D4753CB5DD8970359851D8> getAnonymousStructure_9F40B7B7A2BDB287F40E3DFD2668B220(@Param("size") Long size,@Param("sort") String sort,@Param("page") Long page,@Param("order") String order);
Long countAnonymousStructure_9F40B7B7A2BDB287F40E3DFD2668B220(@Param("size") Long size,@Param("sort") String sort,@Param("page") Long page,@Param("order") String order);

}
