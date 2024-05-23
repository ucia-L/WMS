package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.ShippingEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate ShippingEntity Mapper
*
* @author sys
*/
public interface ShippingEntityMapper extends ReferenceHandleMapper {

    int insert(ShippingEntity bean);
    int batchInsert(List<ShippingEntity> beans);
    List<ShippingEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(ShippingEntity bean, List<String> updateFields);
    int batchUpdate(List<ShippingEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    ShippingEntity selectOne(Long id);

    int createOrUpdate(ShippingEntity bean);
    int updateBy(ShippingEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}