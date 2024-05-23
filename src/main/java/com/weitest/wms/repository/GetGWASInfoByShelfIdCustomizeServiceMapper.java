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
* auto generate GetGWASInfoByShelfIdCustomizeService Mapper
*
* @author sys
*/
public interface GetGWASInfoByShelfIdCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_01D52BAD13AF54738626B5A28BFE5BC8> getSql1(@Param("shelfId") Long shelfId);

}
