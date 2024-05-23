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
* auto generate LoadWareHouseAreaCustomizeService Mapper
*
* @author sys
*/
public interface LoadWareHouseAreaCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_46C8A8E71B06F587D170236042B53479> getAnonymousStructure_C4FA1D15D6667A010FD16DE68FF5F6F8(@Param("wareHouseID") Long wareHouseID);
Long countAnonymousStructure_C4FA1D15D6667A010FD16DE68FF5F6F8(@Param("wareHouseID") Long wareHouseID);

}
