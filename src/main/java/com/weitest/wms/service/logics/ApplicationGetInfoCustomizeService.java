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
* auto generate ApplicationGetInfoCustomizeService logic
*
* @author sys
*/
@Service
public class ApplicationGetInfoCustomizeService {
    private static final Logger LCAP_LOGGER = LoggerFactory.getLogger(Constants.LCAP_CUSTOMIZE_LOGGER);
	@Autowired private ApplicationGetInfoCustomizeServiceMapper applicationGetInfoCustomizeServiceMapper;

	public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_DE6E0F77958CB8E3B8CAEE75D20D9D66  applicationGetInfo(ApplicationEntity filter) {
		com.weitest.wms.domain.structure.anonymous.AnonymousStructure_DE6E0F77958CB8E3B8CAEE75D20D9D66 applicationInfo = new com.weitest.wms.domain.structure.anonymous.AnonymousStructure_DE6E0F77958CB8E3B8CAEE75D20D9D66();
		applicationInfo=CommonFunctionUtil.createListPage(applicationGetInfoCustomizeServiceMapper.getAnonymousStructure_DE6E0F77958CB8E3B8CAEE75D20D9D66(filter), applicationGetInfoCustomizeServiceMapper.countAnonymousStructure_DE6E0F77958CB8E3B8CAEE75D20D9D66(filter).intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_DE6E0F77958CB8E3B8CAEE75D20D9D66.class);
		return applicationInfo;
	}


}
