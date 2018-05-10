package com.jiyun.yingyuxinyuan.model.biz;

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.LoginBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by ASUS on 2018/05/04.
 */

public interface LoginService {
//   登录
    @FormUrlEncoded
    @POST(Urls.LOGIN)
    Observable<LoginBean> GetLogin(@FieldMap Map<String, String> params, @HeaderMap Map<String, String> headers);

}
