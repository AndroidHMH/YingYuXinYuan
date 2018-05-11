package com.jiyun.yingyuxinyuan.ui.activity.my.messagelis.presente;

import android.content.Context;
import android.content.SharedPreferences;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.MessageTiContract;
import com.jiyun.yingyuxinyuan.model.bean.DingTiBean;
import com.jiyun.yingyuxinyuan.model.biz.DingTiService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asus on 2018/5/10.
 */

public class MessageTiPresenterimp implements MessageTiContract.Presenter {
    DingTiService dingTiService;
    MessageTiContract.View view;

    public MessageTiPresenterimp() {
        dingTiService = RetrofitUtils.getInstance().getDingTiService();
    }

    @Override
    public void actualView(MessageTiContract.View view) {
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
       dingTiService.getDingTi(map,headers)
               .subscribeOn(Schedulers.newThread())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Consumer<DingTiBean>() {
                   @Override
                   public void accept(DingTiBean dingTiBean) throws Exception {
                       view.showData(dingTiBean);
                   }
               });
    }
}