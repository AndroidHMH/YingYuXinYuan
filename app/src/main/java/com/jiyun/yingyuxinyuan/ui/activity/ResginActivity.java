package com.jiyun.yingyuxinyuan.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.contract.ResginContract;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginBean;
import com.jiyun.yingyuxinyuan.model.bean.TimeCount;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;
import com.jiyun.yingyuxinyuan.ui.activity.resgin.activity.ResginAllActivity;
import com.jiyun.yingyuxinyuan.ui.activity.resgin.activity.ResginXieYiActivity;
import com.jiyun.yingyuxinyuan.ui.activity.resgin.presenter.ResginPresenterimp;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

//
public class ResginActivity extends BaseActivity<ResginPresenterimp> implements ResginContract.ResginView {

    @BindView(R.id.resgin_close)
    TextView resgin_close;
    @BindView(R.id.resgin_phone)
    EditText resgin_phone_str;
    @BindView(R.id.resgin_yzm)
    EditText resgin_yzm;
    @BindView(R.id.resgin_getyzm)
    Button resgin_getyzm;
    @BindView(R.id.resgin_xieyi_linear)
    LinearLayout resginxieyiLinear;
    @BindView(R.id.resgin_resgin)
    Button resgin_resgin;
    @BindView(R.id.login_weixin)
    LinearLayout login_weixin;
    @BindView(R.id.login_qq)
    LinearLayout login_qq;
    @BindView(R.id.login_weibo)
    LinearLayout login_weibo;
    private TimeCount timeCount;
    private String phone;

    @Override
    protected int getLayoutId() {


        return R.layout.activity_resgin;
    }

    @OnClick({R.id.resgin_phone, R.id.resgin_yzm,
            R.id.resgin_close, R.id.resgin_getyzm, R.id.resgin_resgin,
            R.id.login_weixin, R.id.login_qq, R.id.login_weibo})
    protected void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.resgin_close:
                finish();
                break;
            case R.id.resgin_getyzm:
                //获取验证码
                presenter.getPhoneCode(resgin_phone_str.getText().toString());
                break;
            case R.id.resgin_resgin:
                //注册
                phone = resgin_phone_str.getText().toString();
//                presenter.getResgin(phone, resgin_yzm.getText().toString());
                gotoResginAll();
                break;
            case R.id.login_weixin:
                // 微信登录
                weixin_login();
                break;
            case R.id.login_qq:
                // QQ登录
                qq_login();
                break;
            case R.id.login_weibo:
                // 微博登录
                sina_login();
                break;
        }
    }

    /**
     * 倒计时
     */
    @Override
    public void startTime() {
        timeCount.start();
    }

    //  微博登录
    private void sina_login() {

    }

    //  qq登录
    private void qq_login() {
    }

    //  微信登录
    private void weixin_login() {
    }

    @Override
    protected void init() {
        timeCount = new TimeCount(60000, 1000, resgin_getyzm);
    }

    @Override
    protected void loadDate() {

    }

    @Override
    public void showPhoneYzmMessage(String msg) {
        Toast.makeText(this, "获取验证码成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPhoneResginMessage(String msg) {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void gotoResginAll() {
        // 注册成功，跳转到完善信息页面补充页面
        Intent intent = new Intent(this, ResginAllActivity.class);
        intent.putExtra("phone", phone);
        startActivity(intent);
        finish();
    }

}
