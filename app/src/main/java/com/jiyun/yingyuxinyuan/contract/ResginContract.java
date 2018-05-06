package com.jiyun.yingyuxinyuan.contract;

/**
 * Created by ASUS on 2018/05/04.
 */

import com.jiyun.yingyuxinyuan.base.BasePresenter;

/**
 * 注册页面的契约类
 */
public interface ResginContract {
    interface ResginView{
//        获取手机验证码
        void showPhoneYzmMessage(String msg);
//        手机注册
        void showPhoneResginMessage(String msg);
    }
    interface  ResginPresenter extends BasePresenter<ResginView>{
//        手机验证码
        void getPhoneCode(String phone);
//        手机注册
        void getResgin(String phone,String phoneyzm);
    }
   /*interface  ResginPresenter{
       //        手机验证码
       void getPhoneCode(String phone);
       //        手机注册
       void getResgin(String phone,String phoneyzm);
       //        手机注册完善
       void getResginAll(String password);
   }*/
}
