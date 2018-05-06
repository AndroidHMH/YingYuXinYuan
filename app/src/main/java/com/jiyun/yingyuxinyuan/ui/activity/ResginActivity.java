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
public class ResginActivity extends BaseActivity<ResginPresenterimp> implements ResginContract.ResginView{

    @BindView(R.id.resgin_close)
    TextView resgin_close;
    @BindView(R.id.resgin_phone)
    EditText resgin_phone_str;
    @BindView(R.id.resgin_phone_res)
    ImageView resgin_phone_res;
    @BindView(R.id.resgin_yzm)
    EditText resgin_yzm;
    @BindView(R.id.resgin_getyzm)
    TextView resgin_getyzm;
    @BindView(R.id.resgin_phone_yzm_res)
    ImageView resgin_phone_yzm_res;
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
    String phone_str;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_resgin;
    }
    @OnClick({R.id.resgin_phone,R.id.resgin_yzm,
            R.id.resgin_close,R.id.resgin_getyzm,R.id.resgin_resgin,
            R.id.login_weixin,R.id.login_qq,R.id.login_weibo})
    protected void onViewClicked(View view){
        switch (view.getId()){
//            关闭
            case R.id.resgin_close:
                finish();
                break;
//               输入手机号
            case R.id.resgin_phone:
//                判断是否输入
//                resgin_phone_str.addTextChangedListener(new TextWatcher() {
//                    @Override
//                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//                    }
//
//                    @Override
//                    public void onTextChanged(CharSequence s, int start, int before, int count) {
//                        phone_str = s.toString();
//                        if (TextUtils.isEmpty(phone_str)){
//                            resgin_phone_res.setVisibility(View.INVISIBLE);
//                        }else{
//                            resgin_phone_res.setVisibility(View.VISIBLE);
//                        }
//                    }
//
//                    @Override
//                    public void afterTextChanged(Editable s) {
//
//                    }
//                });
                break;
//                输入手机验证码
            case R.id.resgin_yzm:
//                判断验证码是否输入
//                resgin_yzm.addTextChangedListener(new TextWatcher() {
//                    @Override
//                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//                    }
//
//                    @Override
//                    public void onTextChanged(CharSequence s, int start, int before, int count) {
//                        getyzm_str = s.toString();
//                        if (TextUtils.isEmpty(getyzm_str)){
//                            resgin_phone_yzm_res.setVisibility(View.INVISIBLE);
//                        }else{
//                            resgin_phone_yzm_res.setVisibility(View.VISIBLE);
//                        }
//                    }
//
//                    @Override
//                    public void afterTextChanged(Editable s) {
//
//                    }
//                });
                break;
//              获取验证码
            case R.id.resgin_getyzm:
//                判断手机号是否输入
                if (TextUtils.isEmpty(resgin_phone_str.getText().toString())){
                    return;
                }

                presenter.getPhoneCode(resgin_phone_str.getText().toString());
                break;
//                注册
            case R.id.resgin_resgin:
//                判断手机号，验证码是否为空
                if (TextUtils.isEmpty(resgin_phone_str.getText().toString()) || TextUtils.isEmpty(resgin_yzm.getText().toString())){
                    return;
                }
//                resgin_resgin.setEnabled(false);
//                注册
                resgin();
                break;
//                微信登录
            case R.id.login_weixin:
                weixin_login();
                break;
//                QQ登录
            case R.id.login_qq:
                qq_login();
                break;
//                微博登录
            case R.id.login_weibo:
                sina_login();
                break;
        }
    }
    private void resgin() {
        presenter.getResgin(resgin_phone_str.getText().toString(),resgin_yzm.getText().toString());
//        注册成功，跳转到完善信息页面补充页面
        startActivity(new Intent(ResginActivity.this,ResginAllActivity.class));
        finish();
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
    }

    @Override
    protected void loadDate() {
//        获取手机验证码
        presenter.getPhoneCode(resgin_phone_str.getText().toString());
//        注册
        presenter.getResgin(resgin_phone_str.getText().toString(),resgin_yzm.getText().toString());


    }
    @Override
    public void showPhoneYzmMessage(String msg) {
        Toast.makeText(this, "获取验证码成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPhoneResginMessage(String msg) {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }


}
