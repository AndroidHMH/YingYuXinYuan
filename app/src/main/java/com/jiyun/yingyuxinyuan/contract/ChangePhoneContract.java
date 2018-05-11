package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.ChangePhoneBean;

/**
 * Created by ASUS on 2018/05/09.
 */

public interface ChangePhoneContract {
    interface ChangeView {
        //获取手机验证码
        void showNewPhoneYzmMessage(String msg);

        //倒计时
        void startTime();

        void showError(String msg);

        void next();
    }

    interface ChangePresenter extends BasePresenter<ChangeView> {
        void getChangeYzm(String phone);


        boolean isPhone(String phone);

    }
}
