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
* auto generate SumWeighGoodsWeightCustomizeService Mapper
*
* @author sys
*/
public interface SumWeighGoodsWeightCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_99F93033A4D47195671A7C16EA108BEB> getAnonymousStructure_4947911501E711DE9CE7537BC08471D4(@Param("OrderID") Long OrderID);
Long countAnonymousStructure_4947911501E711DE9CE7537BC08471D4(@Param("OrderID") Long OrderID);

}
