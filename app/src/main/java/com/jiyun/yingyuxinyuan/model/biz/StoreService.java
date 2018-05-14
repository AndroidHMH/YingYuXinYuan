package com.jiyun.yingyuxinyuan.model.biz;

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.DingDanBean;
import com.jiyun.yingyuxinyuan.model.bean.StoreBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by ASUS on 2018/05/11.
 */

public interface StoreService {
    @FormUrlEncoded
    @POST(Urls.STORE)
    Observable<StoreBean> loadDate(@Header("apptoken") String apptoken, @FieldMap Map<String, String> params);

}
