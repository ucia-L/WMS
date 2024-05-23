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
* auto generate NumberOrderOutMoneyCustomizeService Mapper
*
* @author sys
*/
public interface NumberOrderOutMoneyCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_5A14F9A92CC4897170A1082F2B4A9FCF> getSql1(@Param("category") AccountCategoryEnum category);

}
