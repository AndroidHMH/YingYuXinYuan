package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.ChangePhoneBean;

/**
 * Created by ASUS on 2018/05/09.
 */

public interface ChangePhoneContract {
    interface ChangeView{
        //获取手机验证码
        void showNewPhoneYzmMessage(String msg);
        //倒计时
        void startTime();

        void gotoNext(ChangePhoneBean changePhoneBean);

        void next();
    }
    interface ChangePresenter extends BasePresenter<ChangeView> {
        void getChangeYzm(String phone);

        void gotoNext(String phone, String changezym);

        boolean isPhone(String phone);

        boolean isYzm(String changeyzm);
    }
}
