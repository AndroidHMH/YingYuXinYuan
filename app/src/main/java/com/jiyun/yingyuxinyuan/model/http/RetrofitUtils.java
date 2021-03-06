package com.jiyun.yingyuxinyuan.model.http;

/**
 * Created by asus on 2018/5/3.
 */

import android.content.Context;
import android.content.SharedPreferences;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.config.EncryptUtil;
import com.jiyun.yingyuxinyuan.config.Urls;
import com.jiyun.yingyuxinyuan.model.bean.TokenBean;
import com.jiyun.yingyuxinyuan.model.biz.AppTokenService;
import com.jiyun.yingyuxinyuan.model.biz.ChangPswService;
import com.jiyun.yingyuxinyuan.model.biz.ChangePhoneService;
import com.jiyun.yingyuxinyuan.model.biz.ChangePswNextService;
import com.jiyun.yingyuxinyuan.model.biz.ChongCenterService;
import com.jiyun.yingyuxinyuan.model.biz.DetailsSystemAdsService;
import com.jiyun.yingyuxinyuan.model.biz.DianZanService;
import com.jiyun.yingyuxinyuan.model.biz.DingDanService;
import com.jiyun.yingyuxinyuan.model.biz.DingTiService;
import com.jiyun.yingyuxinyuan.model.biz.FenSiService;
import com.jiyun.yingyuxinyuan.model.biz.ForgetService;
import com.jiyun.yingyuxinyuan.model.biz.GuanMyService;
import com.jiyun.yingyuxinyuan.model.biz.GuanZhuService;
import com.jiyun.yingyuxinyuan.model.biz.HomeWorkWoService;
import com.jiyun.yingyuxinyuan.model.biz.HomeworkContentService;
import com.jiyun.yingyuxinyuan.model.biz.HomeworkService;
import com.jiyun.yingyuxinyuan.model.biz.JiaoYanService;
import com.jiyun.yingyuxinyuan.model.biz.LoginService;
import com.jiyun.yingyuxinyuan.model.biz.LookClassItemService;
import com.jiyun.yingyuxinyuan.model.biz.MingShiService;
import com.jiyun.yingyuxinyuan.model.biz.MySelfService;
import com.jiyun.yingyuxinyuan.model.biz.PingWoService;
import com.jiyun.yingyuxinyuan.model.biz.PreviewService;
import com.jiyun.yingyuxinyuan.model.biz.PswResService;
import com.jiyun.yingyuxinyuan.model.biz.ResginAllService;
import com.jiyun.yingyuxinyuan.model.biz.ResginService;
import com.jiyun.yingyuxinyuan.model.biz.SetHobbyService;
import com.jiyun.yingyuxinyuan.model.biz.ShouChangService;
import com.jiyun.yingyuxinyuan.model.biz.SingleService;
import com.jiyun.yingyuxinyuan.model.biz.StoreService;
import com.jiyun.yingyuxinyuan.model.biz.TeacherListItemService;
import com.jiyun.yingyuxinyuan.model.biz.TeacherService;
import com.jiyun.yingyuxinyuan.model.biz.TieZiService;
import com.jiyun.yingyuxinyuan.model.biz.TreasureItemContentService;
import com.jiyun.yingyuxinyuan.model.biz.TreasureService;
import com.jiyun.yingyuxinyuan.model.biz.UnivstarService;
import com.jiyun.yingyuxinyuan.model.biz.ZanService;
import com.jiyun.yingyuxinyuan.model.biz.ZuoPingService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit工具类
 */
public class RetrofitUtils {
    private static RetrofitUtils retrofitUtils;
    private Retrofit retrofit;

