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
* auto generate LoadCANGCHUGUANLITableView6CustomizeService Mapper
*
* @author sys
*/
public interface LoadCANGCHUGUANLITableView6CustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_5FCA4D0BC12DD21DE8AB0B014AC1F1E5> getAnonymousStructure_8B7A01F9E9F20DE75E42AAFB1EC465EE(@Param("size") Long size,@Param("sort") String sort,@Param("page") Long page,@Param("order") String order);
Long countAnonymousStructure_8B7A01F9E9F20DE75E42AAFB1EC465EE(@Param("size") Long size,@Param("sort") String sort,@Param("page") Long page,@Param("order") String order);

}
