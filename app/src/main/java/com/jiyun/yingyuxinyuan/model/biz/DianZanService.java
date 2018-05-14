package com.jiyun.yingyuxinyuan.model.biz;

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.DianZanBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by asus on 2018/5/11.
 */

public interface DianZanService {

    @FormUrlEncoded
    @POST(Urls.DIAN_ZAN)
    Observable<DianZanBean> sendZan(@Header("apptoken") String apptoken, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST(Urls.QU_XIAO_ZAN)
    Observable<DianZanBean> quXiaoZan(@Header("apptoken") String apptoken, @FieldMap Map<String, String> params);
}
