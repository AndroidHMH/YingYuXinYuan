package com.jiyun.yingyuxinyuan.model.biz;

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.HomeWorkWoBean;
import com.jiyun.yingyuxinyuan.model.bean.PingWoBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by ASUS on 2018/05/10.
 */

public interface HomeWorkWoService {
    // 作业提醒
    @FormUrlEncoded
    @POST(Urls.HOME_WORK_MY)
    Observable<HomeWorkWoBean> getHomeWorkWo(@FieldMap Map<String, String> params, @HeaderMap Map<String, String> headers);
}
