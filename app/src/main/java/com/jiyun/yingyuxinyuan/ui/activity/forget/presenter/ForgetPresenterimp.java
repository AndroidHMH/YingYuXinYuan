package com.jiyun.yingyuxinyuan.ui.activity.forget.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.ForgetContract;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginYzmBean;
import com.jiyun.yingyuxinyuan.model.biz.ForgetService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ASUS on 2018/05/07.
 */

public class ForgetPresenterimp implements ForgetContract.ForgetPresenter {
    ForgetService forgetService;
    ForgetContract.ForgetView forgetView;

    public ForgetPresenterimp() {
        forgetService = RetrofitUtils.getInstance().getForgetService();
    }

    @Override
    public void actualView(ForgetContract.ForgetView forgetView) {
        this.forgetView = forgetView;
    }

    @Override
    public void unActualView() {
        forgetView = null;
    }

    @Override
    public void getPhoneCode(final String phone) {
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        Map<String, String> map = new HashMap<>();
        map.put("mobile", phone);
     /*   if (!isPhone(phone)){
            return;
        }*/

        Map<String, String> headers = new HashMap<>();
        headers.put("apptoken", token.getString("appToken", ""));
        forgetService.GetPhoneYzm(map,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PhoneResginYzmBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PhoneResginYzmBean phoneResginYzmBean) {
                        String message = phoneResginYzmBean.getMessage();
                        Log.e("TAG",message.toString());
                        forgetView.showPhoneYzmMessage(message);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("TAG","失败");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    @Override
    public boolean isPhone(String phone) {
        if (phone==null){
            return false;
        }
        if (phone.equals("")){
            return false;
        }
        if (phone.contains(" ")){
            return false;
        }
        if (phone.matches("^((13[0-9])|(15[^4,\\\\D])|(18[0,5-9]))\\\\d{8}$")){
            return true;
        }
        return false;
    }


}
