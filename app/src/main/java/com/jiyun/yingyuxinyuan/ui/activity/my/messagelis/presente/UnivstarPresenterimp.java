package com.jiyun.yingyuxinyuan.ui.activity.my.messagelis.presente;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.UnivastarContract;
import com.jiyun.yingyuxinyuan.model.bean.UnivstarBean;
import com.jiyun.yingyuxinyuan.model.bean.ZanBean;
import com.jiyun.yingyuxinyuan.model.biz.UnivstarService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ASUS on 2018/05/10.
 */

public class UnivstarPresenterimp implements UnivastarContract.Presenter{
    UnivstarService univstarService;
    UnivastarContract.View view;

    public UnivstarPresenterimp() {
        univstarService = RetrofitUtils.getInstance().getUnivstarService();
    }

    @Override
    public void actualView(UnivastarContract.View view) {
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
        univstarService.getUnivstar(map,headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UnivstarBean>() {
                    @Override
                    public void accept(UnivstarBean univstarBean) throws Exception {
                        view.showData(univstarBean);
                        Log.e("长度", univstarBean.getData().getList().size()+"");
                    }
                });
    }
}
