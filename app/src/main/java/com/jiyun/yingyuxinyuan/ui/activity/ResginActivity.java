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

public class ResginActivity extends BaseActivity {

    @BindView(R.id.resgin_close)
    ImageView resgin_close;
    @BindView(R.id.resgin_phone)
    EditText resgin_phone;
    @BindView(R.id.resgin_phone_res)
    ImageView resgin_phone_res;
    @BindView(R.id.resgin_yzm)
    EditText resgin_yzm;
    @BindView(R.id.resgin_getyzm)
    TextView resgin_getyzm;
    @BindView(R.id.resgin_resgin)
    Button resgin_resgin;
    @BindView(R.id.login_weixin)
    LinearLayout login_weixin;
    @BindView(R.id.login_qq)
    LinearLayout login_qq;
    @BindView(R.id.login_weibo)
    LinearLayout login_weibo;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_resgin;
    }
    @OnClick({R.id.resgin_close,R.id.resgin_getyzm,R.id.resgin_resgin,R.id.login_weixin,R.id.login_qq,R.id.login_weibo})
    protected void onViewClicked(View view){
        switch (view.getId()){
//            关闭
            case R.id.resgin_close:
                finish();
                break;
//              获取验证码
            case R.id.resgin_getyzm:
                break;
//                注册
            case R.id.resgin_resgin:

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
//        设置注册按钮变色
       /* if (!resgin_phone.getText().toString().trim().equals("")&& !resgin_yzm.getText().toString().trim().equals("")){
            resgin_resgin.setBackgroundColor(R.color.blue);
        }*/
    }

    @Override
    protected void loadDate() {

    }
}
