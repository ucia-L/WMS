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
* auto generate GetCargoNameCustomizeService Mapper
*
* @author sys
*/
public interface GetCargoNameCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_D1EF128ECC36C32CE1D080378997A52D> getAnonymousStructure_F479C59DEDC4428D4F0EE4EE199E2EDC(@Param("CargoId") Long CargoId);
Long countAnonymousStructure_F479C59DEDC4428D4F0EE4EE199E2EDC(@Param("CargoId") Long CargoId);

}
