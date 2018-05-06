package com.jiyun.yingyuxinyuan.ui.modular.treasure.presenter;

/**
 * Created by asus on 2018/5/3.
 */


import android.content.Context;
import android.content.SharedPreferences;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.TreasureItemContract;
import com.jiyun.yingyuxinyuan.model.bean.TreasureItemBean;
import com.jiyun.yingyuxinyuan.model.biz.TreasureService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 宝典子页面的P层
 */
public class TreasureItemPresenter implements TreasureItemContract.Presenter {
    private TreasureItemContract.View view;
    private TreasureService treasureService;

    public TreasureItemPresenter(TreasureItemContract.View view) {
        this.view = view;
        treasureService = RetrofitUtils.getInstance().getTreasureService();
    }

    @Override
    public void loadDate(int sortord, int loginUserId) {
        HashMap<String, String> headers = new HashMap<>();
        HashMap<String, String> params = new HashMap<>();
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        headers.put("apptoken", token.getString("appToken", ""));
        params.put("sortord", "" + sortord);
        params.put("loginUserId", "" + loginUserId);
        treasureService.loadItemBean(params, headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TreasureItemBean>() {
                    @Override
                    public void accept(TreasureItemBean treasureItemBean) throws Exception {
                        String message = treasureItemBean.getMessage();
                        if ("成功".equals(message)) {
                            view.showDate(treasureItemBean);
                        } else {
                            view.showError();
                        }
                    }
                });
    }
}
