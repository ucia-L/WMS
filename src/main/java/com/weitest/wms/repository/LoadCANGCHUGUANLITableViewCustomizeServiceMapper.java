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
* auto generate LoadCANGCHUGUANLITableViewCustomizeService Mapper
*
* @author sys
*/
public interface LoadCANGCHUGUANLITableViewCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_C71057545BF85840FA6BDA8BFC46C794> getAnonymousStructure_2FE03BCC710FA19E5C3AEF2BA6EF0337(@Param("filter") OutboundOrderEntity filter,@Param("size") Long size,@Param("sort") String sort,@Param("page") Long page,@Param("order") String order);
Long countAnonymousStructure_2FE03BCC710FA19E5C3AEF2BA6EF0337(@Param("filter") OutboundOrderEntity filter,@Param("size") Long size,@Param("sort") String sort,@Param("page") Long page,@Param("order") String order);

}
