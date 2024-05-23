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
* auto generate LCAPLoadUserRoleMappingTableViewCustomizeService Mapper
*
* @author sys
*/
public interface LCAPLoadUserRoleMappingTableViewCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_99BA20F3093BB3AC3F3CA0BCA6D65EB8> getAnonymousStructure_A43B95DDE943F37E89AA74CCF8732C90(@Param("filter") LCAPUserRoleMapping filter,@Param("size") Long size,@Param("sort") String sort,@Param("page") Long page,@Param("order") String order);
Long countAnonymousStructure_A43B95DDE943F37E89AA74CCF8732C90(@Param("filter") LCAPUserRoleMapping filter,@Param("size") Long size,@Param("sort") String sort,@Param("page") Long page,@Param("order") String order);

}
