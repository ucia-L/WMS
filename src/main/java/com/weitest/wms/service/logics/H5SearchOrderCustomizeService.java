package com.weitest.wms.service.logics;

import com.weitest.wms.config.Constants;
import com.weitest.wms.context.UserContext;
import com.weitest.wms.util.*;
import com.weitest.wms.domain.*;
import com.weitest.wms.domain.enumeration.*;
import com.weitest.wms.service.*;
import com.weitest.wms.service.dto.filters.*;
import com.weitest.wms.service.dto.filters.atomic.*;
import com.weitest.wms.service.dto.filters.logic.binary.*;
import com.weitest.wms.service.dto.filters.logic.binary.calculate.*;
import com.weitest.wms.service.dto.filters.logic.binary.compare.*;
import com.weitest.wms.service.dto.filters.logic.binary.logicCalculate.*;
import com.weitest.wms.service.dto.filters.logic.binary.matching.*;
import com.weitest.wms.service.dto.filters.logic.unary.*;
import com.weitest.wms.repository.*;
import com.weitest.wms.exception.HttpCodeException;
import com.weitest.wms.service.system.configuration.*;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.sql.Blob;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.lang.reflect.Field;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.scheduling.annotation.Scheduled;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.RoundingMode;
import com.weitest.wms.service.entities.*;
import com.weitest.wms.functional.FunctionContainer;
import com.weitest.wms.domain.entities.*;
import com.weitest.wms.domain.structure.*;

/**
* auto generate H5SearchOrderCustomizeService logic
*
* @author sys
*/
@Service
public class H5SearchOrderCustomizeService {
    private static final Logger LCAP_LOGGER = LoggerFactory.getLogger(Constants.LCAP_CUSTOMIZE_LOGGER);
	@Autowired private H5SearchOrderCustomizeServiceMapper h5SearchOrderCustomizeServiceMapper;

	public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_3BD8627F316F26B90013F1C52321E84D  h5SearchOrder(OrdersEntity id) {
		com.weitest.wms.domain.structure.anonymous.AnonymousStructure_3BD8627F316F26B90013F1C52321E84D result = new com.weitest.wms.domain.structure.anonymous.AnonymousStructure_3BD8627F316F26B90013F1C52321E84D();
		result=CommonFunctionUtil.createListPage(h5SearchOrderCustomizeServiceMapper.getAnonymousStructure_3BD8627F316F26B90013F1C52321E84D(id), h5SearchOrderCustomizeServiceMapper.countAnonymousStructure_3BD8627F316F26B90013F1C52321E84D(id).intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_3BD8627F316F26B90013F1C52321E84D.class);
		return result;
	}


}
