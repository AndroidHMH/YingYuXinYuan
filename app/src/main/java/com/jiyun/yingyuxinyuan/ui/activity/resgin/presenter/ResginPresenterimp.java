package com.jiyun.yingyuxinyuan.ui.activity.resgin.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.config.SpUtils;
import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.contract.ResginContract;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginAllBean;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginBean;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginYzmBean;
import com.jiyun.yingyuxinyuan.model.biz.ResginService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by ASUS on 2018/05/04.
 */
//注册Presenter   短信验证码，手机号注册，手机号注册完善(密码)
public class ResginPresenterimp implements ResginContract.resginPresenter {
    ResginService resginService;
    ResginContract.resginView resginView;

    public ResginPresenterimp(ResginContract.resginView resginView) {
        this.resginView = resginView;
        resginService = RetrofitUtils.getInstance().getResginService();
    }

//    获取手机验证码
    @Override
    public void getPhoneCode(final String phone) {
        Map<String,String> map = new HashMap<>();
        map.put("mobile", phone);
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        Map<String, String> headers = new HashMap<>();
        headers.put("apptoken", token.getString("appToken", ""));

        resginService.GetPhoneYzm(map,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PhoneResginYzmBean>() {
                    @Override
                    public void accept(PhoneResginYzmBean phoneResginYzmBean) throws Exception {
                        resginView.showPhoneYzmMessage(phoneResginYzmBean.toString());
                    }
                });
    }

//    手机注册
    @Override
    public void getResgin(String phone,String phoneyzm) {
        Map<String, String> map = new HashMap<>();
        map.put("mobile", phone);
        map.put("mobileValidCode", phoneyzm);
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        Map<String, String> headers = new HashMap<>();
        headers.put("apptoken", token.getString("appToken", ""));

        resginService.GetPhoneResin(map,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PhoneResginBean>() {
                    @Override
                    public void accept(PhoneResginBean phoneResginBean) throws Exception {
                            resginView.showPhoneResginMessage(phoneResginBean.toString());
                    }
                });
    }

//    手机注册完善
    @Override
    public void getResginAll(String password) {
        Map<String, String> map = new HashMap<>();
        map.put("psw", password);
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        Map<String, String> headers = new HashMap<>();
        headers.put("apptoken", token.getString("appToken", ""));

        resginService.GetPhoneResginAll(map,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PhoneResginAllBean>() {
                    @Override
                    public void accept(PhoneResginAllBean phoneResginAllBean) throws Exception {
                        resginView.showRhoneResginAllMessage(phoneResginAllBean.getMessage());
                    }
                });
    }
}
