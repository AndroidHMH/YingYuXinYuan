package com.jiyun.yingyuxinyuan.model.biz;

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.TeacherListBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by asus on 2018/5/8.
 */

public interface TeacherListItemService {
    @FormUrlEncoded
    @POST(Urls.TEACHER_LIST_DATE)
    Observable<TeacherListBean> loadDate(@HeaderMap Map<String, String> header, @FieldMap Map<String, String> params);
}
