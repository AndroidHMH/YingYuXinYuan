package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;

/**
 * Created by asus on 2018/5/10.
 */

public interface ChangpswContract {
    interface View {
        void showError(String msg);

        void startTime();

        void next();
    }

    interface Presenter extends BasePresenter<View> {
        void getYanZheng(String phone);

        boolean isPhone(String phone);
    }
}
