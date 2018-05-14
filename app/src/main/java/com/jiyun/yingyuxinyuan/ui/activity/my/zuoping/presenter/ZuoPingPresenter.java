package com.jiyun.yingyuxinyuan.ui.activity.my.zuoping.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.ZuoPingContract;
import com.jiyun.yingyuxinyuan.model.bean.ZanBean;
import com.jiyun.yingyuxinyuan.model.bean.ZuoPingBean;
import com.jiyun.yingyuxinyuan.model.biz.ZuoPingService;
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

public class ZuoPingPresenter implements ZuoPingContract.Presenter {
    ZuoPingContract.View view;
    ZuoPingService zuoPingService;

    public ZuoPingPresenter() {
        zuoPingService = RetrofitUtils.getInstance().getZuoPingService();
    }

    @Override
    public void actualView(ZuoPingContract.View view) {
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
        zuoPingService.getData(map, headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ZuoPingBean>() {
                    @Override
                    public void accept(ZuoPingBean zuoPingBean) throws Exception {
                        String message = zuoPingBean.getMessage();
                        if ("成功".equals(message)){
                            List<?> list = zuoPingBean.getData().getList();
                            if (list != null && list.size()!=0){
                                view.showData(zuoPingBean);
                            }else{
                                view.showErroe("暂无数据");
                            }
                        }else{
                            view.showErroe("请求失败");
                        }
                    }
                });
    }
}
