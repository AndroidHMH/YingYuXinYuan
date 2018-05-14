package com.jiyun.yingyuxinyuan.config;

import android.content.Context;
import android.content.SharedPreferences;

import com.jiyun.yingyuxinyuan.model.bean.UserBean;

import java.util.ArrayList;

/**
 * Created by ASUS on 2018/05/08.
 */

public class LoginShareUtils {
    public static final String NICKNAME = "nickname";
    public static final String MOBILE = "mobile";
    public static final String ID = "id";
    public static final String SEX = "sex";
    public static final String BIRTHDAY = "birthday";
    public static final String PHOTO = "photo";
    public static final String ADDRESS = "address";

    /**
     * 登录成功返回的用户数据
     *
     * @param context
     * @param dataBean
     */
    public static void UserMessage(Context context, UserBean.DataBean dataBean) {
        SharedPreferences loginPreferences = context.getSharedPreferences("Login", context.MODE_PRIVATE);
        SharedPreferences.Editor edit = loginPreferences.edit();
//            如果成功，将用户返回的所有信息进行保存
        edit.putString("nickname", dataBean.getNickname());
        edit.putString("photo", dataBean.getPhoto());
        edit.putString("id", dataBean.getId() + "");
        edit.putString("sex", dataBean.getSex() + "");
        edit.putString("birthday", dataBean.getBirthday() + "");
        edit.putString("mobile", dataBean.getMobile());
        Object address = dataBean.getAddress();
        if (address == null) {
            edit.putString("address", "");
        } else {
            edit.putString("address", (String) address);
        }
        edit.commit();
    }

    public static String getUserMessage(Context context, String key) {
        SharedPreferences loginPreferences = context.getSharedPreferences("Login", context.MODE_PRIVATE);
        return loginPreferences.getString(key, "未获取到值");
    }

    public static void setUserMessage(Context context, String key, String value) {
        SharedPreferences loginPreferences = context.getSharedPreferences("Login", context.MODE_PRIVATE);
        SharedPreferences.Editor edit = loginPreferences.edit();
        edit.putString(key, value);
        edit.commit();
    }

    public static void tuiChu(Context context) {
        SharedPreferences loginPreferences = context.getSharedPreferences("Login", context.MODE_PRIVATE);
        SharedPreferences.Editor edit = loginPreferences.edit();
        edit.clear();
        edit.commit();
    }
}
