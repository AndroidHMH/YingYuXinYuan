package com.jiyun.yingyuxinyuan.ui.modular.homework.presenter;

/**
 * Created by asus on 2018/5/3.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.HomeworkItemContract;
import com.jiyun.yingyuxinyuan.model.bean.HomeworkBean;
import com.jiyun.yingyuxinyuan.model.biz.HomeworkService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 作业的Presenter层
 */
public class HomeworkItemPresenter implements HomeworkItemContract.Presenter {
    private HomeworkItemContract.View view;
    private HomeworkService homeworkService;

    public HomeworkItemPresenter(HomeworkItemContract.View view) {
        this.view = view;
        homeworkService = RetrofitUtils.getInstance().getHomeworkService();
    }

    @Override
    public void loadHomeworkDate(int sortord, int loginUserId) {
        HashMap<String, String> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        params.put("loginUserId", loginUserId + "");
        params.put("sortord", sortord + "");
        headers.put("apptoken", token.getString("appToken", ""));
        homeworkService.loadHomeworkBean(params, headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeworkBean>() {
                    @Override
                    public void accept(HomeworkBean homeworkBean) throws Exception {
                        String message = homeworkBean.getMessage();
                        if ("成功".equals(message)) {
                            view.showHomeworkBean(homeworkBean);
                        } else {
                            view.showError();
                        }
                    }
                });
    }
}
