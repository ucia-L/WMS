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
* auto generate LoadPackagedCustomizeService Mapper
*
* @author sys
*/
public interface LoadPackagedCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_9F8161883D490A0AB37214092BCEC0F7> getAnonymousStructure_3936BC2CAC14076AF3E78DD9CC846982(@Param("PackageFilter") PackagedEntity PackageFilter,@Param("OrderFilter") OutboundOrderEntity OrderFilter);
Long countAnonymousStructure_3936BC2CAC14076AF3E78DD9CC846982(@Param("PackageFilter") PackagedEntity PackageFilter,@Param("OrderFilter") OutboundOrderEntity OrderFilter);

}
