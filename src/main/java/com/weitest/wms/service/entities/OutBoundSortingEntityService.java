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
import com.weitest.wms.domain.entities.OutBoundSortingEntity;
import com.weitest.wms.domain.enumeration.*;
import com.weitest.wms.domain.structure.*;
import com.weitest.wms.datasource.dynamic.DataSource;
import com.weitest.wms.repository.entities.OutBoundSortingEntityMapper;
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
* auto generate OutBoundSortingEntity ServiceImpl
*
* @author sys
*/
@Service
public class OutBoundSortingEntityService extends AbstractService {
    @Resource
    private OutBoundSortingEntityMapper mapper;
    @Resource
    private RelationInnerService relationInnerService;

    private Map<String, String> entityFieldNameTitleMap = new LinkedHashMap<String, String>();
    private Map<String, String> entityFieldTitleNameMap = new LinkedHashMap<String, String>();
    private Map<String, String> entityFiledColumnNameMap = new LinkedHashMap<>();

    public OutBoundSortingEntityService() {
        entityFieldNameTitleMap.put("id", "编号");
        entityFieldTitleNameMap.put("编号", "id");
        entityFiledColumnNameMap.put("id", "id");
        entityFieldNameTitleMap.put("createdTime", "创建时间");
        entityFieldTitleNameMap.put("创建时间", "createdTime");
        entityFiledColumnNameMap.put("createdTime", "createdTime");
        entityFieldNameTitleMap.put("updatedTime", "更新时间");
        entityFieldTitleNameMap.put("更新时间", "updatedTime");
        entityFiledColumnNameMap.put("updatedTime", "updatedTime");
        entityFieldNameTitleMap.put("createdBy", "创建者");
        entityFieldTitleNameMap.put("创建者", "createdBy");
        entityFiledColumnNameMap.put("createdBy", "createdBy");
        entityFieldNameTitleMap.put("updatedBy", "更新者");
        entityFieldTitleNameMap.put("更新者", "updatedBy");
        entityFiledColumnNameMap.put("updatedBy", "updatedBy");
        entityFieldNameTitleMap.put("packingID", "配货表编号");
        entityFieldTitleNameMap.put("配货表编号", "packingID");
        entityFiledColumnNameMap.put("packingID", "packingID");
        entityFieldNameTitleMap.put("status", "分拣状态");
        entityFieldTitleNameMap.put("分拣状态", "status");
        entityFiledColumnNameMap.put("status", "status");
        entityFieldNameTitleMap.put("sortingWorkerID", "分拣员工编号");
        entityFieldTitleNameMap.put("分拣员工编号", "sortingWorkerID");
        entityFiledColumnNameMap.put("sortingWorkerID", "sortingWorkerID");
        entityFieldNameTitleMap.put("sortingWorkerName", "分拣员工姓名");
        entityFieldTitleNameMap.put("分拣员工姓名", "sortingWorkerName");
        entityFiledColumnNameMap.put("sortingWorkerName", "sortingWorkerName");
        entityFieldNameTitleMap.put("sortingData", "分拣时间");
        entityFieldTitleNameMap.put("分拣时间", "sortingData");
        entityFiledColumnNameMap.put("sortingData", "sortingData");
        entityFieldNameTitleMap.put("outBoundTmpArea", "出库暂留区");
        entityFieldTitleNameMap.put("出库暂留区", "outBoundTmpArea");
        entityFiledColumnNameMap.put("outBoundTmpArea", "outBoundTmpArea");
    }

    /**
    * auto gen create method
    **/
    @Transactional(rollbackFor = Exception.class)
    public OutBoundSortingEntity create(OutBoundSortingEntity entity) {
        if (null == entity) {
            throw new HttpCodeException(400, "create param is required");
        }
        // fill default value
        entity.setId(SnowflakeIdWorker.getInstance().nextId());
        entity.setCreatedTime(ZonedDateTime.now(ZoneId.of("UTC")));
        entity.setUpdatedTime(ZonedDateTime.now(ZoneId.of("UTC")));
        UserContext.UserInfo currentUserInfo = UserContext.getCurrentUserInfo();
        String currentUserName = null == currentUserInfo ? null : currentUserInfo.getUserName();
        entity.setCreatedBy(StringUtils.isBlank(entity.getCreatedBy()) ? currentUserName : entity.getCreatedBy());
        entity.setUpdatedBy(StringUtils.isBlank(entity.getUpdatedBy()) ? currentUserName : entity.getUpdatedBy());
        paramValidate(entity);
        mapper.insert(entity);
        return entity;
    }

