package com.mvp_demo.module;

/**
 * 登录回调接口
 */

public interface OnLoginListener {
    /**
     * 登录成功回调
     */
    void loginSuccess(User user);

    /**
     * 登录失败
     */
    void loginFailed();
    //自己加的：输入的字符为空
    void inputEmpty();


}
