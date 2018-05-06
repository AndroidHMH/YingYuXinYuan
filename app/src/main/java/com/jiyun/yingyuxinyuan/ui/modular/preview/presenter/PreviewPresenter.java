package com.jiyun.yingyuxinyuan.ui.modular.preview.presenter;

/**
 * Created by asus on 2018/5/3.
 */

import android.content.Context;
import android.content.SharedPreferences;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.PreviewContract;
import com.jiyun.yingyuxinyuan.model.bean.PreviewBean;
import com.jiyun.yingyuxinyuan.model.biz.PreviewService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 预告页的P层
 */
public class PreviewPresenter implements PreviewContract.Presenter {
    private PreviewContract.View view;
    private PreviewService previewService;

    public PreviewPresenter() {
        previewService = RetrofitUtils.getInstance().getPreviewService();
    }

    @Override
    public void actualView(PreviewContract.View view) {
        this.view = view;
    }

    @Override
    public void unActualView() {
        this.view = null;
    }

    @Override
    public void loadDate(int loginUserId, String startTime, String endTime) {
        HashMap<String, String> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        params.put("loginUserId", loginUserId + "");
        params.put("startDate", startTime);
        params.put("endDate", endTime);
        headers.put("apptoken", token.getString("appToken", ""));
        previewService.loadDate(params, headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PreviewBean>() {
                    @Override
                    public void accept(PreviewBean previewBean) throws Exception {
                        String message = previewBean.getMessage();
                        if ("成功".equals(message)) {
                            view.showDate(previewBean);
                        } else {
                            view.showError("请求失败");
                        }
                    }
                });
    }
}
