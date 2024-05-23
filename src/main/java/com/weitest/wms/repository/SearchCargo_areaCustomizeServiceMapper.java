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
* auto generate SearchCargo_areaCustomizeService Mapper
*
* @author sys
*/
public interface SearchCargo_areaCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_99E1DEAE53C2D28A1AFEEA89BC2690EF> getAnonymousStructure_821D7D11F928C9F38F5FEB835A4DD107(@Param("userInfo") UserinfoEntity userInfo);
Long countAnonymousStructure_821D7D11F928C9F38F5FEB835A4DD107(@Param("userInfo") UserinfoEntity userInfo);

}
