package com.jiyun.yingyuxinyuan.ui.activity.resgin.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.config.SpUtils;
import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.contract.ResginContract;
import com.jiyun.yingyuxinyuan.contract.TeacherContract;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginAllBean;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginBean;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginYzmBean;
import com.jiyun.yingyuxinyuan.model.biz.ResginService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by ASUS on 2018/05/04.
 */
//注册Presenter   短信验证码，手机号注册，手机号注册完善(密码)
public class ResginPresenterimp implements ResginContract.ResginPresenter {
    ResginService resginService;
    ResginContract.ResginView resginView;
    SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);

   public ResginPresenterimp() {
        resginService = RetrofitUtils.getInstance().getResginService();
    }
   @Override
    public void actualView(ResginContract.ResginView view) {
        this.resginView = view;
    }

    @Override
    public void unActualView() {
        this.resginView = null;
    }


    //    获取手机验证码
    @Override
    public void getPhoneCode(final String phone) {
        Map<String,String> map = new HashMap<>();
        map.put("mobile", phone);

        Map<String, String> headers = new HashMap<>();
        headers.put("apptoken", token.getString("appToken", ""));

        resginService.GetPhoneYzm(map,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PhoneResginYzmBean>() {
                    @Override
                    public void accept(PhoneResginYzmBean phoneResginYzmBean) throws Exception {
                        resginView.showPhoneYzmMessage(phoneResginYzmBean.getMessage());
                    }
                });
    }
    //    手机注册
    @Override
    public void getResgin(String phone,String phoneyzm) {
        Map<String, String> map = new HashMap<>();
        map.put("mobile", phone);
        map.put("mobileValidCode", phoneyzm);

        Map<String, String> headers = new HashMap<>();
        headers.put("apptoken", token.getString("appToken", ""));

        resginService.GetPhoneResin(map,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PhoneResginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        resginView.showPhoneResginMessage(d.toString());
                    }

                    @Override
                    public void onNext(PhoneResginBean phoneResginBean) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        resginView.showPhoneResginMessage(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
