package com.jiyun.yingyuxinyuan.model.biz;

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.DingTiBean;
import com.jiyun.yingyuxinyuan.model.bean.GuanMyBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by ASUS on 2018/05/11.
 */

public interface GuanMyService {
    // 关注提醒
    @FormUrlEncoded
    @POST(Urls.GUAN_MY)
    Observable<GuanMyBean> getGuan(@FieldMap Map<String, String> params, @HeaderMap Map<String, String> headers);
}
