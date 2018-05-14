package com.jiyun.yingyuxinyuan.model.biz;

import com.jiyun.yingyuxinyuan.config.Urls;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by asus on 2018/5/13.
 */

public interface SingleService {

    @FormUrlEncoded
    @POST(Urls.CHANGE_MSG)
    Observable<ResponseBody> sendChangeMsg(@Header("apptoken") String apptoken, @FieldMap Map<String, String> params);
}
