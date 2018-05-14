package com.jiyun.yingyuxinyuan.model.biz;

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.ZanBean;
import com.jiyun.yingyuxinyuan.model.bean.ZuoPingBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by ASUS on 2018/05/13.
 */

public interface ZuoPingService {
    //  我的作品
    @FormUrlEncoded
    @POST(Urls.ZUO_PING)
    Observable<ZuoPingBean> getData(@FieldMap Map<String, String> params, @HeaderMap Map<String, String> headers);
}
