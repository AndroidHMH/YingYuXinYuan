package com.jiyun.yingyuxinyuan.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {

   @BindView(R.id.login_close)
    TextView login_close;
   @BindView(R.id.login_resgin)
   TextView login_resgin;
   @BindView(R.id.login_phone)
    EditText login_phone;
   @BindView(R.id.login_phone_res)
    ImageView login_phone_res;
   @BindView(R.id.login_psw)
   EditText login_psw;
   @BindView(R.id.login_psw_res)
   ImageView login_psw_res;
   @BindView(R.id.login_forget)
   TextView login_forget;
   @BindView(R.id.login_login)
    Button login_login;
   @BindView(R.id.login_weixin)
    LinearLayout login_weixin;
    @BindView(R.id.login_qq)
    LinearLayout login_qq;
    @BindView(R.id.login_weibo)
    LinearLayout login_weibo;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.login_login,R.id.login_close,R.id.login_resgin,R.id.login_forget,R.id.login_weixin,R.id.login_qq,R.id.login_weibo})
    protected void onViewClicked(View view){
        switch (view.getId()){
//            关闭
            case R.id.login_close:
                finish();
                break;
//             注册
            case R.id.login_resgin:
                startActivity(new Intent(LoginActivity.this,ResginActivity.class));
                break;
//             忘记密码
            case R.id.login_forget:
                startActivity(new Intent(LoginActivity.this,ForgetActivity.class));
                break;
//              登录
            case R.id.login_login:
                break;
//                微信登录
            case R.id.login_weixin:
                break;
//                QQ登录
            case R.id.login_qq:
                break;
//                微博登录
            case R.id.login_weibo:
                break;
        }
    }


    @Override
    protected void init() {
      /*  if (!login_phone.getText().toString().trim().equals("") && !login_psw.getText().toString().trim().equals("")){
            login_login.setBackgroundColor(R.color.blue);
        }*/
    }

    @Override
    protected void loadDate() {

    }
}
