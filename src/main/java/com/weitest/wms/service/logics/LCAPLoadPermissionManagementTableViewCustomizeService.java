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
* auto generate LCAPLoadPermissionManagementTableViewCustomizeService logic
*
* @author sys
*/
@Service
public class LCAPLoadPermissionManagementTableViewCustomizeService {
    private static final Logger LCAP_LOGGER = LoggerFactory.getLogger(Constants.LCAP_CUSTOMIZE_LOGGER);
	@Autowired private LCAPLoadPermissionManagementTableViewCustomizeServiceMapper lCAPLoadPermissionManagementTableViewCustomizeServiceMapper;

	public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_D5C9C5DD94C4E7386BEED9E75D0F06FA  lCAPLoadPermissionManagementTableView(Long page,Long size,String sort,String order,LCAPPermission filter) {
		com.weitest.wms.domain.structure.anonymous.AnonymousStructure_D5C9C5DD94C4E7386BEED9E75D0F06FA result = new com.weitest.wms.domain.structure.anonymous.AnonymousStructure_D5C9C5DD94C4E7386BEED9E75D0F06FA();
		result=CommonFunctionUtil.createListPage(lCAPLoadPermissionManagementTableViewCustomizeServiceMapper.getAnonymousStructure_D5C9C5DD94C4E7386BEED9E75D0F06FA(filter,size,getTableField("AnonymousStructure_92F2372792A8A12DF53175B7AD25D2FD",sort),page,order), lCAPLoadPermissionManagementTableViewCustomizeServiceMapper.countAnonymousStructure_D5C9C5DD94C4E7386BEED9E75D0F06FA(filter,size,getTableField("AnonymousStructure_92F2372792A8A12DF53175B7AD25D2FD",sort),page,order).intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_D5C9C5DD94C4E7386BEED9E75D0F06FA.class);
		return result;
	}

    private static Map<String, Map<String, String>> structureTableColumnMap = new HashMap<>();
    private static Map<String, Map<String, List<String>>> structurePropFieldMap = new HashMap<>();
    static {
        Map<String, List<String>> propColumnMap = null;
        Map<String,String> tableColumnMap = null;
        if (structureTableColumnMap.get("AnonymousStructure_92F2372792A8A12DF53175B7AD25D2FD") == null) {
        structureTableColumnMap.put("AnonymousStructure_92F2372792A8A12DF53175B7AD25D2FD",new HashMap<String, String>());
        }
        tableColumnMap = structureTableColumnMap.get("AnonymousStructure_92F2372792A8A12DF53175B7AD25D2FD");
            tableColumnMap.put("lCAPPermission.updatedTime","`LCAPPermission_79f632`.`updatedTime`");
            tableColumnMap.put("lCAPPermission.createdBy","`LCAPPermission_79f632`.`createdBy`");
            tableColumnMap.put("lCAPPermission.updatedBy","`LCAPPermission_79f632`.`updatedBy`");
            tableColumnMap.put("lCAPPermission.uuid","`LCAPPermission_79f632`.`uuid`");
            tableColumnMap.put("lCAPPermission.id","`LCAPPermission_79f632`.`id`");
            tableColumnMap.put("lCAPPermission.name","`LCAPPermission_79f632`.`name`");
            tableColumnMap.put("lCAPPermission.description","`LCAPPermission_79f632`.`description`");
            tableColumnMap.put("lCAPPermission.createdTime","`LCAPPermission_79f632`.`createdTime`");
        if (structurePropFieldMap.get("AnonymousStructure_92F2372792A8A12DF53175B7AD25D2FD") == null) {
            structurePropFieldMap.put("AnonymousStructure_92F2372792A8A12DF53175B7AD25D2FD",new HashMap<String, List<String>>());
        }
         propColumnMap = structurePropFieldMap.get("AnonymousStructure_92F2372792A8A12DF53175B7AD25D2FD");
        if (propColumnMap.get("updatedTime") == null){
            propColumnMap.put("updatedTime", new ArrayList<>());
            }
            propColumnMap.get("updatedTime").add("lCAPPermission.updatedTime");
        if (propColumnMap.get("updatedBy") == null){
            propColumnMap.put("updatedBy", new ArrayList<>());
            }
            propColumnMap.get("updatedBy").add("lCAPPermission.updatedBy");
        if (propColumnMap.get("createdBy") == null){
            propColumnMap.put("createdBy", new ArrayList<>());
            }
            propColumnMap.get("createdBy").add("lCAPPermission.createdBy");
        if (propColumnMap.get("name") == null){
            propColumnMap.put("name", new ArrayList<>());
            }
            propColumnMap.get("name").add("lCAPPermission.name");
        if (propColumnMap.get("description") == null){
            propColumnMap.put("description", new ArrayList<>());
            }
            propColumnMap.get("description").add("lCAPPermission.description");
        if (propColumnMap.get("createdTime") == null){
            propColumnMap.put("createdTime", new ArrayList<>());
            }
            propColumnMap.get("createdTime").add("lCAPPermission.createdTime");
        if (propColumnMap.get("id") == null){
            propColumnMap.put("id", new ArrayList<>());
            }
            propColumnMap.get("id").add("lCAPPermission.id");
        if (propColumnMap.get("uuid") == null){
            propColumnMap.put("uuid", new ArrayList<>());
            }
            propColumnMap.get("uuid").add("lCAPPermission.uuid");
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
