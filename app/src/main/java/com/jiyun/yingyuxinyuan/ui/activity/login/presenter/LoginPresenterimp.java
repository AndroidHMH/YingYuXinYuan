package com.jiyun.yingyuxinyuan.ui.activity.login.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.LoginContract;
import com.jiyun.yingyuxinyuan.model.bean.LoginBean;
import com.jiyun.yingyuxinyuan.model.biz.LoginService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ASUS on 2018/05/05.
 */

public class LoginPresenterimp implements LoginContract.LoginPresenter {
    LoginService loginService;
    LoginContract.LoginView loginView;

    public LoginPresenterimp() {
        loginService = RetrofitUtils.getInstance().getLoginService();
    }

    @Override
    public void actualView(LoginContract.LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void unActualView() {
        this.loginView = null;
    }

    @Override
    public void getLogin(String phone, String password) {
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        Map<String, String> map = new HashMap<>();
        map.put("mobile", phone);
        map.put("mobileValidCode", password);

        if (!isPhone(phone)){
            return;
        }
        if (!isPsw(password)){
            return;
        }


        Map<String, String> headers = new HashMap<>();
        headers.put("apptoken", token.getString("appToken", ""));
        loginService.GetLogin(map,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        int code = loginBean.getCode();
                        loginView.showData(code+"");
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public boolean isPhone(String phone) {
        if (phone == null){
            return false;
        }
        if (phone.equals("")){
            return false;
        }
        if (phone.contains(" ")){
            return false;
        }
        if (phone.matches("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$")){
            return true;
        }
        return false;
    }

    @Override
    public boolean isPsw(String password) {
        if (password == null){
            return false;
        }
        if (password.equals("")){
            return false;
        }
        if (password.contains(" ")){
            return false;
        }
        if (password.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$")){
            return true;
        }
        return false;
    }

}
