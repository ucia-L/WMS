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
* auto generate LoadCommoditiesForPurchaseCustomizeService logic
*
* @author sys
*/
@Service
public class LoadCommoditiesForPurchaseCustomizeService {
    private static final Logger LCAP_LOGGER = LoggerFactory.getLogger(Constants.LCAP_CUSTOMIZE_LOGGER);
	@Autowired private LoadCommoditiesForPurchaseCustomizeServiceMapper loadCommoditiesForPurchaseCustomizeServiceMapper;

	public List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_D3A798E5313781AC13C96C5E0CDD841E>  loadCommoditiesForPurchase(Long warehouse_id) {
		List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_D3A798E5313781AC13C96C5E0CDD841E> result = new ArrayList <>();
		result=CommonFunctionUtil.createListPage(loadCommoditiesForPurchaseCustomizeServiceMapper.getAnonymousStructure_09BDCBA976A138647CE5FAE1CFBDB3A1(warehouse_id), loadCommoditiesForPurchaseCustomizeServiceMapper.countAnonymousStructure_09BDCBA976A138647CE5FAE1CFBDB3A1(warehouse_id).intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_09BDCBA976A138647CE5FAE1CFBDB3A1.class).list;
		return result;
	}


}
