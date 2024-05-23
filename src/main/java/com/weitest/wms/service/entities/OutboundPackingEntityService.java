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
import com.weitest.wms.domain.entities.OutboundPackingEntity;
import com.weitest.wms.domain.enumeration.*;
import com.weitest.wms.domain.structure.*;
import com.weitest.wms.datasource.dynamic.DataSource;
import com.weitest.wms.repository.entities.OutboundPackingEntityMapper;
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
* auto generate OutboundPackingEntity ServiceImpl
*
* @author sys
*/
@Service
public class OutboundPackingEntityService extends AbstractService {
    @Resource
    private OutboundPackingEntityMapper mapper;
    @Resource
    private RelationInnerService relationInnerService;

    private Map<String, String> entityFieldNameTitleMap = new LinkedHashMap<String, String>();
    private Map<String, String> entityFieldTitleNameMap = new LinkedHashMap<String, String>();
    private Map<String, String> entityFiledColumnNameMap = new LinkedHashMap<>();

    public OutboundPackingEntityService() {
        entityFieldNameTitleMap.put("id", "配货编号");
        entityFieldTitleNameMap.put("配货编号", "id");
        entityFiledColumnNameMap.put("id", "id");
        entityFieldNameTitleMap.put("outbound_good_id", "商品编号");
        entityFieldTitleNameMap.put("商品编号", "outbound_good_id");
        entityFiledColumnNameMap.put("outbound_good_id", "outboundGoodId");
        entityFieldNameTitleMap.put("quantity", "数量");
        entityFieldTitleNameMap.put("数量", "quantity");
        entityFiledColumnNameMap.put("quantity", "quantity");
        entityFieldNameTitleMap.put("warehouseArea_id", "仓库库区编号");
        entityFieldTitleNameMap.put("仓库库区编号", "warehouseArea_id");
        entityFiledColumnNameMap.put("warehouseArea_id", "warehouseAreaId");
        entityFieldNameTitleMap.put("shelf_id", "货架编号");
        entityFieldTitleNameMap.put("货架编号", "shelf_id");
        entityFiledColumnNameMap.put("shelf_id", "shelfId");
        entityFieldNameTitleMap.put("outbound_tmparea_id", "出库暂存区");
        entityFieldTitleNameMap.put("出库暂存区", "outbound_tmparea_id");
        entityFiledColumnNameMap.put("outbound_tmparea_id", "outboundTmpareaId");
        entityFieldNameTitleMap.put("status", "状态");
        entityFieldTitleNameMap.put("状态", "status");
        entityFiledColumnNameMap.put("status", "status");
        entityFieldNameTitleMap.put("outbound_commodity_name", "出库商品名称");
        entityFieldTitleNameMap.put("出库商品名称", "outbound_commodity_name");
        entityFiledColumnNameMap.put("outbound_commodity_name", "outboundCommodityName");
        entityFieldNameTitleMap.put("outBoundOrderID", "出库订单编号");
        entityFieldTitleNameMap.put("出库订单编号", "outBoundOrderID");
        entityFiledColumnNameMap.put("outBoundOrderID", "outBoundOrderID");
    }

    /**
    * auto gen create method
    **/
    @Transactional(rollbackFor = Exception.class)
    public OutboundPackingEntity create(OutboundPackingEntity entity) {
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
    public List<OutboundPackingEntity> batchCreate(List<OutboundPackingEntity> entities) {
        if (null == entities || entities.isEmpty()) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_NOTHING_TODO.code);
        }


        // fill default value
        for (OutboundPackingEntity entity : entities) {
            paramValidate(entity);
        }
        mapper.batchInsert(entities);
        return entities;
    }

    /**
    * auto gen update method
    **/
    @Transactional
    public OutboundPackingEntity update(OutboundPackingEntity entity, List<String> updateFields) {
        if (null == entity) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, "OutboundPackingEntity");
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
    public List<OutboundPackingEntity> batchUpdate(List<OutboundPackingEntity> entities, List<String> updateFields) {
        if (null == entities || entities.isEmpty()) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_NOTHING_TODO.code);
        }
        // updateFields为null时，默认全量更新
        List<OutboundPackingEntity> updateEntities = new ArrayList<>(entities.size());
        for (OutboundPackingEntity entity : entities) {
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
        OutboundPackingEntity entity = mapper.selectOne( id ); 

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
            .left(new ColumnQueryFilter("OutboundPacking", "OutboundPacking", "id", "id"))
            .right(new ListLiteralQueryFilter(ids));
        CommonFunctionUtil.preHandleQueryExpression(inQueryFilter, entityFiledColumnNameMap);
        List<OutboundPackingEntity>  entities = mapper.selectList(inQueryFilter);
        for (OutboundPackingEntity entity : entities) {
            relationInnerService.onDelete(entity);
        }

        return mapper.batchDelete(ids);
    }

    /**
     * auto gen get method
     **/
    public OutboundPackingEntity get( Long id ) { 
        if ( id == null ) { 
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_PRIMARY_KEY_REQUIRED.code);
        }

        OutboundPackingEntity entity = mapper.selectOne( id ); 
        if (null == entity) {
            throw new HttpCodeException(404, ErrorCodeEnum.DATA_NOT_EXIST.code);
        }
        return entity;
    }

    /**
    * auto gen list method
    **/
    public List<OutboundPackingEntity> list(AbstractQueryFilter queryFilter) {
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
            List<OutboundPackingEntity> data = ExcelUtil.read(file.getInputStream(), type, OutboundPackingEntity.class, entityFieldTitleNameMap);
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

            List<OutboundPackingEntity> data = list(queryFilter);
            String storeFilePath = ExcelUtil.write(data, OutboundPackingEntity.class, exportFieldMap);
            org.springframework.core.io.Resource resource = null;
            String contentType = null;
            resource = new FileUrlResource(storeFilePath);
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            if (contentType == null) {
                contentType = "application/octet-stream";
            }
            return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + OutboundPackingEntity.class.getSimpleName() + ".xlsx\"")
                .body(resource);
        } catch (Exception e) {
            throw new HttpCodeException(500, e);
        }
    }

    /**
    * auto gen createOrUpdate method
    **/
    @Transactional(rollbackFor = Exception.class)
    public OutboundPackingEntity createOrUpdate(OutboundPackingEntity entity, List<String> updateFields) {
        if (null == entity) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, OutboundPackingEntity.class);
        }

        if ( entity.getId() == null ) { 
            // insert
            entity = create(entity);
        }  else {
            OutboundPackingEntity existEntity = mapper.selectOne(entity.getId()); 
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
    public long updateBy(OutboundPackingEntity entity, List<String> updateFields, AbstractQueryFilter filter) {

        if (null == entity) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, OutboundPackingEntity.class);
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