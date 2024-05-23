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
* auto generate LoadInventoryGoodCustomizeService Mapper
*
* @author sys
*/
public interface LoadInventoryGoodCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_95099195743EB2065E42C28888106EDB> getAnonymousStructure_115E9C4C0500FD78F13E094BE9D1634A(@Param("filter") InventoryGoodEntity filter);
Long countAnonymousStructure_115E9C4C0500FD78F13E094BE9D1634A(@Param("filter") InventoryGoodEntity filter);

}
