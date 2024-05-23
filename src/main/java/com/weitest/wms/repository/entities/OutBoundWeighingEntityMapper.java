package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.OutBoundWeighingEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate OutBoundWeighingEntity Mapper
*
* @author sys
*/
public interface OutBoundWeighingEntityMapper extends ReferenceHandleMapper {

    int insert(OutBoundWeighingEntity bean);
    int batchInsert(List<OutBoundWeighingEntity> beans);
    List<OutBoundWeighingEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(OutBoundWeighingEntity bean, List<String> updateFields);
    int batchUpdate(List<OutBoundWeighingEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    OutBoundWeighingEntity selectOne(Long id);

    int createOrUpdate(OutBoundWeighingEntity bean);
    int updateBy(OutBoundWeighingEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}