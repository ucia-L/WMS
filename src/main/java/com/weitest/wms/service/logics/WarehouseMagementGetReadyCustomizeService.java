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
* auto generate WarehouseMagementGetReadyCustomizeService logic
*
* @author sys
*/
@Service
public class WarehouseMagementGetReadyCustomizeService {
    private static final Logger LCAP_LOGGER = LoggerFactory.getLogger(Constants.LCAP_CUSTOMIZE_LOGGER);
	@Autowired private WarehouseMagementGetReadyCustomizeServiceMapper warehouseMagementGetReadyCustomizeServiceMapper;

	public List<ShelfGoodInfoStructure>  warehouseMagementGetReady(Long warehouse_id,OnShelfFilterStructure Serch) {
		com.weitest.wms.domain.structure.anonymous.AnonymousStructure_066A0DCCF9CBA9BEF52F6A44E6C77E87 goodList = new com.weitest.wms.domain.structure.anonymous.AnonymousStructure_066A0DCCF9CBA9BEF52F6A44E6C77E87();
		ShelfGoodInfoStructure shelfGoodInfoTmp = new ShelfGoodInfoStructure();
		List<ShelfGoodInfoStructure> result = new ArrayList <>();
		if((Serch.endTime == null)) {
		} else {
			Serch.endTime=CommonFunctionUtil.alterDateTime(Serch.endTime,"Increase",1L,"day");
		}
		goodList=CommonFunctionUtil.createListPage(warehouseMagementGetReadyCustomizeServiceMapper.getAnonymousStructure_066A0DCCF9CBA9BEF52F6A44E6C77E87(Serch), warehouseMagementGetReadyCustomizeServiceMapper.countAnonymousStructure_066A0DCCF9CBA9BEF52F6A44E6C77E87(Serch).intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_066A0DCCF9CBA9BEF52F6A44E6C77E87.class);
		for(Long index = 0L; index < goodList.list.size(); index++ ) {
			com.weitest.wms.domain.structure.anonymous.AnonymousStructure_9C51235C084B53955268CCC880F52D83  item = goodList.list.get(index.intValue());
			shelfGoodInfoTmp=CommonFunctionUtil.New(ShelfGoodInfoStructure.class);
			shelfGoodInfoTmp.goodInfo=item.goods;
			shelfGoodInfoTmp.inbound_tmp_name=warehouseMagementGetReadyCustomizeServiceMapper.getSql1(item);
			if((item.goods.shelf_id == null)) {
			} else {
				shelfGoodInfoTmp.storage_name=warehouseMagementGetReadyCustomizeServiceMapper.getSql2(item);
				shelfGoodInfoTmp.shelf_name=warehouseMagementGetReadyCustomizeServiceMapper.getSql3(item);
				List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_E3C62BD932173A0ED274FCAFD69E4C99>  currentLcpEachName_1 = CommonFunctionUtil.createListPage(warehouseMagementGetReadyCustomizeServiceMapper.getAnonymousStructure_4BC132E19238F578170F4FC0E2989E7A(item), warehouseMagementGetReadyCustomizeServiceMapper.countAnonymousStructure_4BC132E19238F578170F4FC0E2989E7A(item).intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_4BC132E19238F578170F4FC0E2989E7A.class).list;
				for(Long index1 = 0L; index1 < currentLcpEachName_1.size(); index1++ ) {
					com.weitest.wms.domain.structure.anonymous.AnonymousStructure_E3C62BD932173A0ED274FCAFD69E4C99  item1 = currentLcpEachName_1.get(index1.intValue());
					if(((item1 != null) && ((item1.shelf != null) && (item1.shelf.status != null)))) {
						shelfGoodInfoTmp.shelfStatus=CommonFunctionUtil.clone(item1.shelf.status);
					} else {
					}
				}
			}
			CommonFunctionUtil.add(result,shelfGoodInfoTmp);
		}
		return result;
	}


}
