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
* auto generate LCAPLoadUserRoleMappingTableViewCustomizeService logic
*
* @author sys
*/
@Service
public class LCAPLoadUserRoleMappingTableViewCustomizeService {
    private static final Logger LCAP_LOGGER = LoggerFactory.getLogger(Constants.LCAP_CUSTOMIZE_LOGGER);
	@Autowired private LCAPLoadUserRoleMappingTableViewCustomizeServiceMapper lCAPLoadUserRoleMappingTableViewCustomizeServiceMapper;

	public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_A43B95DDE943F37E89AA74CCF8732C90  lCAPLoadUserRoleMappingTableView(Long page,Long size,String sort,String order,LCAPUserRoleMapping filter) {
		com.weitest.wms.domain.structure.anonymous.AnonymousStructure_A43B95DDE943F37E89AA74CCF8732C90 result = new com.weitest.wms.domain.structure.anonymous.AnonymousStructure_A43B95DDE943F37E89AA74CCF8732C90();
		result=CommonFunctionUtil.createListPage(lCAPLoadUserRoleMappingTableViewCustomizeServiceMapper.getAnonymousStructure_A43B95DDE943F37E89AA74CCF8732C90(filter,size,getTableField("AnonymousStructure_99BA20F3093BB3AC3F3CA0BCA6D65EB8",sort),page,order), lCAPLoadUserRoleMappingTableViewCustomizeServiceMapper.countAnonymousStructure_A43B95DDE943F37E89AA74CCF8732C90(filter,size,getTableField("AnonymousStructure_99BA20F3093BB3AC3F3CA0BCA6D65EB8",sort),page,order).intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_A43B95DDE943F37E89AA74CCF8732C90.class);
		return result;
	}

