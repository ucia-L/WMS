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
* auto generate LCAPGetMappingIdByRoleIdAndUserIdCustomizeService logic
*
* @author sys
*/
@Service
public class LCAPGetMappingIdByRoleIdAndUserIdCustomizeService {
    private static final Logger LCAP_LOGGER = LoggerFactory.getLogger(Constants.LCAP_CUSTOMIZE_LOGGER);
	@Autowired private LCAPGetMappingIdByRoleIdAndUserIdCustomizeServiceMapper lCAPGetMappingIdByRoleIdAndUserIdCustomizeServiceMapper;

	public Long  lCAPGetMappingIdByRoleIdAndUserId(Long roleId,String userId) {
		com.weitest.wms.domain.structure.anonymous.AnonymousStructure_53DE9B8001DA9BE446985BA45040CA18 variable1 = new com.weitest.wms.domain.structure.anonymous.AnonymousStructure_53DE9B8001DA9BE446985BA45040CA18();
		Long result = 0L;
		result=0L;
		variable1=CommonFunctionUtil.createListPage(lCAPGetMappingIdByRoleIdAndUserIdCustomizeServiceMapper.getAnonymousStructure_53DE9B8001DA9BE446985BA45040CA18(), lCAPGetMappingIdByRoleIdAndUserIdCustomizeServiceMapper.countAnonymousStructure_53DE9B8001DA9BE446985BA45040CA18().intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_53DE9B8001DA9BE446985BA45040CA18.class);
		for(Long i = 0L; i < CommonFunctionUtil.length(variable1.list); i++ ) {
			com.weitest.wms.domain.structure.anonymous.AnonymousStructure_E69C6A05AFC359D00B28F67D0E02C8E5  item = variable1.list.get(i.intValue());
			if(((item.lCAPUserRoleMapping.roleId.equals(roleId)) && (item.lCAPUserRoleMapping.userId.equals(userId)))) {
				result=item.lCAPUserRoleMapping.id;
			} else {
			}
		}
		return result;
	}


}
