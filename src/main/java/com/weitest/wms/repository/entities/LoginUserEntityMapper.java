package com.weitest.wms.repository.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import java.math.BigDecimal;
import com.weitest.wms.domain.entities.LoginUserEntity;
import com.weitest.wms.repository.ReferenceHandleMapper;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import org.apache.ibatis.annotations.Param;
/**
* auto generate LoginUserEntity Mapper
*
* @author sys
*/
public interface LoginUserEntityMapper extends ReferenceHandleMapper {

    int insert(LoginUserEntity bean);
    int batchInsert(List<LoginUserEntity> beans);
    List<LoginUserEntity> selectList(@Param("filter") AbstractQueryFilter filter);
    int count(@Param("filter") AbstractQueryFilter filter);

    int update(LoginUserEntity bean, List<String> updateFields);
    int batchUpdate(List<LoginUserEntity> beans, List<String> updateFields);
    int delete(Long id);
    int batchDelete(List<Long> ids);
    LoginUserEntity selectOne(Long id);

    int createOrUpdate(LoginUserEntity bean);
    int updateBy(LoginUserEntity bean, List<String> updateFields, AbstractQueryFilter filter);
    int deleteBy(@Param("filter") AbstractQueryFilter filter);

}