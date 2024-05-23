package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.OutBoundInspectionEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate OutBoundInspectionEntity Mapper
*
* @author sys
*/
public interface OutBoundInspectionEntityMapper extends ReferenceHandleMapper {

    int insert(OutBoundInspectionEntity bean);
    int batchInsert(List<OutBoundInspectionEntity> beans);
    List<OutBoundInspectionEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(OutBoundInspectionEntity bean, List<String> updateFields);
    int batchUpdate(List<OutBoundInspectionEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    OutBoundInspectionEntity selectOne(Long id);

    int createOrUpdate(OutBoundInspectionEntity bean);
    int updateBy(OutBoundInspectionEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}