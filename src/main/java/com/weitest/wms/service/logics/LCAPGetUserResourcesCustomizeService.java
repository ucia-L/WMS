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
* auto generate LCAPGetUserResourcesCustomizeService logic
*
* @author sys
*/
@Service
public class LCAPGetUserResourcesCustomizeService {
    private static final Logger LCAP_LOGGER = LoggerFactory.getLogger(Constants.LCAP_CUSTOMIZE_LOGGER);
	@Autowired private LCAPGetUserResourcesCustomizeServiceMapper lCAPGetUserResourcesCustomizeServiceMapper;

	public List<LCAPGetResourceResultStructure>  lCAPGetUserResources(String userId) {
		com.weitest.wms.domain.structure.anonymous.AnonymousStructure_FA75F69B8BA9C34178F71FC536D2D824 variable1 = new com.weitest.wms.domain.structure.anonymous.AnonymousStructure_FA75F69B8BA9C34178F71FC536D2D824();
		List<String> variable2 = new ArrayList <>();
		LCAPGetResourceResultStructure variable3 = new LCAPGetResourceResultStructure();
		List<LCAPGetResourceResultStructure> variable4 = new ArrayList <>();
		LCAPGetResourceResultStructure variable5 = new LCAPGetResourceResultStructure();
		List<LCAPGetResourceResultStructure> result = new ArrayList <>();
		variable1=CommonFunctionUtil.createListPage(lCAPGetUserResourcesCustomizeServiceMapper.getAnonymousStructure_FA75F69B8BA9C34178F71FC536D2D824(userId), lCAPGetUserResourcesCustomizeServiceMapper.countAnonymousStructure_FA75F69B8BA9C34178F71FC536D2D824(userId).intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_FA75F69B8BA9C34178F71FC536D2D824.class);
		for(Long i = 0L; i < CommonFunctionUtil.length(variable1.list); i++ ) {
			com.weitest.wms.domain.structure.anonymous.AnonymousStructure_B202841ADEE061731D68863F55003B0E  item = variable1.list.get(i.intValue());
			if(CommonFunctionUtil.contains(variable2,item.lCAPResource.name)) {
			} else {
				CommonFunctionUtil.add(variable2,item.lCAPResource.name);
				variable3.resourceValue=item.lCAPResource.name;
				variable3.resourceType=item.lCAPResource.type;
				variable5=CommonFunctionUtil.clone(variable3);
				CommonFunctionUtil.add(variable4,variable5);
			}
		}
		result=variable4;
		return result;
	}


}
