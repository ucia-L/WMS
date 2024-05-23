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
* auto generate GetOrderWithGoodsForOutCustomizeService logic
*
* @author sys
*/
@Service
public class GetOrderWithGoodsForOutCustomizeService {
    private static final Logger LCAP_LOGGER = LoggerFactory.getLogger(Constants.LCAP_CUSTOMIZE_LOGGER);
	@Autowired private GetOrderWithGoodsForOutCustomizeServiceMapper getOrderWithGoodsForOutCustomizeServiceMapper;
	@Autowired private GetGoodsWithAllInfoCustomizeService getGoodsWithAllInfoCustomizeService;

	public List<OrderGoodsStructure>  getOrderWithGoodsForOut(GoodsEntity filter) {
		List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_700A1909C69274C7EF524520E99699D1> orders = new ArrayList <>();
		List<com.weitest.wms.domain.structure.anonymous.AnonymousStructure_90C927AEC6192B24A524A13F9820A290> Goods = new ArrayList <>();
		OrderGoodsStructure temp = new OrderGoodsStructure();
		GoodsInfoStructure tempGoodInfo = new GoodsInfoStructure();
		List<OrderGoodsStructure> result = new ArrayList <>();
		orders=CommonFunctionUtil.createListPage(getOrderWithGoodsForOutCustomizeServiceMapper.getAnonymousStructure_B68304FA575E7E3C6172C58A216669D4(), getOrderWithGoodsForOutCustomizeServiceMapper.countAnonymousStructure_B68304FA575E7E3C6172C58A216669D4().intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_B68304FA575E7E3C6172C58A216669D4.class).list;
		result=CommonFunctionUtil.New(List.class);
		for(Long index = 0L; index < orders.size(); index++ ) {
			com.weitest.wms.domain.structure.anonymous.AnonymousStructure_700A1909C69274C7EF524520E99699D1  item = orders.get(index.intValue());
			CommonFunctionUtil.clear(Goods);
			CommonFunctionUtil.clear(temp);
			temp=CommonFunctionUtil.New(OrderGoodsStructure.class);
			filter.afterSale_id=item.afterSalesOrder.id;
			Goods=getGoodsWithAllInfoCustomizeService.getGoodsWithAllInfo(filter);
			temp.order=CommonFunctionUtil.New(AfterSalesOrderEntity.class);
			temp.goods=CommonFunctionUtil.New(List.class);
			temp.order=item.afterSalesOrder;
			for(Long index1 = 0L; index1 < CommonFunctionUtil.length(Goods); index1++ ) {
				com.weitest.wms.domain.structure.anonymous.AnonymousStructure_90C927AEC6192B24A524A13F9820A290  item1 = Goods.get(index1.intValue());
				tempGoodInfo=CommonFunctionUtil.New(GoodsInfoStructure.class);
				tempGoodInfo.goods=CommonFunctionUtil.New(GoodsEntity.class);
				tempGoodInfo.goods.category=item1.goods.category;
				tempGoodInfo.goods.inbound_date=item1.goods.inbound_date;
				tempGoodInfo.goods.inbound_op=item1.goods.inbound_op;
				tempGoodInfo.goods.inbound_tmp_area=item1.goods.inbound_tmp_area;
				tempGoodInfo.goods.name=item1.goods.name;
				tempGoodInfo.goods.notes=item1.goods.notes;
				tempGoodInfo.goods.order_id=item1.goods.order_id;
				tempGoodInfo.goods.outbound_date=item1.goods.outbound_date;
				tempGoodInfo.goods.outbound_op=item1.goods.outbound_op;
				tempGoodInfo.goods.quantity=item1.goods.quantity;
				tempGoodInfo.goods.refuse_reason=item1.goods.refuse_reason;
				tempGoodInfo.goods.shelf_id=item1.goods.shelf_id;
				tempGoodInfo.goods.status=item1.goods.status;
				tempGoodInfo.goods.storage_area_id=item1.goods.storage_area_id;
				tempGoodInfo.goods.unit=item1.goods.unit;
				tempGoodInfo.goods.warehouse_id=item1.goods.warehouse_id;
				tempGoodInfo.goods.id=item1.goods.id;
				tempGoodInfo.shelf_name=item1.shelf.name;
				tempGoodInfo.warehouseArea_name=item1.warehouseArea.name;
				tempGoodInfo.warehouse_name=item1.warehouse.name;
				CommonFunctionUtil.add(temp.goods,CommonFunctionUtil.clone(tempGoodInfo));
			}
			if((CommonFunctionUtil.length(temp.goods).equals(0L))) {
			} else {
				CommonFunctionUtil.add(result,CommonFunctionUtil.clone(temp));
			}
		}
		return result;
	}


}
