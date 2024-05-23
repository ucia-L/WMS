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
* auto generate LoadInboundManagementListViewCustomizeService Mapper
*
* @author sys
*/
public interface LoadInboundManagementListViewCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_95099195743EB2065E42C28888106EDB> getAnonymousStructure_115E9C4C0500FD78F13E094BE9D1634A(@Param("size") Long size,@Param("page") Long page);
Long countAnonymousStructure_115E9C4C0500FD78F13E094BE9D1634A(@Param("size") Long size,@Param("page") Long page);

}
