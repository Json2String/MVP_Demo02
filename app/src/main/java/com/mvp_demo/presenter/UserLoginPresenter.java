package com.mvp_demo.presenter;

import android.os.Handler;
import android.util.Log;

import com.mvp_demo.module.IUserLoginModule;
import com.mvp_demo.module.OnLoginListener;
import com.mvp_demo.module.User;
import com.mvp_demo.module.UserLoginModel;
import com.mvp_demo.view.IUserLoginView;

/**
 * MVP中的presenter层
 */

public class UserLoginPresenter implements OnLoginListener {
    private static final String TAG = "UserLoginPresenter";
    private final UserLoginModel UserLoginModule;
    //1.既然p层起到桥梁作用，p层肯定持有view层和model层对象（就是成员变量）
//    private IUserLoginModule iUserLoginModule ;
    private IUserLoginView iUserLoginView;

    public UserLoginPresenter(IUserLoginView iUserLoginView) {
        this.UserLoginModule = new UserLoginModel();
//        this.iUserLoginModule = new UserLoginModel();
       /* this.iUserLoginModule = new IUserLoginModule() {
            @Override
            public void login(String username, String password, OnLoginListener listener) {

            }
        },*/
        this.iUserLoginView = iUserLoginView;
    }

    //既然起到桥梁的作用，肯定需要提供桥梁的方法
    public void login(){
        //显示进度条
        iUserLoginView.showProgressDialog();
        String userName = iUserLoginView.getUserName();
        String password = iUserLoginView.getPassword();
//        iUserLoginModule.login(userName, password, this);
        UserLoginModule.login(userName, password, this);

    }

    @Override
    public void loginSuccess(final User user) {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //隐藏进度条
                iUserLoginView.hideProgressDialog();
                //跳转主页
                iUserLoginView.jump2Main(user);
            }
        }, 1000);

       /* mHandler.post(new Runnable() {
            @Override
            public void run() {
                //隐藏进度条
                iUserLoginView.hideProgressDialog();
                //跳转主页
                iUserLoginView.jump2Main(user);

            }
        });*/
    }

    @Override
    public void loginFailed() {
       /* mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //隐藏进度条
                iUserLoginView.hideProgressDialog();
                //显示登录失败的信息
                iUserLoginView.loginError();
            }
        }, 1000);*/

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                //隐藏进度条
                iUserLoginView.hideProgressDialog();
                //显示登录失败的信息
                iUserLoginView.loginError();
            }
        });
    }

    @Override
    public void inputEmpty() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                iUserLoginView.hideProgressDialog();
                iUserLoginView.inputEmpty();
            }
        });
    }

    private Handler mHandler = new Handler();
}
