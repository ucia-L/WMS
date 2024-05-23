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
* auto generate WHMGetAllWarehouseInfoCustomizeService Mapper
*
* @author sys
*/
public interface WHMGetAllWarehouseInfoCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_59D6E064B8AF915736CFC671F08179BD> getAnonymousStructure_B4CC68B69563665635B619B115C5A847(@Param("filter") WarehouseEntity filter);
Long countAnonymousStructure_B4CC68B69563665635B619B115C5A847(@Param("filter") WarehouseEntity filter);

}
