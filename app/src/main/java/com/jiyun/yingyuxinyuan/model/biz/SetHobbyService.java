package com.jiyun.yingyuxinyuan.model.biz;

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginYzmBean;
import com.jiyun.yingyuxinyuan.model.bean.SetHobbyBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by ASUS on 2018/05/04.
 */

public interface SetHobbyService {
    //    偏好设置
   @FormUrlEncoded
    @POST(Urls.SET_HOBBY)
    Observable<SetHobbyBean> GetData(@HeaderMap Map<String, String> headers);

    //    偏好设置
   @GET
    Observable<SetHobbyBean> GetDatae(@Url String url);
}
