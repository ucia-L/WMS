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
* auto generate GetAfterSaleWithGoodsCustomizeService logic
*
* @author sys
*/
@Service
public class GetAfterSaleWithGoodsCustomizeService {
    private static final Logger LCAP_LOGGER = LoggerFactory.getLogger(Constants.LCAP_CUSTOMIZE_LOGGER);
	@Autowired private GetAfterSaleWithGoodsCustomizeServiceMapper getAfterSaleWithGoodsCustomizeServiceMapper;
	@Autowired private AfterSalesOrderEntityService afterSalesOrderEntityService;

	public List<AfterSaleGoodsStructure>  getAfterSaleWithGoods(AfterSalesOrderEntity filter,java.time.ZonedDateTime startTime,java.time.ZonedDateTime endTime) {
		List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_700A1909C69274C7EF524520E99699D1> orders = new ArrayList <>();
		List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_C536A748AD5BD93EDD4558A2682AE5EA> goods = new ArrayList <>();
		AfterSaleGoodsStructure temp = new AfterSaleGoodsStructure();
		Long CountNoHandle = 0L;
		List<AfterSaleGoodsStructure> result = new ArrayList <>();
		orders=CommonFunctionUtil.createListPage(getAfterSaleWithGoodsCustomizeServiceMapper.getAnonymousStructure_B68304FA575E7E3C6172C58A216669D4(filter,startTime,endTime), getAfterSaleWithGoodsCustomizeServiceMapper.countAnonymousStructure_B68304FA575E7E3C6172C58A216669D4(filter,startTime,endTime).intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_B68304FA575E7E3C6172C58A216669D4.class).list;
		for(Long index = 0L; index < CommonFunctionUtil.length(orders); index++ ) {
			com.weitest.wms.domain.structure.anonymous.AnonymousStructure_700A1909C69274C7EF524520E99699D1  item = orders.get(index.intValue());
			CommonFunctionUtil.clear(goods);
			CommonFunctionUtil.clear(temp);
			goods=CommonFunctionUtil.createListPage(getAfterSaleWithGoodsCustomizeServiceMapper.getAnonymousStructure_B6021528EA8063DE04918A525D9D601D(item), getAfterSaleWithGoodsCustomizeServiceMapper.countAnonymousStructure_B6021528EA8063DE04918A525D9D601D(item).intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_B6021528EA8063DE04918A525D9D601D.class).list;
			temp.afterSales=CommonFunctionUtil.New(AfterSalesOrderEntity.class);
			CountNoHandle=getAfterSaleWithGoodsCustomizeServiceMapper.getStructure1(item);
			temp.goods=CommonFunctionUtil.New(List.class);
			for(Long index1 = 0L; index1 < CommonFunctionUtil.length(goods); index1++ ) {
				com.weitest.wms.domain.structure.anonymous.AnonymousStructure_C536A748AD5BD93EDD4558A2682AE5EA  item1 = goods.get(index1.intValue());
				CommonFunctionUtil.add(temp.goods,CommonFunctionUtil.clone(item1.afterSaleGood));
			}
			if((CountNoHandle.equals(0L))) {
				item.afterSalesOrder.status=Status_orderEnum.FIELD_2;
				afterSalesOrderEntityService.update(item.afterSalesOrder, Arrays.asList("id","status"));
			} else {
				if((CountNoHandle.compareTo(CommonFunctionUtil.length(goods)) < 0)) {
					item.afterSalesOrder.status=Status_orderEnum.FIELD_1;
					afterSalesOrderEntityService.update(item.afterSalesOrder, Arrays.asList("id","status"));
				} else {
				}
			}
			temp.afterSales=item.afterSalesOrder;
			CommonFunctionUtil.add(result,CommonFunctionUtil.clone(temp));
		}
		return result;
	}


}
