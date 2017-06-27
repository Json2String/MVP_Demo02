package com.mvp_demo.module;

/**
 * MVP中的Modle层：登录业务
 */

public interface IUserLoginModule {
    void login(String username, String password, OnLoginListener listener);

}
