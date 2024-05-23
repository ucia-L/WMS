package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.ApplicationEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate ApplicationEntity Mapper
*
* @author sys
*/
public interface ApplicationEntityMapper extends ReferenceHandleMapper {

    int insert(ApplicationEntity bean);
    int batchInsert(List<ApplicationEntity> beans);
    List<ApplicationEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(ApplicationEntity bean, List<String> updateFields);
    int batchUpdate(List<ApplicationEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    ApplicationEntity selectOne(Long id);

    int createOrUpdate(ApplicationEntity bean);
    int updateBy(ApplicationEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}