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
* auto generate GetGoodsOfWASCustomizeService Mapper
*
* @author sys
*/
public interface GetGoodsOfWASCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_AEE8CD279C962BE4731F0674236CA027> getAnonymousStructure_C432E94EE06B2309D2DAD7BD16CF89D0(@Param("warehouseId") Long warehouseId,@Param("goodCategory") GoodCategoryEnum goodCategory);
Long countAnonymousStructure_C432E94EE06B2309D2DAD7BD16CF89D0(@Param("warehouseId") Long warehouseId,@Param("goodCategory") GoodCategoryEnum goodCategory);

}
