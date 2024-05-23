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
* auto generate OrderGetInfoCustomizeService Mapper
*
* @author sys
*/
public interface OrderGetInfoCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_6EDCCE20CF8BA7EDF48C71C6959DE267> getAnonymousStructure_2939E2BD009F159DEECDA97A8CF7E2AE(@Param("fliter") OrdersEntity fliter);
Long countAnonymousStructure_2939E2BD009F159DEECDA97A8CF7E2AE(@Param("fliter") OrdersEntity fliter);

}
