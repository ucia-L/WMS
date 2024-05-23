package com.weitest.wms.service;

import java.util.List;

/**
* auto generate UserRoleService logic
*
* @author sys
*/
public interface UserRoleService {
    /**
     * 根据角色名称获取其下的用户名称列表
     *
     * @param roleName 角色名称
     * @return 用户名称集合
     */
    List<String> getUserListByRoleName(String roleName);
}
