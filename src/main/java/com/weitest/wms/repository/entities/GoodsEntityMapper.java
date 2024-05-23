package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.GoodsEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate GoodsEntity Mapper
*
* @author sys
*/
public interface GoodsEntityMapper extends ReferenceHandleMapper {

    int insert(GoodsEntity bean);
    int batchInsert(List<GoodsEntity> beans);
    List<GoodsEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(GoodsEntity bean, List<String> updateFields);
    int batchUpdate(List<GoodsEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    GoodsEntity selectOne(Long id);

    int createOrUpdate(GoodsEntity bean);
    int updateBy(GoodsEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}