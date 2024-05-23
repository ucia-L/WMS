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
* auto generate LCAPGetResourceListByRoleIdCustomizeService logic
*
* @author sys
*/
@Service
public class LCAPGetResourceListByRoleIdCustomizeService {
    private static final Logger LCAP_LOGGER = LoggerFactory.getLogger(Constants.LCAP_CUSTOMIZE_LOGGER);
	@Autowired private LCAPGetResourceListByRoleIdCustomizeServiceMapper lCAPGetResourceListByRoleIdCustomizeServiceMapper;

	public List<LCAPResource>  lCAPGetResourceListByRoleId(Long roleId) {
		com.weitest.wms.domain.structure.anonymous.AnonymousStructure_B676D945A9DD0D6FB27D68FFAC48D5EE variable1 = new com.weitest.wms.domain.structure.anonymous.AnonymousStructure_B676D945A9DD0D6FB27D68FFAC48D5EE();
		LCAPResource variable3 = new LCAPResource();
		List<LCAPResource> resultResourceList = new ArrayList <>();
		variable1=CommonFunctionUtil.createListPage(lCAPGetResourceListByRoleIdCustomizeServiceMapper.getAnonymousStructure_B676D945A9DD0D6FB27D68FFAC48D5EE(roleId), lCAPGetResourceListByRoleIdCustomizeServiceMapper.countAnonymousStructure_B676D945A9DD0D6FB27D68FFAC48D5EE(roleId).intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_B676D945A9DD0D6FB27D68FFAC48D5EE.class);
		for(Long i = 0L; i < CommonFunctionUtil.length(variable1.list); i++ ) {
			com.weitest.wms.domain.structure.anonymous.AnonymousStructure_CF51E2CA3BEA957FFEB6CEA32F96003B  item = variable1.list.get(i.intValue());
			variable3.id=item.lCAPResource.id;
			variable3.name=item.lCAPResource.name;
			variable3.description=item.lCAPResource.description;
			CommonFunctionUtil.add(resultResourceList,variable3);
		}
		return resultResourceList;
	}


}
