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
* auto generate LoadInboundManagementListView1CustomizeService Mapper
*
* @author sys
*/
public interface LoadInboundManagementListView1CustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_8FBEC37F0009D18C595E831E379F9806> getAnonymousStructure_3BD8627F316F26B90013F1C52321E84D(@Param("size") Long size,@Param("page") Long page);
Long countAnonymousStructure_3BD8627F316F26B90013F1C52321E84D(@Param("size") Long size,@Param("page") Long page);

}
