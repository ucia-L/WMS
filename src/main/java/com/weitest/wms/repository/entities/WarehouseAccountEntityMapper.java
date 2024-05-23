package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.WarehouseAccountEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate WarehouseAccountEntity Mapper
*
* @author sys
*/
public interface WarehouseAccountEntityMapper extends ReferenceHandleMapper {

    int insert(WarehouseAccountEntity bean);
    int batchInsert(List<WarehouseAccountEntity> beans);
    List<WarehouseAccountEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(WarehouseAccountEntity bean, List<String> updateFields);
    int batchUpdate(List<WarehouseAccountEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    WarehouseAccountEntity selectOne(Long id);

    int createOrUpdate(WarehouseAccountEntity bean);
    int updateBy(WarehouseAccountEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}