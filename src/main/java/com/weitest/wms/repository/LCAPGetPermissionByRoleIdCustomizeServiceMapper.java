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
* auto generate LCAPGetPermissionByRoleIdCustomizeService Mapper
*
* @author sys
*/
public interface LCAPGetPermissionByRoleIdCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_1C8D1250B6DC21B85363C7974FAD68BD> getAnonymousStructure_1406A78D88BEF361C3C93B65A4E2AB5A(@Param("roleId") Long roleId);
Long countAnonymousStructure_1406A78D88BEF361C3C93B65A4E2AB5A(@Param("roleId") Long roleId);

}
