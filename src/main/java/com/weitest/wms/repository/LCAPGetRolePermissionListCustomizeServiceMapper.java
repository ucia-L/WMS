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
* auto generate LCAPGetRolePermissionListCustomizeService Mapper
*
* @author sys
*/
public interface LCAPGetRolePermissionListCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_9D03344DB7AB35A991C54E50A80AE1F9> getAnonymousStructure_0136396D558BF391361EA94F4EF87419(@Param("inputRoleId") Long inputRoleId);
Long countAnonymousStructure_0136396D558BF391361EA94F4EF87419(@Param("inputRoleId") Long inputRoleId);

}
