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
* auto generate RefuseReasonGetByIdAndPermissionCustomizeService Mapper
*
* @author sys
*/
public interface RefuseReasonGetByIdAndPermissionCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_42ACE71392ED2686AE1F74A33B6E8332> getAnonymousStructure_DE6E0F77958CB8E3B8CAEE75D20D9D66(@Param("permission") PermissionEnum permission,@Param("id") Long id);
Long countAnonymousStructure_DE6E0F77958CB8E3B8CAEE75D20D9D66(@Param("permission") PermissionEnum permission,@Param("id") Long id);

}
