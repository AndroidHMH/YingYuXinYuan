package com.jiyun.yingyuxinyuan.ui.activity.my.setting.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.config.LoginShareUtils;
import com.jiyun.yingyuxinyuan.contract.ChangePswNextContract;
import com.jiyun.yingyuxinyuan.model.bean.ChangePswBean;
import com.jiyun.yingyuxinyuan.model.biz.ChangePswNextService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asus on 2018/5/10.
 */

public class ChangePswNextPresenter implements ChangePswNextContract.Presenter {
    private ChangePswNextContract.View view;
    private ChangePswNextService changePswNextService;

    public ChangePswNextPresenter() {
        changePswNextService = RetrofitUtils.getInstance().getChangePswNextService();
    }

    @Override
    public void actualView(ChangePswNextContract.View view) {
        this.view = view;
    }

    @Override
    public void unActualView() {
        this.view = null;
    }

    @Override
    public void loadPsw(String psw, String newPsw) {
        if (!isPsw(psw)) {
            return;
        }
        if (!isPsw(newPsw)) {
            return;
        }
        if (!psw2psw(psw, newPsw)) {
            return;
        }
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        Map<String, String> params = new HashMap<>();
        params.put("loginUserId", LoginShareUtils.getUserMessage(App.context, LoginShareUtils.ID));
        params.put("password", psw);
        changePswNextService.sendChangePsw(token.getString("appToken", ""), params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ChangePswBean>() {
                    @Override
                    public void accept(ChangePswBean changePswBean) throws Exception {
                        String message = changePswBean.getMessage();
                        if ("成功".equals(message)) {
                            view.success();
                        } else {
                            view.showError("修改失败");
                        }
                    }
                });

    }

    @Override
    public boolean psw2psw(String psw, String newPsw) {
        if (psw.equals(newPsw)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isPsw(String psw) {
        if (psw == null) {
            return false;
        }
        if ("".equals(psw)) {
            return false;
        }
        if (psw.contains(" ")) {
            return false;
        }
        return true;
    }
}