    /**
    * auto gen batch create method
    **/
    @Transactional(rollbackFor = Exception.class)
    public List<OutBoundSortingEntity> batchCreate(List<OutBoundSortingEntity> entities) {
        if (null == entities || entities.isEmpty()) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_NOTHING_TODO.code);
        }

        UserContext.UserInfo currentUserInfo = UserContext.getCurrentUserInfo();
        String currentUserName = null == currentUserInfo ? null : currentUserInfo.getUserName();

        // fill default value
        for (OutBoundSortingEntity entity : entities) {
            entity.setId(SnowflakeIdWorker.getInstance().nextId());
            entity.setCreatedTime(ZonedDateTime.now(ZoneId.of("UTC")));
            entity.setUpdatedTime(ZonedDateTime.now(ZoneId.of("UTC")));
            entity.setCreatedBy(StringUtils.isBlank(entity.getCreatedBy()) ? currentUserName : entity.getCreatedBy());
            entity.setUpdatedBy(StringUtils.isBlank(entity.getUpdatedBy()) ? currentUserName : entity.getUpdatedBy());
            paramValidate(entity);
        }
        mapper.batchInsert(entities);
        return entities;
    }

    /**
    * auto gen update method
    **/
    @Transactional
    public OutBoundSortingEntity update(OutBoundSortingEntity entity, List<String> updateFields) {
        if (null == entity) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, "OutBoundSortingEntity");
        }
        if ( entity.getId() == null ) { 
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_PRIMARY_KEY_REQUIRED.code);
        }

        // updateFields为null时，默认全量更新
        if (null != updateFields && updateFields.size() == 1 &&  updateFields.contains("id")) {
            return entity;
        } else {
            UserContext.UserInfo currentUserInfo = UserContext.getCurrentUserInfo();
            String currentUserName = null == currentUserInfo ? null : currentUserInfo.getUserName();
            entity.setUpdatedTime(ZonedDateTime.now(ZoneId.of("UTC")));
            entity.setUpdatedBy(StringUtils.isBlank(entity.getUpdatedBy()) ? currentUserName : entity.getUpdatedBy());
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
    public List<OutBoundSortingEntity> batchUpdate(List<OutBoundSortingEntity> entities, List<String> updateFields) {
        if (null == entities || entities.isEmpty()) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_NOTHING_TODO.code);
        }
        // updateFields为null时，默认全量更新
        List<OutBoundSortingEntity> updateEntities = new ArrayList<>(entities.size());
        for (OutBoundSortingEntity entity : entities) {
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
        OutBoundSortingEntity entity = mapper.selectOne( id ); 

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
            .left(new ColumnQueryFilter("OutBoundSorting", "OutBoundSorting", "id", "id"))
            .right(new ListLiteralQueryFilter(ids));
        CommonFunctionUtil.preHandleQueryExpression(inQueryFilter, entityFiledColumnNameMap);
        List<OutBoundSortingEntity>  entities = mapper.selectList(inQueryFilter);
        for (OutBoundSortingEntity entity : entities) {
            relationInnerService.onDelete(entity);
        }

        return mapper.batchDelete(ids);
    }

    /**
     * auto gen get method
     **/
    public OutBoundSortingEntity get( Long id ) { 
        if ( id == null ) { 
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_PRIMARY_KEY_REQUIRED.code);
        }

        OutBoundSortingEntity entity = mapper.selectOne( id ); 
        if (null == entity) {
            throw new HttpCodeException(404, ErrorCodeEnum.DATA_NOT_EXIST.code);
        }
        return entity;
    }

    /**
    * auto gen list method
    **/
    public List<OutBoundSortingEntity> list(AbstractQueryFilter queryFilter) {
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
            List<OutBoundSortingEntity> data = ExcelUtil.read(file.getInputStream(), type, OutBoundSortingEntity.class, entityFieldTitleNameMap);
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

            List<OutBoundSortingEntity> data = list(queryFilter);
            String storeFilePath = ExcelUtil.write(data, OutBoundSortingEntity.class, exportFieldMap);
            org.springframework.core.io.Resource resource = null;
            String contentType = null;
            resource = new FileUrlResource(storeFilePath);
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            if (contentType == null) {
                contentType = "application/octet-stream";
            }
            return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + OutBoundSortingEntity.class.getSimpleName() + ".xlsx\"")
                .body(resource);
        } catch (Exception e) {
            throw new HttpCodeException(500, e);
        }
    }

    /**
    * auto gen createOrUpdate method
    **/
    @Transactional(rollbackFor = Exception.class)
    public OutBoundSortingEntity createOrUpdate(OutBoundSortingEntity entity, List<String> updateFields) {
        if (null == entity) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, OutBoundSortingEntity.class);
        }

        if ( entity.getId() == null ) { 
            // insert
            entity = create(entity);
        }  else {
            OutBoundSortingEntity existEntity = mapper.selectOne(entity.getId()); 
            if (null == existEntity) {
                // insert
                entity.setCreatedTime(ZonedDateTime.now(ZoneId.of("UTC")));
                entity.setUpdatedTime(ZonedDateTime.now(ZoneId.of("UTC")));
                UserContext.UserInfo currentUserInfo = UserContext.getCurrentUserInfo();
                String currentUserName = null == currentUserInfo ? null : currentUserInfo.getUserName();
                entity.setCreatedBy(StringUtils.isBlank(entity.getCreatedBy()) ? currentUserName : entity.getCreatedBy());
                entity.setUpdatedBy(StringUtils.isBlank(entity.getUpdatedBy()) ? currentUserName : entity.getUpdatedBy());
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
    public long updateBy(OutBoundSortingEntity entity, List<String> updateFields, AbstractQueryFilter filter) {

        if (null == entity) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, OutBoundSortingEntity.class);
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
            entity.setUpdatedTime(ZonedDateTime.now(ZoneId.of("UTC")));
            entity.setCreatedBy(StringUtils.isBlank(entity.getCreatedBy()) ? currentUserName : entity.getCreatedBy());
            entity.setUpdatedBy(StringUtils.isBlank(entity.getUpdatedBy()) ? currentUserName : entity.getUpdatedBy());
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