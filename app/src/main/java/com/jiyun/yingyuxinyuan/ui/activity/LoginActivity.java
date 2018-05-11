package com.jiyun.yingyuxinyuan.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
import com.jiyun.yingyuxinyuan.config.LoginShareUtils;
import com.jiyun.yingyuxinyuan.contract.LoginContract;
import com.jiyun.yingyuxinyuan.model.bean.EventBean;
import com.jiyun.yingyuxinyuan.model.bean.LoginBean;
import com.jiyun.yingyuxinyuan.ui.MainActivity;
import com.jiyun.yingyuxinyuan.ui.activity.forget.ForgetActivity;
import com.jiyun.yingyuxinyuan.ui.activity.login.presenter.LoginPresenterimp;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 登录页面  手机号注册
 */
public class LoginActivity extends BaseActivity<LoginPresenterimp> implements LoginContract.LoginView {

    @BindView(R.id.login_close)
    TextView login_close;
    @BindView(R.id.login_resgin)
    TextView login_resgin;
    @BindView(R.id.login_phone)
    EditText login_phone;
    @BindView(R.id.login_psw)
    EditText login_psw;
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
    UMAuthListener umAuthListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(LoginActivity.this, "成功了", Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {

            Toast.makeText(LoginActivity.this, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(LoginActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @OnClick({R.id.login_login, R.id.login_close, R.id.login_resgin, R.id.login_forget, R.id.login_weixin, R.id.login_qq, R.id.login_weibo})
    protected void onViewClicked(View view) {
        switch (view.getId()) {
//            关闭
            case R.id.login_close:
                finish();
                break;
//             注册
            case R.id.login_resgin:
                startActivity(new Intent(LoginActivity.this, ResginActivity.class));
                break;
//             忘记密码
            case R.id.login_forget:
                startActivity(new Intent(LoginActivity.this, ForgetActivity.class));
                break;
//              登录
            case R.id.login_login:
                presenter.getLogin(login_phone.getText().toString(), login_psw.getText().toString());
                break;
//                微信登录
            case R.id.login_weixin:
                break;
//                QQ登录
            case R.id.login_qq:
                UMShareAPI.get(this).getPlatformInfo(LoginActivity.this, SHARE_MEDIA.QQ, umAuthListener);
                break;
//                微博登录
            case R.id.login_weibo:
                break;
        }
    }


    @Override
    protected void init() {

    }

    @Override
    protected void loadDate() {
    }

    @Override
    public void gotoMain() {
        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
