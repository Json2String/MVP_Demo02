package com.mvp_demo.view;

import com.mvp_demo.module.User;

/**
 * MVP中的View层，如何编写View层代码？
 *
 * 看效果图那些属于view：2个EditText，一个Button，一个ProgressDialog
 *
 *  1.有那些操作：获取用户名、获取密码
 *  2.有那些用户交互：显示ProgressDialog，隐藏ProgressDialog
 *  3.结果是什么：登录成功跳转主页，登录失败提示用户
 *
 */

public interface IUserLoginView {
    //获取用户名
    String getUserName();
    //获得密码
    String getPassword();

    //显示ProgressDialog
    void showProgressDialog();
    //隐藏ProgressDialog
    void hideProgressDialog();

    //登录成功跳转主页
    void jump2Main(User user);
    //登录失败
    void loginError();
    //输入的字符为空
    void inputEmpty();


}
