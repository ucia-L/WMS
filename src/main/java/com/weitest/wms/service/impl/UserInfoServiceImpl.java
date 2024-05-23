package com.weitest.wms.service.impl;

import com.weitest.wms.domain.entities.LCAPUser;
import com.weitest.wms.repository.LCAPUserInfoMapper;
import com.weitest.wms.service.UserInfoService;
import com.weitest.wms.web.dto.UserListReqDTO;
import com.weitest.wms.web.dto.UserListResDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
* auto generate UserInfoServiceImpl
*
* 应用内用户相关的系统逻辑
*
* @author sys
*/
@Service
public class UserInfoServiceImpl implements UserInfoService {
    private Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Resource
    private LCAPUserInfoMapper lcapUserInfoMapper;
    /**
     * 用户下沉的用户获取逻辑
     *
     * @return
     */
    @Override
    public List<UserListResDTO> getUserListFromAppOrNuims(UserListReqDTO reqDTO) {
        String userNameFilter = reqDTO.getUserNameFilter();
        String nameFilter = Objects.isNull(userNameFilter) ? StringUtils.EMPTY : userNameFilter;
        List<LCAPUser> lcapUsers = lcapUserInfoMapper.pageQuery(reqDTO.getLimit(), reqDTO.getOffset(), nameFilter);
        Long total = lcapUserInfoMapper.pageQueryCount(nameFilter);

        return lcapUsers.stream().map(x -> {
            UserListResDTO userData = new UserListResDTO();
            userData.setUserId(x.getUserId());
            // 用户下沉时，用户数据本身不区分环境，环境概念体现在应用上
            userData.setEnv("");
            userData.setUserName(x.getUserName());
            userData.setSource(x.getSource().getCode());
            return userData;
        }).collect(Collectors.toList());
    }
}
