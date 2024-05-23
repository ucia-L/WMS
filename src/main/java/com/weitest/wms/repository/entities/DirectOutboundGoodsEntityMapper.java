package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.DirectOutboundGoodsEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate DirectOutboundGoodsEntity Mapper
*
* @author sys
*/
public interface DirectOutboundGoodsEntityMapper extends ReferenceHandleMapper {

    int insert(DirectOutboundGoodsEntity bean);
    int batchInsert(List<DirectOutboundGoodsEntity> beans);
    List<DirectOutboundGoodsEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(DirectOutboundGoodsEntity bean, List<String> updateFields);
    int batchUpdate(List<DirectOutboundGoodsEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    DirectOutboundGoodsEntity selectOne(Long id);

    int createOrUpdate(DirectOutboundGoodsEntity bean);
    int updateBy(DirectOutboundGoodsEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}