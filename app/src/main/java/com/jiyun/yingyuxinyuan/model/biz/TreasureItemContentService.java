package com.jiyun.yingyuxinyuan.model.biz;

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.TreasureItemContentBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * Created by asus on 2018/5/10.
 */

public interface TreasureItemContentService {
    @FormUrlEncoded
    @POST(Urls.BAO_DIAN_XIANG_QING)
    Observable<TreasureItemContentBean> loadDate(@HeaderMap Map<String, String> headers, @FieldMap Map<String, String> params);
}
