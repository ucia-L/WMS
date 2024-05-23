package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.OutBoundSortingEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate OutBoundSortingEntity Mapper
*
* @author sys
*/
public interface OutBoundSortingEntityMapper extends ReferenceHandleMapper {

    int insert(OutBoundSortingEntity bean);
    int batchInsert(List<OutBoundSortingEntity> beans);
    List<OutBoundSortingEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(OutBoundSortingEntity bean, List<String> updateFields);
    int batchUpdate(List<OutBoundSortingEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    OutBoundSortingEntity selectOne(Long id);

    int createOrUpdate(OutBoundSortingEntity bean);
    int updateBy(OutBoundSortingEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}