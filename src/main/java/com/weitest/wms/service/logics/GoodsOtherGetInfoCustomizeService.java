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
* auto generate GoodsOtherGetInfoCustomizeService logic
*
* @author sys
*/
@Service
public class GoodsOtherGetInfoCustomizeService {
    private static final Logger LCAP_LOGGER = LoggerFactory.getLogger(Constants.LCAP_CUSTOMIZE_LOGGER);
	@Autowired private GoodsOtherGetInfoCustomizeServiceMapper goodsOtherGetInfoCustomizeServiceMapper;

	public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_066A0DCCF9CBA9BEF52F6A44E6C77E87  goodsOtherGetInfo(GoodsEntity fliter) {
		com.weitest.wms.domain.structure.anonymous.AnonymousStructure_066A0DCCF9CBA9BEF52F6A44E6C77E87 result = new com.weitest.wms.domain.structure.anonymous.AnonymousStructure_066A0DCCF9CBA9BEF52F6A44E6C77E87();
		result=CommonFunctionUtil.createListPage(goodsOtherGetInfoCustomizeServiceMapper.getAnonymousStructure_066A0DCCF9CBA9BEF52F6A44E6C77E87(fliter), goodsOtherGetInfoCustomizeServiceMapper.countAnonymousStructure_066A0DCCF9CBA9BEF52F6A44E6C77E87(fliter).intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_066A0DCCF9CBA9BEF52F6A44E6C77E87.class);
		return result;
	}


}
