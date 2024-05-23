package com.weitest.wms.service.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.FileUrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.apache.commons.lang3.StringUtils;

import com.weitest.wms.exception.HttpCodeException;
import com.weitest.wms.domain.entities.AllotOutboundEntity;
import com.weitest.wms.domain.enumeration.*;
import com.weitest.wms.domain.structure.*;
import com.weitest.wms.datasource.dynamic.DataSource;
import com.weitest.wms.repository.entities.AllotOutboundEntityMapper;
import com.weitest.wms.util.SnowflakeIdWorker;
import com.weitest.wms.util.CommonFunctionUtil;
import com.weitest.wms.service.entities.AbstractService;
import com.weitest.wms.service.entities.inner.RelationInnerService;
import com.weitest.wms.service.dto.filter.*;
import com.weitest.wms.service.dto.filters.*;
import com.weitest.wms.service.dto.filters.atomic.*;
import com.weitest.wms.service.dto.filters.logic.unary.*;
import com.weitest.wms.service.dto.filters.logic.binary.matching.*;
import com.weitest.wms.util.ExcelUtil;
import com.weitest.wms.context.UserContext;
/**
* auto generate AllotOutboundEntity ServiceImpl
*
* @author sys
*/
@Service
public class AllotOutboundEntityService extends AbstractService {
    @Resource
    private AllotOutboundEntityMapper mapper;
    @Resource
    private RelationInnerService relationInnerService;

    private Map<String, String> entityFieldNameTitleMap = new LinkedHashMap<String, String>();
    private Map<String, String> entityFieldTitleNameMap = new LinkedHashMap<String, String>();
    private Map<String, String> entityFiledColumnNameMap = new LinkedHashMap<>();

    public AllotOutboundEntityService() {
        entityFieldNameTitleMap.put("id", "调拨出库编号");
        entityFieldTitleNameMap.put("调拨出库编号", "id");
        entityFiledColumnNameMap.put("id", "id");
        entityFieldNameTitleMap.put("name", "货物名称");
        entityFieldTitleNameMap.put("货物名称", "name");
        entityFiledColumnNameMap.put("name", "name");
        entityFieldNameTitleMap.put("unit", "货物单位");
        entityFieldTitleNameMap.put("货物单位", "unit");
        entityFiledColumnNameMap.put("unit", "unit");
        entityFieldNameTitleMap.put("quantity", "出库数量");
        entityFieldTitleNameMap.put("出库数量", "quantity");
        entityFiledColumnNameMap.put("quantity", "quantity");
        entityFieldNameTitleMap.put("warehouse_Oid", "原仓库");
        entityFieldTitleNameMap.put("原仓库", "warehouse_Oid");
        entityFiledColumnNameMap.put("warehouse_Oid", "warehouseOid");
        entityFieldNameTitleMap.put("warehouse_Tid", "目的仓库");
        entityFieldTitleNameMap.put("目的仓库", "warehouse_Tid");
        entityFiledColumnNameMap.put("warehouse_Tid", "warehouseTid");
        entityFieldNameTitleMap.put("warehouseArea_Oid", "原货区");
        entityFieldTitleNameMap.put("原货区", "warehouseArea_Oid");
        entityFiledColumnNameMap.put("warehouseArea_Oid", "warehouseAreaOid");
        entityFieldNameTitleMap.put("warehouseArea_Tid", "目的货区");
        entityFieldTitleNameMap.put("目的货区", "warehouseArea_Tid");
        entityFiledColumnNameMap.put("warehouseArea_Tid", "warehouseAreaTid");
        entityFieldNameTitleMap.put("shelf_Oid", "原架位id");
        entityFieldTitleNameMap.put("原架位id", "shelf_Oid");
        entityFiledColumnNameMap.put("shelf_Oid", "shelfOid");
        entityFieldNameTitleMap.put("shelf_Tid", "目的架位id");
        entityFieldTitleNameMap.put("目的架位id", "shelf_Tid");
        entityFiledColumnNameMap.put("shelf_Tid", "shelfTid");
        entityFieldNameTitleMap.put("allotTime", "调拨时间");
        entityFieldTitleNameMap.put("调拨时间", "allotTime");
        entityFiledColumnNameMap.put("allotTime", "allotTime");
    }

