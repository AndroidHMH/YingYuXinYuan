package com.jiyun.yingyuxinyuan.config;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by asus on 2018/5/6.
 */

/**
 * 时间的工具类
 */
public class DateUtils {
    public static String getYYYYbyTimeStampMs(Long second) {
        String format = "yyyy-MM-dd HH:mm:ss";
        if (second == null || second == 0) {
            return "";
        }
        Date da = null;
        try {
            da = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse("1970-01-01 08:00:00");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Date date = new Date(da.getTime() + second);
        return (new SimpleDateFormat(format)).format(date);
    }
}
