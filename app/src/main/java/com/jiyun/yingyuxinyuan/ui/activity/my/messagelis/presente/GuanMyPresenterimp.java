package com.jiyun.yingyuxinyuan.ui.activity.my.messagelis.presente;

import android.content.Context;
import android.content.SharedPreferences;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.contract.GuanWyContract;
import com.jiyun.yingyuxinyuan.model.bean.GuanMyBean;
import com.jiyun.yingyuxinyuan.model.bean.HomeWorkWoBean;
import com.jiyun.yingyuxinyuan.model.biz.GuanMyService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ASUS on 2018/05/11.
 */

public class GuanMyPresenterimp implements GuanWyContract.Presenter {
    GuanMyService guanMyService;
    GuanWyContract.View view;

    public GuanMyPresenterimp() {
        guanMyService = RetrofitUtils.getInstance().getGuanMyService();
    }

    @Override
    public void actualView(GuanWyContract.View view) {
        this.view = view;
    }

    @Override
    public void unActualView() {
        this.view = null;
    }

    @Override
    public void showData(String userId) {
        Map<String, String> map = new HashMap<>();
        map.put("loginUserId",userId);
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        Map<String, String> headers = new HashMap<>();
        headers.put("apptoken", token.getString("appToken", ""));
        guanMyService.getGuan(map,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GuanMyBean>() {
                    @Override
                    public void accept(GuanMyBean guanMyBean) throws Exception {
                        view.showData(guanMyBean);
                    }
                });
    }
}
