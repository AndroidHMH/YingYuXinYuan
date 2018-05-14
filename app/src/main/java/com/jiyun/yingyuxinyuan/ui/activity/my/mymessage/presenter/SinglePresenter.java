package com.jiyun.yingyuxinyuan.ui.activity.my.mymessage.presenter;

import android.util.Log;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.config.LoginShareUtils;
import com.jiyun.yingyuxinyuan.config.TokenUtils;
import com.jiyun.yingyuxinyuan.contract.SingleContract;
import com.jiyun.yingyuxinyuan.model.biz.SingleService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by asus on 2018/5/13.
 */

public class SinglePresenter implements SingleContract.Presenter {
    private SingleContract.View view;
    private SingleService singleService;
    public static final String NICKNAME = "nickname";
    public static final String ADDRESS = "address";

    public SinglePresenter() {
        singleService = RetrofitUtils.getInstance().getSingleService();
    }

    @Override
    public void actualView(SingleContract.View view) {
        this.view = view;
    }

    @Override
    public void unActualView() {
        this.view = null;
    }

    @Override
    public void sendChangeMsg(String type, String msg) {
        Map<String, String> params = new HashMap<>();
        params.put(type, msg);
        params.put("user", LoginShareUtils.getUserMessage(App.context, LoginShareUtils.ID));
        singleService.sendChangeMsg(TokenUtils.getToken(), params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        String string = responseBody.string();
                        Log.d("SinglePresenter", string);
                    }
                });
    }
}
