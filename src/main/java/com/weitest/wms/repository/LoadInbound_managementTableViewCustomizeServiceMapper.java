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
* auto generate LoadInbound_managementTableViewCustomizeService Mapper
*
* @author sys
*/
public interface LoadInbound_managementTableViewCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_9C51235C084B53955268CCC880F52D83> getAnonymousStructure_066A0DCCF9CBA9BEF52F6A44E6C77E87(@Param("size") Long size,@Param("sort") String sort,@Param("page") Long page,@Param("order") String order);
Long countAnonymousStructure_066A0DCCF9CBA9BEF52F6A44E6C77E87(@Param("size") Long size,@Param("sort") String sort,@Param("page") Long page,@Param("order") String order);

}
