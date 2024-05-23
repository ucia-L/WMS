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
* auto generate GetGoodsWithAllInfoCustomizeService Mapper
*
* @author sys
*/
public interface GetGoodsWithAllInfoCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_90C927AEC6192B24A524A13F9820A290> getAnonymousStructure_376B634BA33FFFA6D51D570BB51635C1(@Param("fliter") GoodsEntity fliter);
Long countAnonymousStructure_376B634BA33FFFA6D51D570BB51635C1(@Param("fliter") GoodsEntity fliter);

}
