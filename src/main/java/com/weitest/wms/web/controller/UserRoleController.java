package com.weitest.wms.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.weitest.wms.service.UserRoleService;
import javax.annotation.Resource;

import java.util.List;

/**
* auto generate UserRoleController api
*
* @author sys
*/
@RestController
@RequestMapping("api/system")
public class UserRoleController {

    @Resource
    private UserRoleService userRoleService;
    
    @GetMapping("/getUserListByRoleName")
    public List<String> getUserListByRoleName(String roleName) {
        return userRoleService.getUserListByRoleName(roleName);
    }
}
