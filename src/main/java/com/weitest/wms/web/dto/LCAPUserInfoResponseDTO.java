package com.weitest.wms.web.dto;

/**
* auto generate LCAPUserInfoResponseDTO
* 封装用户controller的响应结果
*
* @author sys
*/
public class LCAPUserInfoResponseDTO {
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
