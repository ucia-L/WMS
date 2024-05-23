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
* auto generate LCAPGetRoleBindUserListCustomizeService Mapper
*
* @author sys
*/
public interface LCAPGetRoleBindUserListCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_E69C6A05AFC359D00B28F67D0E02C8E5> getAnonymousStructure_53DE9B8001DA9BE446985BA45040CA18(@Param("inputRoleId") Long inputRoleId);
Long countAnonymousStructure_53DE9B8001DA9BE446985BA45040CA18(@Param("inputRoleId") Long inputRoleId);

}