    /**
    * auto gen create method
    **/
    @Transactional(rollbackFor = Exception.class)
    public AllotOutboundEntity create(AllotOutboundEntity entity) {
        if (null == entity) {
            throw new HttpCodeException(400, "create param is required");
        }
        // fill default value
        paramValidate(entity);
        mapper.insert(entity);
        return entity;
    }

    /**
    * auto gen batch create method
    **/
    @Transactional(rollbackFor = Exception.class)
    public List<AllotOutboundEntity> batchCreate(List<AllotOutboundEntity> entities) {
        if (null == entities || entities.isEmpty()) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_NOTHING_TODO.code);
        }


        // fill default value
        for (AllotOutboundEntity entity : entities) {
            paramValidate(entity);
        }
        mapper.batchInsert(entities);
        return entities;
    }

    /**
    * auto gen update method
    **/
    @Transactional
    public AllotOutboundEntity update(AllotOutboundEntity entity, List<String> updateFields) {
        if (null == entity) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, "AllotOutboundEntity");
        }
        if ( entity.getId() == null ) { 
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_PRIMARY_KEY_REQUIRED.code);
        }

        // updateFields为null时，默认全量更新
        if (null != updateFields && updateFields.size() == 1 &&  updateFields.contains("id")) {
            return entity;
        } else {
            int rows = mapper.update(entity, updateFields);
            if (rows <= 0) {
                throw new HttpCodeException(404, ErrorCodeEnum.DATA_NOT_EXIST.code, entity.getClass().getName());
            }

            return get(entity.getId());
        }
    }

    /**
    * auto gen batchUpdate method
    **/
    @Transactional(rollbackFor = Exception.class)
    public List<AllotOutboundEntity> batchUpdate(List<AllotOutboundEntity> entities, List<String> updateFields) {
        if (null == entities || entities.isEmpty()) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_NOTHING_TODO.code);
        }
        // updateFields为null时，默认全量更新
        List<AllotOutboundEntity> updateEntities = new ArrayList<>(entities.size());
        for (AllotOutboundEntity entity : entities) {
            updateEntities.add(update(entity, updateFields));
        }

        return updateEntities;
    }

    /**
    * auto gen delete method
    **/
    @Transactional(rollbackFor = Exception.class)
    public long delete( Long id ) { 
        if ( id == null ) { 
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_PRIMARY_KEY_REQUIRED.code);
        }
        AllotOutboundEntity entity = mapper.selectOne( id ); 

        if (null == entity) {
            throw new HttpCodeException(404, ErrorCodeEnum.DATA_NOT_EXIST.code, "");
        }
        relationInnerService.onDelete(entity);
        return mapper.delete( id ); 
    }

    /**
    * auto gen batch delete method
    **/
    @Transactional(rollbackFor = Exception.class)
    public long batchDelete(List<Long> ids) {
        if (null == ids || ids.isEmpty()) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_NOTHING_TODO.code);
        }

        AbstractQueryFilter inQueryFilter = new InQueryFilter()
            .left(new ColumnQueryFilter("AllotOutbound", "AllotOutbound", "id", "id"))
            .right(new ListLiteralQueryFilter(ids));
        CommonFunctionUtil.preHandleQueryExpression(inQueryFilter, entityFiledColumnNameMap);
        List<AllotOutboundEntity>  entities = mapper.selectList(inQueryFilter);
        for (AllotOutboundEntity entity : entities) {
            relationInnerService.onDelete(entity);
        }

        return mapper.batchDelete(ids);
    }

    /**
     * auto gen get method
     **/
    public AllotOutboundEntity get( Long id ) { 
        if ( id == null ) { 
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_PRIMARY_KEY_REQUIRED.code);
        }

        AllotOutboundEntity entity = mapper.selectOne( id ); 
        if (null == entity) {
            throw new HttpCodeException(404, ErrorCodeEnum.DATA_NOT_EXIST.code);
        }
        return entity;
    }

    /**
    * auto gen list method
    **/
    public List<AllotOutboundEntity> list(AbstractQueryFilter queryFilter) {
        if (null == queryFilter) {
            queryFilter = new UnaryExpressionFilter();
        }
        CommonFunctionUtil.preHandleQueryExpression(queryFilter, entityFiledColumnNameMap);
        return mapper.selectList(queryFilter);
    }

    /**
    * auto gen count method
    **/
    public long count(AbstractQueryFilter queryFilter) {
        if (null == queryFilter) {
            queryFilter = new UnaryExpressionFilter();
        }
        CommonFunctionUtil.preHandleQueryExpression(queryFilter, entityFiledColumnNameMap);
        return mapper.count(queryFilter);
    }

    /**
    * auto gen importFile method
    **/
    @Transactional(rollbackFor = Exception.class)
    public String importFile(MultipartFile file) {
        String type;
        String[] items = file.getOriginalFilename().split("\\.");
        if (items.length > 1) {
            type = items[items.length - 1];
            if (!"xls".equalsIgnoreCase(type) && !"xlsx".equalsIgnoreCase(type)) {
                return "不支持的文件类型";
            }
        } else {
            return "不支持的文件类型";
        }

        try {
            List<AllotOutboundEntity> data = ExcelUtil.read(file.getInputStream(), type, AllotOutboundEntity.class, entityFieldTitleNameMap);
            batchCreate(data);
            return "ok";
        } catch (Exception e) {
            throw new HttpCodeException(500, e);
        }
    }

    /**
    * auto gen export method
    **/
    public ResponseEntity<org.springframework.core.io.Resource> export(AbstractQueryFilter queryFilter, String fields, HttpServletRequest request) {
        try {
            Map<String, String> exportFieldMap = entityFieldNameTitleMap;
            if (fields != null && !"".equals(fields.trim())) {
                for (String filedName : fields.split(",")) {
                    exportFieldMap = new LinkedHashMap<String, String>();
                    exportFieldMap.put(filedName, entityFieldNameTitleMap.get(filedName));
                }
            }

            List<AllotOutboundEntity> data = list(queryFilter);
            String storeFilePath = ExcelUtil.write(data, AllotOutboundEntity.class, exportFieldMap);
            org.springframework.core.io.Resource resource = null;
            String contentType = null;
            resource = new FileUrlResource(storeFilePath);
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            if (contentType == null) {
                contentType = "application/octet-stream";
            }
            return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + AllotOutboundEntity.class.getSimpleName() + ".xlsx\"")
                .body(resource);
        } catch (Exception e) {
            throw new HttpCodeException(500, e);
        }
    }

    /**
    * auto gen createOrUpdate method
    **/
    @Transactional(rollbackFor = Exception.class)
    public AllotOutboundEntity createOrUpdate(AllotOutboundEntity entity, List<String> updateFields) {
        if (null == entity) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, AllotOutboundEntity.class);
        }

        if ( entity.getId() == null ) { 
            // insert
            entity = create(entity);
        }  else {
            AllotOutboundEntity existEntity = mapper.selectOne(entity.getId()); 
            if (null == existEntity) {
                // insert
                paramValidate(entity);
                mapper.createOrUpdate(entity);
            } else {
                // updateFields为null时，默认全量更新
                entity = update(entity, updateFields);
            }
        }
        return entity;
    }

    /**
    * auto gen updateBy method
    **/
    @Transactional(rollbackFor = Exception.class)
    public long updateBy(AllotOutboundEntity entity, List<String> updateFields, AbstractQueryFilter filter) {

        if (null == entity) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, AllotOutboundEntity.class);
        }

        // updateFields为null时，默认全量更新
        if (null == filter) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, AbstractQueryFilter.class);
        }

        if (null != updateFields && updateFields.size() == 1 &&  updateFields.contains("id")) {
            return 0;
        } else {
            CommonFunctionUtil.preHandleQueryExpression(filter, entityFiledColumnNameMap);
            return mapper.updateBy(entity, updateFields, filter);
        }
    }

    /**
    * auto gen deleteBy method
    **/
    @Transactional(rollbackFor = Exception.class)
    public long deleteBy(AbstractQueryFilter filter) {
        if (null == filter) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, AbstractQueryFilter.class);
        }

        CommonFunctionUtil.preHandleQueryExpression(filter, entityFiledColumnNameMap);
        return mapper.deleteBy(filter);
    }
}