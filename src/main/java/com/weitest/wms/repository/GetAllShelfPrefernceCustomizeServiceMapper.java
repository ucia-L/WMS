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
* auto generate GetAllShelfPrefernceCustomizeService Mapper
*
* @author sys
*/
public interface GetAllShelfPrefernceCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_BC30EA51BEF759784391A78DA6D8A137> getAnonymousStructure_FD913F7039BB93235C19104CFEA0F401();
Long countAnonymousStructure_FD913F7039BB93235C19104CFEA0F401();

}
