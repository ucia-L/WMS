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
import com.weitest.wms.domain.entities.ShelfEntity;
import com.weitest.wms.domain.enumeration.*;
import com.weitest.wms.domain.structure.*;
import com.weitest.wms.datasource.dynamic.DataSource;
import com.weitest.wms.repository.entities.ShelfEntityMapper;
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
* auto generate ShelfEntity ServiceImpl
*
* @author sys
*/
@Service
public class ShelfEntityService extends AbstractService {
    @Resource
    private ShelfEntityMapper mapper;
    @Resource
    private RelationInnerService relationInnerService;

    private Map<String, String> entityFieldNameTitleMap = new LinkedHashMap<String, String>();
    private Map<String, String> entityFieldTitleNameMap = new LinkedHashMap<String, String>();
    private Map<String, String> entityFiledColumnNameMap = new LinkedHashMap<>();

    public ShelfEntityService() {
        entityFieldNameTitleMap.put("id", "主键");
        entityFieldTitleNameMap.put("主键", "id");
        entityFiledColumnNameMap.put("id", "id");
        entityFieldNameTitleMap.put("name", "货架名称");
        entityFieldTitleNameMap.put("货架名称", "name");
        entityFiledColumnNameMap.put("name", "name");
        entityFieldNameTitleMap.put("warehouseArea_id", "货区编号");
        entityFieldTitleNameMap.put("货区编号", "warehouseArea_id");
        entityFiledColumnNameMap.put("warehouseArea_id", "warehouseAreaId");
        entityFieldNameTitleMap.put("createdTime", "创建时间");
        entityFieldTitleNameMap.put("创建时间", "createdTime");
        entityFiledColumnNameMap.put("createdTime", "createdTime");
        entityFieldNameTitleMap.put("createdBy", "创建者");
        entityFieldTitleNameMap.put("创建者", "createdBy");
        entityFiledColumnNameMap.put("createdBy", "createdBy");
        entityFieldTitleNameMap.put("id_tag", "id_tag");
        entityFiledColumnNameMap.put("id_tag", "idTag");
        entityFieldTitleNameMap.put("status", "status");
        entityFiledColumnNameMap.put("status", "status");
        entityFieldNameTitleMap.put("capacity", "容量");
        entityFieldTitleNameMap.put("容量", "capacity");
        entityFiledColumnNameMap.put("capacity", "capacity");
        entityFieldNameTitleMap.put("currentQuantity", "当前库存");
        entityFieldTitleNameMap.put("当前库存", "currentQuantity");
        entityFiledColumnNameMap.put("currentQuantity", "currentQuantity");
        entityFieldNameTitleMap.put("preference", "货架偏好");
        entityFieldTitleNameMap.put("货架偏好", "preference");
        entityFiledColumnNameMap.put("preference", "preference");
    }

    /**
    * auto gen create method
    **/
    @Transactional(rollbackFor = Exception.class)
    public ShelfEntity create(ShelfEntity entity) {
        if (null == entity) {
            throw new HttpCodeException(400, "create param is required");
        }
        // fill default value
        entity.setCreatedTime(ZonedDateTime.now(ZoneId.of("UTC")));
        UserContext.UserInfo currentUserInfo = UserContext.getCurrentUserInfo();
        String currentUserName = null == currentUserInfo ? null : currentUserInfo.getUserName();
        entity.setCreatedBy(StringUtils.isBlank(entity.getCreatedBy()) ? currentUserName : entity.getCreatedBy());
        entity.setCapacity(getOrDefault(entity.getCapacity(), 100L));
        entity.setCurrentQuantity(getOrDefault(entity.getCurrentQuantity(), 0L));
        paramValidate(entity);
        mapper.insert(entity);
        return entity;
    }

