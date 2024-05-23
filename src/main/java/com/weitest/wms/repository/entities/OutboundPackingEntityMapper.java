package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.OutboundPackingEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate OutboundPackingEntity Mapper
*
* @author sys
*/
public interface OutboundPackingEntityMapper extends ReferenceHandleMapper {

    int insert(OutboundPackingEntity bean);
    int batchInsert(List<OutboundPackingEntity> beans);
    List<OutboundPackingEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(OutboundPackingEntity bean, List<String> updateFields);
    int batchUpdate(List<OutboundPackingEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    OutboundPackingEntity selectOne(Long id);

    int createOrUpdate(OutboundPackingEntity bean);
    int updateBy(OutboundPackingEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}