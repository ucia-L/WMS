package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.OutBoundSecSortingEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate OutBoundSecSortingEntity Mapper
*
* @author sys
*/
public interface OutBoundSecSortingEntityMapper extends ReferenceHandleMapper {

    int insert(OutBoundSecSortingEntity bean);
    int batchInsert(List<OutBoundSecSortingEntity> beans);
    List<OutBoundSecSortingEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(OutBoundSecSortingEntity bean, List<String> updateFields);
    int batchUpdate(List<OutBoundSecSortingEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    OutBoundSecSortingEntity selectOne(Long id);

    int createOrUpdate(OutBoundSecSortingEntity bean);
    int updateBy(OutBoundSecSortingEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}