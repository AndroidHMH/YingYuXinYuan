package com.jiyun.yingyuxinyuan.ui.activity.my.messagelis.presente;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.PinWoContract;
import com.jiyun.yingyuxinyuan.contract.ZanContract;
import com.jiyun.yingyuxinyuan.model.bean.PingWoBean;
import com.jiyun.yingyuxinyuan.model.bean.ZanBean;
import com.jiyun.yingyuxinyuan.model.biz.PingWoService;
import com.jiyun.yingyuxinyuan.model.biz.ZanService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asus on 2018/5/10.
 */

public class PinWoPresenterimp implements PinWoContract.Presenter {
    PingWoService pingWoService;
    PinWoContract.View view;

    public PinWoPresenterimp() {
        pingWoService = RetrofitUtils.getInstance().getPingService();
    }

    @Override
    public void actualView(PinWoContract.View view) {
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
        pingWoService.getPing(map,headers)
               .subscribeOn(Schedulers.newThread())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Consumer<PingWoBean>() {
                   @Override
                   public void accept(PingWoBean pingWoBean) throws Exception {
                       view.showData(pingWoBean);
                       Log.e("TAG",pingWoBean.getData().getSize()+"");
                   }
               });
    }
}
