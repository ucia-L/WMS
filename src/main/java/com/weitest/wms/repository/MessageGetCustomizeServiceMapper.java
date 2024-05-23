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
* auto generate MessageGetCustomizeService Mapper
*
* @author sys
*/
public interface MessageGetCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_85E2885473D719772D99312974DB249D> getAnonymousStructure_37391B25C11ADF7D1902013971D77D9D(@Param("forSearch") MessageeEntity forSearch);
Long countAnonymousStructure_37391B25C11ADF7D1902013971D77D9D(@Param("forSearch") MessageeEntity forSearch);

}
