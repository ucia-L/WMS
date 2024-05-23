package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.AfterSaleGoodEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate AfterSaleGoodEntity Mapper
*
* @author sys
*/
public interface AfterSaleGoodEntityMapper extends ReferenceHandleMapper {

    int insert(AfterSaleGoodEntity bean);
    int batchInsert(List<AfterSaleGoodEntity> beans);
    List<AfterSaleGoodEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(AfterSaleGoodEntity bean, List<String> updateFields);
    int batchUpdate(List<AfterSaleGoodEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    AfterSaleGoodEntity selectOne(Long id);

    int createOrUpdate(AfterSaleGoodEntity bean);
    int updateBy(AfterSaleGoodEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}