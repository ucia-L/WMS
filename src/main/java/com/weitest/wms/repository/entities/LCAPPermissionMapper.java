package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.LCAPPermission;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate LCAPPermission Mapper
*
* @author sys
*/
public interface LCAPPermissionMapper extends ReferenceHandleMapper {

    int insert(LCAPPermission bean);
    int batchInsert(List<LCAPPermission> beans);
    List<LCAPPermission> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(LCAPPermission bean, List<String> updateFields);
    int batchUpdate(List<LCAPPermission> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    LCAPPermission selectOne(Long id);

    int createOrUpdate(LCAPPermission bean);
    int updateBy(LCAPPermission bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}