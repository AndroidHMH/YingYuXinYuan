package com.jiyun.yingyuxinyuan.ui.modular.treasureitemcontent.presneter;

import android.content.Context;
import android.content.SharedPreferences;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.TreasureItemContentContract;
import com.jiyun.yingyuxinyuan.model.bean.TreasureItemContentBean;
import com.jiyun.yingyuxinyuan.model.biz.TreasureItemContentService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asus on 2018/5/10.
 */

public class TreasureItemContentPresenter implements TreasureItemContentContract.Presenter {

    private TreasureItemContentContract.View view;
    private TreasureItemContentService treasureItemContentService;

    public TreasureItemContentPresenter() {
        treasureItemContentService = RetrofitUtils.getInstance().getTreasureItemContentService();
    }

    @Override
    public void actualView(TreasureItemContentContract.View view) {
        this.view = view;
    }

    @Override
    public void unActualView() {
        this.view = null;
    }

    @Override
    public void loadDate(String artcircleId) {
        HashMap<String, String> headers = new HashMap<>();
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        headers.put("apptoken", token.getString("appToken", ""));
        HashMap<String, String> params = new HashMap<>();
        params.put("artcircleId", artcircleId + "");
        treasureItemContentService.loadDate(headers, params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TreasureItemContentBean>() {
                    @Override
                    public void accept(TreasureItemContentBean treasureItemContentBean) throws Exception {
                        String message = treasureItemContentBean.getMessage();
                        if ("成功".equals(message)) {
                            view.showDate(treasureItemContentBean);
                            List<TreasureItemContentBean.DataBean.CommentsBean.ListBean> list = treasureItemContentBean.getData().getComments().getList();
                            if (list != null && list.size() != 0) {
                                view.showPingLun(list);
                            } else {
                                view.showErrorPingLun();
                            }
                        } else {
                            view.showError("请求失败");
                        }
                    }
                });
    }
}
