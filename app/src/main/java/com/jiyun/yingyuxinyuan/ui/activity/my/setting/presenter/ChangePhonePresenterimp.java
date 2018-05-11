package com.jiyun.yingyuxinyuan.ui.activity.my.setting.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.ChangePhoneContract;
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
 * Created by ASUS on 2018/05/09.
 */

public class ChangePhonePresenterimp implements ChangePhoneContract.ChangePresenter {
    ChangePhoneService changePhoneService;
    ChangePhoneContract.ChangeView changeView;

    public ChangePhonePresenterimp() {
        changePhoneService = RetrofitUtils.getInstance().getChangePhoneService();
    }

    @Override
    public void actualView(ChangePhoneContract.ChangeView changeView) {
        this.changeView = changeView;
    }

    @Override
    public void unActualView() {
        this.changeView = null;
    }

    @Override
    public void getChangeYzm(String phone) {
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
                            changeView.showNewPhoneYzmMessage("获取成功");
                            changeView.startTime();
                        } else {
                            changeView.showError("获取失败");
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
}
