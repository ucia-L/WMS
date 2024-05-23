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
* auto generate LCAPLoadPermissionResourceListViewCustomizeService Mapper
*
* @author sys
*/
public interface LCAPLoadPermissionResourceListViewCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_EA050579F163467B7D2FD3E8C15362AF> getAnonymousStructure_D8CB63E646D19A8E127BF2A118560F92(@Param("size") Long size,@Param("page") Long page);
Long countAnonymousStructure_D8CB63E646D19A8E127BF2A118560F92(@Param("size") Long size,@Param("page") Long page);

}
