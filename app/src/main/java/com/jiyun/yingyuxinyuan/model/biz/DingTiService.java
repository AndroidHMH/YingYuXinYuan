package com.jiyun.yingyuxinyuan.model.biz;

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.DingTiBean;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginYzmBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by ASUS on 2018/05/10.
 */

public interface DingTiService {
        // 订单提醒
        @FormUrlEncoded
        @POST(Urls.DING_TI)
    Observable<DingTiBean> getDingTi(@FieldMap Map<String, String> params, @HeaderMap Map<String, String> headers);
}
