package com.weitest.wms.web.dto;

/**
* auto generate LCAPUserInfoRequestDTO
* 封装用户controller的请求参数
*
* @author sys
*/
public class LCAPUserInfoRequestDTO {
    private String userId;
    private String userName;

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
