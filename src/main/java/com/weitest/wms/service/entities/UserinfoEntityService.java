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
import com.weitest.wms.domain.entities.UserinfoEntity;
import com.weitest.wms.domain.enumeration.*;
import com.weitest.wms.domain.structure.*;
import com.weitest.wms.datasource.dynamic.DataSource;
import com.weitest.wms.repository.entities.UserinfoEntityMapper;
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
* auto generate UserinfoEntity ServiceImpl
*
* @author sys
*/
@Service
public class UserinfoEntityService extends AbstractService {
    @Resource
    private UserinfoEntityMapper mapper;
    @Resource
    private RelationInnerService relationInnerService;

    private Map<String, String> entityFieldNameTitleMap = new LinkedHashMap<String, String>();
    private Map<String, String> entityFieldTitleNameMap = new LinkedHashMap<String, String>();
    private Map<String, String> entityFiledColumnNameMap = new LinkedHashMap<>();

    public UserinfoEntityService() {
        entityFieldNameTitleMap.put("id", "主键");
        entityFieldTitleNameMap.put("主键", "id");
        entityFiledColumnNameMap.put("id", "id");
        entityFieldNameTitleMap.put("createdTime", "注册时间");
        entityFieldTitleNameMap.put("注册时间", "createdTime");
        entityFiledColumnNameMap.put("createdTime", "createdTime");
        entityFieldNameTitleMap.put("username", "用户名");
        entityFieldTitleNameMap.put("用户名", "username");
        entityFiledColumnNameMap.put("username", "username");
        entityFieldNameTitleMap.put("password", "密码");
        entityFieldTitleNameMap.put("密码", "password");
        entityFiledColumnNameMap.put("password", "password");
        entityFieldNameTitleMap.put("phone", "手机号");
        entityFieldTitleNameMap.put("手机号", "phone");
        entityFiledColumnNameMap.put("phone", "phone");
        entityFieldNameTitleMap.put("name", "名字");
        entityFieldTitleNameMap.put("名字", "name");
        entityFiledColumnNameMap.put("name", "name");
        entityFieldNameTitleMap.put("avatar", "用户头像");
        entityFieldTitleNameMap.put("用户头像", "avatar");
        entityFiledColumnNameMap.put("avatar", "avatar");
        entityFieldNameTitleMap.put("sex", "性别");
        entityFieldTitleNameMap.put("性别", "sex");
        entityFiledColumnNameMap.put("sex", "sex");
        entityFieldNameTitleMap.put("is_inbound", "入库管理权限");
        entityFieldTitleNameMap.put("入库管理权限", "is_inbound");
        entityFiledColumnNameMap.put("is_inbound", "isInbound");
        entityFieldNameTitleMap.put("is_outbound", "出库管理权限");
        entityFieldTitleNameMap.put("出库管理权限", "is_outbound");
        entityFiledColumnNameMap.put("is_outbound", "isOutbound");
        entityFieldNameTitleMap.put("is_distribution", "配送管理权限");
        entityFieldTitleNameMap.put("配送管理权限", "is_distribution");
        entityFiledColumnNameMap.put("is_distribution", "isDistribution");
        entityFieldNameTitleMap.put("is_warefareManage", "仓内管理权限");
        entityFieldTitleNameMap.put("仓内管理权限", "is_warefareManage");
        entityFiledColumnNameMap.put("is_warefareManage", "isWarefareManage");
        entityFieldNameTitleMap.put("is_finance", "财政管理权限");
        entityFieldTitleNameMap.put("财政管理权限", "is_finance");
        entityFiledColumnNameMap.put("is_finance", "isFinance");
        entityFieldNameTitleMap.put("is_admin", "管理员");
        entityFieldTitleNameMap.put("管理员", "is_admin");
        entityFiledColumnNameMap.put("is_admin", "isAdmin");
        entityFieldNameTitleMap.put("warehouse_id", "仓库编号");
        entityFieldTitleNameMap.put("仓库编号", "warehouse_id");
        entityFiledColumnNameMap.put("warehouse_id", "warehouseId");
        entityFieldNameTitleMap.put("createdBy", "创建者");
        entityFieldTitleNameMap.put("创建者", "createdBy");
        entityFiledColumnNameMap.put("createdBy", "createdBy");
        entityFieldNameTitleMap.put("orderInbound_count", "订单入库单数");
        entityFieldTitleNameMap.put("订单入库单数", "orderInbound_count");
        entityFiledColumnNameMap.put("orderInbound_count", "orderInboundCount");
        entityFieldNameTitleMap.put("orderOutbound_count", "订单出库单数");
        entityFieldTitleNameMap.put("订单出库单数", "orderOutbound_count");
        entityFiledColumnNameMap.put("orderOutbound_count", "orderOutboundCount");
        entityFieldNameTitleMap.put("afterSaleInbound_count", "售后入库单数");
        entityFieldTitleNameMap.put("售后入库单数", "afterSaleInbound_count");
        entityFiledColumnNameMap.put("afterSaleInbound_count", "afterSaleInboundCount");
        entityFieldNameTitleMap.put("afterSaleOutbound_count", "售后出库单数");
        entityFieldTitleNameMap.put("售后出库单数", "afterSaleOutbound_count");
        entityFiledColumnNameMap.put("afterSaleOutbound_count", "afterSaleOutboundCount");
        entityFieldNameTitleMap.put("otherInbound_count", "其它入库单数");
        entityFieldTitleNameMap.put("其它入库单数", "otherInbound_count");
        entityFiledColumnNameMap.put("otherInbound_count", "otherInboundCount");
        entityFieldNameTitleMap.put("otherOutbound_count", "其它出库单数");
        entityFieldTitleNameMap.put("其它出库单数", "otherOutbound_count");
        entityFiledColumnNameMap.put("otherOutbound_count", "otherOutboundCount");
    }

