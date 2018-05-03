package com.jiyun.yingyuxinyuan.ui.modular.teacher.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.base.BaseFragment;
import com.jiyun.yingyuxinyuan.model.bean.TeacherHomePageBean;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 名师页面
 */
public class TeacherFragment extends BaseFragment {


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_teacher;
    }

    @Override
    protected void init() {
        HashMap<String, String> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        params.put("loginUserId", "0");
        headers.put("apptoken", token.getString("appToken", ""));
        RetrofitUtils.getInstance().getTeacherService()
                .loadHomePage(params, headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TeacherHomePageBean>() {
                    @Override
                    public void accept(TeacherHomePageBean teacherHomePageBean) throws Exception {
                        Log.d("TeacherFragment", teacherHomePageBean.toString());
                    }
                });
    }

    @Override
    protected void loadDate() {

    }

}
