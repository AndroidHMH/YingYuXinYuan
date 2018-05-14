package com.jiyun.yingyuxinyuan.ui.modular.detailssystemads.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.DetailsSystemAdsContract;
import com.jiyun.yingyuxinyuan.contract.DetailsSystemAdsTwoContract;
import com.jiyun.yingyuxinyuan.model.bean.DetailsSystemAdsBean;
import com.jiyun.yingyuxinyuan.model.bean.DetailsSystemAdsTwoBean;
import com.jiyun.yingyuxinyuan.model.bean.GuanZhuBean;
import com.jiyun.yingyuxinyuan.model.bean.ShouChangBean;
import com.jiyun.yingyuxinyuan.model.biz.DetailsSystemAdsService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;
import com.jiyun.yingyuxinyuan.ui.modular.guanzhu.GuanZhu;
import com.jiyun.yingyuxinyuan.ui.modular.shoucang.ShouChang;

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
    private GuanZhu guanZhu;
    private ShouChang shouChang;
    public DetailsSystemAdsTwoPresenter() {
        detailsSystemAdsService = RetrofitUtils.getInstance().getDetailsSystemAdsService();
        guanZhu = new GuanZhu();
        shouChang = new ShouChang();
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
                        Log.e("aaaaacc", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void guanZhu(String attentionId) {
        guanZhu.guanZhu(attentionId, new GuanZhu.Result() {
            @Override
            public void success(GuanZhuBean guanZhuBean) {
                view.showSuccess("关注成功");
            }

            @Override
            public void error(String msg) {
                view.showError("关注失败");
            }
        });
    }

    @Override
    public void quXiao(String attentionId) {
        guanZhu.quXiao(attentionId, new GuanZhu.Result() {
            @Override
            public void success(GuanZhuBean guanZhuBean) {
                view.showSuccess("取消关注成功");
            }

            @Override
            public void error(String msg) {
                view.showError("取消关注失败");
            }
        });
    }

    @Override
    public void shouCang(String id, String type) {
        shouChang.shouChang(id, type, new ShouChang.Result() {
            @Override
            public void success(ShouChangBean shouChangBean) {
                view.showSuccess("收藏");
            }

            @Override
            public void error(String msg) {
                view.showError("失败");
            }
        });
    }

    @Override
    public void quXiaoShou(String id, String type) {
        shouChang.quXiaoShouChang(id, type, new ShouChang.Result() {
            @Override
            public void success(ShouChangBean shouChangBean) {
                view.showSuccess("取消");
            }

            @Override
            public void error(String msg) {
                view.showError("取消失败");
            }
        });
    }
}
