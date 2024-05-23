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
* auto generate LCAPGetUserTableViewCustomizeService Mapper
*
* @author sys
*/
public interface LCAPGetUserTableViewCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_47C167E7217746A55100F50A57F637C0> getAnonymousStructure_90BB04F104917B26166C550B4A1B0632(@Param("filter") LCAPUser filter,@Param("size") Long size,@Param("sort") String sort,@Param("page") Long page,@Param("order") String order);
Long countAnonymousStructure_90BB04F104917B26166C550B4A1B0632(@Param("filter") LCAPUser filter,@Param("size") Long size,@Param("sort") String sort,@Param("page") Long page,@Param("order") String order);

}
