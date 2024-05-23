package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.AfterSalesOrderEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate AfterSalesOrderEntity Mapper
*
* @author sys
*/
public interface AfterSalesOrderEntityMapper extends ReferenceHandleMapper {

    int insert(AfterSalesOrderEntity bean);
    int batchInsert(List<AfterSalesOrderEntity> beans);
    List<AfterSalesOrderEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(AfterSalesOrderEntity bean, List<String> updateFields);
    int batchUpdate(List<AfterSalesOrderEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    AfterSalesOrderEntity selectOne(Long id);

    int createOrUpdate(AfterSalesOrderEntity bean);
    int updateBy(AfterSalesOrderEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}