package com.jiyun.yingyuxinyuan.model.biz;

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.HomeworkContentBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by asus on 2018/5/9.
 */

public interface HomeworkContentService {
    @FormUrlEncoded
    @POST(Urls.ZUO_YE_TUIJIAN)
    Observable<HomeworkContentBean> loadDate(@FieldMap Map<String, String> params, @HeaderMap Map<String, String> headers);
}