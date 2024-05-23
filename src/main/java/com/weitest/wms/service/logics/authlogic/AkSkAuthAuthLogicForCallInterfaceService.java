package com.weitest.wms.service.logics.authlogic;

import com.weitest.wms.config.Constants;
import com.weitest.wms.util.*;
import com.weitest.wms.domain.*;
import com.weitest.wms.domain.enumeration.*;
import com.weitest.wms.service.*;
import com.weitest.wms.service.dto.filters.*;
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
import com.weitest.wms.domain.http.HttpRequest;
import com.weitest.wms.domain.entities.*;
import com.weitest.wms.domain.structure.*;
import com.weitest.wms.domain.http.HttpParameter;

/**
* auto generate AkSkAuthAuthLogicForCallInterfaceService logic
*
* @author sys
*/
@Service
public class AkSkAuthAuthLogicForCallInterfaceService {
    private static final Logger LCAP_LOGGER = LoggerFactory.getLogger(Constants.LCAP_CUSTOMIZE_LOGGER);


	public HttpRequest auth(HttpRequest request) {
		String ak = "";
		String sk = "";
		String timestamp = "";
		String signature = "";
		ak="Codewave";
		CommonFunctionUtil.mapPut(request.headers,"ak",ak);
		sk="Codewave";
		timestamp=CommonFunctionUtil.toString(CommonFunctionUtil.convertTimezone(CommonFunctionUtil.currDateTime(),"Asia/Shanghai"));
		CommonFunctionUtil.mapPut(request.headers,"timestamp",timestamp);
		signature=(ak + (sk + timestamp));
		CommonFunctionUtil.mapPut(request.headers,"signature",signature);
		return request;
	}
}
