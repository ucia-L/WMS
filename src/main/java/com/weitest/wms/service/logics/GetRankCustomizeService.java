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
* auto generate GetRankCustomizeService logic
*
* @author sys
*/
@Service
public class GetRankCustomizeService {
    private static final Logger LCAP_LOGGER = LoggerFactory.getLogger(Constants.LCAP_CUSTOMIZE_LOGGER);
	@Autowired private GetRankCustomizeServiceMapper getRankCustomizeServiceMapper;

	public List<Long>  getRank(Long id) {
		List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_293B78F7E0EEAFF27E0B88A23BB4B26B> variable1 = new ArrayList <>();
		List<Long> result = new ArrayList <>();
		variable1=getRankCustomizeServiceMapper.getSql1();
		for(Long index = 0L; index < variable1.size(); index++ ) {
			com.weitest.wms.domain.structure.anonymous.AnonymousStructure_293B78F7E0EEAFF27E0B88A23BB4B26B  item = variable1.get(index.intValue());
			if((item.id.equals(id))) {
				CommonFunctionUtil.add(result,(index + 1L));
				index=CommonFunctionUtil.length(variable1);
			} else {
			}
		}
		variable1=getRankCustomizeServiceMapper.getSql2();
		for(Long index = 0L; index < variable1.size(); index++ ) {
			com.weitest.wms.domain.structure.anonymous.AnonymousStructure_293B78F7E0EEAFF27E0B88A23BB4B26B  item = variable1.get(index.intValue());
			if((item.id.equals(id))) {
				CommonFunctionUtil.add(result,(index + 1L));
				index=CommonFunctionUtil.length(variable1);
			} else {
			}
		}
		variable1=getRankCustomizeServiceMapper.getSql3();
		for(Long index = 0L; index < variable1.size(); index++ ) {
			com.weitest.wms.domain.structure.anonymous.AnonymousStructure_293B78F7E0EEAFF27E0B88A23BB4B26B  item = variable1.get(index.intValue());
			if((item.id.equals(id))) {
				CommonFunctionUtil.add(result,(index + 1L));
				index=CommonFunctionUtil.length(variable1);
			} else {
			}
		}
		variable1=getRankCustomizeServiceMapper.getSql4();
		for(Long index = 0L; index < variable1.size(); index++ ) {
			com.weitest.wms.domain.structure.anonymous.AnonymousStructure_293B78F7E0EEAFF27E0B88A23BB4B26B  item = variable1.get(index.intValue());
			if((item.id.equals(id))) {
				CommonFunctionUtil.add(result,(index + 1L));
				index=CommonFunctionUtil.length(variable1);
			} else {
			}
		}
		variable1=getRankCustomizeServiceMapper.getSql5();
		for(Long index = 0L; index < variable1.size(); index++ ) {
			com.weitest.wms.domain.structure.anonymous.AnonymousStructure_293B78F7E0EEAFF27E0B88A23BB4B26B  item = variable1.get(index.intValue());
			if((item.id.equals(id))) {
				CommonFunctionUtil.add(result,(index + 1L));
				index=CommonFunctionUtil.length(variable1);
			} else {
			}
		}
		variable1=getRankCustomizeServiceMapper.getSql6();
		for(Long index = 0L; index < variable1.size(); index++ ) {
			com.weitest.wms.domain.structure.anonymous.AnonymousStructure_293B78F7E0EEAFF27E0B88A23BB4B26B  item = variable1.get(index.intValue());
			if((item.id.equals(id))) {
				CommonFunctionUtil.add(result,(index + 1L));
				index=CommonFunctionUtil.length(variable1);
			} else {
			}
		}
		return result;
	}


}