    private static Map<String, Map<String, String>> structureTableColumnMap = new HashMap<>();
    private static Map<String, Map<String, List<String>>> structurePropFieldMap = new HashMap<>();
    static {
        Map<String, List<String>> propColumnMap = null;
        Map<String,String> tableColumnMap = null;
        if (structureTableColumnMap.get("AnonymousStructure_99BA20F3093BB3AC3F3CA0BCA6D65EB8") == null) {
        structureTableColumnMap.put("AnonymousStructure_99BA20F3093BB3AC3F3CA0BCA6D65EB8",new HashMap<String, String>());
        }
        tableColumnMap = structureTableColumnMap.get("AnonymousStructure_99BA20F3093BB3AC3F3CA0BCA6D65EB8");
            tableColumnMap.put("lCAPUserRoleMapping.createdTime","`LCAPUserRoleMapping_79f632`.`createdTime`");
            tableColumnMap.put("lCAPRole.updatedTime","`LCAPRole_79f632`.`updatedTime`");
            tableColumnMap.put("lCAPRole.updatedBy","`LCAPRole_79f632`.`updatedBy`");
            tableColumnMap.put("lCAPRole.editable","`LCAPRole_79f632`.`editable`");
            tableColumnMap.put("lCAPUserRoleMapping.createdBy","`LCAPUserRoleMapping_79f632`.`createdBy`");
            tableColumnMap.put("lCAPUserRoleMapping.updatedTime","`LCAPUserRoleMapping_79f632`.`updatedTime`");
            tableColumnMap.put("lCAPUserRoleMapping.userName","`LCAPUserRoleMapping_79f632`.`userName`");
            tableColumnMap.put("lCAPRole.roleStatus","`LCAPRole_79f632`.`roleStatus`");
            tableColumnMap.put("lCAPRole.name","`LCAPRole_79f632`.`name`");
            tableColumnMap.put("lCAPRole.createdBy","`LCAPRole_79f632`.`createdBy`");
            tableColumnMap.put("lCAPRole.id","`LCAPRole_79f632`.`id`");
            tableColumnMap.put("lCAPUserRoleMapping.updatedBy","`LCAPUserRoleMapping_79f632`.`updatedBy`");
            tableColumnMap.put("lCAPRole.createdTime","`LCAPRole_79f632`.`createdTime`");
            tableColumnMap.put("lCAPRole.description","`LCAPRole_79f632`.`description`");
            tableColumnMap.put("lCAPUserRoleMapping.source","`LCAPUserRoleMapping_79f632`.`source`");
            tableColumnMap.put("lCAPUserRoleMapping.roleId","`LCAPUserRoleMapping_79f632`.`roleId`");
            tableColumnMap.put("lCAPUserRoleMapping.userId","`LCAPUserRoleMapping_79f632`.`userId`");
            tableColumnMap.put("lCAPRole.uuid","`LCAPRole_79f632`.`uuid`");
            tableColumnMap.put("lCAPUserRoleMapping.id","`LCAPUserRoleMapping_79f632`.`id`");
        if (structurePropFieldMap.get("AnonymousStructure_99BA20F3093BB3AC3F3CA0BCA6D65EB8") == null) {
            structurePropFieldMap.put("AnonymousStructure_99BA20F3093BB3AC3F3CA0BCA6D65EB8",new HashMap<String, List<String>>());
        }
         propColumnMap = structurePropFieldMap.get("AnonymousStructure_99BA20F3093BB3AC3F3CA0BCA6D65EB8");
        if (propColumnMap.get("updatedTime") == null){
            propColumnMap.put("updatedTime", new ArrayList<>());
            }
            propColumnMap.get("updatedTime").add("lCAPUserRoleMapping.updatedTime");
            propColumnMap.get("updatedTime").add("lCAPRole.updatedTime");
        if (propColumnMap.get("updatedBy") == null){
            propColumnMap.put("updatedBy", new ArrayList<>());
            }
            propColumnMap.get("updatedBy").add("lCAPUserRoleMapping.updatedBy");
            propColumnMap.get("updatedBy").add("lCAPRole.updatedBy");
        if (propColumnMap.get("editable") == null){
            propColumnMap.put("editable", new ArrayList<>());
            }
            propColumnMap.get("editable").add("lCAPRole.editable");
        if (propColumnMap.get("roleId") == null){
            propColumnMap.put("roleId", new ArrayList<>());
            }
            propColumnMap.get("roleId").add("lCAPUserRoleMapping.roleId");
        if (propColumnMap.get("description") == null){
            propColumnMap.put("description", new ArrayList<>());
            }
            propColumnMap.get("description").add("lCAPRole.description");
        if (propColumnMap.get("source") == null){
            propColumnMap.put("source", new ArrayList<>());
            }
            propColumnMap.get("source").add("lCAPUserRoleMapping.source");
        if (propColumnMap.get("userName") == null){
            propColumnMap.put("userName", new ArrayList<>());
            }
            propColumnMap.get("userName").add("lCAPUserRoleMapping.userName");
        if (propColumnMap.get("uuid") == null){
            propColumnMap.put("uuid", new ArrayList<>());
            }
            propColumnMap.get("uuid").add("lCAPRole.uuid");
        if (propColumnMap.get("userId") == null){
            propColumnMap.put("userId", new ArrayList<>());
            }
            propColumnMap.get("userId").add("lCAPUserRoleMapping.userId");
        if (propColumnMap.get("roleStatus") == null){
            propColumnMap.put("roleStatus", new ArrayList<>());
            }
            propColumnMap.get("roleStatus").add("lCAPRole.roleStatus");
        if (propColumnMap.get("createdBy") == null){
            propColumnMap.put("createdBy", new ArrayList<>());
            }
            propColumnMap.get("createdBy").add("lCAPUserRoleMapping.createdBy");
            propColumnMap.get("createdBy").add("lCAPRole.createdBy");
        if (propColumnMap.get("name") == null){
            propColumnMap.put("name", new ArrayList<>());
            }
            propColumnMap.get("name").add("lCAPRole.name");
        if (propColumnMap.get("createdTime") == null){
            propColumnMap.put("createdTime", new ArrayList<>());
            }
            propColumnMap.get("createdTime").add("lCAPUserRoleMapping.createdTime");
            propColumnMap.get("createdTime").add("lCAPRole.createdTime");
        if (propColumnMap.get("id") == null){
            propColumnMap.put("id", new ArrayList<>());
            }
            propColumnMap.get("id").add("lCAPUserRoleMapping.id");
            propColumnMap.get("id").add("lCAPRole.id");
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
