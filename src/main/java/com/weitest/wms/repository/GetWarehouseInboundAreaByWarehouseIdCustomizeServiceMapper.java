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
* auto generate GetWarehouseInboundAreaByWarehouseIdCustomizeService Mapper
*
* @author sys
*/
public interface GetWarehouseInboundAreaByWarehouseIdCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_4801458D6ADF51D817C73959F167DAA9> getAnonymousStructure_9ADEC8AA39F589C6B8C8BCD0BE7EF597(@Param("warehouse_id") Long warehouse_id);
Long countAnonymousStructure_9ADEC8AA39F589C6B8C8BCD0BE7EF597(@Param("warehouse_id") Long warehouse_id);

}
