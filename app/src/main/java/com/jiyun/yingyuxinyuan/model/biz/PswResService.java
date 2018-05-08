package com.jiyun.yingyuxinyuan.model.biz;

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.ResPswBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by ASUS on 2018/05/08.
 */

public interface PswResService {
    @FormUrlEncoded
    @POST(Urls.RES_PSW)
    Observable<ResPswBean> resetPass(@FieldMap Map<String, String> params, @HeaderMap Map<String, String> headers);
}
