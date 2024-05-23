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
import com.weitest.wms.domain.entities.ShippingEntity;
import com.weitest.wms.domain.enumeration.*;
import com.weitest.wms.domain.structure.*;
import com.weitest.wms.datasource.dynamic.DataSource;
import com.weitest.wms.repository.entities.ShippingEntityMapper;
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
* auto generate ShippingEntity ServiceImpl
*
* @author sys
*/
@Service
public class ShippingEntityService extends AbstractService {
    @Resource
    private ShippingEntityMapper mapper;
    @Resource
    private RelationInnerService relationInnerService;

    private Map<String, String> entityFieldNameTitleMap = new LinkedHashMap<String, String>();
    private Map<String, String> entityFieldTitleNameMap = new LinkedHashMap<String, String>();
    private Map<String, String> entityFiledColumnNameMap = new LinkedHashMap<>();

    public ShippingEntityService() {
        entityFieldNameTitleMap.put("id", "主键");
        entityFieldTitleNameMap.put("主键", "id");
        entityFiledColumnNameMap.put("id", "id");
        entityFieldNameTitleMap.put("updatedBy", "更新者");
        entityFieldTitleNameMap.put("更新者", "updatedBy");
        entityFiledColumnNameMap.put("updatedBy", "updatedBy");
        entityFieldNameTitleMap.put("updatedTime", "更新时间");
        entityFieldTitleNameMap.put("更新时间", "updatedTime");
        entityFiledColumnNameMap.put("updatedTime", "updatedTime");
        entityFieldNameTitleMap.put("createdBy", "创建者");
        entityFieldTitleNameMap.put("创建者", "createdBy");
        entityFiledColumnNameMap.put("createdBy", "createdBy");
        entityFieldNameTitleMap.put("createdTime", "创建时间");
        entityFieldTitleNameMap.put("创建时间", "createdTime");
        entityFiledColumnNameMap.put("createdTime", "createdTime");
        entityFieldNameTitleMap.put("outBoundOrderID", "出货订单编号");
        entityFieldTitleNameMap.put("出货订单编号", "outBoundOrderID");
        entityFiledColumnNameMap.put("outBoundOrderID", "outBoundOrderID");
        entityFieldNameTitleMap.put("shippingWorkerID", "发货员工编号");
        entityFieldTitleNameMap.put("发货员工编号", "shippingWorkerID");
        entityFiledColumnNameMap.put("shippingWorkerID", "shippingWorkerID");
        entityFieldNameTitleMap.put("shippingWorkerName", "发货员工姓名");
        entityFieldTitleNameMap.put("发货员工姓名", "shippingWorkerName");
        entityFiledColumnNameMap.put("shippingWorkerName", "shippingWorkerName");
        entityFieldNameTitleMap.put("shipping_status", "发货状态");
        entityFieldTitleNameMap.put("发货状态", "shipping_status");
        entityFiledColumnNameMap.put("shipping_status", "shippingStatus");
        entityFieldNameTitleMap.put("express_id", "快递单号");
        entityFieldTitleNameMap.put("快递单号", "express_id");
        entityFiledColumnNameMap.put("express_id", "expressId");
        entityFieldNameTitleMap.put("express_company", "快递公司");
        entityFieldTitleNameMap.put("快递公司", "express_company");
        entityFiledColumnNameMap.put("express_company", "expressCompany");
        entityFieldNameTitleMap.put("shippingTime", "发货时间");
        entityFieldTitleNameMap.put("发货时间", "shippingTime");
        entityFiledColumnNameMap.put("shippingTime", "shippingTime");
    }

    /**
    * auto gen create method
    **/
    @Transactional(rollbackFor = Exception.class)
    public ShippingEntity create(ShippingEntity entity) {
        if (null == entity) {
            throw new HttpCodeException(400, "create param is required");
        }
        // fill default value
        entity.setId(SnowflakeIdWorker.getInstance().nextId());
        UserContext.UserInfo currentUserInfo = UserContext.getCurrentUserInfo();
        String currentUserName = null == currentUserInfo ? null : currentUserInfo.getUserName();
        entity.setUpdatedBy(StringUtils.isBlank(entity.getUpdatedBy()) ? currentUserName : entity.getUpdatedBy());
        entity.setUpdatedTime(ZonedDateTime.now(ZoneId.of("UTC")));
        entity.setCreatedBy(StringUtils.isBlank(entity.getCreatedBy()) ? currentUserName : entity.getCreatedBy());
        entity.setCreatedTime(ZonedDateTime.now(ZoneId.of("UTC")));
        paramValidate(entity);
        mapper.insert(entity);
        return entity;
    }

