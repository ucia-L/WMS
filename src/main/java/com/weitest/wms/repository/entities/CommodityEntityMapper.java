package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.CommodityEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate CommodityEntity Mapper
*
* @author sys
*/
public interface CommodityEntityMapper extends ReferenceHandleMapper {

    int insert(CommodityEntity bean);
    int batchInsert(List<CommodityEntity> beans);
    List<CommodityEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(CommodityEntity bean, List<String> updateFields);
    int batchUpdate(List<CommodityEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    CommodityEntity selectOne(Long id);

    int createOrUpdate(CommodityEntity bean);
    int updateBy(CommodityEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}