package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.IventoryGWASEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate IventoryGWASEntity Mapper
*
* @author sys
*/
public interface IventoryGWASEntityMapper extends ReferenceHandleMapper {

    int insert(IventoryGWASEntity bean);
    int batchInsert(List<IventoryGWASEntity> beans);
    List<IventoryGWASEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(IventoryGWASEntity bean, List<String> updateFields);
    int batchUpdate(List<IventoryGWASEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    IventoryGWASEntity selectOne(Long id);

    int createOrUpdate(IventoryGWASEntity bean);
    int updateBy(IventoryGWASEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}