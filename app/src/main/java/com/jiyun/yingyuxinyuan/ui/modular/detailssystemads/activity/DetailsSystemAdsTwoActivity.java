package com.jiyun.yingyuxinyuan.ui.modular.detailssystemads.activity;

import android.content.Intent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.config.DateUtils;
import com.jiyun.yingyuxinyuan.contract.DetailsSystemAdsTwoContract;
import com.jiyun.yingyuxinyuan.model.bean.DetailsSystemAdsTwoBean;
import com.jiyun.yingyuxinyuan.ui.modular.detailssystemads.presenter.DetailsSystemAdsTwoPresenter;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 轮播图点击
 */
public class DetailsSystemAdsTwoActivity extends BaseActivity<DetailsSystemAdsTwoPresenter> implements DetailsSystemAdsTwoContract.View {

    @BindView(R.id.details_system_ads_two_img)
    ImageView detailsSystemAdsTwoImg;
    @BindView(R.id.details_system_ads_two_time_tv)
    TextView detailsSystemAdsTwoTimeTv;
    @BindView(R.id.details_system_ads_two_title_tv)
    TextView detailsSystemAdsTwoTitleTv;
    @BindView(R.id.details_system_ads_two_now_count_tv)
    TextView detailsSystemAdsTwoNowCountTv;
    @BindView(R.id.details_system_ads_two_all_count_tv)
    TextView detailsSystemAdsTwoAllCountTv;
    @BindView(R.id.details_system_ads_two_price_tv)
    TextView detailsSystemAdsTwoPriceTv;
    @BindView(R.id.details_system_ads_two_teacher_icon_img)
    RoundedImageView detailsSystemAdsTwoTeacherIconImg;
    @BindView(R.id.details_system_ads_two_teacher_name_tv)
    TextView detailsSystemAdsTwoTeacherNameTv;
    @BindView(R.id.details_system_ads_two_teacher_teach_tv)
    TextView detailsSystemAdsTwoTeacherTeachTv;
    @BindView(R.id.details_system_ads_two_guan_zhu_btn)
    Button detailsSystemAdsTwoGuanZhuBtn;
    @BindView(R.id.details_system_ads_two_web_view)
    WebView detailsSystemAdsTwoWebView;
    @BindView(R.id.details_system_ads_two_back_btn)
    ImageView detailsSystemAdsTwoBackBtn;
    @BindView(R.id.details_system_ads_two_share_btn)
    ImageView detailsSystemAdsTwoShareBtn;
    @BindView(R.id.details_system_ads_two_shouCang_btn)
    LinearLayout detailsSystemAdsTwoShouCangBtn;
    @BindView(R.id.details_system_ads_two_gou_mai_btn)
    TextView detailsSystemAdsTwoGouMaiBtn;
    private String mobileUrl;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_details_system_ads_two;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        mobileUrl = intent.getStringExtra("mobileUrl");
    }

    @Override
    protected void loadDate() {
        presenter.loadDate(mobileUrl);
    }

    @OnClick({R.id.details_system_ads_two_guan_zhu_btn, R.id.details_system_ads_two_back_btn, R.id.details_system_ads_two_share_btn, R.id.details_system_ads_two_shouCang_btn, R.id.details_system_ads_two_gou_mai_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.details_system_ads_two_guan_zhu_btn:

                break;
            case R.id.details_system_ads_two_back_btn:
                finish();
                break;
            case R.id.details_system_ads_two_share_btn:
                break;
            case R.id.details_system_ads_two_shouCang_btn:
                break;
            case R.id.details_system_ads_two_gou_mai_btn:
                break;
        }
    }

    @Override
    public void showDate(DetailsSystemAdsTwoBean detailsSystemAdsTwoBean) {
        DetailsSystemAdsTwoBean.DataBean data = detailsSystemAdsTwoBean.getData();
        Glide.with(this).load(data.getCoverImg()).into(detailsSystemAdsTwoImg);
        detailsSystemAdsTwoTimeTv.setText(DateUtils.getYYYYbyTimeStampMs(data.getStartDate()));
        detailsSystemAdsTwoNowCountTv.setText(data.getSubscribe() + "");
        detailsSystemAdsTwoAllCountTv.setText(data.getSubscribeNum() + "");
        detailsSystemAdsTwoPriceTv.setText(data.getPrice() + "");
        Glide.with(this).load(data.getPhoto()).asBitmap().placeholder(R.color.gray_prograss_bg)
                .error(R.color.gray_prograss_bg).dontAnimate().into(detailsSystemAdsTwoTeacherIconImg);
        detailsSystemAdsTwoTeacherNameTv.setText(data.getRealname());
        detailsSystemAdsTwoTeacherTeachTv.setText(data.getIntro());
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
