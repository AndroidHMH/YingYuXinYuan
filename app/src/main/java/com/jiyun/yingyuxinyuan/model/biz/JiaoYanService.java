package com.jiyun.yingyuxinyuan.model.biz;

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.YanZhengBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by asus on 2018/5/11.
 */

public interface JiaoYanService {
    @FormUrlEncoded
    @POST(Urls.YAN_ZHENG)
    Observable<YanZhengBean> yanZheng(@Header("apptaken") String apptaken, @FieldMap Map<String, String> params);
}
