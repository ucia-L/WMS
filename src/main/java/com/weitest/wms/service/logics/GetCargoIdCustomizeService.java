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
* auto generate GetCargoIdCustomizeService logic
*
* @author sys
*/
@Service
public class GetCargoIdCustomizeService {
    private static final Logger LCAP_LOGGER = LoggerFactory.getLogger(Constants.LCAP_CUSTOMIZE_LOGGER);
	@Autowired private GetCargoIdCustomizeServiceMapper getCargoIdCustomizeServiceMapper;

	public Long  getCargoId(String Cargo_area) {
		com.weitest.wms.domain.structure.anonymous.AnonymousStructure_3A3C19D4BE4C5471234B195A6833A837 temp = new com.weitest.wms.domain.structure.anonymous.AnonymousStructure_3A3C19D4BE4C5471234B195A6833A837();
		com.weitest.wms.domain.structure.anonymous.AnonymousStructure_83A1AC65E64BEE1D4A4A85DE50C13654 id = new com.weitest.wms.domain.structure.anonymous.AnonymousStructure_83A1AC65E64BEE1D4A4A85DE50C13654();
		Long result = 0L;
		temp=CommonFunctionUtil.createListPage(getCargoIdCustomizeServiceMapper.getAnonymousStructure_3A3C19D4BE4C5471234B195A6833A837(Cargo_area), getCargoIdCustomizeServiceMapper.countAnonymousStructure_3A3C19D4BE4C5471234B195A6833A837(Cargo_area).intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_3A3C19D4BE4C5471234B195A6833A837.class);
		id=CommonFunctionUtil.get(temp.list,0L);
		result=id.warehouseArea.id;
		return result;
	}


}
