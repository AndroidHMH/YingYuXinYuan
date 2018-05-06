package com.jiyun.yingyuxinyuan.ui.activity.resgin.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.ResginAllContract;
import com.jiyun.yingyuxinyuan.contract.ResginContract;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginAllBean;
import com.jiyun.yingyuxinyuan.model.biz.ResginAllService;
import com.jiyun.yingyuxinyuan.model.biz.ResginService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by ASUS on 2018/05/05.
 */

public class ResginAllPresenterimp implements  ResginAllContract.ResginAllPresenter   {
    ResginAllService resginAllService;
    ResginAllContract.ResginAllView resginAllView;
    SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);

    public ResginAllPresenterimp() {
        resginAllService = RetrofitUtils.getInstance().getResginAllService();
    }

    @Override
    public void actualView(ResginAllContract.ResginAllView resginAllView) {
        this.resginAllView = resginAllView;
    }

    @Override
    public void unActualView() {
        this.resginAllView = null;
    }

    @Override
    public void getResginAll(String password) {
        Map<String, String> map = new HashMap<>();
        map.put("psw", password);
        Map<String, String> headers = new HashMap<>();
        headers.put("apptoken", token.getString("appToken", ""));

        resginAllService.GetPhoneResginAll(map,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody phoneResginAllBean) {
                        try {
                            String string = phoneResginAllBean.string();
                            Log.e("TAG",string);
//                            PhoneResginAllBean phoneResginAllBean1 = new Gson().fromJson(string, PhoneResginAllBean.class);
                            resginAllView.showRhoneResginAllMessage(string);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                      //
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
