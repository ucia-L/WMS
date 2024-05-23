package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.OutboundOrderEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate OutboundOrderEntity Mapper
*
* @author sys
*/
public interface OutboundOrderEntityMapper extends ReferenceHandleMapper {

    int insert(OutboundOrderEntity bean);
    int batchInsert(List<OutboundOrderEntity> beans);
    List<OutboundOrderEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(OutboundOrderEntity bean, List<String> updateFields);
    int batchUpdate(List<OutboundOrderEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    OutboundOrderEntity selectOne(Long id);

    int createOrUpdate(OutboundOrderEntity bean);
    int updateBy(OutboundOrderEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}