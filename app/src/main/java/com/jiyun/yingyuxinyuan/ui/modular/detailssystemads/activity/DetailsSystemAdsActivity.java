package com.jiyun.yingyuxinyuan.ui.modular.detailssystemads.activity;

import android.content.Intent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.config.DateUtils;
import com.jiyun.yingyuxinyuan.contract.DetailsSystemAdsContract;
import com.jiyun.yingyuxinyuan.model.bean.DetailsSystemAdsBean;
import com.jiyun.yingyuxinyuan.ui.modular.detailssystemads.presenter.DetailsSystemAdsPresenter;
import com.jiyun.yingyuxinyuan.ui.modular.shoucang.ShouChang;


import butterknife.BindView;
import butterknife.OnClick;

/**
 * 轮播图点击
 */
public class DetailsSystemAdsActivity extends BaseActivity<DetailsSystemAdsPresenter> implements DetailsSystemAdsContract.View {

    @BindView(R.id.details_system_ads_back_btn)
    ImageView detailsSystemAdsBackBtn;
    @BindView(R.id.details_system_ads_share_btn)
    ImageView detailsSystemAdsShareBtn;
    @BindView(R.id.details_system_ads_img)
    ImageView detailsSystemAdsImg;
    @BindView(R.id.details_system_ads_time_tv)
    TextView detailsSystemAdsTimeTv;
    @BindView(R.id.details_system_ads_title_tv)
    TextView detailsSystemAdsTitleTv;
    @BindView(R.id.details_system_ads_now_count_tv)
    TextView detailsSystemAdsNowCountTv;
    @BindView(R.id.details_system_ads_all_count_tv)
    TextView detailsSystemAdsAllCountTv;
    @BindView(R.id.details_system_ads_price_tv)
    TextView detailsSystemAdsPriceTv;
    @BindView(R.id.details_system_ads_web_view)
    WebView detailsSystemAdsWebView;
    @BindView(R.id.details_system_ads_shouCang_btn)
    LinearLayout detailsSystemAdsShouCangBtn;
    @BindView(R.id.details_system_ada_shouCang_iv)
    ImageView detailsSystemAdsShouCangIv;
    @BindView(R.id.details_system_ads_zi_xun_btn)
    TextView detailsSystemAdsZiXunBtn;
    @BindView(R.id.details_system_ads_gou_mai_btn)
    TextView detailsSystemAdsGouMaiBtn;
    @BindView(R.id.details_system_ads_address_tv)
    TextView detailsSystemAdsAddressTv;
    private String mobileUrl;
    private String urlType;
    private int favorite;
    private int id150;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_details_system_ads;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        mobileUrl = intent.getStringExtra("mobileUrl");
        WebSettings webSettings = detailsSystemAdsWebView.getSettings();
        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
        // 若加载的 html 里有JS 在执行动画等操作，会造成资源浪费（CPU、电量）
        // 在 onStop 和 onResume 里分别把 setJavaScriptEnabled() 给设置成 false 和 true 即可
        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小

        //缩放操作
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件

        //其他细节操作
        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式

    }

    @Override
    protected void loadDate() {
        presenter.loadDate(mobileUrl);
    }

    @OnClick({R.id.details_system_ads_back_btn, R.id.details_system_ads_share_btn, R.id.details_system_ads_shouCang_btn, R.id.details_system_ads_zi_xun_btn, R.id.details_system_ads_gou_mai_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.details_system_ads_back_btn:
                finish();
                break;
            case R.id.details_system_ads_share_btn:
                break;
            case R.id.details_system_ads_shouCang_btn:
                if (0 == favorite){
                    presenter.shouCang(id150+"", ShouChang.ZHI_BO_KE);
                    detailsSystemAdsShouCangIv.setImageResource(R.mipmap.collect_active);
                    favorite = 1;
                }else{
                    presenter.quXiaoStore(id150+"", ShouChang.ZHI_BO_KE);
                    detailsSystemAdsShouCangIv.setImageResource(R.mipmap.collect_normal);
                    favorite = 0;
                }
                break;
            case R.id.details_system_ads_zi_xun_btn:
                break;
            case R.id.details_system_ads_gou_mai_btn:
                break;
        }
    }

    @Override
    public void showDate(DetailsSystemAdsBean detailsSystemAdsBean) {
        DetailsSystemAdsBean.DataBean data = detailsSystemAdsBean.getData();
        detailsSystemAdsAddressTv.setText(data.getAddress());
        detailsSystemAdsAllCountTv.setText(data.getSubscribeNum() + "");
        detailsSystemAdsNowCountTv.setText(data.getReservationNum() + "");
        detailsSystemAdsTimeTv.setText(DateUtils.getYYYYbyTimeStampMs(data.getStartDate()));
        detailsSystemAdsPriceTv.setText(data.getPrice() + "");
        Glide.with(this).load(data.getCoverImg()).into(detailsSystemAdsImg);
//        http://share.univstar.com/view/course.html?courseid=
        detailsSystemAdsWebView.loadUrl("http://share.univstar.com/view/course.html?courseid=" + mobileUrl);
//        detailsSystemAdsWebView.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return super.shouldOverrideUrlLoading(view, url);
//            }
//        });
        favorite = data.getFavorite();
        if (0 == favorite){
            detailsSystemAdsShouCangIv.setImageResource(R.mipmap.collect_normal);
        }else{
            detailsSystemAdsShouCangIv.setImageResource(R.mipmap.collect_active);
        }
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void sucess(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void error(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
