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
* auto generate LoadOutBoundPackingsCustomizeService Mapper
*
* @author sys
*/
public interface LoadOutBoundPackingsCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_8E2CA7465AE892F5A14EC35F441B6201> getAnonymousStructure_64727DC0004C83C1CE0D2D2737E9AFAF(@Param("GoodID") Long GoodID);
Long countAnonymousStructure_64727DC0004C83C1CE0D2D2737E9AFAF(@Param("GoodID") Long GoodID);

}
