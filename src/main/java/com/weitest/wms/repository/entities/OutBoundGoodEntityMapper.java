package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.OutBoundGoodEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate OutBoundGoodEntity Mapper
*
* @author sys
*/
public interface OutBoundGoodEntityMapper extends ReferenceHandleMapper {

    int insert(OutBoundGoodEntity bean);
    int batchInsert(List<OutBoundGoodEntity> beans);
    List<OutBoundGoodEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(OutBoundGoodEntity bean, List<String> updateFields);
    int batchUpdate(List<OutBoundGoodEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    OutBoundGoodEntity selectOne(Long id);

    int createOrUpdate(OutBoundGoodEntity bean);
    int updateBy(OutBoundGoodEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}