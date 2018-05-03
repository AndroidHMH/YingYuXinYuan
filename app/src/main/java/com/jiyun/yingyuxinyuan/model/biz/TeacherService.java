package com.jiyun.yingyuxinyuan.model.biz;

/**
 * Created by asus on 2018/5/3.
 */

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.TeacherHomePageBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * 名师页面的所有业务方法
 */
public interface TeacherService {
    @FormUrlEncoded
    @POST(Urls.TEACHER_HOME_PAGE)
    Observable<TeacherHomePageBean> loadHomePage(@FieldMap Map<String, String> params, @HeaderMap Map<String, String> headers);
}
