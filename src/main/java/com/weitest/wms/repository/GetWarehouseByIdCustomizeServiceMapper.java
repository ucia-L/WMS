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
* auto generate GetWarehouseByIdCustomizeService Mapper
*
* @author sys
*/
public interface GetWarehouseByIdCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_F349DEC1E5A50FAAD59CBCBBFB541B93> getAnonymousStructure_F38430154A940234D722FC75BC91969C(@Param("id") Long id);
Long countAnonymousStructure_F38430154A940234D722FC75BC91969C(@Param("id") Long id);

}
