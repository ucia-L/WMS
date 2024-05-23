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
* auto generate LoadGoodsALLinfo_byOrderIDCustomizeService Mapper
*
* @author sys
*/
public interface LoadGoodsALLinfo_byOrderIDCustomizeServiceMapper {

List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_946782E67B818EC2F9357CB1045A1E1A> getAnonymousStructure_6997C69216008989CE406C282DF8F531(@Param("order_id") Long order_id);
Long countAnonymousStructure_6997C69216008989CE406C282DF8F531(@Param("order_id") Long order_id);

}
