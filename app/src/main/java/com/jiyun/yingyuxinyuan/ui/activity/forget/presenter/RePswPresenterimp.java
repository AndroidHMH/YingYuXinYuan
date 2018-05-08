package com.jiyun.yingyuxinyuan.ui.activity.forget.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.RePswContract;
import com.jiyun.yingyuxinyuan.model.bean.ResPswBean;
import com.jiyun.yingyuxinyuan.model.biz.PswResService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ASUS on 2018/05/08.
 */

public class RePswPresenterimp implements RePswContract.RePswPresenter {
    PswResService pswResService;
    RePswContract.RePswView rePswView;

    public RePswPresenterimp() {
        pswResService = RetrofitUtils.getInstance().getPswResService();
    }

    @Override
    public void actualView(RePswContract.RePswView rePswView) {
        this.rePswView = rePswView;
    }

    @Override
    public void unActualView() {
        this.pswResService = null;
    }

    @Override
    public void finish(String phone, String psw) {

        Map<String,String> map = new HashMap<>();
        map.put("mobile", phone);
        map.put("password", psw);
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        Map<String, String> headers = new HashMap<>();
        headers.put("apptoken", token.getString("appToken", ""));

        pswResService.resetPass(map,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResPswBean>() {
                    @Override
                    public void accept(ResPswBean resPswBean) throws Exception {
                        String message = resPswBean.getMessage();
                        Log.e("TAG",message);
                        rePswView.showMessage(message);
                    }
                });
    }
}
