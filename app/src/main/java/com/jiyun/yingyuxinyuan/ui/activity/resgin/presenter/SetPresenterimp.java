package com.jiyun.yingyuxinyuan.ui.activity.resgin.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.SetHobbyContract;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginYzmBean;
import com.jiyun.yingyuxinyuan.model.bean.SetHobbyBean;
import com.jiyun.yingyuxinyuan.model.biz.SetHobbyService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ASUS on 2018/05/04.
 */

public class SetPresenterimp implements SetHobbyContract.sethobbyPres {
    SetHobbyContract.sethobbyView sethobbyView;
    SetHobbyService setHobbyService;

    public SetPresenterimp() {
        setHobbyService =RetrofitUtils.getInstance().getsetHobbyService();
    }

    @Override
    public void getSetData() {
        setHobbyService.GetDatae("user/preference")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SetHobbyBean>() {
                    @Override
                    public void accept(SetHobbyBean setHobbyBean) throws Exception {
//                        Gson gson = new Gson();
//                        SetHobbyBean.DataBean data = setHobbyBean.getData();
//                        List<SetHobbyBean.DataBean.CollegesBean> colleges = data.getColleges();
//                        List<SetHobbyBean.DataBean.MajorsBean> majors = data.getMajors();
//                        gson.fromJson(SetHobbyBean.class);
                        sethobbyView.showSetData(setHobbyBean);
                    }
                });
    }

    @Override
    public void actualView(SetHobbyContract.sethobbyView sethobbyView) {
        this.sethobbyView = sethobbyView;
    }

    @Override
    public void unActualView() {
        this.sethobbyView=null;
    }
}
