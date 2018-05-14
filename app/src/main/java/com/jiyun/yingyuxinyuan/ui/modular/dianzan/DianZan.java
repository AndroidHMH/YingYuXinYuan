package com.jiyun.yingyuxinyuan.ui.modular.dianzan;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.config.LoginShareUtils;
import com.jiyun.yingyuxinyuan.config.TokenUtils;
import com.jiyun.yingyuxinyuan.model.bean.DianZanBean;
import com.jiyun.yingyuxinyuan.model.biz.DianZanService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asus on 2018/5/11.
 */

public class DianZan {
    private DianZanService dianZanService;
    public static final String YI_KAO_QUAN_ZUO_PIN = "艺考圈作品";
    public static final String XUE_SHENG_ZUO_PIN = "学生作业";
    public static final String YI_KAO_QUAN_PING_LUN = "艺考圈评论";
    public static final String LAO_SHI = "老师";
    public static final String YI_KAO_QUAN_HUI_FU = "艺考圈回复";
    public static final String ZUO_YE_PING_LUN = "作业评论";
    public static final String ZUO_YE_HUI_FU = "作业回复";

    public DianZan() {
        dianZanService = RetrofitUtils.getInstance().getDianZanService();
    }

    /**
     * 点赞
     *
     * @param userId 被点赞的用户ID
     * @param id     点赞的课程/评论 ID
     * @param type   点赞类型
     * @param result 回调
     */
    public void sendZan(String userId, String id, String type, final Result result) {
        Map<String, String> params = new HashMap<>();
        params.put("userId", userId);
        params.put("id", id);
        params.put("loginUserId", LoginShareUtils.getUserMessage(App.context, LoginShareUtils.ID));
        params.put("type", type);
        dianZanService.sendZan(TokenUtils.getToken(), params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DianZanBean>() {
                    @Override
                    public void accept(DianZanBean dianZanBean) throws Exception {
                        String message = dianZanBean.getMessage();
                        if ("成功".equals(message)) {
                            result.success(dianZanBean);
                        } else {
                            result.error("点赞失败");
                        }
                    }
                });
    }

    /**
     * 取消点赞
     *
     * @param userId 被点赞的用户ID
     * @param id     点赞的课程/评论 ID
     * @param type   点赞类型
     * @param result 回调
     */
    public void quXiaoZan(String userId, String id, String type, final Result result) {
        Map<String, String> params = new HashMap<>();
        params.put("userId", userId);
        params.put("id", id);
        params.put("loginUserId", LoginShareUtils.getUserMessage(App.context, LoginShareUtils.ID));
        params.put("type", type);
        dianZanService.quXiaoZan(TokenUtils.getToken(), params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DianZanBean>() {
                    @Override
                    public void accept(DianZanBean dianZanBean) throws Exception {
                        String message = dianZanBean.getMessage();
                        if ("成功".equals(message)) {
                            result.success(dianZanBean);
                        } else {
                            result.error("取消赞失败");
                        }
                    }
                });
    }

    public interface Result {
        void success(DianZanBean dianZanBean);

        void error(String msg);
    }
}
