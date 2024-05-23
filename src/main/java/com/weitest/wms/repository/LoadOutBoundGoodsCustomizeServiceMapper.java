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
* auto generate LoadOutBoundGoodsCustomizeService Mapper
*
* @author sys
*/
public interface LoadOutBoundGoodsCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_0525662B8F4292C798EFF880E786BA4E> getAnonymousStructure_4EE7EE1E30E7881C7AED96E05B24EEE9(@Param("filter") Long filter);
Long countAnonymousStructure_4EE7EE1E30E7881C7AED96E05B24EEE9(@Param("filter") Long filter);

}
