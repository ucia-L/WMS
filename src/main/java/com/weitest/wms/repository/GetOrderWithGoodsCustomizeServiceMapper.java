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
* auto generate GetOrderWithGoodsCustomizeService Mapper
*
* @author sys
*/
public interface GetOrderWithGoodsCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_8FBEC37F0009D18C595E831E379F9806> getAnonymousStructure_3BD8627F316F26B90013F1C52321E84D(@Param("filter") InboundOrderFilterStructure filter);
Long countAnonymousStructure_3BD8627F316F26B90013F1C52321E84D(@Param("filter") InboundOrderFilterStructure filter);
List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_679CD6B8F1870BD9EC7C1E0FBA5624BC> getAnonymousStructure_ACB08A0FFAA227B182FE2140FD2C2BAD(@Param("item") com.weitest.wms.domain.structure.anonymous.AnonymousStructure_8FBEC37F0009D18C595E831E379F9806 item);
Long countAnonymousStructure_ACB08A0FFAA227B182FE2140FD2C2BAD(@Param("item") com.weitest.wms.domain.structure.anonymous.AnonymousStructure_8FBEC37F0009D18C595E831E379F9806 item);
Long getStructure1(@Param("item") com.weitest.wms.domain.structure.anonymous.AnonymousStructure_8FBEC37F0009D18C595E831E379F9806 item);
Long getStructure2(@Param("item") com.weitest.wms.domain.structure.anonymous.AnonymousStructure_8FBEC37F0009D18C595E831E379F9806 item);

}
