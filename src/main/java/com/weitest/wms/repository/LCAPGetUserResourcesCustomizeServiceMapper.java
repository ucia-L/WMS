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
* auto generate LCAPGetUserResourcesCustomizeService Mapper
*
* @author sys
*/
public interface LCAPGetUserResourcesCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_B202841ADEE061731D68863F55003B0E> getAnonymousStructure_FA75F69B8BA9C34178F71FC536D2D824(@Param("userId") String userId);
Long countAnonymousStructure_FA75F69B8BA9C34178F71FC536D2D824(@Param("userId") String userId);

}
