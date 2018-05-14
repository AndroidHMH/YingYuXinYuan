package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.StoreBean;

/**
 * Created by ASUS on 2018/05/11.
 */

public interface StoreContract {
    interface View{
        void showData(StoreBean storeBean);
        void showError();
    }
    interface Presenter extends BasePresenter<StoreContract.View> {
        void showData(int type);
    }
}
