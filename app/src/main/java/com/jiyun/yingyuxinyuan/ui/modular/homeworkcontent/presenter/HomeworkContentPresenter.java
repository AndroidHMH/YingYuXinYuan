package com.jiyun.yingyuxinyuan.ui.modular.homeworkcontent.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.HomeworkContentContract;
import com.jiyun.yingyuxinyuan.model.bean.HomeworkContentBean;
import com.jiyun.yingyuxinyuan.model.biz.HomeworkContentService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asus on 2018/5/9.
 */

public class HomeworkContentPresenter implements HomeworkContentContract.Presenter {
    private HomeworkContentContract.View view;
    private HomeworkContentService homeworkContentService;

    public HomeworkContentPresenter() {
        homeworkContentService = RetrofitUtils.getInstance().getHomeworkContentService();
    }

    @Override
    public void actualView(HomeworkContentContract.View view) {
        this.view = view;
    }

    @Override
    public void unActualView() {
        this.view = null;
    }

    @Override
    public void loadDate(String homewokId) {
        HashMap<String, String> headers = new HashMap<>();
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        headers.put("apptoken", token.getString("appToken", ""));
        HashMap<String, String> params = new HashMap<>();
        params.put("homewokId", homewokId);
        homeworkContentService.loadDate(params, headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeworkContentBean>() {
                    @Override
                    public void accept(HomeworkContentBean homeworkContentBean) throws Exception {
                        String message = homeworkContentBean.getMessage();
                        HomeworkContentBean.DataBean data = homeworkContentBean.getData();
                        if ("成功".equals(message)) {
                            view.showDate(homeworkContentBean);
                            //评论的集合
                            HomeworkContentBean.DataBean.CommentsBean comments = data.getComments();
                            List<HomeworkContentBean.DataBean.CommentsBean.ListBean> list = comments.getList();
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
