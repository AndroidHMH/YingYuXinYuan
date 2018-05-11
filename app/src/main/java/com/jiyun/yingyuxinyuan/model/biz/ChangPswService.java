package com.jiyun.yingyuxinyuan.model.biz;

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginYzmBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by asus on 2018/5/10.
 */

public interface ChangPswService {
    //    获取短信验证码
    @FormUrlEncoded
    @POST(Urls.PHONE_YZM)
    Observable<PhoneResginYzmBean> GetPhoneYzm(@FieldMap Map<String, String> params, @HeaderMap Map<String, String> headers);
}
