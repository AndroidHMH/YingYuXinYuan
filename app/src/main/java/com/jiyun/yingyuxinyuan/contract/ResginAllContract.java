package com.jiyun.yingyuxinyuan.contract;

/**
 * Created by ASUS on 2018/05/04.
 */

import com.jiyun.yingyuxinyuan.base.BasePresenter;

/**
 * 注册页面的契约类
 */
public interface ResginAllContract {
    interface ResginAllView{
//        手机注册完善
        void showRhoneResginAllMessage(String msg);
    }
    interface  ResginAllPresenter extends BasePresenter<ResginAllView>{
//        手机注册完善
        void getResginAll(String password);
    }
}
