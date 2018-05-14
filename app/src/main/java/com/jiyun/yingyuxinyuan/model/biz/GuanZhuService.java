package com.jiyun.yingyuxinyuan.model.biz;

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.FenSiBean;
import com.jiyun.yingyuxinyuan.model.bean.GuanZhuBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by asus on 2018/5/11.
 */

public interface GuanZhuService {

    @FormUrlEncoded
    @POST(Urls.GUAN_ZHU)
    Observable<GuanZhuBean> guanZhu(@Header("apptoken") String apptoken, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST(Urls.QU_XIAO_GUAN_ZHU)
    Observable<GuanZhuBean> quXiao(@Header("apptoken") String apptoken, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST(Urls.GUAN_ZHU_MY)
    Observable<GuanZhuBean> getData(@FieldMap Map<String, String> params, @HeaderMap Map<String, String> headers);

}