    private RetrofitUtils() {
        getAppToken();
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Urls.BASE_URL)
                .build();
    }

    public static RetrofitUtils getInstance() {
        if (retrofitUtils == null) {
            synchronized (RetrofitUtils.class) {
                if (retrofitUtils == null) {
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    public static void getAppToken() {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Urls.BASE_URL)
                .build();
        retrofit.create(AppTokenService.class)
                .loadToken("https://www.univstar.com/v1/m/security/apptoken")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TokenBean>() {
                    @Override
                    public void accept(TokenBean tokenBean) throws Exception {
                        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
                        String apptoken = tokenBean.getData().getApptoken();
                        long time = System.currentTimeMillis();
                        String decrypt = EncryptUtil.decrypt(apptoken);
                        String headerApptoken = EncryptUtil.encrypt(time + decrypt).replaceAll("\\n", "").toUpperCase();
                        SharedPreferences.Editor edit = token.edit();
                        String appToken = headerApptoken + "." + time;
                        edit.putString("appToken", appToken);
                        edit.commit();
                    }
                });
    }

    public TeacherService getTeacherService() {
        return retrofit.create(TeacherService.class);
    }

    public ResginService getResginService() {
        return retrofit.create(ResginService.class);
    }

    public ResginAllService getResginAllService() {
        return retrofit.create(ResginAllService.class);
    }

    public LoginService getLoginService() {
        return retrofit.create(LoginService.class);
    }

    public SetHobbyService getsetHobbyService() {
        return retrofit.create(SetHobbyService.class);
    }

    public HomeworkService getHomeworkService() {
        return retrofit.create(HomeworkService.class);
    }

    public TreasureService getTreasureService() {
        return retrofit.create(TreasureService.class);
    }

    public PreviewService getPreviewService() {
        return retrofit.create(PreviewService.class);
    }

    public ForgetService getForgetService() {
        return retrofit.create(ForgetService.class);
    }

    public PswResService getPswResService() {
        return retrofit.create(PswResService.class);
    }

    public TeacherListItemService getTeacherListItemService() {
        return retrofit.create(TeacherListItemService.class);
    }

    public LookClassItemService getLookClassItemService() {
        return retrofit.create(LookClassItemService.class);
    }

    public ChangePhoneService getChangePhoneService() {
        return retrofit.create(ChangePhoneService.class);
    }

    public DetailsSystemAdsService getDetailsSystemAdsService() {
        return retrofit.create(DetailsSystemAdsService.class);
    }

    public MingShiService getMingShiService() {
        return retrofit.create(MingShiService.class);
    }

    public HomeworkContentService getHomeworkContentService() {
        return retrofit.create(HomeworkContentService.class);
    }

    public TreasureItemContentService getTreasureItemContentService() {
        return retrofit.create(TreasureItemContentService.class);
    }

    public ChangPswService getChangPswService() {
        return retrofit.create(ChangPswService.class);
    }

    public ChangePswNextService getChangePswNextService() {
        return retrofit.create(ChangePswNextService.class);
    }

    public ChongCenterService getChongCenterService() {
        return retrofit.create(ChongCenterService.class);
    }
    public DingDanService getDingDanService() {
        return retrofit.create(DingDanService.class);
    }
    public GuanMyService getGuanMyService() {
        return retrofit.create(GuanMyService.class);
    }
    public HomeWorkWoService getHomeWorkWoService() {
        return retrofit.create(HomeWorkWoService.class);
    }
    public DingTiService getDingTiService() {
        return retrofit.create(DingTiService.class);
    }
    public PingWoService getPingService() {
        return retrofit.create(PingWoService.class);
    }
    public UnivstarService getUnivstarService() {
        return retrofit.create(UnivstarService.class);
    }
    public ZanService getZanService() {
        return retrofit.create(ZanService.class);
    }
    public JiaoYanService getJiaoYanService() {
        return retrofit.create(JiaoYanService.class);
    }
    public StoreService getStoreService(){ return retrofit.create(StoreService.class); }
    public ZuoPingService getZuoPingService(){return retrofit.create(ZuoPingService.class);}
    public TieZiService getTieZiService(){return retrofit.create(TieZiService.class);}
    public GuanZhuService getGuanZhuService(){return retrofit.create(GuanZhuService.class);}
    public FenSiService getFenSiService(){return retrofit.create(FenSiService.class);}
    public DianZanService getDianZanService() {
        return retrofit.create(DianZanService.class);
    }

    public ShouChangService getShouChangService() {
        return retrofit.create(ShouChangService.class);
    }

    public SingleService getSingleService() {
        return retrofit.create(SingleService.class);
    }

    public MySelfService getMySelfService() {
        return retrofit.create(MySelfService.class);
    }
}
