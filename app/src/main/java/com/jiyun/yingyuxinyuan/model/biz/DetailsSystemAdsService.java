package com.jiyun.yingyuxinyuan.model.biz;

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.DetailsSystemAdsBean;
import com.jiyun.yingyuxinyuan.model.bean.DetailsSystemAdsTwoBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by asus on 2018/5/8.
 */

public interface DetailsSystemAdsService {
    @FormUrlEncoded
    @POST(Urls.LUN_BO_TO_CLICK)
    Observable<DetailsSystemAdsBean> loadDate(@FieldMap Map<String, String> params, @HeaderMap Map<String, String> headers);

    @FormUrlEncoded
    @POST(Urls.LUN_BO_TO_CLICK_TWO)
    Observable<DetailsSystemAdsTwoBean> loadTypeDate(@FieldMap Map<String, String> params, @HeaderMap Map<String, String> headers);
}
