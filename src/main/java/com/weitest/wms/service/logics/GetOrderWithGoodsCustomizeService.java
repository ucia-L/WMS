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
* auto generate GetOrderWithGoodsCustomizeService logic
*
* @author sys
*/
@Service
public class GetOrderWithGoodsCustomizeService {
    private static final Logger LCAP_LOGGER = LoggerFactory.getLogger(Constants.LCAP_CUSTOMIZE_LOGGER);
	@Autowired private GetOrderWithGoodsCustomizeServiceMapper getOrderWithGoodsCustomizeServiceMapper;
	@Autowired private OrdersEntityService ordersEntityService;

	public List<OrderInboundGoodsStructure>  getOrderWithGoods(InboundOrderFilterStructure filter) {
		List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_8FBEC37F0009D18C595E831E379F9806> orders = new ArrayList <>();
		List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_679CD6B8F1870BD9EC7C1E0FBA5624BC> goods = new ArrayList <>();
		OrderInboundGoodsStructure temp = new OrderInboundGoodsStructure();
		Long CountNoHandle = 0L;
		Long CountRefuse = 0L;
		List<OrderInboundGoodsStructure> result = new ArrayList <>();
		if((filter.endTime != null)) {
			CommonFunctionUtil.alterDateTime(filter.endTime,"Increase",1L,"day");
		} else {
		}
		orders=CommonFunctionUtil.createListPage(getOrderWithGoodsCustomizeServiceMapper.getAnonymousStructure_3BD8627F316F26B90013F1C52321E84D(filter), getOrderWithGoodsCustomizeServiceMapper.countAnonymousStructure_3BD8627F316F26B90013F1C52321E84D(filter).intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_3BD8627F316F26B90013F1C52321E84D.class).list;
		for(Long index = 0L; index < CommonFunctionUtil.length(orders); index++ ) {
			com.weitest.wms.domain.structure.anonymous.AnonymousStructure_8FBEC37F0009D18C595E831E379F9806  item = orders.get(index.intValue());
			CommonFunctionUtil.clear(goods);
			CommonFunctionUtil.clear(temp);
			goods=CommonFunctionUtil.createListPage(getOrderWithGoodsCustomizeServiceMapper.getAnonymousStructure_ACB08A0FFAA227B182FE2140FD2C2BAD(item), getOrderWithGoodsCustomizeServiceMapper.countAnonymousStructure_ACB08A0FFAA227B182FE2140FD2C2BAD(item).intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_ACB08A0FFAA227B182FE2140FD2C2BAD.class).list;
			temp.order=CommonFunctionUtil.New(OrdersEntity.class);
			CountNoHandle=getOrderWithGoodsCustomizeServiceMapper.getStructure1(item);
			CountRefuse=getOrderWithGoodsCustomizeServiceMapper.getStructure2(item);
			temp.goods=CommonFunctionUtil.New(List.class);
			for(Long index1 = 0L; index1 < CommonFunctionUtil.length(goods); index1++ ) {
				com.weitest.wms.domain.structure.anonymous.AnonymousStructure_679CD6B8F1870BD9EC7C1E0FBA5624BC  item1 = goods.get(index1.intValue());
				CommonFunctionUtil.add(temp.goods,CommonFunctionUtil.clone(item1.inBoundGood));
			}
			if((CountRefuse.equals(CommonFunctionUtil.length(goods)))) {
				item.orders.status=Status_orderEnum.FIELD_3;
				ordersEntityService.update(item.orders, Arrays.asList("id","status"));
			} else {
			}
			if(((item.orders.status != Status_orderEnum.FIELD_3) && (CountNoHandle.equals(0L)))) {
				item.orders.status=Status_orderEnum.FIELD_2;
				ordersEntityService.update(item.orders, Arrays.asList("id","status"));
			} else {
				if(((CountNoHandle.equals(CommonFunctionUtil.length(goods)) == Boolean.FALSE) && (item.orders.status != Status_orderEnum.FIELD_3))) {
					item.orders.status=Status_orderEnum.FIELD_1;
					ordersEntityService.update(item.orders, Arrays.asList("id","status"));
				} else {
				}
			}
			temp.order=item.orders;
			CommonFunctionUtil.add(result,CommonFunctionUtil.clone(temp));
		}
		return result;
	}


}
