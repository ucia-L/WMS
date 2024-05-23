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
* auto generate LoadMainDashBoardTableViewCustomizeService logic
*
* @author sys
*/
@Service
public class LoadMainDashBoardTableViewCustomizeService {
    private static final Logger LCAP_LOGGER = LoggerFactory.getLogger(Constants.LCAP_CUSTOMIZE_LOGGER);
	@Autowired private LoadMainDashBoardTableViewCustomizeServiceMapper loadMainDashBoardTableViewCustomizeServiceMapper;

	public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_7F0FC9CD7C0E19CDEBEF556E681E6B3C  loadMainDashBoardTableView(Long page,Long size,String sort,String order) {
		com.weitest.wms.domain.structure.anonymous.AnonymousStructure_7F0FC9CD7C0E19CDEBEF556E681E6B3C result = new com.weitest.wms.domain.structure.anonymous.AnonymousStructure_7F0FC9CD7C0E19CDEBEF556E681E6B3C();
		result=CommonFunctionUtil.createListPage(loadMainDashBoardTableViewCustomizeServiceMapper.getAnonymousStructure_7F0FC9CD7C0E19CDEBEF556E681E6B3C(size,getTableField("AnonymousStructure_F30C4D4796DE57EC4963423784B62512",sort),page,order), loadMainDashBoardTableViewCustomizeServiceMapper.countAnonymousStructure_7F0FC9CD7C0E19CDEBEF556E681E6B3C(size,getTableField("AnonymousStructure_F30C4D4796DE57EC4963423784B62512",sort),page,order).intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_7F0FC9CD7C0E19CDEBEF556E681E6B3C.class);
		return result;
	}

    private static Map<String, Map<String, String>> structureTableColumnMap = new HashMap<>();
    private static Map<String, Map<String, List<String>>> structurePropFieldMap = new HashMap<>();
    static {
        Map<String, List<String>> propColumnMap = null;
        Map<String,String> tableColumnMap = null;
        if (structureTableColumnMap.get("AnonymousStructure_F30C4D4796DE57EC4963423784B62512") == null) {
        structureTableColumnMap.put("AnonymousStructure_F30C4D4796DE57EC4963423784B62512",new HashMap<String, String>());
        }
        tableColumnMap = structureTableColumnMap.get("AnonymousStructure_F30C4D4796DE57EC4963423784B62512");
            tableColumnMap.put("shelf.createdBy","`Shelf`.`createdBy`");
            tableColumnMap.put("shelf.preference","`Shelf`.`preference`");
            tableColumnMap.put("shelf.name","`Shelf`.`name`");
            tableColumnMap.put("shelf.status","`Shelf`.`status`");
            tableColumnMap.put("shelf.id_tag","`Shelf`.`idTag`");
            tableColumnMap.put("shelf.id","`Shelf`.`id`");
            tableColumnMap.put("shelf.currentQuantity","`Shelf`.`currentQuantity`");
            tableColumnMap.put("shelf.warehouseArea_id","`Shelf`.`warehouseAreaId`");
            tableColumnMap.put("shelf.createdTime","`Shelf`.`createdTime`");
            tableColumnMap.put("shelf.capacity","`Shelf`.`capacity`");
        if (structurePropFieldMap.get("AnonymousStructure_F30C4D4796DE57EC4963423784B62512") == null) {
            structurePropFieldMap.put("AnonymousStructure_F30C4D4796DE57EC4963423784B62512",new HashMap<String, List<String>>());
        }
         propColumnMap = structurePropFieldMap.get("AnonymousStructure_F30C4D4796DE57EC4963423784B62512");
        if (propColumnMap.get("warehouseArea_id") == null){
            propColumnMap.put("warehouseArea_id", new ArrayList<>());
            }
            propColumnMap.get("warehouseArea_id").add("shelf.warehouseArea_id");
        if (propColumnMap.get("createdBy") == null){
            propColumnMap.put("createdBy", new ArrayList<>());
            }
            propColumnMap.get("createdBy").add("shelf.createdBy");
        if (propColumnMap.get("preference") == null){
            propColumnMap.put("preference", new ArrayList<>());
            }
            propColumnMap.get("preference").add("shelf.preference");
        if (propColumnMap.get("name") == null){
            propColumnMap.put("name", new ArrayList<>());
            }
            propColumnMap.get("name").add("shelf.name");
        if (propColumnMap.get("createdTime") == null){
            propColumnMap.put("createdTime", new ArrayList<>());
            }
            propColumnMap.get("createdTime").add("shelf.createdTime");
        if (propColumnMap.get("id") == null){
            propColumnMap.put("id", new ArrayList<>());
            }
            propColumnMap.get("id").add("shelf.id");
        if (propColumnMap.get("id_tag") == null){
            propColumnMap.put("id_tag", new ArrayList<>());
            }
            propColumnMap.get("id_tag").add("shelf.id_tag");
        if (propColumnMap.get("currentQuantity") == null){
            propColumnMap.put("currentQuantity", new ArrayList<>());
            }
            propColumnMap.get("currentQuantity").add("shelf.currentQuantity");
        if (propColumnMap.get("capacity") == null){
            propColumnMap.put("capacity", new ArrayList<>());
            }
            propColumnMap.get("capacity").add("shelf.capacity");
        if (propColumnMap.get("status") == null){
            propColumnMap.put("status", new ArrayList<>());
            }
            propColumnMap.get("status").add("shelf.status");
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
