package com.jiyun.yingyuxinyuan.model.biz;

import android.database.Observable;

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.ResPswBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by ASUS on 2018/05/09.
 */

public interface UserNewService {
    @FormUrlEncoded
    @POST(Urls.USER_NEW)
    Observable<ResPswBean> postUserInfo(@Field("id") Integer id,
                                                     @Field("nickname") String nickname,
                                                     @Field("realname") String realname,
                                                     @Field("photo") String photo,
                                                     @Field("images") String images,
                                                     @Field("intro") String intro,
                                                     @Field("details") String details,
                                                     @Field("sex") int sex,
                                                     @Field("birthday") String birthday,
                                                     @Field("address") String address);
}
