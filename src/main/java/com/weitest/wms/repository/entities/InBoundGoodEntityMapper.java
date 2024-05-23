package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.InBoundGoodEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate InBoundGoodEntity Mapper
*
* @author sys
*/
public interface InBoundGoodEntityMapper extends ReferenceHandleMapper {

    int insert(InBoundGoodEntity bean);
    int batchInsert(List<InBoundGoodEntity> beans);
    List<InBoundGoodEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(InBoundGoodEntity bean, List<String> updateFields);
    int batchUpdate(List<InBoundGoodEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    InBoundGoodEntity selectOne(Long id);

    int createOrUpdate(InBoundGoodEntity bean);
    int updateBy(InBoundGoodEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}