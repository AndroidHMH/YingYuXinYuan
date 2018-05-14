package com.jiyun.yingyuxinyuan.model.biz;

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.TieZiBean;
import com.jiyun.yingyuxinyuan.model.bean.ZuoPingBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by ASUS on 2018/05/13.
 */

public interface TieZiService {
    //  我的帖子
    @FormUrlEncoded
    @POST(Urls.TIE_ZI_MY)
    Observable<TieZiBean> getData(@FieldMap Map<String, String> params, @HeaderMap Map<String, String> headers);
}
