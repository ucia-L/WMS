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
* auto generate LCAPUnBindUsersCustomizeService logic
*
* @author sys
*/
@Service
public class LCAPUnBindUsersCustomizeService {
    private static final Logger LCAP_LOGGER = LoggerFactory.getLogger(Constants.LCAP_CUSTOMIZE_LOGGER);
	@Autowired private LCAPIsExistRoleIdCustomizeService lCAPIsExistRoleIdCustomizeService;
	@Autowired private LCAPIsAlreadBindUserIdListCustomizeService lCAPIsAlreadBindUserIdListCustomizeService;
	@Autowired private LCAPGetMappingIdByRoleIdAndUserIdCustomizeService lCAPGetMappingIdByRoleIdAndUserIdCustomizeService;
	@Autowired private LCAPUserRoleMappingService lCAPUserRoleMappingService;

	public Long  lCAPUnBindUsers(LCAPRoleBindUsersBodyStructure unBindUsersBody) {
		Long roleIdVariable1 = 0L;
		Boolean isExistRoleId = false;
		List<String> userIdListVariable1 = new ArrayList <>();
		Boolean isAlreadyBind = false;
		LCAPUserRoleMapping roleAndUserMappingBody = new LCAPUserRoleMapping();
		Long idGetByRoleIdAndUserId = 0L;
		Long resultUnBindUsers = 0L;
		roleIdVariable1=unBindUsersBody.roleId;
		isExistRoleId=lCAPIsExistRoleIdCustomizeService.lCAPIsExistRoleId(roleIdVariable1);
		if((isExistRoleId == true)) {
		} else {
			return resultUnBindUsers;
		}
		userIdListVariable1=unBindUsersBody.userIdList;
		if((roleIdVariable1 == null)) {
			return resultUnBindUsers;
		} else {
		}
		if((userIdListVariable1 == null)) {
			return resultUnBindUsers;
		} else {
		}
		resultUnBindUsers=0L;
		for(Long i = 0L; i < CommonFunctionUtil.length(userIdListVariable1); i++ ) {
			String  item = userIdListVariable1.get(i.intValue());
			roleAndUserMappingBody.userId=item;
			roleAndUserMappingBody.roleId=roleIdVariable1;
			isAlreadyBind=lCAPIsAlreadBindUserIdListCustomizeService.lCAPIsAlreadBindUserIdList(item,roleIdVariable1);
			if((isAlreadyBind == true)) {
				resultUnBindUsers=(resultUnBindUsers + 1L);
				idGetByRoleIdAndUserId=lCAPGetMappingIdByRoleIdAndUserIdCustomizeService.lCAPGetMappingIdByRoleIdAndUserId(roleIdVariable1,item);
				if((idGetByRoleIdAndUserId.equals(0L))) {
					return resultUnBindUsers;
				} else {
				}
				lCAPUserRoleMappingService.delete(idGetByRoleIdAndUserId);
			} else {
			}
		}
		return resultUnBindUsers;
	}


}
