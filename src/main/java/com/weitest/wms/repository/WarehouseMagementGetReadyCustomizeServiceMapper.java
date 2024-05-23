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
* auto generate WarehouseMagementGetReadyCustomizeService Mapper
*
* @author sys
*/
public interface WarehouseMagementGetReadyCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_9C51235C084B53955268CCC880F52D83> getAnonymousStructure_066A0DCCF9CBA9BEF52F6A44E6C77E87(@Param("Serch") OnShelfFilterStructure Serch);
Long countAnonymousStructure_066A0DCCF9CBA9BEF52F6A44E6C77E87(@Param("Serch") OnShelfFilterStructure Serch);
String getSql1(@Param("item") com.weitest.wms.domain.structure.anonymous.AnonymousStructure_9C51235C084B53955268CCC880F52D83 item);
String getSql2(@Param("item") com.weitest.wms.domain.structure.anonymous.AnonymousStructure_9C51235C084B53955268CCC880F52D83 item);
String getSql3(@Param("item") com.weitest.wms.domain.structure.anonymous.AnonymousStructure_9C51235C084B53955268CCC880F52D83 item);
List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_E3C62BD932173A0ED274FCAFD69E4C99> getAnonymousStructure_4BC132E19238F578170F4FC0E2989E7A(@Param("item") com.weitest.wms.domain.structure.anonymous.AnonymousStructure_9C51235C084B53955268CCC880F52D83 item);
Long countAnonymousStructure_4BC132E19238F578170F4FC0E2989E7A(@Param("item") com.weitest.wms.domain.structure.anonymous.AnonymousStructure_9C51235C084B53955268CCC880F52D83 item);

}
