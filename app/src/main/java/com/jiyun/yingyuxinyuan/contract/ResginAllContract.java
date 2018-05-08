package com.jiyun.yingyuxinyuan.contract;

/**
 * Created by ASUS on 2018/05/04.
 */

import android.net.Uri;

import com.jiyun.yingyuxinyuan.base.BasePresenter;

/**
 * 注册页面的契约类
 */
public interface ResginAllContract {
    interface ResginAllView {
        //男生按钮选中时
        void changeBoyBtn();

        //女生按钮选中时
        void changeGirlBtn();

        // 手机注册完善
        void showRhoneResginAllMessage(String msg);

        //跳转
        void gotoSetHobby();

        //跳转相册
        void gotoPhoto();
    }

    interface ResginAllPresenter extends BasePresenter<ResginAllView> {
        // 手机注册完善
        void getResginAll(String name, int sex, String phone, String password, String imgUrl);

        //判断密码
        boolean isPasw(String pasw);

        //上传头像
        void uploadImg(String imgUrl);

    }
}
