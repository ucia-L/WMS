package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.UserinfoEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate UserinfoEntity Mapper
*
* @author sys
*/
public interface UserinfoEntityMapper extends ReferenceHandleMapper {

    int insert(UserinfoEntity bean);
    int batchInsert(List<UserinfoEntity> beans);
    List<UserinfoEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(UserinfoEntity bean, List<String> updateFields);
    int batchUpdate(List<UserinfoEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    UserinfoEntity selectOne(Long id);

    int createOrUpdate(UserinfoEntity bean);
    int updateBy(UserinfoEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}