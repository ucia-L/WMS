package com.weitest.wms.web.controller.entities;

import java.io.Serializable;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.math.BigDecimal;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.*;

import com.weitest.wms.exception.HttpCodeException;
import com.weitest.wms.domain.entities.OutBoundSortingEntity;
import com.weitest.wms.domain.enumeration.*;
import com.weitest.wms.service.entities.OutBoundSortingEntityService;
import com.weitest.wms.web.ApiReturn;
import com.weitest.wms.service.dto.filters.EntityFilter;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import com.weitest.wms.service.dto.filters.FilterWrapper;
import com.weitest.wms.domain.PageOf;
import com.weitest.wms.util.JacksonUtils;

/**
* auto generate OutBoundSortingEntity controller
*
* @author sys
*/
@RestController
public class OutBoundSortingEntityController {
    @Resource
    private OutBoundSortingEntityService service;

    /**
    * auto gen create method
    **/
    @PostMapping("/api/out-bound-sorting")
    public ApiReturn<OutBoundSortingEntity> create(@RequestBody OutBoundSortingEntity body) {
        return ApiReturn.of(service.create(body));
    }

    /**
    * auto gen batch create method
    **/
    @PostMapping("/api/out-bound-sorting/batch")
    public ApiReturn<List<OutBoundSortingEntity>> batchCreate(@RequestBody List<OutBoundSortingEntity> body) {
        return ApiReturn.of(service.batchCreate(body));
    }

    /**
    * auto gen update method
    **/
    @PutMapping("/api/out-bound-sorting")
    public ApiReturn<OutBoundSortingEntity> update(@RequestBody EntityFilter filter) {
        if (filter == null || filter.getEntity() == null) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, "");
        }
        Map map = filter.getEntity();
        OutBoundSortingEntity entity = JacksonUtils.fromJson(map, OutBoundSortingEntity.class);
        List<String> updateFields = filter.getProperties();
        return ApiReturn.of(service.update(entity, updateFields));
    }


    /**
    * auto gen batch update method
    **/
    @PutMapping("/api/out-bound-sorting/batch")
    public ApiReturn<List<OutBoundSortingEntity>> batchUpdate(@RequestBody EntityFilter filter) {
        if (filter == null || filter.getEntities() == null) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, "");
        }
        List<String> updateFields = filter.getProperties();
        List<OutBoundSortingEntity> entities = new ArrayList<>();
        for (Map map : filter.getEntities()) {
            entities.add(JacksonUtils.fromJson(map, OutBoundSortingEntity.class));
        }
        return ApiReturn.of(service.batchUpdate(entities, updateFields));
    }

    /**
    * auto gen delete method
    **/
    @DeleteMapping("/api/out-bound-sorting")
    public ApiReturn<Long> delete( @RequestParam(required = true) Long id ) { 
        return ApiReturn.of(service.delete( id )); 
    }

    /**
    * auto gen batch delete method
    **/
    @DeleteMapping("/api/out-bound-sorting/batch")
    public ApiReturn<Long> batchDelete(@RequestBody List<Long> ids) {
        return ApiReturn.of(service.batchDelete(ids));
    }

    /**
    * auto gen get method
    **/
    @GetMapping("/api/out-bound-sorting")
    public ApiReturn<OutBoundSortingEntity> get( @RequestParam(required = true) Long id ) { 
        return ApiReturn.of(service.get( id )); 
    }

    /**
    * auto gen import method
    **/
    @PostMapping("/api/out-bound-sorting/import")
    public ApiReturn<String> importEntities(@RequestParam("file") MultipartFile file) {
        return ApiReturn.of(service.importFile(file));
    }

    /**
    * auto gen createOrUpdate method
    **/
    @PostMapping("/api/out-bound-sorting/createOrUpdate")
    public ApiReturn<OutBoundSortingEntity> createOrUpdate(@RequestBody EntityFilter filter) {
        if (filter == null || filter.getEntity() == null) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, "");
        }
        Map map = filter.getEntity();
        OutBoundSortingEntity entity = JacksonUtils.fromJson(map, OutBoundSortingEntity.class);
        List<String> updateFields = filter.getProperties();
        return ApiReturn.of(service.createOrUpdate(entity, updateFields));
    }

    /**
    * auto gen updateBy method
    **/
    @PutMapping("/api/out-bound-sorting/by")
    public ApiReturn<Long> updateBy(@RequestBody EntityFilter filter) {
        if (filter == null || filter.getEntity() == null) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, "");
        }
        Map map = filter.getEntity();
        OutBoundSortingEntity entity = JacksonUtils.fromJson(map, OutBoundSortingEntity.class);
        List<String> updateFields = filter.getProperties();
        return ApiReturn.of(service.updateBy(entity, updateFields, filter.getFilter().getReturnExpression()));
    }

    /**
    * auto gen deleteBy method
    **/
    @DeleteMapping("/api/out-bound-sorting/by")
    public ApiReturn<Long> deleteBy(@RequestBody FilterWrapper wrapper) {
        if (wrapper == null) {
            throw new HttpCodeException(400, ErrorCodeEnum.PARAM_REQUIRED.code, OutBoundSortingEntity.class);
        }
        return ApiReturn.of(service.deleteBy(wrapper.getReturnExpression()));
    }
}