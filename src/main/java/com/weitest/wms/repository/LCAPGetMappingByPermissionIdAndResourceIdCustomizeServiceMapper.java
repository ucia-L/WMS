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
* auto generate LCAPGetMappingByPermissionIdAndResourceIdCustomizeService Mapper
*
* @author sys
*/
public interface LCAPGetMappingByPermissionIdAndResourceIdCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_D99966CE0A06FAAEEADD3A36C43F7DFF> getAnonymousStructure_38593AA815D055EA90DAB07FE4542F93(@Param("permissionId") Long permissionId,@Param("resourceId") Long resourceId);
Long countAnonymousStructure_38593AA815D055EA90DAB07FE4542F93(@Param("permissionId") Long permissionId,@Param("resourceId") Long resourceId);

}
