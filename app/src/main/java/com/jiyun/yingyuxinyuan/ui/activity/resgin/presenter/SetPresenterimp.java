package com.jiyun.yingyuxinyuan.ui.activity.resgin.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.SetHobbyContract;
import com.jiyun.yingyuxinyuan.model.bean.SetHobbyBean;
import com.jiyun.yingyuxinyuan.model.biz.SetHobbyService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.List;

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
        setHobbyService = RetrofitUtils.getInstance().getsetHobbyService();
    }

    @Override
    public void getSetData() {
        HashMap<String, String> headers = new HashMap<>();
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        headers.put("apptoken", token.getString("appToken", ""));
        setHobbyService.GetDatae(headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SetHobbyBean>() {
                    @Override
                    public void accept(SetHobbyBean setHobbyBean) throws Exception {
                        Log.d("SetPresenterimp", setHobbyBean.toString());
                        String message = setHobbyBean.getMessage();
                        if ("成功".equals(message)) {
                            List<SetHobbyBean.DataBean.CollegesBean> colleges = setHobbyBean.getData().getColleges();
                            List<SetHobbyBean.DataBean.MajorsBean> majors = setHobbyBean.getData().getMajors();
                            sethobbyView.showSchool(colleges);
                            sethobbyView.showSetData(majors);

                        } else {
                            sethobbyView.showErrorMsg(message);
                        }
                    }
                });
    }

    @Override
    public void actualView(SetHobbyContract.sethobbyView sethobbyView) {
        this.sethobbyView = sethobbyView;
    }

    @Override
    public void unActualView() {
        this.sethobbyView = null;
    }
}
