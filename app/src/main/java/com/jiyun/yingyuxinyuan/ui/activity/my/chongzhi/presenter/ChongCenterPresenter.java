package com.jiyun.yingyuxinyuan.ui.activity.my.chongzhi.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.ChongCenterContract;
import com.jiyun.yingyuxinyuan.model.bean.ChongCenterBean;
import com.jiyun.yingyuxinyuan.model.biz.ChongCenterService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asus on 2018/5/11.
 */

public class ChongCenterPresenter implements ChongCenterContract.Presenter {
    private ChongCenterContract.View view;
    private ChongCenterService chongCenterService;

    public ChongCenterPresenter() {
        chongCenterService = RetrofitUtils.getInstance().getChongCenterService();
    }

    @Override
    public void actualView(ChongCenterContract.View view) {
        this.view = view;
    }

    @Override
    public void unActualView() {
        this.view = null;

    }

    @Override
    public void loadInfo(String loginUserId) {
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        chongCenterService.loadDate(loginUserId, token.getString("appToken", ""))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ChongCenterBean>() {
                    @Override
                    public void accept(ChongCenterBean chongCenterBean) throws Exception {
                        String message = chongCenterBean.getMessage();
                        if ("成功".equals(message)) {
                            view.showView(chongCenterBean);
                        } else {
                            view.showError("请求失败");
                        }
                    }
                });
    }


}