    /**
    * auto gen batch create method
    **/
    @Transactional(rollbackFor = Exception.class)
    public List<ShelfEntity> batchCreate(List<ShelfEntity> entities) {
        if (null == entities || entities.isEmpty()) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_NOTHING_TODO.code);
        }

        UserContext.UserInfo currentUserInfo = UserContext.getCurrentUserInfo();
        String currentUserName = null == currentUserInfo ? null : currentUserInfo.getUserName();

        // fill default value
        for (ShelfEntity entity : entities) {
            entity.setCreatedTime(ZonedDateTime.now(ZoneId.of("UTC")));
            entity.setCreatedBy(StringUtils.isBlank(entity.getCreatedBy()) ? currentUserName : entity.getCreatedBy());
            entity.setCapacity(getOrDefault(entity.getCapacity(), 100L));
            entity.setCurrentQuantity(getOrDefault(entity.getCurrentQuantity(), 0L));
            paramValidate(entity);
        }
        mapper.batchInsert(entities);
        return entities;
    }

    /**
    * auto gen update method
    **/
    @Transactional
    public ShelfEntity update(ShelfEntity entity, List<String> updateFields) {
        if (null == entity) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, "ShelfEntity");
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
    public List<ShelfEntity> batchUpdate(List<ShelfEntity> entities, List<String> updateFields) {
        if (null == entities || entities.isEmpty()) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_NOTHING_TODO.code);
        }
        // updateFields为null时，默认全量更新
        List<ShelfEntity> updateEntities = new ArrayList<>(entities.size());
        for (ShelfEntity entity : entities) {
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
        ShelfEntity entity = mapper.selectOne( id ); 

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
            .left(new ColumnQueryFilter("Shelf", "Shelf", "id", "id"))
            .right(new ListLiteralQueryFilter(ids));
        CommonFunctionUtil.preHandleQueryExpression(inQueryFilter, entityFiledColumnNameMap);
        List<ShelfEntity>  entities = mapper.selectList(inQueryFilter);
        for (ShelfEntity entity : entities) {
            relationInnerService.onDelete(entity);
        }

        return mapper.batchDelete(ids);
    }

    /**
     * auto gen get method
     **/
    public ShelfEntity get( Long id ) { 
        if ( id == null ) { 
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_PRIMARY_KEY_REQUIRED.code);
        }

        ShelfEntity entity = mapper.selectOne( id ); 
        if (null == entity) {
            throw new HttpCodeException(404, ErrorCodeEnum.DATA_NOT_EXIST.code);
        }
        return entity;
    }

    /**
    * auto gen list method
    **/
    public List<ShelfEntity> list(AbstractQueryFilter queryFilter) {
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
            List<ShelfEntity> data = ExcelUtil.read(file.getInputStream(), type, ShelfEntity.class, entityFieldTitleNameMap);
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

            List<ShelfEntity> data = list(queryFilter);
            String storeFilePath = ExcelUtil.write(data, ShelfEntity.class, exportFieldMap);
            org.springframework.core.io.Resource resource = null;
            String contentType = null;
            resource = new FileUrlResource(storeFilePath);
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            if (contentType == null) {
                contentType = "application/octet-stream";
            }
            return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + ShelfEntity.class.getSimpleName() + ".xlsx\"")
                .body(resource);
        } catch (Exception e) {
            throw new HttpCodeException(500, e);
        }
    }

    /**
    * auto gen createOrUpdate method
    **/
    @Transactional(rollbackFor = Exception.class)
    public ShelfEntity createOrUpdate(ShelfEntity entity, List<String> updateFields) {
        if (null == entity) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, ShelfEntity.class);
        }

        if ( entity.getId() == null ) { 
            // insert
            entity = create(entity);
        }  else {
            ShelfEntity existEntity = mapper.selectOne(entity.getId()); 
            if (null == existEntity) {
                // insert
                entity.setCreatedTime(ZonedDateTime.now(ZoneId.of("UTC")));
                UserContext.UserInfo currentUserInfo = UserContext.getCurrentUserInfo();
                String currentUserName = null == currentUserInfo ? null : currentUserInfo.getUserName();
                entity.setCreatedBy(StringUtils.isBlank(entity.getCreatedBy()) ? currentUserName : entity.getCreatedBy());
                entity.setCapacity(getOrDefault(entity.getCapacity(), 100L));
                entity.setCurrentQuantity(getOrDefault(entity.getCurrentQuantity(), 0L));
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
    public long updateBy(ShelfEntity entity, List<String> updateFields, AbstractQueryFilter filter) {

        if (null == entity) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, ShelfEntity.class);
        }

        // updateFields为null时，默认全量更新
        if (null == filter) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, AbstractQueryFilter.class);
        }

        if (null != updateFields && updateFields.size() == 1 &&  updateFields.contains("id")) {
            return 0;
        } else {
            UserContext.UserInfo currentUserInfo = UserContext.getCurrentUserInfo();
            String currentUserName = null == currentUserInfo ? null : currentUserInfo.getUserName();
            CommonFunctionUtil.preHandleQueryExpression(filter, entityFiledColumnNameMap);
            entity.setCreatedBy(StringUtils.isBlank(entity.getCreatedBy()) ? currentUserName : entity.getCreatedBy());
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