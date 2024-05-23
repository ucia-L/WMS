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
* auto generate LoadOutBoundWeighingCustomizeService Mapper
*
* @author sys
*/
public interface LoadOutBoundWeighingCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_82F9268615EE563A8D890C3AD9869C25> getAnonymousStructure_48985C1E4DD6B920592526E1448DB5BA(@Param("WeighFilter") OutBoundWeighingEntity WeighFilter,@Param("GoodFilter") OutBoundGoodEntity GoodFilter);
Long countAnonymousStructure_48985C1E4DD6B920592526E1448DB5BA(@Param("WeighFilter") OutBoundWeighingEntity WeighFilter,@Param("GoodFilter") OutBoundGoodEntity GoodFilter);

}
