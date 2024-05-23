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
* auto generate LoadCANGCHUGUANLITableView1CustomizeService logic
*
* @author sys
*/
@Service
public class LoadCANGCHUGUANLITableView1CustomizeService {
    private static final Logger LCAP_LOGGER = LoggerFactory.getLogger(Constants.LCAP_CUSTOMIZE_LOGGER);
	@Autowired private LoadCANGCHUGUANLITableView1CustomizeServiceMapper loadCANGCHUGUANLITableView1CustomizeServiceMapper;

	public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_BC7B3AE84F9C5B2486014DB3333180BF  loadCANGCHUGUANLITableView1(Long page,Long size,String sort,String order) {
		com.weitest.wms.domain.structure.anonymous.AnonymousStructure_BC7B3AE84F9C5B2486014DB3333180BF result = new com.weitest.wms.domain.structure.anonymous.AnonymousStructure_BC7B3AE84F9C5B2486014DB3333180BF();
		result=CommonFunctionUtil.createListPage(loadCANGCHUGUANLITableView1CustomizeServiceMapper.getAnonymousStructure_BC7B3AE84F9C5B2486014DB3333180BF(size,getTableField("AnonymousStructure_46B102641248613FF08FAE8B2E5F02F5",sort),page,order), loadCANGCHUGUANLITableView1CustomizeServiceMapper.countAnonymousStructure_BC7B3AE84F9C5B2486014DB3333180BF(size,getTableField("AnonymousStructure_46B102641248613FF08FAE8B2E5F02F5",sort),page,order).intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_BC7B3AE84F9C5B2486014DB3333180BF.class);
		return result;
	}

