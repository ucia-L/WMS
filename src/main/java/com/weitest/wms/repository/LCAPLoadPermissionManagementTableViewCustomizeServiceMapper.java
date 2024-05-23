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
* auto generate LCAPLoadPermissionManagementTableViewCustomizeService Mapper
*
* @author sys
*/
public interface LCAPLoadPermissionManagementTableViewCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_92F2372792A8A12DF53175B7AD25D2FD> getAnonymousStructure_D5C9C5DD94C4E7386BEED9E75D0F06FA(@Param("filter") LCAPPermission filter,@Param("size") Long size,@Param("sort") String sort,@Param("page") Long page,@Param("order") String order);
Long countAnonymousStructure_D5C9C5DD94C4E7386BEED9E75D0F06FA(@Param("filter") LCAPPermission filter,@Param("size") Long size,@Param("sort") String sort,@Param("page") Long page,@Param("order") String order);

}
