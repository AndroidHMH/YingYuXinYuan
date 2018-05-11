package com.jiyun.yingyuxinyuan.config;

import android.content.Context;
import android.content.SharedPreferences;

import com.jiyun.yingyuxinyuan.app.App;

/**
 * Created by asus on 2018/5/11.
 */

public class TokenUtils {
    public static String getToken() {
        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        return token.getString("appToken", "");
    }
}
