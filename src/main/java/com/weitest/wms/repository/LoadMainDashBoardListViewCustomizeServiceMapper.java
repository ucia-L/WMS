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
* auto generate LoadMainDashBoardListViewCustomizeService Mapper
*
* @author sys
*/
public interface LoadMainDashBoardListViewCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_F30C4D4796DE57EC4963423784B62512> getAnonymousStructure_7F0FC9CD7C0E19CDEBEF556E681E6B3C(@Param("size") Long size,@Param("page") Long page);
Long countAnonymousStructure_7F0FC9CD7C0E19CDEBEF556E681E6B3C(@Param("size") Long size,@Param("page") Long page);

}
