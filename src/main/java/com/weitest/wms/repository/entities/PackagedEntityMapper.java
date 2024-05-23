package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.PackagedEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate PackagedEntity Mapper
*
* @author sys
*/
public interface PackagedEntityMapper extends ReferenceHandleMapper {

    int insert(PackagedEntity bean);
    int batchInsert(List<PackagedEntity> beans);
    List<PackagedEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(PackagedEntity bean, List<String> updateFields);
    int batchUpdate(List<PackagedEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    PackagedEntity selectOne(Long id);

    int createOrUpdate(PackagedEntity bean);
    int updateBy(PackagedEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}