package com.jiyun.yingyuxinyuan.ui.modular.mingshi.persenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.MingShiContract;
import com.jiyun.yingyuxinyuan.model.bean.MingShiBean;
import com.jiyun.yingyuxinyuan.model.biz.MingShiService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asus on 2018/5/9.
 */

public class MingShiPresenter implements MingShiContract.Presenter {
    private MingShiContract.View view;
    private MingShiService mingShiService;

    public MingShiPresenter() {
        mingShiService = RetrofitUtils.getInstance().getMingShiService();
    }

    @Override
    public void actualView(MingShiContract.View view) {
        this.view = view;
    }

    @Override
    public void unActualView() {
        this.view = null;
    }

    @Override
    public void loadDate(String id) {
        HashMap<String, String> headers = new HashMap<>();
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        headers.put("apptoken", token.getString("appToken", ""));
        HashMap<String, String> params = new HashMap<>();
        params.put("teacherId", id);

        mingShiService.loadDate(params, headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MingShiBean>() {
                    @Override
                    public void accept(MingShiBean mingShiBean) throws Exception {
                        String message = mingShiBean.getMessage();
                        if ("成功".equals(message)) {
                            view.showDate(mingShiBean);
                        } else {
                            view.showError("请求失败");
                        }
                    }
                });
    }
}
