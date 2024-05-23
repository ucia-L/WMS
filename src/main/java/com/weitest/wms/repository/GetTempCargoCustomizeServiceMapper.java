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
* auto generate GetTempCargoCustomizeService Mapper
*
* @author sys
*/
public interface GetTempCargoCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_99B5CB65B3B0BEF2E61F9C64025C5D2A> getAnonymousStructure_214AE64B96962CE70EB5317554723466(@Param("userInfo") UserinfoEntity userInfo);
Long countAnonymousStructure_214AE64B96962CE70EB5317554723466(@Param("userInfo") UserinfoEntity userInfo);

}
