package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.OrderOutboundGoodsEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate OrderOutboundGoodsEntity Mapper
*
* @author sys
*/
public interface OrderOutboundGoodsEntityMapper extends ReferenceHandleMapper {

    int insert(OrderOutboundGoodsEntity bean);
    int batchInsert(List<OrderOutboundGoodsEntity> beans);
    List<OrderOutboundGoodsEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(OrderOutboundGoodsEntity bean, List<String> updateFields);
    int batchUpdate(List<OrderOutboundGoodsEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    OrderOutboundGoodsEntity selectOne(Long id);

    int createOrUpdate(OrderOutboundGoodsEntity bean);
    int updateBy(OrderOutboundGoodsEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}