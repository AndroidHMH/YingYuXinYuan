package com.jiyun.yingyuxinyuan.ui.modular.detailssystemads.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
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
import com.jiyun.yingyuxinyuan.ui.modular.shoucang.ShouChang;
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
    @BindView(R.id.details_system_ads_two_shouCang_iv)
    ImageView detailsSystemAdsTwoShouCangIv;
    @BindView(R.id.details_system_ads_two_gou_mai_btn)
    TextView detailsSystemAdsTwoGouMaiBtn;
    private String mobileUrl;
    private int id;
    private int isFavorite;
    private int id150;
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

    private boolean click = false;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @OnClick({R.id.details_system_ads_two_guan_zhu_btn, R.id.details_system_ads_two_back_btn, R.id.details_system_ads_two_share_btn, R.id.details_system_ads_two_shouCang_btn, R.id.details_system_ads_two_gou_mai_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.details_system_ads_two_guan_zhu_btn:
                if (click) {
                    detailsSystemAdsTwoGuanZhuBtn.setText("关注");
                    detailsSystemAdsTwoGuanZhuBtn.setBackground(new ColorDrawable(Color.parseColor("#66535353")));
                    presenter.quXiao(id + "");
                    click = !click;
                } else {
                    detailsSystemAdsTwoGuanZhuBtn.setText("已关注");
                    detailsSystemAdsTwoGuanZhuBtn.setBackground(new ColorDrawable(Color.parseColor("#ff0000ff")));
                    presenter.guanZhu(id + "");
                    click = !click;
                }
                break;
            case R.id.details_system_ads_two_back_btn:
                finish();
                break;
            case R.id.details_system_ads_two_share_btn:
                break;
            case R.id.details_system_ads_two_shouCang_btn:
                if (0 == isFavorite){
                    presenter.shouCang(id150+"", ShouChang.TI_YAN_KE);
                    detailsSystemAdsTwoShouCangIv.setImageResource(R.mipmap.collect_active);
                    isFavorite = 1;
                }else{
                    presenter.quXiaoShou(id150+"", ShouChang.TI_YAN_KE);
                    detailsSystemAdsTwoShouCangIv.setImageResource(R.mipmap.collect_normal);
                    isFavorite = 0;
                }
                break;
            case R.id.details_system_ads_two_gou_mai_btn:
                break;
        }
    }

    @Override
    public void showDate(DetailsSystemAdsTwoBean detailsSystemAdsTwoBean) {
        DetailsSystemAdsTwoBean.DataBean data = detailsSystemAdsTwoBean.getData();
        id = data.getId();
        Glide.with(this).load(data.getCoverImg()).into(detailsSystemAdsTwoImg);
        detailsSystemAdsTwoTimeTv.setText(DateUtils.getYYYYbyTimeStampMs(data.getStartDate()));
        detailsSystemAdsTwoNowCountTv.setText(data.getSubscribe() + "");
        detailsSystemAdsTwoAllCountTv.setText(data.getSubscribeNum() + "");
        detailsSystemAdsTwoPriceTv.setText(data.getPrice() + "");
        Glide.with(this).load(data.getPhoto()).asBitmap().placeholder(R.color.gray_prograss_bg)
                .error(R.color.gray_prograss_bg).dontAnimate().into(detailsSystemAdsTwoTeacherIconImg);
        detailsSystemAdsTwoTeacherNameTv.setText(data.getRealname());
        detailsSystemAdsTwoTeacherTeachTv.setText(data.getIntro());
        isFavorite = data.getIsFavorite();
        if (0 == isFavorite){
            detailsSystemAdsTwoShouCangIv.setImageResource(R.mipmap.collect_normal);
        }else{
            detailsSystemAdsTwoShouCangIv.setImageResource(R.mipmap.collect_active);
        }
    }

    @Override
    public void showSuccess(String msg) {
        if ("关注成功".equals(msg)){
            detailsSystemAdsTwoGuanZhuBtn.setText("已关注");
            detailsSystemAdsTwoGuanZhuBtn.setBackground(new ColorDrawable(Color.parseColor("#66535353")));
        }else if ("取消关注成功".equals(msg)){
            detailsSystemAdsTwoGuanZhuBtn.setText("关注");
            detailsSystemAdsTwoGuanZhuBtn.setBackground(new ColorDrawable(Color.parseColor("#ff0000ff")));
        }else if ("收藏".equals(msg)){
            detailsSystemAdsTwoShouCangIv.setImageResource(R.mipmap.collect_active);
        }else {
            detailsSystemAdsTwoShouCangIv.setImageResource(R.mipmap.collect_normal);
        }
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
