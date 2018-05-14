package com.jiyun.yingyuxinyuan.ui.modular.shoucang;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.config.LoginShareUtils;
import com.jiyun.yingyuxinyuan.config.TokenUtils;
import com.jiyun.yingyuxinyuan.model.bean.GuanZhuBean;
import com.jiyun.yingyuxinyuan.model.bean.ShouChangBean;
import com.jiyun.yingyuxinyuan.model.biz.ShouChangService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asus on 2018/5/12.
 */

public class ShouChang {

    private ShouChangService shouChangService;
    public static final String TI_YAN_KE = "体验课";
    public static final String ZHI_BO_KE = "直播课";
    public static final String YI_KAO_QUAN_ZUO_PIN = "艺考圈作品";

    public ShouChang() {
        shouChangService = RetrofitUtils.getInstance().getShouChangService();
    }

    /**
     * 收藏
     *
     * @param id     收藏的课程ID
     * @param type   收藏类型 体验课 直播课 艺考圈作品
     * @param result 回调
     */
    public void shouChang(String id, String type, final Result result) {
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        params.put("loginUserId", LoginShareUtils.getUserMessage(App.context, LoginShareUtils.ID));
        params.put("type", type);
        shouChangService.shouChang(TokenUtils.getToken(), params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShouChangBean>() {
                    @Override
                    public void accept(ShouChangBean shouChangBean) throws Exception {
                        String message = shouChangBean.getMessage();
                        if ("成功".equals(message)) {
                            result.success(shouChangBean);
                        } else {
                            result.error("请求失败");
                        }
                    }
                });
    }

    /**
     * 取消收藏
     *
     * @param id     收藏的课程ID
     * @param type   收藏类型 体验课 直播课 艺考圈作品
     * @param result 回调
     */
    public void quXiaoShouChang(String id, String type, final Result result) {
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        params.put("loginUserId", LoginShareUtils.getUserMessage(App.context, LoginShareUtils.ID));
        params.put("type", type);
        shouChangService.quXiaoShouChang(TokenUtils.getToken(), params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShouChangBean>() {
                    @Override
                    public void accept(ShouChangBean shouChangBean) throws Exception {
                        String message = shouChangBean.getMessage();
                        if ("成功".equals(message)) {
                            result.success(shouChangBean);
                        } else {
                            result.error("取消失败");
                        }
                    }
                });
    }

    public interface Result {
        void success(ShouChangBean shouChangBean);

        void error(String msg);
    }
}
