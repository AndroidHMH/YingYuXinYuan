package com.jiyun.yingyuxinyuan.ui.modular.teacher.presenter;

/**
 * Created by asus on 2018/5/3.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.TeacherContract;
import com.jiyun.yingyuxinyuan.model.bean.TeacherHomePageBean;
import com.jiyun.yingyuxinyuan.model.biz.TeacherService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 名师页的P层
 */
public class TeacherPresenter implements TeacherContract.Presenter {
    private TeacherService teacherService;
    private TeacherContract.View view;

    public TeacherPresenter() {
        this.teacherService = RetrofitUtils.getInstance().getTeacherService();
    }

    @Override
    public void actualView(TeacherContract.View view) {
        this.view = view;
    }

    @Override
    public void unActualView() {
        this.view = null;
    }

    @Override
    public void loadHomePageDate(Integer userId) {
        HashMap<String, String> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        params.put("loginUserId", userId + "");
        headers.put("apptoken", token.getString("appToken", ""));
        RetrofitUtils.getInstance().getTeacherService()
                .loadHomePage(params, headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TeacherHomePageBean>() {
                    @Override
                    public void accept(TeacherHomePageBean teacherHomePageBean) throws Exception {
                        if (teacherHomePageBean.getCode() == 0) {
                            TeacherHomePageBean.DataBean data = teacherHomePageBean.getData();
                            List<TeacherHomePageBean.DataBean.HomewoksBean> homewoks = data.getHomewoks();
                            List<TeacherHomePageBean.DataBean.LiveCoursesBean> liveCourses = data.getLiveCourses();
                            List<TeacherHomePageBean.DataBean.SystemAdsBean> systemAds = data.getSystemAds();
                            List<TeacherHomePageBean.DataBean.UsersBean> users = data.getUsers();
                            view.showClassRecycler(liveCourses);
                            view.showRollPager(systemAds);
                            view.showTeacherRecycler(users);
                            view.showWorkRecycler(homewoks);
                        } else {
                            view.showError("请求失败");
                        }

                    }
                });
    }
}
