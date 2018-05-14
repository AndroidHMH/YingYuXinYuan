package com.jiyun.yingyuxinyuan.ui.activity.my.tiezi.presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.TieZiContract;
import com.jiyun.yingyuxinyuan.model.bean.TieZiBean;
import com.jiyun.yingyuxinyuan.model.bean.ZuoPingBean;
import com.jiyun.yingyuxinyuan.model.biz.TieZiService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ASUS on 2018/05/13.
 */

public class TieZiPresenter implements TieZiContract.Presenter {
    TieZiService tieZiService;
    TieZiContract.View view;

    public TieZiPresenter() {
        tieZiService = RetrofitUtils.getInstance().getTieZiService();
    }

    @Override
    public void actualView(TieZiContract.View view) {
        this.view = view;
    }

    @Override
    public void unActualView() {
        this.view = null;
    }

    @Override
    public void loadData(String userId) {
        Map<String, String> map = new HashMap<>();
        map.put("loginUserId", userId);
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        Map<String, String> headers = new HashMap<>();
        headers.put("apptoken", token.getString("appToken", ""));
        tieZiService.getData(map, headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TieZiBean>() {
                    @Override
                    public void accept(TieZiBean tieZiBean) throws Exception {
                        String message = tieZiBean.getMessage();
                        if ("成功".equals(message)){
                            List<?> list = tieZiBean.getData().getArtcircleList().getList();
                            if (list != null && list.size() != 0){
                                view.showData(tieZiBean);
                            }else{
                                view.showErroe("暂无数据");
                            }
                        }else{
                            view.showErroe("请求失败");
                        }
                    }
                });
    }
}
