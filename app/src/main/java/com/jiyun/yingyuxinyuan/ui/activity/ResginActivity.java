package com.jiyun.yingyuxinyuan.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.jiyun.yingyuxinyuan.contract.ResginContract;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginBean;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;
import com.jiyun.yingyuxinyuan.ui.activity.resgin.activity.ResginAllActivity;
import com.jiyun.yingyuxinyuan.ui.activity.resgin.activity.ResginXieYiActivity;
import com.jiyun.yingyuxinyuan.ui.activity.resgin.presenter.ResginPresenterimp;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ResginActivity extends BaseActivity implements ResginContract.resginView{

    @BindView(R.id.resgin_close)
    TextView resgin_close;
    @BindView(R.id.resgin_phone)
    EditText resgin_phone;
    @BindView(R.id.resgin_phone_res)
    ImageView resgin_phone_res;
    @BindView(R.id.resgin_yzm)
    EditText resgin_yzm;
    @BindView(R.id.resgin_getyzm)
    TextView resgin_getyzm;
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
    private ResginPresenterimp resginPresenterimp;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_resgin;
    }
    @OnClick({R.id.resgin_phone,R.id.resgin_yzm,R.id.resgin_phone_res,
            R.id.resgin_close,R.id.resgin_getyzm,R.id.resgin_resgin,
            R.id.login_weixin,R.id.login_qq,R.id.login_weibo,R.id.resgin_xieyi_linear})
    protected void onViewClicked(View view){
        switch (view.getId()){
//            关闭
            case R.id.resgin_close:
                finish();
                break;
//               输入手机号
            case R.id.resgin_phone:
                if (resgin_phone.getText().length()==0){
                    resgin_phone_res.setVisibility(View.INVISIBLE);
                }else if(resgin_phone.getText().length() != 0){
                    resgin_phone_res.setVisibility(View.VISIBLE);
                }
                break;
//
            case R.id.resgin_phone_res:
//                resgin_phone.getText().toString().trim().substring(resgin_phone.getText().length()-1);
                break;
//                输入手机验证码
            case R.id.resgin_yzm:
                if (resgin_phone.getText().length() == 0 && resgin_getyzm.getText().length() != 0){
                    resgin_resgin.setBackgroundColor(R.color.colorblue);
                }
                break;
//              获取验证码
            case R.id.resgin_getyzm:
                resginPresenterimp.getPhoneCode(resgin_phone.getText().toString());
                break;
//                注册
            case R.id.resgin_resgin:

                resginPresenterimp.getResgin(resgin_phone.getText().toString(),resgin_yzm.getText().toString());
                startActivity(new Intent(ResginActivity.this,ResginAllActivity.class));
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
        resginPresenterimp = new ResginPresenterimp(this);
    }

    @Override
    protected void loadDate() {
        resginPresenterimp.getPhoneCode(resgin_phone.getText().toString());
        resginPresenterimp.getResgin(resgin_phone.getText().toString(),resgin_yzm.getText().toString());
//         SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
         /* Map<String,String> map = new HashMap<>();
        Map<String, String> headers = new HashMap<>();
        map.put("mobile",resgin_phone.getText().toString().trim());
        headers.put("apptoken", token.getString("appToken", ""));
        RetrofitUtils.getInstance().getResginService()
                .GetPhoneYzm(map,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PhoneResginYzmBean>() {
                    @Override
                    public void accept(PhoneResginYzmBean phoneResginYzmBean) throws Exception {
                        Log.e("ResginActivity",phoneResginYzmBean.toString());
                    }
                });
    */
      /*   Map<String,String> map1 = new HashMap<>();
         Map<String,String> header1 = new HashMap<>();
            map1.put("mobile", resgin_phone.getText().toString());
            map1.put("mobileValidCode", resgin_yzm.getText().toString());
            header1.put("apptoken", token.getString("appToken", ""));
            RetrofitUtils.getInstance().getResginService()
                    .GetPhoneResin(map1,header1)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<PhoneResginBean>() {
                        @Override
                        public void accept(PhoneResginBean phoneResginBean) throws Exception {
                            Log.e("ResginActivity",phoneResginBean.toString());
                        }
                    });
          */

    }

    @Override
    public void showPhone() {

    }

    @Override
    public void showPhoneYzmMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPhoneResginMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showRhoneResginAllMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
