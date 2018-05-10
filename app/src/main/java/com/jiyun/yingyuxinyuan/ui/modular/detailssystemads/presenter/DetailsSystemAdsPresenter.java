package com.jiyun.yingyuxinyuan.ui.modular.detailssystemads.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.contract.DetailsSystemAdsContract;
import com.jiyun.yingyuxinyuan.model.bean.DetailsSystemAdsBean;
import com.jiyun.yingyuxinyuan.model.bean.DetailsSystemAdsTwoBean;
import com.jiyun.yingyuxinyuan.model.biz.DetailsSystemAdsService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asus on 2018/5/8.
 */

public class DetailsSystemAdsPresenter implements DetailsSystemAdsContract.Presenter {
    private DetailsSystemAdsContract.View view;
    private DetailsSystemAdsService detailsSystemAdsService;

    public DetailsSystemAdsPresenter() {
        detailsSystemAdsService = RetrofitUtils.getInstance().getDetailsSystemAdsService();
    }

    @Override
    public void actualView(DetailsSystemAdsContract.View view) {
        this.view = view;
    }

    @Override
    public void unActualView() {
        this.view = null;
    }

    @Override
    public void loadDate(String courseId) {
        HashMap<String, String> headers = new HashMap<>();
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        headers.put("apptoken", token.getString("appToken", ""));
        HashMap<String, String> params = new HashMap<>();
        params.put("courseId", courseId);
        detailsSystemAdsService.loadDate(params, headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DetailsSystemAdsBean>() {
                    @Override
                    public void accept(DetailsSystemAdsBean detailsSystemAdsBean) throws Exception {
                        String message = detailsSystemAdsBean.getMessage();
                        if ("成功".equals(message)) {
                            view.showDate(detailsSystemAdsBean);
                        } else {
                            view.showError("请求失败");
                        }
                    }
                });
    }
}
