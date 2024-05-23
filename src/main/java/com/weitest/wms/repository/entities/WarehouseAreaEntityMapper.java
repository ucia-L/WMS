package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.WarehouseAreaEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate WarehouseAreaEntity Mapper
*
* @author sys
*/
public interface WarehouseAreaEntityMapper extends ReferenceHandleMapper {

    int insert(WarehouseAreaEntity bean);
    int batchInsert(List<WarehouseAreaEntity> beans);
    List<WarehouseAreaEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(WarehouseAreaEntity bean, List<String> updateFields);
    int batchUpdate(List<WarehouseAreaEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    WarehouseAreaEntity selectOne(Long id);

    int createOrUpdate(WarehouseAreaEntity bean);
    int updateBy(WarehouseAreaEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}