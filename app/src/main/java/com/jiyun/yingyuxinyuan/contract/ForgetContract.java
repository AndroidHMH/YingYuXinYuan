package com.jiyun.yingyuxinyuan.contract;

/**
 * Created by ASUS on 2018/05/04.
 */

import com.jiyun.yingyuxinyuan.base.BasePresenter;

/**
 * 注册页面的契约类
 */
public interface ForgetContract {
    interface ForgetView{
//        获取手机验证码
        void showPhoneYzmMessage(String msg);

        void startTime();
    }
    interface  ForgetPresenter extends BasePresenter<ForgetView>{
//        手机验证码
        void getPhoneCode(String phone);
        boolean isPhone(String phone);
    }
}
