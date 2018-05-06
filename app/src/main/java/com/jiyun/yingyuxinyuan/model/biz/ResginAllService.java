package com.jiyun.yingyuxinyuan.model.biz;

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginAllBean;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginBean;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginYzmBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by ASUS on 2018/05/04.
 */

public interface ResginAllService {
//    手机号注册完善（密码）
    @FormUrlEncoded
    @POST(Urls.PHONE_RESGIN_ALL)
    Observable<ResponseBody> GetPhoneResginAll(@FieldMap Map<String, String> params, @FieldMap Map<String, String> headers);

}
