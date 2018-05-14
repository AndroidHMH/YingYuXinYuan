package com.jiyun.yingyuxinyuan.model.biz;

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.ShouChangBean;
import com.jiyun.yingyuxinyuan.ui.modular.shoucang.ShouChang;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by asus on 2018/5/12.
 */

public interface ShouChangService {
    @FormUrlEncoded
    @POST(Urls.SHOU_CHANG)
    Observable<ShouChangBean> shouChang(@Header("apptoken") String apptoken, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST(Urls.QU_XIAO_SHOU_CHANG)
    Observable<ShouChangBean> quXiaoShouChang(@Header("apptoken") String apptoken, @FieldMap Map<String, String> params);
}
