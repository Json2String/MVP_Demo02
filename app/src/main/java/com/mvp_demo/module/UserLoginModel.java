package com.mvp_demo.module;

import android.util.Log;
import android.widget.Toast;

/**
 * 登录业务具体实现类
 */

public class UserLoginModel implements IUserLoginModule {
    private static final String TAG = "UserLoginModel";

    @Override
    public void login(final String username, final String password, final OnLoginListener listener) {

        //访问服务器，模拟实际操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //判断用户名和密码
                if ("it".equals(username) && "123".equals(password)){

                    User user = new User(username, password);
                    //登录成功
                    listener.loginSuccess(user);

                }else if ("".equals(username) || "".equals(password)){
                    listener.inputEmpty();
                }
                else {
                    /*if ("".equals(username) || "".equals(password)){
                        listener.inputEmpty();    //这个也是可以的
                    }*/

                    //登录失败
                    listener.loginFailed();
                }
            }
        }).start();
    }
}