    /**
    * auto gen batch create method
    **/
    @Transactional(rollbackFor = Exception.class)
    public List<ShippingEntity> batchCreate(List<ShippingEntity> entities) {
        if (null == entities || entities.isEmpty()) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_NOTHING_TODO.code);
        }

        UserContext.UserInfo currentUserInfo = UserContext.getCurrentUserInfo();
        String currentUserName = null == currentUserInfo ? null : currentUserInfo.getUserName();

        // fill default value
        for (ShippingEntity entity : entities) {
            entity.setId(SnowflakeIdWorker.getInstance().nextId());
            entity.setUpdatedBy(StringUtils.isBlank(entity.getUpdatedBy()) ? currentUserName : entity.getUpdatedBy());
            entity.setUpdatedTime(ZonedDateTime.now(ZoneId.of("UTC")));
            entity.setCreatedBy(StringUtils.isBlank(entity.getCreatedBy()) ? currentUserName : entity.getCreatedBy());
            entity.setCreatedTime(ZonedDateTime.now(ZoneId.of("UTC")));
            paramValidate(entity);
        }
        mapper.batchInsert(entities);
        return entities;
    }

    /**
    * auto gen update method
    **/
    @Transactional
    public ShippingEntity update(ShippingEntity entity, List<String> updateFields) {
        if (null == entity) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, "ShippingEntity");
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
            entity.setUpdatedBy(StringUtils.isBlank(entity.getUpdatedBy()) ? currentUserName : entity.getUpdatedBy());
            entity.setUpdatedTime(ZonedDateTime.now(ZoneId.of("UTC")));
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
    public List<ShippingEntity> batchUpdate(List<ShippingEntity> entities, List<String> updateFields) {
        if (null == entities || entities.isEmpty()) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_NOTHING_TODO.code);
        }
        // updateFields为null时，默认全量更新
        List<ShippingEntity> updateEntities = new ArrayList<>(entities.size());
        for (ShippingEntity entity : entities) {
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
        ShippingEntity entity = mapper.selectOne( id ); 

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
            .left(new ColumnQueryFilter("Shipping", "Shipping", "id", "id"))
            .right(new ListLiteralQueryFilter(ids));
        CommonFunctionUtil.preHandleQueryExpression(inQueryFilter, entityFiledColumnNameMap);
        List<ShippingEntity>  entities = mapper.selectList(inQueryFilter);
        for (ShippingEntity entity : entities) {
            relationInnerService.onDelete(entity);
        }

        return mapper.batchDelete(ids);
    }

    /**
     * auto gen get method
     **/
    public ShippingEntity get( Long id ) { 
        if ( id == null ) { 
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_PRIMARY_KEY_REQUIRED.code);
        }

        ShippingEntity entity = mapper.selectOne( id ); 
        if (null == entity) {
            throw new HttpCodeException(404, ErrorCodeEnum.DATA_NOT_EXIST.code);
        }
        return entity;
    }

    /**
    * auto gen list method
    **/
    public List<ShippingEntity> list(AbstractQueryFilter queryFilter) {
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
            List<ShippingEntity> data = ExcelUtil.read(file.getInputStream(), type, ShippingEntity.class, entityFieldTitleNameMap);
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

            List<ShippingEntity> data = list(queryFilter);
            String storeFilePath = ExcelUtil.write(data, ShippingEntity.class, exportFieldMap);
            org.springframework.core.io.Resource resource = null;
            String contentType = null;
            resource = new FileUrlResource(storeFilePath);
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            if (contentType == null) {
                contentType = "application/octet-stream";
            }
            return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + ShippingEntity.class.getSimpleName() + ".xlsx\"")
                .body(resource);
        } catch (Exception e) {
            throw new HttpCodeException(500, e);
        }
    }

    /**
    * auto gen createOrUpdate method
    **/
    @Transactional(rollbackFor = Exception.class)
    public ShippingEntity createOrUpdate(ShippingEntity entity, List<String> updateFields) {
        if (null == entity) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, ShippingEntity.class);
        }

        if ( entity.getId() == null ) { 
            // insert
            entity = create(entity);
        }  else {
            ShippingEntity existEntity = mapper.selectOne(entity.getId()); 
            if (null == existEntity) {
                // insert
                UserContext.UserInfo currentUserInfo = UserContext.getCurrentUserInfo();
                String currentUserName = null == currentUserInfo ? null : currentUserInfo.getUserName();
                entity.setUpdatedBy(StringUtils.isBlank(entity.getUpdatedBy()) ? currentUserName : entity.getUpdatedBy());
                entity.setUpdatedTime(ZonedDateTime.now(ZoneId.of("UTC")));
                entity.setCreatedBy(StringUtils.isBlank(entity.getCreatedBy()) ? currentUserName : entity.getCreatedBy());
                entity.setCreatedTime(ZonedDateTime.now(ZoneId.of("UTC")));
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
    public long updateBy(ShippingEntity entity, List<String> updateFields, AbstractQueryFilter filter) {

        if (null == entity) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, ShippingEntity.class);
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
            entity.setUpdatedBy(StringUtils.isBlank(entity.getUpdatedBy()) ? currentUserName : entity.getUpdatedBy());
            entity.setUpdatedTime(ZonedDateTime.now(ZoneId.of("UTC")));
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