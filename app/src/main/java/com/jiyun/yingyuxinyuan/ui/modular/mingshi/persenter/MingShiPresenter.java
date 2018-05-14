package com.jiyun.yingyuxinyuan.ui.modular.mingshi.persenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.MingShiContract;
import com.jiyun.yingyuxinyuan.model.bean.DianZanBean;
import com.jiyun.yingyuxinyuan.model.bean.GuanZhuBean;
import com.jiyun.yingyuxinyuan.model.bean.MingShiBean;
import com.jiyun.yingyuxinyuan.model.biz.MingShiService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;
import com.jiyun.yingyuxinyuan.ui.modular.dianzan.DianZan;
import com.jiyun.yingyuxinyuan.ui.modular.guanzhu.GuanZhu;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asus on 2018/5/9.
 */

public class MingShiPresenter implements MingShiContract.Presenter {
    private MingShiContract.View view;
    private MingShiService mingShiService;
    private DianZan dianZan;
    private GuanZhu guanZhu;

    public MingShiPresenter() {
        mingShiService = RetrofitUtils.getInstance().getMingShiService();
        dianZan = new DianZan();
        guanZhu = new GuanZhu();
    }

    @Override
    public void actualView(MingShiContract.View view) {
        this.view = view;
    }

    @Override
    public void unActualView() {
        this.view = null;
    }

    @Override
    public void loadDate(String id,String loginUserId) {
        HashMap<String, String> headers = new HashMap<>();
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        headers.put("apptoken", token.getString("appToken", ""));
        HashMap<String, String> params = new HashMap<>();
        params.put("teacherId", id);
        params.put("loginUserId", loginUserId);

        mingShiService.loadDate(params, headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MingShiBean>() {
                    @Override
                    public void accept(MingShiBean mingShiBean) throws Exception {
                        String message = mingShiBean.getMessage();
                        if ("成功".equals(message)) {
                            view.showDate(mingShiBean);
                        } else {
                            view.showError("请求失败");
                        }
                    }
                });
    }

    @Override
    public void dianZan(String userId, String id, String type) {
        dianZan.sendZan(userId, id, type, new DianZan.Result() {
            @Override
            public void success(DianZanBean dianZanBean) {
                view.showSuccess("已赞");
            }

            @Override
            public void error(String msg) {
                view.showError("点赞失败");
            }
        });
    }

    @Override
    public void quXiao(String userId, String id, String type) {
        dianZan.quXiaoZan(userId, id, type, new DianZan.Result() {
            @Override
            public void success(DianZanBean dianZanBean) {
                view.showSuccess("已取消");
            }

            @Override
            public void error(String msg) {
                view.showError("取消失败");
            }
        });
    }

    @Override
    public void guanZhu(String attentionId) {
        guanZhu.guanZhu(attentionId, new GuanZhu.Result() {
            @Override
            public void success(GuanZhuBean guanZhuBean) {
                view.showSuccess("已关注");
            }

            @Override
            public void error(String msg) {
                view.showError("关注失败");
            }
        });
    }

    @Override
    public void quXiaoGuan(String attentionId) {
        guanZhu.quXiao(attentionId, new GuanZhu.Result() {
            @Override
            public void success(GuanZhuBean guanZhuBean) {
                view.showSuccess("取消关注");
            }

            @Override
            public void error(String msg) {
                view.showError("取消关注失败");
            }
        });
    }
}
