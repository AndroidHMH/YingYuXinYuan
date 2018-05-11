package com.jiyun.yingyuxinyuan.ui.activity.login.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.config.LoginShareUtils;
import com.jiyun.yingyuxinyuan.contract.LoginContract;
import com.jiyun.yingyuxinyuan.model.bean.LoginBean;
import com.jiyun.yingyuxinyuan.model.bean.UserBean;
import com.jiyun.yingyuxinyuan.model.biz.LoginService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;
import com.jiyun.yingyuxinyuan.ui.activity.LoginActivity;

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
        if (!isPhone(phone)) {
            return;
        }
        if (!isPsw(password)) {
            return;
        }

        map.put("mobile", phone);
        map.put("password", password);

        Map<String, String> headers = new HashMap<>();
        headers.put("apptoken", token.getString("appToken", ""));
        loginService.GetLogin(map, headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean loginBean) throws Exception {
                        String message = loginBean.getMessage();
                        if ("cid为空".equals(message)) {
                            int id = loginBean.getData().getId();
                            loadUserInfo(id);
                        } else {
                            loginView.showError("登陆失败");
                        }
                    }
                });
    }

    /**
     * 获取用户信息
     *
     * @param id 登录者id
     */
    @Override
    public void loadUserInfo(int id) {
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);

        loginService.loadUserInfo(String.valueOf(id), token.getString("appToken", ""))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserBean>() {
                    @Override
                    public void accept(UserBean userBean) throws Exception {
                        String message = userBean.getMessage();
                        if ("成功".equals(message)) {
                            UserBean.DataBean data = userBean.getData();
                            //保存信息
                            LoginShareUtils.UserMessage(App.context, data);
                            loginView.gotoMain();
                        } else {
                            loginView.showError("获取信息失败");
                        }
                    }
                });
    }

    @Override
    public boolean isPhone(String phone) {
        if (phone == null) {
            return false;
        }
        if (phone.equals("")) {
            return false;
        }
        if (phone.contains(" ")) {
            return false;
        }
        if (phone.matches("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$")) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isPsw(String password) {
        if (password == null) {
            return false;
        }
        if (password.equals("")) {
            return false;
        }
        if (password.contains(" ")) {
            return false;
        }
        return true;
    }

}
