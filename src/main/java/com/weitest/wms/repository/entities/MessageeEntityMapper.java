package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.MessageeEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate MessageeEntity Mapper
*
* @author sys
*/
public interface MessageeEntityMapper extends ReferenceHandleMapper {

    int insert(MessageeEntity bean);
    int batchInsert(List<MessageeEntity> beans);
    List<MessageeEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(MessageeEntity bean, List<String> updateFields);
    int batchUpdate(List<MessageeEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    MessageeEntity selectOne(Long id);

    int createOrUpdate(MessageeEntity bean);
    int updateBy(MessageeEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}