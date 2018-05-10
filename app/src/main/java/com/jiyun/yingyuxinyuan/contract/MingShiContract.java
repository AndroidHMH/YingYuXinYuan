package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.MingShiBean;

/**
 * Created by asus on 2018/5/9.
 */

public interface MingShiContract {
    interface View {
        void showDate(MingShiBean mingShiBean);

        void showError(String msg);
    }

    interface Presenter extends BasePresenter<View> {
        void loadDate(String id);
    }
}
