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
* auto generate LCAPLoadRoleManagementTableViewCustomizeService logic
*
* @author sys
*/
@Service
public class LCAPLoadRoleManagementTableViewCustomizeService {
    private static final Logger LCAP_LOGGER = LoggerFactory.getLogger(Constants.LCAP_CUSTOMIZE_LOGGER);
	@Autowired private LCAPLoadRoleManagementTableViewCustomizeServiceMapper lCAPLoadRoleManagementTableViewCustomizeServiceMapper;

	public com.weitest.wms.domain.structure.anonymous.AnonymousStructure_CAC5152BAE2C91DD609E3DFEE343ACC6  lCAPLoadRoleManagementTableView(Long page,Long size,String sort,String order,LCAPRole filter) {
		com.weitest.wms.domain.structure.anonymous.AnonymousStructure_CAC5152BAE2C91DD609E3DFEE343ACC6 result = new com.weitest.wms.domain.structure.anonymous.AnonymousStructure_CAC5152BAE2C91DD609E3DFEE343ACC6();
		result=CommonFunctionUtil.createListPage(lCAPLoadRoleManagementTableViewCustomizeServiceMapper.getAnonymousStructure_CAC5152BAE2C91DD609E3DFEE343ACC6(filter,size,getTableField("AnonymousStructure_70791B893F53C2EFB9E501591763B020",sort),page,order), lCAPLoadRoleManagementTableViewCustomizeServiceMapper.countAnonymousStructure_CAC5152BAE2C91DD609E3DFEE343ACC6(filter,size,getTableField("AnonymousStructure_70791B893F53C2EFB9E501591763B020",sort),page,order).intValue(), com.weitest.wms.domain.structure.anonymous.AnonymousStructure_CAC5152BAE2C91DD609E3DFEE343ACC6.class);
		return result;
	}

    private static Map<String, Map<String, String>> structureTableColumnMap = new HashMap<>();
    private static Map<String, Map<String, List<String>>> structurePropFieldMap = new HashMap<>();
    static {
        Map<String, List<String>> propColumnMap = null;
        Map<String,String> tableColumnMap = null;
        if (structureTableColumnMap.get("AnonymousStructure_70791B893F53C2EFB9E501591763B020") == null) {
        structureTableColumnMap.put("AnonymousStructure_70791B893F53C2EFB9E501591763B020",new HashMap<String, String>());
        }
        tableColumnMap = structureTableColumnMap.get("AnonymousStructure_70791B893F53C2EFB9E501591763B020");
            tableColumnMap.put("lCAPRole.name","`LCAPRole_79f632`.`name`");
            tableColumnMap.put("lCAPRole.createdBy","`LCAPRole_79f632`.`createdBy`");
            tableColumnMap.put("lCAPRole.updatedTime","`LCAPRole_79f632`.`updatedTime`");
            tableColumnMap.put("lCAPRole.updatedBy","`LCAPRole_79f632`.`updatedBy`");
            tableColumnMap.put("lCAPRole.id","`LCAPRole_79f632`.`id`");
            tableColumnMap.put("lCAPRole.createdTime","`LCAPRole_79f632`.`createdTime`");
            tableColumnMap.put("lCAPRole.description","`LCAPRole_79f632`.`description`");
            tableColumnMap.put("lCAPRole.editable","`LCAPRole_79f632`.`editable`");
            tableColumnMap.put("lCAPRole.uuid","`LCAPRole_79f632`.`uuid`");
            tableColumnMap.put("lCAPRole.roleStatus","`LCAPRole_79f632`.`roleStatus`");
        if (structurePropFieldMap.get("AnonymousStructure_70791B893F53C2EFB9E501591763B020") == null) {
            structurePropFieldMap.put("AnonymousStructure_70791B893F53C2EFB9E501591763B020",new HashMap<String, List<String>>());
        }
         propColumnMap = structurePropFieldMap.get("AnonymousStructure_70791B893F53C2EFB9E501591763B020");
        if (propColumnMap.get("updatedTime") == null){
            propColumnMap.put("updatedTime", new ArrayList<>());
            }
            propColumnMap.get("updatedTime").add("lCAPRole.updatedTime");
        if (propColumnMap.get("updatedBy") == null){
            propColumnMap.put("updatedBy", new ArrayList<>());
            }
            propColumnMap.get("updatedBy").add("lCAPRole.updatedBy");
        if (propColumnMap.get("createdBy") == null){
            propColumnMap.put("createdBy", new ArrayList<>());
            }
            propColumnMap.get("createdBy").add("lCAPRole.createdBy");
        if (propColumnMap.get("editable") == null){
            propColumnMap.put("editable", new ArrayList<>());
            }
            propColumnMap.get("editable").add("lCAPRole.editable");
        if (propColumnMap.get("name") == null){
            propColumnMap.put("name", new ArrayList<>());
            }
            propColumnMap.get("name").add("lCAPRole.name");
        if (propColumnMap.get("description") == null){
            propColumnMap.put("description", new ArrayList<>());
            }
            propColumnMap.get("description").add("lCAPRole.description");
        if (propColumnMap.get("createdTime") == null){
            propColumnMap.put("createdTime", new ArrayList<>());
            }
            propColumnMap.get("createdTime").add("lCAPRole.createdTime");
        if (propColumnMap.get("id") == null){
            propColumnMap.put("id", new ArrayList<>());
            }
            propColumnMap.get("id").add("lCAPRole.id");
        if (propColumnMap.get("uuid") == null){
            propColumnMap.put("uuid", new ArrayList<>());
            }
            propColumnMap.get("uuid").add("lCAPRole.uuid");
        if (propColumnMap.get("roleStatus") == null){
            propColumnMap.put("roleStatus", new ArrayList<>());
            }
            propColumnMap.get("roleStatus").add("lCAPRole.roleStatus");
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
