package com.jiyun.yingyuxinyuan.ui.modular.guanzhu;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.config.LoginShareUtils;
import com.jiyun.yingyuxinyuan.config.TokenUtils;
import com.jiyun.yingyuxinyuan.model.bean.DianZanBean;
import com.jiyun.yingyuxinyuan.model.bean.GuanZhuBean;
import com.jiyun.yingyuxinyuan.model.biz.GuanZhuService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by asus on 2018/5/11.
 */

public class GuanZhu {
    private GuanZhuService guanZhuService;

    public GuanZhu() {
        guanZhuService = RetrofitUtils.getInstance().getGuanZhuService();
    }

    /**
     * 关注
     *
     * @param attentionId 被关注者的用户 id
     * @param result      回调
     */
    public void guanZhu(String attentionId, final Result result) {
        Map<String, String> params = new HashMap<>();
        params.put("attentionId", attentionId);
        params.put("loginUserId", LoginShareUtils.getUserMessage(App.context, LoginShareUtils.ID));
        guanZhuService.guanZhu(TokenUtils.getToken(), params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GuanZhuBean>() {
                    @Override
                    public void accept(GuanZhuBean guanZhuBean) throws Exception {
                        String message = guanZhuBean.getMessage();
                        if ("成功".equals(message)) {
                            result.success(guanZhuBean);
                        } else {
                            result.error("关注失败");
                        }
                    }
                });
    }

    /**
     * 关注
     *
     * @param attentionId 被关注者的用户 id
     * @param result      回调
     */
    public void quXiao(String attentionId, final Result result) {
        Map<String, String> params = new HashMap<>();
        params.put("attentionId", attentionId);
        params.put("loginUserId", LoginShareUtils.getUserMessage(App.context, LoginShareUtils.ID));
        guanZhuService.quXiao(TokenUtils.getToken(), params)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GuanZhuBean>() {
                    @Override
                    public void accept(GuanZhuBean guanZhuBean) throws Exception {
                        String message = guanZhuBean.getMessage();
                        if ("成功".equals(message)) {
                            result.success(guanZhuBean);
                        } else {
                            result.error("取消失败");
                        }
                    }
                });
    }


    public interface Result {
        void success(GuanZhuBean guanZhuBean);

        void error(String msg);
    }
}