    /**
    * auto gen create method
    **/
    @Transactional(rollbackFor = Exception.class)
    public UserinfoEntity create(UserinfoEntity entity) {
        if (null == entity) {
            throw new HttpCodeException(400, "create param is required");
        }
        // fill default value
        entity.setId(SnowflakeIdWorker.getInstance().nextId());
        entity.setCreatedTime(ZonedDateTime.now(ZoneId.of("UTC")));
        entity.setAvatar(getOrDefault(entity.getAvatar(), "/assets/avatar-default.svg"));
        UserContext.UserInfo currentUserInfo = UserContext.getCurrentUserInfo();
        String currentUserName = null == currentUserInfo ? null : currentUserInfo.getUserName();
        entity.setCreatedBy(StringUtils.isBlank(entity.getCreatedBy()) ? currentUserName : entity.getCreatedBy());
        entity.setOrderInbound_count(getOrDefault(entity.getOrderInbound_count(), 0L));
        entity.setOrderOutbound_count(getOrDefault(entity.getOrderOutbound_count(), 0L));
        entity.setAfterSaleInbound_count(getOrDefault(entity.getAfterSaleInbound_count(), 0L));
        entity.setAfterSaleOutbound_count(getOrDefault(entity.getAfterSaleOutbound_count(), 0L));
        entity.setOtherInbound_count(getOrDefault(entity.getOtherInbound_count(), 0L));
        entity.setOtherOutbound_count(getOrDefault(entity.getOtherOutbound_count(), 0L));
        paramValidate(entity);
        mapper.insert(entity);
        return entity;
    }

