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
* auto generate LoadCANGCHUGUANLITableView6CustomizeService logic
*
* @author sys
*/
@Service
public class LoadCANGCHUGUANLITableView6CustomizeService {
    private static final Logger LCAP_LOGGER = LoggerFactory.getLogger(Constants.LCAP_CUSTOMIZE_LOGGER);
	@Autowired private LoadCANGCHUGUANLITableView6CustomizeServiceMapper loadCANGCHUGUANLITableView6CustomizeServiceMapper;

	public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_8B7A01F9E9F20DE75E42AAFB1EC465EE  loadCANGCHUGUANLITableView6(Long page,Long size,String sort,String order) {
		com.weitest.wms.domain.structure.anonymous.AnonymousStructure_8B7A01F9E9F20DE75E42AAFB1EC465EE result = new com.weitest.wms.domain.structure.anonymous.AnonymousStructure_8B7A01F9E9F20DE75E42AAFB1EC465EE();
		result=CommonFunctionUtil.createListPage(loadCANGCHUGUANLITableView6CustomizeServiceMapper.getAnonymousStructure_8B7A01F9E9F20DE75E42AAFB1EC465EE(size,getTableField("AnonymousStructure_5FCA4D0BC12DD21DE8AB0B014AC1F1E5",sort),page,order), loadCANGCHUGUANLITableView6CustomizeServiceMapper.countAnonymousStructure_8B7A01F9E9F20DE75E42AAFB1EC465EE(size,getTableField("AnonymousStructure_5FCA4D0BC12DD21DE8AB0B014AC1F1E5",sort),page,order).intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_8B7A01F9E9F20DE75E42AAFB1EC465EE.class);
		return result;
	}

    private static Map<String, Map<String, String>> structureTableColumnMap = new HashMap<>();
    private static Map<String, Map<String, List<String>>> structurePropFieldMap = new HashMap<>();
    static {
        Map<String, List<String>> propColumnMap = null;
        Map<String,String> tableColumnMap = null;
        if (structureTableColumnMap.get("AnonymousStructure_5FCA4D0BC12DD21DE8AB0B014AC1F1E5") == null) {
        structureTableColumnMap.put("AnonymousStructure_5FCA4D0BC12DD21DE8AB0B014AC1F1E5",new HashMap<String, String>());
        }
        tableColumnMap = structureTableColumnMap.get("AnonymousStructure_5FCA4D0BC12DD21DE8AB0B014AC1F1E5");
            tableColumnMap.put("outboundPacking.outbound_commodity_name","`OutboundPacking`.`outboundCommodityName`");
            tableColumnMap.put("outboundPacking.outBoundOrderID","`OutboundPacking`.`outBoundOrderID`");
            tableColumnMap.put("outboundPacking.status","`OutboundPacking`.`status`");
            tableColumnMap.put("outboundPacking.outbound_tmparea_id","`OutboundPacking`.`outboundTmpareaId`");
            tableColumnMap.put("outBoundGood.id","`OutBoundGood`.`id`");
            tableColumnMap.put("outBoundGood.quantity","`OutBoundGood`.`quantity`");
            tableColumnMap.put("outBoundGood.unit","`OutBoundGood`.`unit`");
            tableColumnMap.put("outBoundGood.weight","`OutBoundGood`.`weight`");
            tableColumnMap.put("outBoundGood.status","`OutBoundGood`.`status`");
            tableColumnMap.put("outboundPacking.quantity","`OutboundPacking`.`quantity`");
            tableColumnMap.put("outboundPacking.warehouseArea_id","`OutboundPacking`.`warehouseAreaId`");
            tableColumnMap.put("outboundPacking.outbound_good_id","`OutboundPacking`.`outboundGoodId`");
            tableColumnMap.put("outboundPacking.id","`OutboundPacking`.`id`");
            tableColumnMap.put("outboundPacking.shelf_id","`OutboundPacking`.`shelfId`");
            tableColumnMap.put("outBoundGood.outbound_order_id","`OutBoundGood`.`outboundOrderId`");
            tableColumnMap.put("outBoundGood.name","`OutBoundGood`.`name`");
        if (structurePropFieldMap.get("AnonymousStructure_5FCA4D0BC12DD21DE8AB0B014AC1F1E5") == null) {
            structurePropFieldMap.put("AnonymousStructure_5FCA4D0BC12DD21DE8AB0B014AC1F1E5",new HashMap<String, List<String>>());
        }
         propColumnMap = structurePropFieldMap.get("AnonymousStructure_5FCA4D0BC12DD21DE8AB0B014AC1F1E5");
        if (propColumnMap.get("outBoundOrderID") == null){
            propColumnMap.put("outBoundOrderID", new ArrayList<>());
            }
            propColumnMap.get("outBoundOrderID").add("outboundPacking.outBoundOrderID");
        if (propColumnMap.get("warehouseArea_id") == null){
            propColumnMap.put("warehouseArea_id", new ArrayList<>());
            }
            propColumnMap.get("warehouseArea_id").add("outboundPacking.warehouseArea_id");
        if (propColumnMap.get("unit") == null){
            propColumnMap.put("unit", new ArrayList<>());
            }
            propColumnMap.get("unit").add("outBoundGood.unit");
        if (propColumnMap.get("quantity") == null){
            propColumnMap.put("quantity", new ArrayList<>());
            }
            propColumnMap.get("quantity").add("outBoundGood.quantity");
            propColumnMap.get("quantity").add("outboundPacking.quantity");
        if (propColumnMap.get("outbound_good_id") == null){
            propColumnMap.put("outbound_good_id", new ArrayList<>());
            }
            propColumnMap.get("outbound_good_id").add("outboundPacking.outbound_good_id");
        if (propColumnMap.get("name") == null){
            propColumnMap.put("name", new ArrayList<>());
            }
            propColumnMap.get("name").add("outBoundGood.name");
        if (propColumnMap.get("outbound_tmparea_id") == null){
            propColumnMap.put("outbound_tmparea_id", new ArrayList<>());
            }
            propColumnMap.get("outbound_tmparea_id").add("outboundPacking.outbound_tmparea_id");
        if (propColumnMap.get("weight") == null){
            propColumnMap.put("weight", new ArrayList<>());
            }
            propColumnMap.get("weight").add("outBoundGood.weight");
        if (propColumnMap.get("outbound_commodity_name") == null){
            propColumnMap.put("outbound_commodity_name", new ArrayList<>());
            }
            propColumnMap.get("outbound_commodity_name").add("outboundPacking.outbound_commodity_name");
        if (propColumnMap.get("shelf_id") == null){
            propColumnMap.put("shelf_id", new ArrayList<>());
            }
            propColumnMap.get("shelf_id").add("outboundPacking.shelf_id");
        if (propColumnMap.get("outbound_order_id") == null){
            propColumnMap.put("outbound_order_id", new ArrayList<>());
            }
            propColumnMap.get("outbound_order_id").add("outBoundGood.outbound_order_id");
        if (propColumnMap.get("id") == null){
            propColumnMap.put("id", new ArrayList<>());
            }
            propColumnMap.get("id").add("outBoundGood.id");
            propColumnMap.get("id").add("outboundPacking.id");
        if (propColumnMap.get("status") == null){
            propColumnMap.put("status", new ArrayList<>());
            }
            propColumnMap.get("status").add("outBoundGood.status");
            propColumnMap.get("status").add("outboundPacking.status");
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