    private static Map<String, Map<String, String>> structureTableColumnMap = new HashMap<>();
    private static Map<String, Map<String, List<String>>> structurePropFieldMap = new HashMap<>();
    static {
        Map<String, List<String>> propColumnMap = null;
        Map<String,String> tableColumnMap = null;
        if (structureTableColumnMap.get("AnonymousStructure_46B102641248613FF08FAE8B2E5F02F5") == null) {
        structureTableColumnMap.put("AnonymousStructure_46B102641248613FF08FAE8B2E5F02F5",new HashMap<String, String>());
        }
        tableColumnMap = structureTableColumnMap.get("AnonymousStructure_46B102641248613FF08FAE8B2E5F02F5");
            tableColumnMap.put("goods.status","`Goods`.`status`");
            tableColumnMap.put("goods.order_id","`Goods`.`orderId`");
            tableColumnMap.put("orders.expected_date","`Orders`.`expectedDate`");
            tableColumnMap.put("goods.notes","`Goods`.`notes`");
            tableColumnMap.put("orders.createdTime","`Orders`.`createdTime`");
            tableColumnMap.put("goods.inbound_date","`Goods`.`inboundDate`");
            tableColumnMap.put("orders.id_tag","`Orders`.`idTag`");
            tableColumnMap.put("orders.responsible_person","`Orders`.`responsiblePerson`");
            tableColumnMap.put("goods.warehouse_id","`Goods`.`warehouseId`");
            tableColumnMap.put("orders.updatedBy","`Orders`.`updatedBy`");
            tableColumnMap.put("goods.inbound_tmp_area","`Goods`.`inboundTmpArea`");
            tableColumnMap.put("orders.refuse_reason","`Orders`.`refuseReason`");
            tableColumnMap.put("orders.arrival_date","`Orders`.`arrivalDate`");
            tableColumnMap.put("goods.id_tag","`Goods`.`idTag`");
            tableColumnMap.put("orders.updatedTime","`Orders`.`updatedTime`");
            tableColumnMap.put("goods.unit","`Goods`.`unit`");
            tableColumnMap.put("goods.commodity_id","`Goods`.`commodityId`");
            tableColumnMap.put("orders.status","`Orders`.`status`");
            tableColumnMap.put("goods.name","`Goods`.`name`");
            tableColumnMap.put("goods.category","`Goods`.`category`");
            tableColumnMap.put("goods.outbound_price","`Goods`.`outboundPrice`");
            tableColumnMap.put("orders.goods_num","`Orders`.`goodsNum`");
            tableColumnMap.put("orders.customer_name","`Orders`.`customerName`");
            tableColumnMap.put("goods.storage_area_id","`Goods`.`storageAreaId`");
            tableColumnMap.put("goods.on_shelf_time","`Goods`.`onShelfTime`");
            tableColumnMap.put("orders.createdBy","`Orders`.`createdBy`");
            tableColumnMap.put("goods.afterSale_id","`Goods`.`afterSaleId`");
            tableColumnMap.put("goods.outbound_date","`Goods`.`outboundDate`");
            tableColumnMap.put("goods.inbound_price","`Goods`.`inboundPrice`");
            tableColumnMap.put("goods.on_shelf_op","`Goods`.`onShelfOp`");
            tableColumnMap.put("orders.id","`Orders`.`id`");
            tableColumnMap.put("goods.refuse_reason","`Goods`.`refuseReason`");
            tableColumnMap.put("goods.outbound_op","`Goods`.`outboundOp`");
            tableColumnMap.put("goods.shelf_id","`Goods`.`shelfId`");
            tableColumnMap.put("orders.amount","`Orders`.`amount`");
            tableColumnMap.put("goods.quantity","`Goods`.`quantity`");
            tableColumnMap.put("orders.notes","`Orders`.`notes`");
            tableColumnMap.put("goods.inbound_op","`Goods`.`inboundOp`");
            tableColumnMap.put("goods.goodCategory","`Goods`.`goodCategory`");
            tableColumnMap.put("goods.id","`Goods`.`id`");
        if (structurePropFieldMap.get("AnonymousStructure_46B102641248613FF08FAE8B2E5F02F5") == null) {
            structurePropFieldMap.put("AnonymousStructure_46B102641248613FF08FAE8B2E5F02F5",new HashMap<String, List<String>>());
        }
         propColumnMap = structurePropFieldMap.get("AnonymousStructure_46B102641248613FF08FAE8B2E5F02F5");
        if (propColumnMap.get("notes") == null){
            propColumnMap.put("notes", new ArrayList<>());
            }
            propColumnMap.get("notes").add("goods.notes");
            propColumnMap.get("notes").add("orders.notes");
        if (propColumnMap.get("responsible_person") == null){
            propColumnMap.put("responsible_person", new ArrayList<>());
            }
            propColumnMap.get("responsible_person").add("orders.responsible_person");
        if (propColumnMap.get("goodCategory") == null){
            propColumnMap.put("goodCategory", new ArrayList<>());
            }
            propColumnMap.get("goodCategory").add("goods.goodCategory");
        if (propColumnMap.get("storage_area_id") == null){
            propColumnMap.put("storage_area_id", new ArrayList<>());
            }
            propColumnMap.get("storage_area_id").add("goods.storage_area_id");
        if (propColumnMap.get("outbound_date") == null){
            propColumnMap.put("outbound_date", new ArrayList<>());
            }
            propColumnMap.get("outbound_date").add("goods.outbound_date");
        if (propColumnMap.get("inbound_tmp_area") == null){
            propColumnMap.put("inbound_tmp_area", new ArrayList<>());
            }
            propColumnMap.get("inbound_tmp_area").add("goods.inbound_tmp_area");
        if (propColumnMap.get("inbound_op") == null){
            propColumnMap.put("inbound_op", new ArrayList<>());
            }
            propColumnMap.get("inbound_op").add("goods.inbound_op");
        if (propColumnMap.get("createdTime") == null){
            propColumnMap.put("createdTime", new ArrayList<>());
            }
            propColumnMap.get("createdTime").add("orders.createdTime");
        if (propColumnMap.get("outbound_price") == null){
            propColumnMap.put("outbound_price", new ArrayList<>());
            }
            propColumnMap.get("outbound_price").add("goods.outbound_price");
        if (propColumnMap.get("id") == null){
            propColumnMap.put("id", new ArrayList<>());
            }
            propColumnMap.get("id").add("goods.id");
            propColumnMap.get("id").add("orders.id");
        if (propColumnMap.get("arrival_date") == null){
            propColumnMap.put("arrival_date", new ArrayList<>());
            }
            propColumnMap.get("arrival_date").add("orders.arrival_date");
        if (propColumnMap.get("afterSale_id") == null){
            propColumnMap.put("afterSale_id", new ArrayList<>());
            }
            propColumnMap.get("afterSale_id").add("goods.afterSale_id");
        if (propColumnMap.get("updatedTime") == null){
            propColumnMap.put("updatedTime", new ArrayList<>());
            }
            propColumnMap.get("updatedTime").add("orders.updatedTime");
        if (propColumnMap.get("amount") == null){
            propColumnMap.put("amount", new ArrayList<>());
            }
            propColumnMap.get("amount").add("orders.amount");
        if (propColumnMap.get("updatedBy") == null){
            propColumnMap.put("updatedBy", new ArrayList<>());
            }
            propColumnMap.get("updatedBy").add("orders.updatedBy");
        if (propColumnMap.get("quantity") == null){
            propColumnMap.put("quantity", new ArrayList<>());
            }
            propColumnMap.get("quantity").add("goods.quantity");
        if (propColumnMap.get("inbound_date") == null){
            propColumnMap.put("inbound_date", new ArrayList<>());
            }
            propColumnMap.get("inbound_date").add("goods.inbound_date");
        if (propColumnMap.get("refuse_reason") == null){
            propColumnMap.put("refuse_reason", new ArrayList<>());
            }
            propColumnMap.get("refuse_reason").add("goods.refuse_reason");
            propColumnMap.get("refuse_reason").add("orders.refuse_reason");
        if (propColumnMap.get("on_shelf_time") == null){
            propColumnMap.put("on_shelf_time", new ArrayList<>());
            }
            propColumnMap.get("on_shelf_time").add("goods.on_shelf_time");
        if (propColumnMap.get("inbound_price") == null){
            propColumnMap.put("inbound_price", new ArrayList<>());
            }
            propColumnMap.get("inbound_price").add("goods.inbound_price");
        if (propColumnMap.get("id_tag") == null){
            propColumnMap.put("id_tag", new ArrayList<>());
            }
            propColumnMap.get("id_tag").add("goods.id_tag");
            propColumnMap.get("id_tag").add("orders.id_tag");
        if (propColumnMap.get("on_shelf_op") == null){
            propColumnMap.put("on_shelf_op", new ArrayList<>());
            }
            propColumnMap.get("on_shelf_op").add("goods.on_shelf_op");
        if (propColumnMap.get("unit") == null){
            propColumnMap.put("unit", new ArrayList<>());
            }
            propColumnMap.get("unit").add("goods.unit");
        if (propColumnMap.get("commodity_id") == null){
            propColumnMap.put("commodity_id", new ArrayList<>());
            }
            propColumnMap.get("commodity_id").add("goods.commodity_id");
        if (propColumnMap.get("expected_date") == null){
            propColumnMap.put("expected_date", new ArrayList<>());
            }
            propColumnMap.get("expected_date").add("orders.expected_date");
        if (propColumnMap.get("createdBy") == null){
            propColumnMap.put("createdBy", new ArrayList<>());
            }
            propColumnMap.get("createdBy").add("orders.createdBy");
        if (propColumnMap.get("outbound_op") == null){
            propColumnMap.put("outbound_op", new ArrayList<>());
            }
            propColumnMap.get("outbound_op").add("goods.outbound_op");
        if (propColumnMap.get("name") == null){
            propColumnMap.put("name", new ArrayList<>());
            }
            propColumnMap.get("name").add("goods.name");
        if (propColumnMap.get("goods_num") == null){
            propColumnMap.put("goods_num", new ArrayList<>());
            }
            propColumnMap.get("goods_num").add("orders.goods_num");
        if (propColumnMap.get("shelf_id") == null){
            propColumnMap.put("shelf_id", new ArrayList<>());
            }
            propColumnMap.get("shelf_id").add("goods.shelf_id");
        if (propColumnMap.get("customer_name") == null){
            propColumnMap.put("customer_name", new ArrayList<>());
            }
            propColumnMap.get("customer_name").add("orders.customer_name");
        if (propColumnMap.get("category") == null){
            propColumnMap.put("category", new ArrayList<>());
            }
            propColumnMap.get("category").add("goods.category");
        if (propColumnMap.get("order_id") == null){
            propColumnMap.put("order_id", new ArrayList<>());
            }
            propColumnMap.get("order_id").add("goods.order_id");
        if (propColumnMap.get("warehouse_id") == null){
            propColumnMap.put("warehouse_id", new ArrayList<>());
            }
            propColumnMap.get("warehouse_id").add("goods.warehouse_id");
        if (propColumnMap.get("status") == null){
            propColumnMap.put("status", new ArrayList<>());
            }
            propColumnMap.get("status").add("goods.status");
            propColumnMap.get("status").add("orders.status");
    }
    private String getTableField(String structureName, String param) {
        if (structurePropFieldMap.get(structureName) == null) {
            return param;
        }
        if (param == null || "".equals(param)) {
            return null;
        }
        Map<String, String> tableColumnMap = structureTableColumnMap.get(structureName);
        Map<String, List<String>> propColumnMap = structurePropFieldMap.get(structureName);
        String[] paramSplit = param.split("\\.");
        if (paramSplit.length == 1) {
            List<String> propList = propColumnMap.get(paramSplit[0]);
            String tableColumn = getTableColumn(propList, tableColumnMap);
            if (tableColumn != null) {
                return tableColumn;
            }
        } else if (tableColumnMap.get(param) != null) {
            return tableColumnMap.get(param);
        }
        throw new HttpCodeException(404, "排序参数{" + param + "}不存在");
    }

