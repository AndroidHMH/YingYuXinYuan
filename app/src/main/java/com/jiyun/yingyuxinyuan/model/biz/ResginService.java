package com.jiyun.yingyuxinyuan.model.biz;

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginAllBean;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginBean;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginYzmBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by ASUS on 2018/05/04.
 */

public interface ResginService {
//    获取短信验证码
    @FormUrlEncoded
    @POST(Urls.PHONE_YZM)
    Observable<PhoneResginYzmBean> GetPhoneYzm(@FieldMap Map<String, String> params, @HeaderMap Map<String, String> headers);
//    手机号注册
    @FormUrlEncoded
    @POST(Urls.PHONE_RESGIN)
    Observable<PhoneResginBean> GetPhoneResin(@FieldMap Map<String,String> params,@FieldMap Map<String,String> headers);
//    手机号注册完善（密码）
    @FormUrlEncoded
    @POST(Urls.PHONE_RESGIN_ALL)
    Observable<PhoneResginAllBean> GetPhoneResginAll(@FieldMap Map<String,String> params,@FieldMap Map<String,String> headers);

}
