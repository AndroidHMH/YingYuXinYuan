package com.jiyun.yingyuxinyuan.model.biz;

/**
 * Created by asus on 2018/5/3.
 */

import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.TreasureItemBean;
import com.jiyun.yingyuxinyuan.model.bean.TreasureRollPagerBean;
import com.jiyun.yingyuxinyuan.model.bean.TreasureTitleBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * 宝典页面的所有业务方法
 */
public interface TreasureService {
    @POST(Urls.TREASURE_TITLE)
    Observable<TreasureTitleBean> loadTitle(@HeaderMap Map<String, String> headers);

    @POST(Urls.TREASURE_ROLL_PAGER)
    Observable<TreasureRollPagerBean> loadRollPager(@HeaderMap Map<String, String> headers);

    @FormUrlEncoded
    @POST(Urls.TREASURES_HOME_PAGE)
    Observable<TreasureItemBean> loadItemBean(@FieldMap Map<String, String> params, @HeaderMap Map<String, String> headers);
}
