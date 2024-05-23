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
* auto generate LoadCommoditiesForPurchaseCustomizeService Mapper
*
* @author sys
*/
public interface LoadCommoditiesForPurchaseCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_D3A798E5313781AC13C96C5E0CDD841E> getAnonymousStructure_09BDCBA976A138647CE5FAE1CFBDB3A1(@Param("warehouse_id") Long warehouse_id);
Long countAnonymousStructure_09BDCBA976A138647CE5FAE1CFBDB3A1(@Param("warehouse_id") Long warehouse_id);

}
