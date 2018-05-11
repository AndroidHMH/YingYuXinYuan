package com.jiyun.yingyuxinyuan.model.biz;

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.PingWoBean;
import com.jiyun.yingyuxinyuan.model.bean.ZanBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by ASUS on 2018/05/10.
 */

public interface PingWoService {
    // 评论我的
    @FormUrlEncoded
    @POST(Urls.PIN)
    Observable<PingWoBean> getPing(@FieldMap Map<String, String> params, @HeaderMap Map<String, String> headers);
}
