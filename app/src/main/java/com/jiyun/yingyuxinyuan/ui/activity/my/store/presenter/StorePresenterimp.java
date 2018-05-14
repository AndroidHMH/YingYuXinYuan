package com.jiyun.yingyuxinyuan.ui.activity.my.store.presenter;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.config.LoginShareUtils;
import com.jiyun.yingyuxinyuan.config.TokenUtils;
import com.jiyun.yingyuxinyuan.contract.StoreContract;
import com.jiyun.yingyuxinyuan.model.bean.DingDanBean;
import com.jiyun.yingyuxinyuan.model.bean.StoreBean;
import com.jiyun.yingyuxinyuan.model.biz.StoreService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ASUS on 2018/05/11.
 */

public class StorePresenterimp implements StoreContract.Presenter{
    StoreContract.View view;
    StoreService storeService;

    public StorePresenterimp() {
        storeService = RetrofitUtils.getInstance().getStoreService();
    }

    @Override
    public void actualView(StoreContract.View view) {
        this.view = view;
    }

    @Override
    public void unActualView() {
        this.view = null;
    }

    @Override
    public void showData(int type) {
        Map<String, String> params = new HashMap<>();
        params.put("loginUserId", LoginShareUtils.getUserMessage(App.context, LoginShareUtils.ID));
        params.put("type", Integer.toString(type));
        storeService.loadDate(TokenUtils.getToken(), params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<StoreBean>() {
                    @Override
                    public void accept(StoreBean storeBean) throws Exception {
                        String message = storeBean.getMessage();
                        if ("成功".equals(message)){
                            List<?> list = storeBean.getData().getList();
                            if (list != null && list.size() != 0){
                                view.showData(storeBean);
                            }
                            else {
                                view.showError();
                            }
                        }else {
                            view.showError();
                        }
                    }
                });
    }
}
