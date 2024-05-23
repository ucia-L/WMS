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
* auto generate GetAfterSaleWithGoodsCustomizeService Mapper
*
* @author sys
*/
public interface GetAfterSaleWithGoodsCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_700A1909C69274C7EF524520E99699D1> getAnonymousStructure_B68304FA575E7E3C6172C58A216669D4(@Param("filter") AfterSalesOrderEntity filter,@Param("startTime") java.time.ZonedDateTime startTime,@Param("endTime") java.time.ZonedDateTime endTime);
Long countAnonymousStructure_B68304FA575E7E3C6172C58A216669D4(@Param("filter") AfterSalesOrderEntity filter,@Param("startTime") java.time.ZonedDateTime startTime,@Param("endTime") java.time.ZonedDateTime endTime);
List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_C536A748AD5BD93EDD4558A2682AE5EA> getAnonymousStructure_B6021528EA8063DE04918A525D9D601D(@Param("item") com.weitest.wms.domain.structure.anonymous.AnonymousStructure_700A1909C69274C7EF524520E99699D1 item);
Long countAnonymousStructure_B6021528EA8063DE04918A525D9D601D(@Param("item") com.weitest.wms.domain.structure.anonymous.AnonymousStructure_700A1909C69274C7EF524520E99699D1 item);
Long getStructure1(@Param("item") com.weitest.wms.domain.structure.anonymous.AnonymousStructure_700A1909C69274C7EF524520E99699D1 item);

}
