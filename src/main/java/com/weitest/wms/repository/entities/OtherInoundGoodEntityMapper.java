package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.OtherInoundGoodEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate OtherInoundGoodEntity Mapper
*
* @author sys
*/
public interface OtherInoundGoodEntityMapper extends ReferenceHandleMapper {

    int insert(OtherInoundGoodEntity bean);
    int batchInsert(List<OtherInoundGoodEntity> beans);
    List<OtherInoundGoodEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(OtherInoundGoodEntity bean, List<String> updateFields);
    int batchUpdate(List<OtherInoundGoodEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    OtherInoundGoodEntity selectOne(Long id);

    int createOrUpdate(OtherInoundGoodEntity bean);
    int updateBy(OtherInoundGoodEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}