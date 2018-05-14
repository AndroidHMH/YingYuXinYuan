package com.jiyun.yingyuxinyuan.ui.activity.my.guanzhu.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.GuanZhuContract;
import com.jiyun.yingyuxinyuan.model.bean.GuanZhuBean;
import com.jiyun.yingyuxinyuan.model.bean.ZuoPingBean;
import com.jiyun.yingyuxinyuan.model.biz.GuanZhuService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ASUS on 2018/05/13.
 */

public class GuanZhuPresenter implements GuanZhuContract.Presenter {
    GuanZhuService guanZhuService;
    GuanZhuContract.View view;

    public GuanZhuPresenter() {
        guanZhuService = RetrofitUtils.getInstance().getGuanZhuService();
    }

    @Override
    public void actualView(GuanZhuContract.View view) {
        this.view = view;
    }

    @Override
    public void unActualView() {
        this.view = null;
    }

    @Override
    public void loadData(String userId) {
        Map<String, String> map = new HashMap<>();
        map.put("loginUserId", userId);
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        Map<String, String> headers = new HashMap<>();
        headers.put("apptoken", token.getString("appToken", ""));
        guanZhuService.getData(map, headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GuanZhuBean>() {
                    @Override
                    public void accept(GuanZhuBean guanZhuBean) throws Exception {
                        String message = guanZhuBean.getMessage();
                        if ("成功".equals(message)){
                            List<GuanZhuBean.DataBean.ListBean> list = guanZhuBean.getData().getList();
                            if (list != null && list.size() != 0){
                                view.showData(guanZhuBean);
                            }else{
                                view.showError("暂无数据");
                            }
                        }else{
                            view.showError("请求失败");
                        }
                    }
                });
    }
}
