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
* auto generate LoadWarehouseAccountCustomizeService Mapper
*
* @author sys
*/
public interface LoadWarehouseAccountCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_4D4C8EF779CEA58C959BF52C7FAAEE70> getAnonymousStructure_FF69F0762641F6C693E37CD8B489D3D5(@Param("filter") WarehouseAccountEntity filter,@Param("startTime") java.time.ZonedDateTime startTime,@Param("endTime") java.time.ZonedDateTime endTime,@Param("warehouse_id") Long warehouse_id);
Long countAnonymousStructure_FF69F0762641F6C693E37CD8B489D3D5(@Param("filter") WarehouseAccountEntity filter,@Param("startTime") java.time.ZonedDateTime startTime,@Param("endTime") java.time.ZonedDateTime endTime,@Param("warehouse_id") Long warehouse_id);

}
