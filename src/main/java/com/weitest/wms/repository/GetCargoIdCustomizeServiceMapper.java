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
* auto generate GetCargoIdCustomizeService Mapper
*
* @author sys
*/
public interface GetCargoIdCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_83A1AC65E64BEE1D4A4A85DE50C13654> getAnonymousStructure_3A3C19D4BE4C5471234B195A6833A837(@Param("Cargo_area") String Cargo_area);
Long countAnonymousStructure_3A3C19D4BE4C5471234B195A6833A837(@Param("Cargo_area") String Cargo_area);

}
