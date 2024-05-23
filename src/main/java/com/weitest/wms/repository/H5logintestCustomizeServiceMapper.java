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
* auto generate H5logintestCustomizeService Mapper
*
* @author sys
*/
public interface H5logintestCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_2057AF86534DB39D024DB52971831007> getAnonymousStructure_CEA46914E8B41B3EA46132D72F048689(@Param("username") String username);
Long countAnonymousStructure_CEA46914E8B41B3EA46132D72F048689(@Param("username") String username);

}
