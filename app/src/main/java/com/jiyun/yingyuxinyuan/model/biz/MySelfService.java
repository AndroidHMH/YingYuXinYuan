package com.jiyun.yingyuxinyuan.model.biz;

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.MySelfBean;
import com.jiyun.yingyuxinyuan.model.bean.TieZiBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by asus on 2018/5/13.
 */

public interface MySelfService {
    @FormUrlEncoded
    @POST(Urls.MY_SELF)
    Observable<MySelfBean> loadDate(@Header("apptoken") String apptoken, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST(Urls.TIE_ZI)
    Observable<TieZiBean> loadTieZi(@Header("apptoken") String apptoken, @FieldMap Map<String, String> params);
}
