package com.weitest.wms.service.impl;

import com.weitest.wms.domain.entities.LCAPRole;
import com.weitest.wms.domain.entities.LCAPUserRoleMapping;
import com.weitest.wms.service.dto.filters.AbstractQueryFilter;
import com.weitest.wms.service.dto.filters.atomic.StringLiteralQueryFilter;
import com.weitest.wms.service.dto.filters.atomic.ColumnQueryFilter;
import com.weitest.wms.service.dto.filters.logic.binary.compare.EqualQueryFilter;
import com.weitest.wms.service.entities.LCAPRoleService;
import com.weitest.wms.service.entities.LCAPUserRoleMappingService;
import com.weitest.wms.service.UserRoleService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
* auto generate UserRoleServiceImpl logic
* 权限下沉情况下 处理角色下用户逻辑
*
* @author sys
*/
@Service
public class UserRoleServiceImpl implements UserRoleService{

    private Logger log = LoggerFactory.getLogger(UserRoleServiceImpl.class);

    @Resource
    private LCAPUserRoleMappingService lcapUserRoleMappingService;

    @Resource
    private LCAPRoleService lcapRoleService;

    @Override
    public List<String> getUserListByRoleName(String roleName) {
        if (Objects.isNull(roleName)) {
            log.warn("查询角色下用户，角色名为空");
            return new ArrayList<>();
        }
        List<LCAPUserRoleMapping> userRoleMappings = lcapUserRoleMappingService.list(null);
        if (CollectionUtils.isEmpty(userRoleMappings)) {
            log.warn("查询用户角色映射关系为空");
            return new ArrayList<>();
        }

        AbstractQueryFilter queryFilter = new EqualQueryFilter()
            .left(new ColumnQueryFilter(null, null, "name", "name"))
            .right(new StringLiteralQueryFilter(roleName));
        // 因为同一个应用下角色不能重名，所以可以根据角色名取出唯一值
        Optional<LCAPRole> first = lcapRoleService.list(queryFilter).stream().findFirst();
        if (!first.isPresent()) {
            log.warn("查询 {} 角色结果为空", roleName);
            return new ArrayList<>();
        }
        Long id = first.get().getId();
        return userRoleMappings.stream().filter(x -> Objects.equals(x.getRoleId(), id)).map(LCAPUserRoleMapping::getUserName).distinct().collect(Collectors.toList());
    }
}
