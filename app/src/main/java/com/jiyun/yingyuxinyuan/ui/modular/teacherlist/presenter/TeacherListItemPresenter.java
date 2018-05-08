package com.jiyun.yingyuxinyuan.ui.modular.teacherlist.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.TeacherListItemContract;
import com.jiyun.yingyuxinyuan.contract.TeacherListItemContract.Presenter;
import com.jiyun.yingyuxinyuan.model.bean.TeacherListBean;
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

public class TeacherListItemPresenter implements Presenter {
    private TeacherListItemContract.View view;
    private TeacherListItemService teacherListItemService;

    public TeacherListItemPresenter(TeacherListItemContract.View view) {
        this.view = view;
        this.teacherListItemService = RetrofitUtils.getInstance().getTeacherListItemService();
    }

    @Override
    public void loadDate(int userType) {
        Map<String, String> params = new HashMap<>();
        Map<String, String> headers = new HashMap<>();
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        headers.put("apptoken", token.getString("appToken", ""));
        params.put("userType", userType + "");
        teacherListItemService.loadDate(headers, params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TeacherListBean>() {
                    @Override
                    public void accept(TeacherListBean teacherListBean) throws Exception {
                        String message = teacherListBean.getMessage();
                        if ("成功".equals(message)) {
                            List<TeacherListBean.DataBean.ListBean> list = teacherListBean.getData().getList();
                            if (list != null && list.size() != 0) {
                                view.showDate(teacherListBean);
                            } else {
                                view.showError("无数据");
                            }
                        } else {
                            view.showError("请求失败");
                        }
                    }
                });
    }
}
