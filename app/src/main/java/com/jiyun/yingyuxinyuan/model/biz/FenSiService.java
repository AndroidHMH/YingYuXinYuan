package com.jiyun.yingyuxinyuan.model.biz;

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.FenSiBean;
import com.jiyun.yingyuxinyuan.model.bean.GuanZhuBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by ASUS on 2018/05/13.
 */

public interface FenSiService {
    //  我的粉丝
    @FormUrlEncoded
    @POST(Urls.FEN_SI)
    Observable<FenSiBean> getData(@FieldMap Map<String, String> params, @HeaderMap Map<String, String> headers);
}
