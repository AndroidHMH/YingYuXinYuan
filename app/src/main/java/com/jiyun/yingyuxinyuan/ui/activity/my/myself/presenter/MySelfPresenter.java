package com.jiyun.yingyuxinyuan.ui.activity.my.myself.presenter;

import com.jiyun.yingyuxinyuan.config.TokenUtils;
import com.jiyun.yingyuxinyuan.contract.MySelfContract;
import com.jiyun.yingyuxinyuan.model.bean.MySelfBean;
import com.jiyun.yingyuxinyuan.model.bean.TieZiBean;
import com.jiyun.yingyuxinyuan.model.biz.MySelfService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asus on 2018/5/13.
 */

public class MySelfPresenter implements MySelfContract.Presenter {
    private MySelfContract.View view;
    private MySelfService mySelfService;

    public MySelfPresenter() {
        mySelfService = RetrofitUtils.getInstance().getMySelfService();
    }

    @Override
    public void actualView(MySelfContract.View view) {
        this.view = view;
    }

    @Override
    public void unActualView() {
        this.view = null;
    }

    @Override
    public void loadDate(String studentId) {
        Map<String, String> params = new HashMap<>();
        params.put("studentId", studentId);
        mySelfService.loadDate(TokenUtils.getToken(), params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MySelfBean>() {
                    @Override
                    public void accept(MySelfBean mySelfBean) throws Exception {
                        String message = mySelfBean.getMessage();
                        if ("成功".equals(message)) {
                            MySelfBean.DataBean data = mySelfBean.getData();
                            view.showUserDate(data.getUserInfo());
                            List<?> list = data.getHomewokList().getList();
                            if (list != null && list.size() != 0) {
                                view.showZuoPin(data.getHomewokList());
                            } else {
                                view.showError("暂无数据");
                            }
                        } else {
                            view.showError("请求失败");
                        }
                    }
                });
    }

    @Override
    public void loadTieZi(String studentId) {
        Map<String, String> params = new HashMap<>();
        params.put("studentId", studentId);
        mySelfService.loadTieZi(TokenUtils.getToken(), params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TieZiBean>() {
                    @Override
                    public void accept(TieZiBean tieZiBean) throws Exception {
                        String message = tieZiBean.getMessage();
                        if ("成功".equals(message)) {
                            List<TieZiBean.DataBean.ArtcircleListBean.ListBean> list = tieZiBean.getData().getArtcircleList().getList();
                            if (list != null && list.size() != 0) {
                                view.showTieZi(list);
                            } else {
                                view.showTieZiError("暂无数据");
                            }
                        } else {
                            view.showTieZiError("请求失败");
                        }
                    }
                });
    }
}
