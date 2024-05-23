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
* auto generate LCAPGetScopeResourceByRoleIdCustomizeService Mapper
*
* @author sys
*/
public interface LCAPGetScopeResourceByRoleIdCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_CF51E2CA3BEA957FFEB6CEA32F96003B> getAnonymousStructure_B676D945A9DD0D6FB27D68FFAC48D5EE(@Param("roleId") Long roleId);
Long countAnonymousStructure_B676D945A9DD0D6FB27D68FFAC48D5EE(@Param("roleId") Long roleId);

}
