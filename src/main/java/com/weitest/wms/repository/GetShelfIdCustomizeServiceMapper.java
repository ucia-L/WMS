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
* auto generate GetShelfIdCustomizeService Mapper
*
* @author sys
*/
public interface GetShelfIdCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_1E957FBA34F48431FB8E43537F5AB7E6> getAnonymousStructure_CDF5CCF70A20738444A91579D12EDF48(@Param("shelf") String shelf);
Long countAnonymousStructure_CDF5CCF70A20738444A91579D12EDF48(@Param("shelf") String shelf);

}
