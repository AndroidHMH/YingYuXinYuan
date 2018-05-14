package com.jiyun.yingyuxinyuan.ui.activity.my.fensi.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.FenSiContract;
import com.jiyun.yingyuxinyuan.model.bean.FenSiBean;
import com.jiyun.yingyuxinyuan.model.bean.GuanZhuBean;
import com.jiyun.yingyuxinyuan.model.biz.FenSiService;
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

public class FenSiPresenter implements FenSiContract.Presenter {
    FenSiService fenSiService;
    FenSiContract.View view;

    public FenSiPresenter() {
        fenSiService = RetrofitUtils.getInstance().getFenSiService();
    }

    @Override
    public void actualView(FenSiContract.View view) {
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
        fenSiService.getData(map, headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FenSiBean>() {
                    @Override
                    public void accept(FenSiBean fenSiBean) throws Exception {
                        String message = fenSiBean.getMessage();
                        if ("成功".equals(message)){
                            List<FenSiBean.DataBean.ListBean> list = fenSiBean.getData().getList();
                            if (list != null && list.size() != 0){
                                view.showData(fenSiBean);
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
