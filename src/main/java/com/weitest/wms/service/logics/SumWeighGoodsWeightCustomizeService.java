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
* auto generate SumWeighGoodsWeightCustomizeService logic
*
* @author sys
*/
@Service
public class SumWeighGoodsWeightCustomizeService {
    private static final Logger LCAP_LOGGER = LoggerFactory.getLogger(Constants.LCAP_CUSTOMIZE_LOGGER);
	@Autowired private SumWeighGoodsWeightCustomizeServiceMapper sumWeighGoodsWeightCustomizeServiceMapper;

	public BigDecimal  sumWeighGoodsWeight(Long OrderID) {
		List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_99F93033A4D47195671A7C16EA108BEB> weighGood = new ArrayList <>();
		BigDecimal result = BigDecimal.ZERO;
		weighGood=CommonFunctionUtil.createListPage(sumWeighGoodsWeightCustomizeServiceMapper.getAnonymousStructure_4947911501E711DE9CE7537BC08471D4(OrderID), sumWeighGoodsWeightCustomizeServiceMapper.countAnonymousStructure_4947911501E711DE9CE7537BC08471D4(OrderID).intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_4947911501E711DE9CE7537BC08471D4.class).list;
		for(Long index = 0L; index < weighGood.size(); index++ ) {
			com.weitest.wms.domain.structure.anonymous.AnonymousStructure_99F93033A4D47195671A7C16EA108BEB  item = weighGood.get(index.intValue());
			result=item.allWeight;
		}
		return result;
	}


}
