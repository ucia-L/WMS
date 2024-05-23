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
* auto generate GetGWASInfoCustomizeService Mapper
*
* @author sys
*/
public interface GetGWASInfoCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_4482D3CDBC1D77AC573D37AD8FBE981C> getAnonymousStructure_E66459C8D0390E3AEBC41C75BAF3694B(@Param("filter") IventoryGWASEntity filter);
Long countAnonymousStructure_E66459C8D0390E3AEBC41C75BAF3694B(@Param("filter") IventoryGWASEntity filter);

}
