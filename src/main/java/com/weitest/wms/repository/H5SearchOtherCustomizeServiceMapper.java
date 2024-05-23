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
* auto generate H5SearchOtherCustomizeService Mapper
*
* @author sys
*/
public interface H5SearchOtherCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_51ED79A8D81AADBEE849551E25ACA005> getAnonymousStructure_97E3321D7BDB25644BE310E28052FE80();
Long countAnonymousStructure_97E3321D7BDB25644BE310E28052FE80();

}
