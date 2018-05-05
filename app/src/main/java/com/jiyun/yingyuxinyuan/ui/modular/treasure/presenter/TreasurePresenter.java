package com.jiyun.yingyuxinyuan.ui.modular.treasure.presenter;

/**
 * Created by asus on 2018/5/3.
 */

import android.content.Context;
import android.content.SharedPreferences;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.TreasureContract;
import com.jiyun.yingyuxinyuan.model.bean.TreasureRollPagerBean;
import com.jiyun.yingyuxinyuan.model.bean.TreasureTitleBean;
import com.jiyun.yingyuxinyuan.model.biz.TreasureService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 宝典页的P层
 */
public class TreasurePresenter implements TreasureContract.Presenter {
    private TreasureContract.View view;
    private TreasureService treasureService;

    public TreasurePresenter() {
        treasureService = RetrofitUtils.getInstance().getTreasureService();
    }

    @Override
    public void actualView(TreasureContract.View view) {
        this.view = view;
    }

    @Override
    public void unActualView() {
        this.view = null;
    }

    @Override
    public void loadTitle() {
        HashMap<String, String> headers = new HashMap<>();
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        headers.put("apptoken", token.getString("appToken", ""));
        treasureService.loadTitle(headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TreasureTitleBean>() {
                    @Override
                    public void accept(TreasureTitleBean treasureTitleBean) throws Exception {
                        view.addTitle(treasureTitleBean);
                    }
                });
    }

    @Override
    public void loadRollPager() {
        HashMap<String, String> headers = new HashMap<>();
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        headers.put("apptoken", token.getString("appToken", ""));
        treasureService.loadRollPager(headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TreasureRollPagerBean>() {
                    @Override
                    public void accept(TreasureRollPagerBean treasureRollPagerBean) throws Exception {
                        view.showRollPager(treasureRollPagerBean);
                    }
                });
    }
}
