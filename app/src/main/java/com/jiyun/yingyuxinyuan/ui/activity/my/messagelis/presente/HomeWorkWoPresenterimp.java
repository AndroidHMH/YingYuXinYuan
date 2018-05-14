package com.jiyun.yingyuxinyuan.ui.activity.my.messagelis.presente;

import android.content.Context;
import android.content.SharedPreferences;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.HomeWorkWoContract;
import com.jiyun.yingyuxinyuan.contract.PinWoContract;
import com.jiyun.yingyuxinyuan.model.bean.HomeWorkWoBean;
import com.jiyun.yingyuxinyuan.model.bean.PingWoBean;
import com.jiyun.yingyuxinyuan.model.biz.HomeWorkWoService;
import com.jiyun.yingyuxinyuan.model.biz.PingWoService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asus on 2018/5/10.
 */

public class HomeWorkWoPresenterimp implements HomeWorkWoContract.Presenter {
    HomeWorkWoService homeWorkWoService;
    HomeWorkWoContract.View view;

    public HomeWorkWoPresenterimp() {
        homeWorkWoService = RetrofitUtils.getInstance().getHomeWorkWoService();
    }


    @Override
    public void actualView(HomeWorkWoContract.View view) {
        this.view = view;
    }

    @Override
    public void unActualView() {
        this.view = null;
    }

    @Override
    public void loadDate(String userId) {
        Map<String, String> map = new HashMap<>();
        map.put("loginUserId", userId);
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        Map<String, String> headers = new HashMap<>();
        headers.put("apptoken", token.getString("appToken", ""));
        homeWorkWoService.getHomeWorkWo(map, headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeWorkWoBean>() {
                    @Override
                    public void accept(HomeWorkWoBean homeWorkWoBean) throws Exception {
                        String message = homeWorkWoBean.getMessage();
                        if ("成功".equals(message)) {
                            List<?> list = homeWorkWoBean.getData().getList();
                            if (list != null && list.size() != 0) {
                                view.showData(homeWorkWoBean);
                            } else {
                                view.showError("暂无数据");
                            }
                        } else {
                            view.showError("请求失败");
                        }
                    }
                });
    }
}
