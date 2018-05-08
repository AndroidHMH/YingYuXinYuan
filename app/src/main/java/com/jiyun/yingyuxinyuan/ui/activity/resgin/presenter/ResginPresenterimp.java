package com.jiyun.yingyuxinyuan.ui.activity.resgin.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.config.SpUtils;
import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.contract.ResginContract;
import com.jiyun.yingyuxinyuan.contract.TeacherContract;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginAllBean;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginBean;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginYzmBean;
import com.jiyun.yingyuxinyuan.model.biz.ResginService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.http.POST;

/**
 * Created by ASUS on 2018/05/04.
 */
//注册Presenter   短信验证码，手机号注册，手机号注册完善(密码)
public class ResginPresenterimp implements ResginContract.ResginPresenter {
    ResginService resginService;
    ResginContract.ResginView resginView;

    public ResginPresenterimp() {

        resginService = RetrofitUtils.getInstance().getResginService();
    }

    @Override
    public void actualView(ResginContract.ResginView view) {
        this.resginView = view;
    }

    @Override
    public void unActualView() {
        this.resginView = null;
    }


    // 获取手机验证码
    @Override
    public void getPhoneCode(final String phone) {
        Map<String, String> map = new HashMap<>();
        map.put("mobile", phone);
        if (!isPhone(phone)) {
            return;
        }
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        Map<String, String> headers = new HashMap<>();
        headers.put("apptoken", token.getString("appToken", ""));

        resginService.GetPhoneYzm(map, headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PhoneResginYzmBean>() {
                    @Override
                    public void accept(PhoneResginYzmBean phoneResginYzmBean) throws Exception {
                        resginView.showPhoneYzmMessage(phoneResginYzmBean.getMessage());
                        resginView.startTime();
                    }
                });
    }

    // 手机注册
    @Override
    public void getResgin(String phone, String phoneyzm) {
        Map<String, String> map = new HashMap<>();
        map.put("mobile", phone);
        map.put("mobileValidCode", phoneyzm);
        if (!isPhone(phone)) {
            return;
        }
        if (!isYanZheng(phoneyzm)) {
            return;
        }
        Log.d("ResginPresenterimp", "App.context:" + App.context);
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        Map<String, String> headers = new HashMap<>();
        headers.put("apptoken", token.getString("appToken", ""));

        resginService.GetPhoneResin(map, headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PhoneResginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PhoneResginBean phoneResginBean) {
                        String message = phoneResginBean.getMessage();
                        if ("成功".equals(message)) {
                            Log.d("ResginPresenterimp", resginView.toString());
                            resginView.gotoResginAll();
                        } else {
                            resginView.showPhoneResginMessage("注册失败，请重新输入");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        resginView.showPhoneResginMessage(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    /**
     * 判断手机号
     *
     * @param phone
     * @return
     */
    @Override
    public boolean isPhone(String phone) {
        if (phone == null) {
            return false;
        }
        if ("".equals(phone)) {
            return false;
        }
        if (phone.contains(" ")) {
            return false;
        }
        String regex_mobile = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
        if (Pattern.matches(regex_mobile, phone)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断验证码
     *
     * @param yanZheng
     * @return
     */
    @Override
    public boolean isYanZheng(String yanZheng) {
        if (yanZheng == null) {
            return false;
        }
        if ("".equals(yanZheng)) {
            return false;
        }
        if (yanZheng.contains(" ")) {
            return false;
        }
        return true;
    }
}
