package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.AllotOutboundEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate AllotOutboundEntity Mapper
*
* @author sys
*/
public interface AllotOutboundEntityMapper extends ReferenceHandleMapper {

    int insert(AllotOutboundEntity bean);
    int batchInsert(List<AllotOutboundEntity> beans);
    List<AllotOutboundEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(AllotOutboundEntity bean, List<String> updateFields);
    int batchUpdate(List<AllotOutboundEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    AllotOutboundEntity selectOne(Long id);

    int createOrUpdate(AllotOutboundEntity bean);
    int updateBy(AllotOutboundEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}