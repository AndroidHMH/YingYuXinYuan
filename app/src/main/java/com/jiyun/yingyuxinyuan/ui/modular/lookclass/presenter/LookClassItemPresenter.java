package com.jiyun.yingyuxinyuan.ui.modular.lookclass.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.LookClassItemContract;
import com.jiyun.yingyuxinyuan.contract.TeacherListItemContract;
import com.jiyun.yingyuxinyuan.model.bean.LookClassItemBean;
import com.jiyun.yingyuxinyuan.model.biz.LookClassItemService;
import com.jiyun.yingyuxinyuan.model.biz.TeacherListItemService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asus on 2018/5/8.
 */

public class LookClassItemPresenter implements LookClassItemContract.Presenter {
    private LookClassItemContract.View view;
    private LookClassItemService lookClassItemService;

    public LookClassItemPresenter(LookClassItemContract.View view) {
        this.view = view;
        this.lookClassItemService = RetrofitUtils.getInstance().getLookClassItemService();
    }

    @Override
    public void loadDate(String type) {
        Map<String, String> params = new HashMap<>();
        Map<String, String> headers = new HashMap<>();
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        headers.put("apptoken", token.getString("appToken", ""));
        params.put("type", type);
        lookClassItemService.loadDate(headers, params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LookClassItemBean>() {
                    @Override
                    public void accept(LookClassItemBean classItemBean) throws Exception {
                        String message = classItemBean.getMessage();
                        if ("成功".equals(message)) {
                            List<LookClassItemBean.DataBean.ListBean> list = classItemBean.getData().getList();
                            if (list != null && list.size() != 0) {
                                view.showDate(classItemBean);
                            } else {
                                view.showError("没数据");
                            }
                        } else {
                            view.showError("请求失败");
                        }
                    }
                });
    }
}
