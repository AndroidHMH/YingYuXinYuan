package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;

/**
 * Created by asus on 2018/5/10.
 */

public interface ChangePhoneNextContract {
    interface View {
        void showError(String msg);

        void startTime();

        void success();
    }

    interface Presenter extends BasePresenter<View> {
        void loadYanZheng(String phone);

        boolean isPhone(String phone);

        void changePhone(String phone, String yanZheng);

        boolean isYan(String yanZheng);
    }
}
