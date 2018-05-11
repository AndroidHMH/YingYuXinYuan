package com.jiyun.yingyuxinyuan.ui.activity.my.setting.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.config.LoginShareUtils;
import com.jiyun.yingyuxinyuan.contract.ChangePhoneNextContract;
import com.jiyun.yingyuxinyuan.model.bean.ChangePhoneBean;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginYzmBean;
import com.jiyun.yingyuxinyuan.model.biz.ChangePhoneService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asus on 2018/5/10.
 */

public class ChangePhoneNextPresenter implements ChangePhoneNextContract.Presenter {
    private ChangePhoneNextContract.View view;
    private ChangePhoneService changePhoneService;

    public ChangePhoneNextPresenter() {
        changePhoneService = RetrofitUtils.getInstance().getChangePhoneService();
    }

    @Override
    public void actualView(ChangePhoneNextContract.View view) {
        this.view = view;
    }

    @Override
    public void unActualView() {
        this.view = null;
    }

    @Override
    public void loadYanZheng(String phone) {
        Map<String, String> map = new HashMap<>();
        if (!isPhone(phone)) {
            return;
        }
        map.put("mobile", phone);
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        Map<String, String> headers = new HashMap<>();
        headers.put("apptoken", token.getString("appToken", ""));

        changePhoneService.GetPhoneYzm(map, headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PhoneResginYzmBean>() {
                    @Override
                    public void accept(PhoneResginYzmBean phoneResginYzmBean) throws Exception {
                        String message = phoneResginYzmBean.getMessage();
                        if ("验证码已发送".equals(message)) {
                            view.startTime();
                        } else {
                            view.showError("获取失败");
                        }
                    }
                });
    }

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

    @Override
    public void changePhone(final String phone, String yanZheng) {
        Map<String, String> map = new HashMap<>();
        if (!isPhone(phone)) {
            return;
        }
        if (!isYan(yanZheng)) {
            return;
        }
        map.put("loginUserId", LoginShareUtils.getUserMessage(App.context, LoginShareUtils.ID));
        map.put("mobile", phone);
        map.put("code", yanZheng);
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        Map<String, String> headers = new HashMap<>();
        headers.put("apptoken", token.getString("appToken", ""));

        changePhoneService.GetNext(map, headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ChangePhoneBean>() {
                    @Override
                    public void accept(ChangePhoneBean changePhoneBean) throws Exception {
                        String message = changePhoneBean.getMessage();
                        if ("成功".equals(message)) {
                            LoginShareUtils.setUserMessage(App.context, LoginShareUtils.MOBILE, phone);
                            view.success();
                            view.showError("替换成功");
                        } else {
                            view.showError("替换失败");
                        }
                    }
                });

    }

    @Override
    public boolean isYan(String yanZheng) {
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
