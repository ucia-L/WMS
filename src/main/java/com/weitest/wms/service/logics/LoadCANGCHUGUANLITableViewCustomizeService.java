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
* auto generate LoadCANGCHUGUANLITableViewCustomizeService logic
*
* @author sys
*/
@Service
public class LoadCANGCHUGUANLITableViewCustomizeService {
    private static final Logger LCAP_LOGGER = LoggerFactory.getLogger(Constants.LCAP_CUSTOMIZE_LOGGER);
	@Autowired private LoadCANGCHUGUANLITableViewCustomizeServiceMapper loadCANGCHUGUANLITableViewCustomizeServiceMapper;

	public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_2FE03BCC710FA19E5C3AEF2BA6EF0337  loadCANGCHUGUANLITableView(Long page,Long size,String sort,String order,OutboundOrderEntity filter) {
		com.weitest.wms.domain.structure.anonymous.AnonymousStructure_2FE03BCC710FA19E5C3AEF2BA6EF0337 result = new com.weitest.wms.domain.structure.anonymous.AnonymousStructure_2FE03BCC710FA19E5C3AEF2BA6EF0337();
		result=CommonFunctionUtil.createListPage(loadCANGCHUGUANLITableViewCustomizeServiceMapper.getAnonymousStructure_2FE03BCC710FA19E5C3AEF2BA6EF0337(filter,size,getTableField("AnonymousStructure_C71057545BF85840FA6BDA8BFC46C794",sort),page,order), loadCANGCHUGUANLITableViewCustomizeServiceMapper.countAnonymousStructure_2FE03BCC710FA19E5C3AEF2BA6EF0337(filter,size,getTableField("AnonymousStructure_C71057545BF85840FA6BDA8BFC46C794",sort),page,order).intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_2FE03BCC710FA19E5C3AEF2BA6EF0337.class);
		return result;
	}

    private static Map<String, Map<String, String>> structureTableColumnMap = new HashMap<>();
    private static Map<String, Map<String, List<String>>> structurePropFieldMap = new HashMap<>();
    static {
        Map<String, List<String>> propColumnMap = null;
        Map<String,String> tableColumnMap = null;
        if (structureTableColumnMap.get("AnonymousStructure_C71057545BF85840FA6BDA8BFC46C794") == null) {
        structureTableColumnMap.put("AnonymousStructure_C71057545BF85840FA6BDA8BFC46C794",new HashMap<String, String>());
        }
        tableColumnMap = structureTableColumnMap.get("AnonymousStructure_C71057545BF85840FA6BDA8BFC46C794");
            tableColumnMap.put("outboundOrder.responsible_person","`OutboundOrder`.`responsiblePerson`");
            tableColumnMap.put("outboundOrder.customer_name","`OutboundOrder`.`customerName`");
            tableColumnMap.put("outboundOrder.error_description","`OutboundOrder`.`errorDescription`");
            tableColumnMap.put("outboundOrder.outbound_order_createdTime","`OutboundOrder`.`outboundOrderCreatedTime`");
            tableColumnMap.put("outboundOrder.status","`OutboundOrder`.`status`");
            tableColumnMap.put("outboundOrder.goods_num","`OutboundOrder`.`goodsNum`");
            tableColumnMap.put("outboundOrder.id","`OutboundOrder`.`id`");
            tableColumnMap.put("outboundOrder.amount","`OutboundOrder`.`amount`");
        if (structurePropFieldMap.get("AnonymousStructure_C71057545BF85840FA6BDA8BFC46C794") == null) {
            structurePropFieldMap.put("AnonymousStructure_C71057545BF85840FA6BDA8BFC46C794",new HashMap<String, List<String>>());
        }
         propColumnMap = structurePropFieldMap.get("AnonymousStructure_C71057545BF85840FA6BDA8BFC46C794");
        if (propColumnMap.get("amount") == null){
            propColumnMap.put("amount", new ArrayList<>());
            }
            propColumnMap.get("amount").add("outboundOrder.amount");
        if (propColumnMap.get("error_description") == null){
            propColumnMap.put("error_description", new ArrayList<>());
            }
            propColumnMap.get("error_description").add("outboundOrder.error_description");
        if (propColumnMap.get("responsible_person") == null){
            propColumnMap.put("responsible_person", new ArrayList<>());
            }
            propColumnMap.get("responsible_person").add("outboundOrder.responsible_person");
        if (propColumnMap.get("outbound_order_createdTime") == null){
            propColumnMap.put("outbound_order_createdTime", new ArrayList<>());
            }
            propColumnMap.get("outbound_order_createdTime").add("outboundOrder.outbound_order_createdTime");
        if (propColumnMap.get("goods_num") == null){
            propColumnMap.put("goods_num", new ArrayList<>());
            }
            propColumnMap.get("goods_num").add("outboundOrder.goods_num");
        if (propColumnMap.get("customer_name") == null){
            propColumnMap.put("customer_name", new ArrayList<>());
            }
            propColumnMap.get("customer_name").add("outboundOrder.customer_name");
        if (propColumnMap.get("id") == null){
            propColumnMap.put("id", new ArrayList<>());
            }
            propColumnMap.get("id").add("outboundOrder.id");
        if (propColumnMap.get("status") == null){
            propColumnMap.put("status", new ArrayList<>());
            }
            propColumnMap.get("status").add("outboundOrder.status");
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
