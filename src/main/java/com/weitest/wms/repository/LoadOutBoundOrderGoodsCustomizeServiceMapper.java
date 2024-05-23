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
* auto generate LoadOutBoundOrderGoodsCustomizeService Mapper
*
* @author sys
*/
public interface LoadOutBoundOrderGoodsCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_A0E8F3604290BB6B607983E5884603F3> getAnonymousStructure_F4FCBEC33D3E6E7EA4A5B5D36520577A(@Param("OrderID") Long OrderID);
Long countAnonymousStructure_F4FCBEC33D3E6E7EA4A5B5D36520577A(@Param("OrderID") Long OrderID);

}
