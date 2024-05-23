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
import com.weitest.wms.domain.entities.IventoryGWASEntity;
import com.weitest.wms.domain.enumeration.*;
import com.weitest.wms.domain.structure.*;
import com.weitest.wms.datasource.dynamic.DataSource;
import com.weitest.wms.repository.entities.IventoryGWASEntityMapper;
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
* auto generate IventoryGWASEntity ServiceImpl
*
* @author sys
*/
@Service
public class IventoryGWASEntityService extends AbstractService {
    @Resource
    private IventoryGWASEntityMapper mapper;
    @Resource
    private RelationInnerService relationInnerService;

    private Map<String, String> entityFieldNameTitleMap = new LinkedHashMap<String, String>();
    private Map<String, String> entityFieldTitleNameMap = new LinkedHashMap<String, String>();
    private Map<String, String> entityFiledColumnNameMap = new LinkedHashMap<>();

    public IventoryGWASEntityService() {
        entityFieldNameTitleMap.put("id", "盘点id");
        entityFieldTitleNameMap.put("盘点id", "id");
        entityFiledColumnNameMap.put("id", "id");
        entityFieldNameTitleMap.put("gid", "货物id");
        entityFieldTitleNameMap.put("货物id", "gid");
        entityFiledColumnNameMap.put("gid", "gid");
        entityFieldNameTitleMap.put("g_name", "货物名");
        entityFieldTitleNameMap.put("货物名", "g_name");
        entityFiledColumnNameMap.put("g_name", "gName");
        entityFieldNameTitleMap.put("g_quantity", "货物数量");
        entityFieldTitleNameMap.put("货物数量", "g_quantity");
        entityFiledColumnNameMap.put("g_quantity", "gQuantity");
        entityFieldNameTitleMap.put("g_unit", "货物单位");
        entityFieldTitleNameMap.put("货物单位", "g_unit");
        entityFiledColumnNameMap.put("g_unit", "gUnit");
        entityFieldNameTitleMap.put("wid", "仓库id");
        entityFieldTitleNameMap.put("仓库id", "wid");
        entityFiledColumnNameMap.put("wid", "wid");
        entityFieldNameTitleMap.put("w_name", "仓库名");
        entityFieldTitleNameMap.put("仓库名", "w_name");
        entityFiledColumnNameMap.put("w_name", "wName");
        entityFieldNameTitleMap.put("waid", "库区id");
        entityFieldTitleNameMap.put("库区id", "waid");
        entityFiledColumnNameMap.put("waid", "waid");
        entityFieldNameTitleMap.put("wa_name", "货区名");
        entityFieldTitleNameMap.put("货区名", "wa_name");
        entityFiledColumnNameMap.put("wa_name", "waName");
        entityFieldNameTitleMap.put("sid", "货架id");
        entityFieldTitleNameMap.put("货架id", "sid");
        entityFiledColumnNameMap.put("sid", "sid");
        entityFieldNameTitleMap.put("s_name", "货架名");
        entityFieldTitleNameMap.put("货架名", "s_name");
        entityFiledColumnNameMap.put("s_name", "sName");
        entityFieldNameTitleMap.put("dateTime", "日期");
        entityFieldTitleNameMap.put("日期", "dateTime");
        entityFiledColumnNameMap.put("dateTime", "dateTime");
    }

    /**
    * auto gen create method
    **/
    @Transactional(rollbackFor = Exception.class)
    public IventoryGWASEntity create(IventoryGWASEntity entity) {
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
    public List<IventoryGWASEntity> batchCreate(List<IventoryGWASEntity> entities) {
        if (null == entities || entities.isEmpty()) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_NOTHING_TODO.code);
        }


        // fill default value
        for (IventoryGWASEntity entity : entities) {
            paramValidate(entity);
        }
        mapper.batchInsert(entities);
        return entities;
    }

    /**
    * auto gen update method
    **/
    @Transactional
    public IventoryGWASEntity update(IventoryGWASEntity entity, List<String> updateFields) {
        if (null == entity) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, "IventoryGWASEntity");
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
    public List<IventoryGWASEntity> batchUpdate(List<IventoryGWASEntity> entities, List<String> updateFields) {
        if (null == entities || entities.isEmpty()) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_NOTHING_TODO.code);
        }
        // updateFields为null时，默认全量更新
        List<IventoryGWASEntity> updateEntities = new ArrayList<>(entities.size());
        for (IventoryGWASEntity entity : entities) {
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
        IventoryGWASEntity entity = mapper.selectOne( id ); 

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
            .left(new ColumnQueryFilter("IventoryGWAS", "IventoryGWAS", "id", "id"))
            .right(new ListLiteralQueryFilter(ids));
        CommonFunctionUtil.preHandleQueryExpression(inQueryFilter, entityFiledColumnNameMap);
        List<IventoryGWASEntity>  entities = mapper.selectList(inQueryFilter);
        for (IventoryGWASEntity entity : entities) {
            relationInnerService.onDelete(entity);
        }

        return mapper.batchDelete(ids);
    }

    /**
     * auto gen get method
     **/
    public IventoryGWASEntity get( Long id ) { 
        if ( id == null ) { 
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_PRIMARY_KEY_REQUIRED.code);
        }

        IventoryGWASEntity entity = mapper.selectOne( id ); 
        if (null == entity) {
            throw new HttpCodeException(404, ErrorCodeEnum.DATA_NOT_EXIST.code);
        }
        return entity;
    }

    /**
    * auto gen list method
    **/
    public List<IventoryGWASEntity> list(AbstractQueryFilter queryFilter) {
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
            List<IventoryGWASEntity> data = ExcelUtil.read(file.getInputStream(), type, IventoryGWASEntity.class, entityFieldTitleNameMap);
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

            List<IventoryGWASEntity> data = list(queryFilter);
            String storeFilePath = ExcelUtil.write(data, IventoryGWASEntity.class, exportFieldMap);
            org.springframework.core.io.Resource resource = null;
            String contentType = null;
            resource = new FileUrlResource(storeFilePath);
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            if (contentType == null) {
                contentType = "application/octet-stream";
            }
            return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + IventoryGWASEntity.class.getSimpleName() + ".xlsx\"")
                .body(resource);
        } catch (Exception e) {
            throw new HttpCodeException(500, e);
        }
    }

    /**
    * auto gen createOrUpdate method
    **/
    @Transactional(rollbackFor = Exception.class)
    public IventoryGWASEntity createOrUpdate(IventoryGWASEntity entity, List<String> updateFields) {
        if (null == entity) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, IventoryGWASEntity.class);
        }

        if ( entity.getId() == null ) { 
            // insert
            entity = create(entity);
        }  else {
            IventoryGWASEntity existEntity = mapper.selectOne(entity.getId()); 
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
    public long updateBy(IventoryGWASEntity entity, List<String> updateFields, AbstractQueryFilter filter) {

        if (null == entity) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, IventoryGWASEntity.class);
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