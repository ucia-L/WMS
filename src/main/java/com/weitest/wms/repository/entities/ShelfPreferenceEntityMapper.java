package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.ShelfPreferenceEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate ShelfPreferenceEntity Mapper
*
* @author sys
*/
public interface ShelfPreferenceEntityMapper extends ReferenceHandleMapper {

    int insert(ShelfPreferenceEntity bean);
    int batchInsert(List<ShelfPreferenceEntity> beans);
    List<ShelfPreferenceEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(ShelfPreferenceEntity bean, List<String> updateFields);
    int batchUpdate(List<ShelfPreferenceEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    ShelfPreferenceEntity selectOne(Long id);

    int createOrUpdate(ShelfPreferenceEntity bean);
    int updateBy(ShelfPreferenceEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}