package com.jiyun.yingyuxinyuan.ui.activity.my.setting.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.config.TokenUtils;
import com.jiyun.yingyuxinyuan.contract.ChangpswContract;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginYzmBean;
import com.jiyun.yingyuxinyuan.model.bean.YanZhengBean;
import com.jiyun.yingyuxinyuan.model.biz.ChangPswService;
import com.jiyun.yingyuxinyuan.model.biz.JiaoYanService;
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

public class ChangPswPresenter implements ChangpswContract.Presenter {
    private ChangpswContract.View view;
    private ChangPswService changPswService;
    private JiaoYanService jiaoYanService;

    public ChangPswPresenter() {
        changPswService = RetrofitUtils.getInstance().getChangPswService();
        jiaoYanService = RetrofitUtils.getInstance().getJiaoYanService();
    }

    @Override
    public void actualView(ChangpswContract.View view) {
        this.view = view;
    }

    @Override
    public void unActualView() {
        this.view = null;
    }

    @Override
    public void getYanZheng(String phone) {
        Map<String, String> map = new HashMap<>();
        if (!isPhone(phone)) {
            return;
        }
        map.put("mobile", phone);
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        Map<String, String> headers = new HashMap<>();
        headers.put("apptoken", token.getString("appToken", ""));

        changPswService.GetPhoneYzm(map, headers)
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
    public void yanZheng(String phone, String yanZheng) {
        Map<String, String> params = new HashMap<>();
        params.put("mobile", phone);
        params.put("authCode", yanZheng);

        jiaoYanService.yanZheng(TokenUtils.getToken(), params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<YanZhengBean>() {
                    @Override
                    public void accept(YanZhengBean yanZhengBean) throws Exception {
                        String message = yanZhengBean.getMessage();
                        if ("成功".equals(message)) {
                            view.next();
                        } else {
                            view.showError("验证码输入错误");
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
