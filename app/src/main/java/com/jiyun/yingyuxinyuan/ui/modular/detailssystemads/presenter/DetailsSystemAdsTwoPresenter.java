package com.jiyun.yingyuxinyuan.ui.modular.detailssystemads.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.DetailsSystemAdsContract;
import com.jiyun.yingyuxinyuan.contract.DetailsSystemAdsTwoContract;
import com.jiyun.yingyuxinyuan.model.bean.DetailsSystemAdsBean;
import com.jiyun.yingyuxinyuan.model.bean.DetailsSystemAdsTwoBean;
import com.jiyun.yingyuxinyuan.model.biz.DetailsSystemAdsService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asus on 2018/5/8.
 */

public class DetailsSystemAdsTwoPresenter implements DetailsSystemAdsTwoContract.Presenter {
    private DetailsSystemAdsTwoContract.View view;
    private DetailsSystemAdsService detailsSystemAdsService;

    public DetailsSystemAdsTwoPresenter() {
        detailsSystemAdsService = RetrofitUtils.getInstance().getDetailsSystemAdsService();
    }

    @Override
    public void actualView(DetailsSystemAdsTwoContract.View view) {
        this.view = view;
    }

    @Override
    public void unActualView() {
        this.view = null;
    }

    @Override
    public void loadDate(String id) {
        HashMap<String, String> headers = new HashMap<>();
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        headers.put("apptoken", token.getString("appToken", ""));
        HashMap<String, String> params = new HashMap<>();
        params.put("id", id);
        detailsSystemAdsService.loadTypeDate(params, headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DetailsSystemAdsTwoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DetailsSystemAdsTwoBean detailsSystemAdsTwoBean) {
                        Log.e("DetailsSystemAdsTwoPres", detailsSystemAdsTwoBean.toString());
                        String message = detailsSystemAdsTwoBean.getMessage();
                        if ("成功".equals(message)) {
                            view.showDate(detailsSystemAdsTwoBean);
                        } else {
                            view.showError("请求失败");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("aaaaacc",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
