package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;

/**
 * Created by asus on 2018/5/13.
 */

public interface SingleContract {
    interface View {
        void returnActivity();
    }

    interface Presenter extends BasePresenter<View> {
        void sendChangeMsg(String type, String msg);
    }
}
