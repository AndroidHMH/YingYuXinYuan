package com.jiyun.yingyuxinyuan.ui.activity.my.dingdan.presenter;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.config.LoginShareUtils;
import com.jiyun.yingyuxinyuan.config.TokenUtils;
import com.jiyun.yingyuxinyuan.contract.DingDanContract;
import com.jiyun.yingyuxinyuan.model.bean.DingDanBean;
import com.jiyun.yingyuxinyuan.model.biz.DingDanService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asus on 2018/5/11.
 */

public class DingDanPresenter implements DingDanContract.Presenter {
    private DingDanContract.View view;
    private DingDanService dingDanService;

    public DingDanPresenter() {
        dingDanService = RetrofitUtils.getInstance().getDingDanService();
    }

    @Override
    public void actualView(DingDanContract.View view) {
        this.view = view;
    }

    @Override
    public void unActualView() {
        this.view = null;
    }

    @Override
    public void loadDate(String status) {
        Map<String, String> params = new HashMap<>();
        params.put("loginUserId", LoginShareUtils.getUserMessage(App.context, LoginShareUtils.ID));
        params.put("status", status);
        dingDanService.loadDate(TokenUtils.getToken(), params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DingDanBean>() {
                    @Override
                    public void accept(DingDanBean dingDanBean) throws Exception {
                        String message = dingDanBean.getMessage();
                        if ("成功".equals(message)) {
                            List<DingDanBean.DataBean.ListBean> list = dingDanBean.getData().getList();
                            if (list != null && list.size() != 0) {
                                view.showDate(dingDanBean);
                            } else {
                                view.showError();
                            }
                        } else {
                            view.showError();
                        }
                    }
                });
    }
}
