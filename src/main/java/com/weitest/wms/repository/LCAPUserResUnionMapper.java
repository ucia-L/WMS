package com.weitest.wms.repository;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* auto generate LCAPUserResUnionMapper
*   定义制品应用操作下沉的用户逻辑鉴权的方法，用于联合查询用户的资源权限
* * LCAPUserResUnionMapper 这个类是ftl模版生成的
*
* @author sys
*/
public interface LCAPUserResUnionMapper {
     List<String> getUserResourceList(@Param("userId") String userId);
}
