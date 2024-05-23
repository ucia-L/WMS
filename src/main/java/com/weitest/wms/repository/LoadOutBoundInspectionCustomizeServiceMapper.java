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
* auto generate LoadOutBoundInspectionCustomizeService Mapper
*
* @author sys
*/
public interface LoadOutBoundInspectionCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_65D4FBF1CDABA1524741C04438F4588B> getAnonymousStructure_68653DA8EC7C1852D8209A98376127A9(@Param("GoodFilter") OutBoundGoodEntity GoodFilter,@Param("InspectionFilter") OutBoundInspectionEntity InspectionFilter);
Long countAnonymousStructure_68653DA8EC7C1852D8209A98376127A9(@Param("GoodFilter") OutBoundGoodEntity GoodFilter,@Param("InspectionFilter") OutBoundInspectionEntity InspectionFilter);

}
