package com.jiyun.yingyuxinyuan.model.biz;

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.ChongCenterBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by asus on 2018/5/11.
 */

public interface ChongCenterService {
    @FormUrlEncoded
    @POST(Urls.CHONG_CENTER)
    Observable<ChongCenterBean> loadDate(@Field("loginUserId") String loginUserId, @Header("apptoken") String apptoken);
}
