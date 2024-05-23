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
* auto generate PackingCheckFinishSortingCustomizeService Mapper
*
* @author sys
*/
public interface PackingCheckFinishSortingCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_7EDA8CCDD6EFC9A171C2171ABBFBF81B> getAnonymousStructure_0F020D443067A97F55EC43EC204FBBA0(@Param("OrderID") Long OrderID);
Long countAnonymousStructure_0F020D443067A97F55EC43EC204FBBA0(@Param("OrderID") Long OrderID);

}
