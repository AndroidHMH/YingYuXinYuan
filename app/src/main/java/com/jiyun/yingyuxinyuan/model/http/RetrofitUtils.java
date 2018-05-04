package com.jiyun.yingyuxinyuan.model.http;

/**
 * Created by asus on 2018/5/3.
 */

import android.content.Context;
import android.content.SharedPreferences;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.config.EncryptUtil;
import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.TokenBean;
import com.jiyun.yingyuxinyuan.model.biz.AppTokenService;
import com.jiyun.yingyuxinyuan.model.biz.ResginService;
import com.jiyun.yingyuxinyuan.model.biz.SetHobbyService;
import com.jiyun.yingyuxinyuan.model.biz.TeacherService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit工具类
 */
public class RetrofitUtils {
    private static RetrofitUtils retrofitUtils;
    private Retrofit retrofit;

    private RetrofitUtils() {
        getAppToken();
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Urls.BASE_URL)
                .build();
    }

    public static RetrofitUtils getInstance() {
        if (retrofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                if (retrofitUtils == null) {
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    public static void getAppToken() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Urls.BASE_URL)
                .build();
        retrofit.create(AppTokenService.class)
                .loadToken("https://www.univstar.com/v1/m/security/apptoken")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TokenBean>() {
                    @Override
                    public void accept(TokenBean tokenBean) throws Exception {
                        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
                        String apptoken = tokenBean.getData().getApptoken();
                        long time = System.currentTimeMillis();
                        String decrypt = EncryptUtil.decrypt(apptoken);
                        String headerApptoken = EncryptUtil.encrypt(time + decrypt).replaceAll("\\n", "").toUpperCase();
                        SharedPreferences.Editor edit = token.edit();
                        String appToken = headerApptoken + "." + time;
                        edit.putString("appToken", appToken);
                        edit.commit();
                    }
                });
    }

    public TeacherService getTeacherService() {
        return retrofit.create(TeacherService.class);
    }
    public ResginService getResginService() {  return retrofit.create(ResginService.class);  }
    public SetHobbyService getsetHobbyService() {  return retrofit.create(SetHobbyService.class);  }

}
