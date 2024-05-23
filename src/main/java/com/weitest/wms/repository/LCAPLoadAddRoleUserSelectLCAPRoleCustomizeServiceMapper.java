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
* auto generate LCAPLoadAddRoleUserSelectLCAPRoleCustomizeService Mapper
*
* @author sys
*/
public interface LCAPLoadAddRoleUserSelectLCAPRoleCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_70791B893F53C2EFB9E501591763B020> getAnonymousStructure_CAC5152BAE2C91DD609E3DFEE343ACC6(@Param("size") Long size,@Param("page") Long page);
Long countAnonymousStructure_CAC5152BAE2C91DD609E3DFEE343ACC6(@Param("size") Long size,@Param("page") Long page);

}
