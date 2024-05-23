package com.weitest.wms.web.controller;

import com.weitest.wms.service.UserInfoService;
import com.weitest.wms.web.dto.UserListReqDTO;
import com.weitest.wms.web.dto.UserListResDTO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* auto generate UserInfoController
* 给ide提供一个全局系统逻辑来获取用户列表，可以兼容用户下沉和非下沉场景
*
* @author sys
*/
@RestController
@RequestMapping("api/system/user")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    @PostMapping("/userListFromNuimOrApp")
    public List<UserListResDTO> getUserList(@RequestBody UserListReqDTO req) {
       return userInfoService.getUserListFromAppOrNuims(req);
    }
}
