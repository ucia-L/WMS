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
import com.weitest.wms.domain.entities.GoodsEntity;
import com.weitest.wms.domain.enumeration.*;
import com.weitest.wms.domain.structure.*;
import com.weitest.wms.datasource.dynamic.DataSource;
import com.weitest.wms.repository.entities.GoodsEntityMapper;
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
* auto generate GoodsEntity ServiceImpl
*
* @author sys
*/
@Service
public class GoodsEntityService extends AbstractService {
    @Resource
    private GoodsEntityMapper mapper;
    @Resource
    private RelationInnerService relationInnerService;

    private Map<String, String> entityFieldNameTitleMap = new LinkedHashMap<String, String>();
    private Map<String, String> entityFieldTitleNameMap = new LinkedHashMap<String, String>();
    private Map<String, String> entityFiledColumnNameMap = new LinkedHashMap<>();

    public GoodsEntityService() {
        entityFieldNameTitleMap.put("id", "主键");
        entityFieldTitleNameMap.put("主键", "id");
        entityFiledColumnNameMap.put("id", "id");
        entityFieldNameTitleMap.put("category", "种类");
        entityFieldTitleNameMap.put("种类", "category");
        entityFiledColumnNameMap.put("category", "category");
        entityFieldNameTitleMap.put("name", "货物名称");
        entityFieldTitleNameMap.put("货物名称", "name");
        entityFiledColumnNameMap.put("name", "name");
        entityFieldNameTitleMap.put("status", "其他状态");
        entityFieldTitleNameMap.put("其他状态", "status");
        entityFiledColumnNameMap.put("status", "status");
        entityFieldNameTitleMap.put("quantity", "货物数量");
        entityFieldTitleNameMap.put("货物数量", "quantity");
        entityFiledColumnNameMap.put("quantity", "quantity");
        entityFieldNameTitleMap.put("unit", "货物单位");
        entityFieldTitleNameMap.put("货物单位", "unit");
        entityFiledColumnNameMap.put("unit", "unit");
        entityFieldNameTitleMap.put("inbound_date", "入库时间");
        entityFieldTitleNameMap.put("入库时间", "inbound_date");
        entityFiledColumnNameMap.put("inbound_date", "inboundDate");
        entityFieldNameTitleMap.put("inbound_op", "入库操作者");
        entityFieldTitleNameMap.put("入库操作者", "inbound_op");
        entityFiledColumnNameMap.put("inbound_op", "inboundOp");
        entityFieldNameTitleMap.put("outbound_date", "出库时间");
        entityFieldTitleNameMap.put("出库时间", "outbound_date");
        entityFiledColumnNameMap.put("outbound_date", "outboundDate");
        entityFieldNameTitleMap.put("outbound_op", "出库操作者");
        entityFieldTitleNameMap.put("出库操作者", "outbound_op");
        entityFiledColumnNameMap.put("outbound_op", "outboundOp");
        entityFieldNameTitleMap.put("notes", "备注");
        entityFieldTitleNameMap.put("备注", "notes");
        entityFiledColumnNameMap.put("notes", "notes");
        entityFieldNameTitleMap.put("inbound_tmp_area", "入库暂存区");
        entityFieldTitleNameMap.put("入库暂存区", "inbound_tmp_area");
        entityFiledColumnNameMap.put("inbound_tmp_area", "inboundTmpArea");
        entityFieldNameTitleMap.put("warehouse_id", "仓库编号");
        entityFieldTitleNameMap.put("仓库编号", "warehouse_id");
        entityFiledColumnNameMap.put("warehouse_id", "warehouseId");
        entityFieldNameTitleMap.put("storage_area_id", "库区编号");
        entityFieldTitleNameMap.put("库区编号", "storage_area_id");
        entityFiledColumnNameMap.put("storage_area_id", "storageAreaId");
        entityFieldNameTitleMap.put("shelf_id", "货架编号");
        entityFieldTitleNameMap.put("货架编号", "shelf_id");
        entityFiledColumnNameMap.put("shelf_id", "shelfId");
        entityFieldNameTitleMap.put("order_id", "订单入库订单编号");
        entityFieldTitleNameMap.put("订单入库订单编号", "order_id");
        entityFiledColumnNameMap.put("order_id", "orderId");
        entityFieldNameTitleMap.put("refuse_reason", "拒绝原因");
        entityFieldTitleNameMap.put("拒绝原因", "refuse_reason");
        entityFiledColumnNameMap.put("refuse_reason", "refuseReason");
        entityFieldNameTitleMap.put("inbound_price", "入库价格");
        entityFieldTitleNameMap.put("入库价格", "inbound_price");
        entityFiledColumnNameMap.put("inbound_price", "inboundPrice");
        entityFieldNameTitleMap.put("outbound_price", "出库价格");
        entityFieldTitleNameMap.put("出库价格", "outbound_price");
        entityFiledColumnNameMap.put("outbound_price", "outboundPrice");
        entityFieldNameTitleMap.put("id_tag", "货物编号");
        entityFieldTitleNameMap.put("货物编号", "id_tag");
        entityFiledColumnNameMap.put("id_tag", "idTag");
        entityFieldNameTitleMap.put("on_shelf_time", "上架时间");
        entityFieldTitleNameMap.put("上架时间", "on_shelf_time");
        entityFiledColumnNameMap.put("on_shelf_time", "onShelfTime");
        entityFieldNameTitleMap.put("on_shelf_op", "上架操作者");
        entityFieldTitleNameMap.put("上架操作者", "on_shelf_op");
        entityFiledColumnNameMap.put("on_shelf_op", "onShelfOp");
        entityFieldNameTitleMap.put("commodity_id", "商品id");
        entityFieldTitleNameMap.put("商品id", "commodity_id");
        entityFiledColumnNameMap.put("commodity_id", "commodityId");
        entityFieldNameTitleMap.put("afterSale_id", "售后id编号");
        entityFieldTitleNameMap.put("售后id编号", "afterSale_id");
        entityFiledColumnNameMap.put("afterSale_id", "afterSaleId");
        entityFieldNameTitleMap.put("goodCategory", "产品类别");
        entityFieldTitleNameMap.put("产品类别", "goodCategory");
        entityFiledColumnNameMap.put("goodCategory", "goodCategory");
    }

