package com.mvp_demo;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mvp_demo.module.User;
import com.mvp_demo.presenter.UserLoginPresenter;
import com.mvp_demo.view.IUserLoginView;

public class LoginActivityMVP extends AppCompatActivity implements IUserLoginView, View.OnClickListener {

    private EditText userName;
    private EditText password;
    private Button login;
    private ProgressDialog progressDialog;
    private UserLoginPresenter userLoginPresenter;
    private Context context;
    private static final String TAG = "LoginActivityMVP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginmvp);
        this.context = this;
        initView();
        login.setOnClickListener(this);

    }

    private void initView() {
        userName = (EditText) findViewById(R.id.et_username);
        password = (EditText) findViewById(R.id.et_password);
        login = (Button) findViewById(R.id.btn_login);
        progressDialog = new ProgressDialog(this);
        userLoginPresenter = new UserLoginPresenter(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                userLoginPresenter.login();
                break;
        }
    }

    @Override
    public String getUserName() {
        Log.d(TAG, "getUserName: " + userName.getText().toString().trim());
        return userName.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        Log.d(TAG, "getPassword: " + password.getText().toString().trim());
        return password.getText().toString().trim();
    }

    @Override
    public void showProgressDialog() {
        Log.d(TAG, "showProgressDialog: " + progressDialog);
        progressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        Log.d(TAG, "hideProgressDialog: " + progressDialog);
        progressDialog.hide();
    }

    @Override
    public void jump2Main(User user) {
        Toast.makeText(this, "登录跳转到住页面", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {

        Toast.makeText(this, "用户名或密码错误，请重新登录", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void inputEmpty() {
        Toast.makeText(this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
    }
}
