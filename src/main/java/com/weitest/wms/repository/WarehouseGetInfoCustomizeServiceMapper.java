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
* auto generate WarehouseGetInfoCustomizeService Mapper
*
* @author sys
*/
public interface WarehouseGetInfoCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_71AFED732D709AF046E771165E69776D> getAnonymousStructure_7CC1E5F8E9FC7EB40FE2F6D0BC184542(@Param("filter") WarehouseEntity filter);
Long countAnonymousStructure_7CC1E5F8E9FC7EB40FE2F6D0BC184542(@Param("filter") WarehouseEntity filter);

}