    /**
    * auto gen create method
    **/
    @Transactional(rollbackFor = Exception.class)
    public GoodsEntity create(GoodsEntity entity) {
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
    public List<GoodsEntity> batchCreate(List<GoodsEntity> entities) {
        if (null == entities || entities.isEmpty()) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_NOTHING_TODO.code);
        }


        // fill default value
        for (GoodsEntity entity : entities) {
            paramValidate(entity);
        }
        mapper.batchInsert(entities);
        return entities;
    }

    /**
    * auto gen update method
    **/
    @Transactional
    public GoodsEntity update(GoodsEntity entity, List<String> updateFields) {
        if (null == entity) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, "GoodsEntity");
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
    public List<GoodsEntity> batchUpdate(List<GoodsEntity> entities, List<String> updateFields) {
        if (null == entities || entities.isEmpty()) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_NOTHING_TODO.code);
        }
        // updateFields为null时，默认全量更新
        List<GoodsEntity> updateEntities = new ArrayList<>(entities.size());
        for (GoodsEntity entity : entities) {
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
        GoodsEntity entity = mapper.selectOne( id ); 

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
            .left(new ColumnQueryFilter("Goods", "Goods", "id", "id"))
            .right(new ListLiteralQueryFilter(ids));
        CommonFunctionUtil.preHandleQueryExpression(inQueryFilter, entityFiledColumnNameMap);
        List<GoodsEntity>  entities = mapper.selectList(inQueryFilter);
        for (GoodsEntity entity : entities) {
            relationInnerService.onDelete(entity);
        }

        return mapper.batchDelete(ids);
    }

    /**
     * auto gen get method
     **/
    public GoodsEntity get( Long id ) { 
        if ( id == null ) { 
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_PRIMARY_KEY_REQUIRED.code);
        }

        GoodsEntity entity = mapper.selectOne( id ); 
        if (null == entity) {
            throw new HttpCodeException(404, ErrorCodeEnum.DATA_NOT_EXIST.code);
        }
        return entity;
    }

    /**
    * auto gen list method
    **/
    public List<GoodsEntity> list(AbstractQueryFilter queryFilter) {
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
            List<GoodsEntity> data = ExcelUtil.read(file.getInputStream(), type, GoodsEntity.class, entityFieldTitleNameMap);
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

            List<GoodsEntity> data = list(queryFilter);
            String storeFilePath = ExcelUtil.write(data, GoodsEntity.class, exportFieldMap);
            org.springframework.core.io.Resource resource = null;
            String contentType = null;
            resource = new FileUrlResource(storeFilePath);
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            if (contentType == null) {
                contentType = "application/octet-stream";
            }
            return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + GoodsEntity.class.getSimpleName() + ".xlsx\"")
                .body(resource);
        } catch (Exception e) {
            throw new HttpCodeException(500, e);
        }
    }

    /**
    * auto gen createOrUpdate method
    **/
    @Transactional(rollbackFor = Exception.class)
    public GoodsEntity createOrUpdate(GoodsEntity entity, List<String> updateFields) {
        if (null == entity) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, GoodsEntity.class);
        }

        if ( entity.getId() == null ) { 
            // insert
            entity = create(entity);
        }  else {
            GoodsEntity existEntity = mapper.selectOne(entity.getId()); 
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
    public long updateBy(GoodsEntity entity, List<String> updateFields, AbstractQueryFilter filter) {

        if (null == entity) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, GoodsEntity.class);
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