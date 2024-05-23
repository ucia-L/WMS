package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.WarehouseEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate WarehouseEntity Mapper
*
* @author sys
*/
public interface WarehouseEntityMapper extends ReferenceHandleMapper {

    int insert(WarehouseEntity bean);
    int batchInsert(List<WarehouseEntity> beans);
    List<WarehouseEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(WarehouseEntity bean, List<String> updateFields);
    int batchUpdate(List<WarehouseEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    WarehouseEntity selectOne(Long id);

    int createOrUpdate(WarehouseEntity bean);
    int updateBy(WarehouseEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}