    // for sonar check Cognitive Complexity
    private String getTableColumn(List<String> propList, Map<String, String> tableColumnMap) {
        String tableColumn = null;
        if (propList != null) {
            for (String prop : propList) {
                String str = tableColumnMap.get(prop);
                if (str == null || "".equals(str)) {
                    continue;
                }
                if (tableColumn == null) {
                    tableColumn = str;
                } else {
                    tableColumn = str.length() >= tableColumn.length() ? tableColumn : str;
                }
            }
        }

        return tableColumn;
    }

    public  <T> T getObjectTableField(String structureName,T obj,List<String> fieldNames) {
        try {
            T cloneObj = CommonFunctionUtil.clone(obj);
            for (String fieldRef : fieldNames) {
                String[] fieldNameSplit = fieldRef.split("\\.");
                Field field = obj.getClass().getDeclaredField(fieldNameSplit[0]);
                Object fieldObject = cloneObj;
                for (int fieldIndex = 1; fieldIndex < fieldNameSplit.length; fieldIndex++) {
                    fieldObject = field.get(fieldObject);
                    field = field.getType().getDeclaredField(fieldNameSplit[fieldIndex]);
                }
                    field.set(fieldObject, getTableField(structureName, (String) field.get(fieldObject)));
                }
                return cloneObj;
            } catch (Exception e) {
                throw new HttpCodeException("500", e);
            }
    }

}
