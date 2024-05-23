package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.InventoryTaskEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate InventoryTaskEntity Mapper
*
* @author sys
*/
public interface InventoryTaskEntityMapper extends ReferenceHandleMapper {

    int insert(InventoryTaskEntity bean);
    int batchInsert(List<InventoryTaskEntity> beans);
    List<InventoryTaskEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(InventoryTaskEntity bean, List<String> updateFields);
    int batchUpdate(List<InventoryTaskEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    InventoryTaskEntity selectOne(Long id);

    int createOrUpdate(InventoryTaskEntity bean);
    int updateBy(InventoryTaskEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}