    /**
    * auto gen batch create method
    **/
    @Transactional(rollbackFor = Exception.class)
    public List<UserinfoEntity> batchCreate(List<UserinfoEntity> entities) {
        if (null == entities || entities.isEmpty()) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_NOTHING_TODO.code);
        }

        UserContext.UserInfo currentUserInfo = UserContext.getCurrentUserInfo();
        String currentUserName = null == currentUserInfo ? null : currentUserInfo.getUserName();

        // fill default value
        for (UserinfoEntity entity : entities) {
            entity.setId(SnowflakeIdWorker.getInstance().nextId());
            entity.setCreatedTime(ZonedDateTime.now(ZoneId.of("UTC")));
            entity.setAvatar(getOrDefault(entity.getAvatar(), "/assets/avatar-default.svg"));
            entity.setCreatedBy(StringUtils.isBlank(entity.getCreatedBy()) ? currentUserName : entity.getCreatedBy());
            entity.setOrderInbound_count(getOrDefault(entity.getOrderInbound_count(), 0L));
            entity.setOrderOutbound_count(getOrDefault(entity.getOrderOutbound_count(), 0L));
            entity.setAfterSaleInbound_count(getOrDefault(entity.getAfterSaleInbound_count(), 0L));
            entity.setAfterSaleOutbound_count(getOrDefault(entity.getAfterSaleOutbound_count(), 0L));
            entity.setOtherInbound_count(getOrDefault(entity.getOtherInbound_count(), 0L));
            entity.setOtherOutbound_count(getOrDefault(entity.getOtherOutbound_count(), 0L));
            paramValidate(entity);
        }
        mapper.batchInsert(entities);
        return entities;
    }

    /**
    * auto gen update method
    **/
    @Transactional
    public UserinfoEntity update(UserinfoEntity entity, List<String> updateFields) {
        if (null == entity) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, "UserinfoEntity");
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
    public List<UserinfoEntity> batchUpdate(List<UserinfoEntity> entities, List<String> updateFields) {
        if (null == entities || entities.isEmpty()) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_NOTHING_TODO.code);
        }
        // updateFields为null时，默认全量更新
        List<UserinfoEntity> updateEntities = new ArrayList<>(entities.size());
        for (UserinfoEntity entity : entities) {
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
        UserinfoEntity entity = mapper.selectOne( id ); 

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
            .left(new ColumnQueryFilter("Userinfo", "Userinfo", "id", "id"))
            .right(new ListLiteralQueryFilter(ids));
        CommonFunctionUtil.preHandleQueryExpression(inQueryFilter, entityFiledColumnNameMap);
        List<UserinfoEntity>  entities = mapper.selectList(inQueryFilter);
        for (UserinfoEntity entity : entities) {
            relationInnerService.onDelete(entity);
        }

        return mapper.batchDelete(ids);
    }

    /**
     * auto gen get method
     **/
    public UserinfoEntity get( Long id ) { 
        if ( id == null ) { 
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_PRIMARY_KEY_REQUIRED.code);
        }

        UserinfoEntity entity = mapper.selectOne( id ); 
        if (null == entity) {
            throw new HttpCodeException(404, ErrorCodeEnum.DATA_NOT_EXIST.code);
        }
        return entity;
    }

    /**
    * auto gen list method
    **/
    public List<UserinfoEntity> list(AbstractQueryFilter queryFilter) {
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
            List<UserinfoEntity> data = ExcelUtil.read(file.getInputStream(), type, UserinfoEntity.class, entityFieldTitleNameMap);
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

            List<UserinfoEntity> data = list(queryFilter);
            String storeFilePath = ExcelUtil.write(data, UserinfoEntity.class, exportFieldMap);
            org.springframework.core.io.Resource resource = null;
            String contentType = null;
            resource = new FileUrlResource(storeFilePath);
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            if (contentType == null) {
                contentType = "application/octet-stream";
            }
            return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + UserinfoEntity.class.getSimpleName() + ".xlsx\"")
                .body(resource);
        } catch (Exception e) {
            throw new HttpCodeException(500, e);
        }
    }

    /**
    * auto gen createOrUpdate method
    **/
    @Transactional(rollbackFor = Exception.class)
    public UserinfoEntity createOrUpdate(UserinfoEntity entity, List<String> updateFields) {
        if (null == entity) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, UserinfoEntity.class);
        }

        if ( entity.getId() == null ) { 
            // insert
            entity = create(entity);
        }  else {
            UserinfoEntity existEntity = mapper.selectOne(entity.getId()); 
            if (null == existEntity) {
                // insert
                entity.setCreatedTime(ZonedDateTime.now(ZoneId.of("UTC")));
                entity.setAvatar(getOrDefault(entity.getAvatar(), "/assets/avatar-default.svg"));
                UserContext.UserInfo currentUserInfo = UserContext.getCurrentUserInfo();
                String currentUserName = null == currentUserInfo ? null : currentUserInfo.getUserName();
                entity.setCreatedBy(StringUtils.isBlank(entity.getCreatedBy()) ? currentUserName : entity.getCreatedBy());
                entity.setOrderInbound_count(getOrDefault(entity.getOrderInbound_count(), 0L));
                entity.setOrderOutbound_count(getOrDefault(entity.getOrderOutbound_count(), 0L));
                entity.setAfterSaleInbound_count(getOrDefault(entity.getAfterSaleInbound_count(), 0L));
                entity.setAfterSaleOutbound_count(getOrDefault(entity.getAfterSaleOutbound_count(), 0L));
                entity.setOtherInbound_count(getOrDefault(entity.getOtherInbound_count(), 0L));
                entity.setOtherOutbound_count(getOrDefault(entity.getOtherOutbound_count(), 0L));
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
    public long updateBy(UserinfoEntity entity, List<String> updateFields, AbstractQueryFilter filter) {

        if (null == entity) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, UserinfoEntity.class);
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