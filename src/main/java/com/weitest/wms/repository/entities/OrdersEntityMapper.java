package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.OrdersEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate OrdersEntity Mapper
*
* @author sys
*/
public interface OrdersEntityMapper extends ReferenceHandleMapper {

    int insert(OrdersEntity bean);
    int batchInsert(List<OrdersEntity> beans);
    List<OrdersEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(OrdersEntity bean, List<String> updateFields);
    int batchUpdate(List<OrdersEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    OrdersEntity selectOne(Long id);

    int createOrUpdate(OrdersEntity bean);
    int updateBy(OrdersEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}