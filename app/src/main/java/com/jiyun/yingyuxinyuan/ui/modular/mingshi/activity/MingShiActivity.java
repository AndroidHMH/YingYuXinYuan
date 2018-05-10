package com.jiyun.yingyuxinyuan.ui.modular.mingshi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.contract.MingShiContract;
import com.jiyun.yingyuxinyuan.model.bean.MingShiBean;
import com.jiyun.yingyuxinyuan.ui.modular.mingshi.persenter.MingShiPresenter;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MingShiActivity extends BaseActivity<MingShiPresenter> implements MingShiContract.View {

    @BindView(R.id.ming_shi_img)
    ImageView mingShiImg;
    @BindView(R.id.ming_shi_zan_img)
    ImageView mingShiZanImg;
    @BindView(R.id.ming_shi_zan_tv)
    TextView mingShiZanTv;
    @BindView(R.id.ming_shi_zan_btn)
    LinearLayout mingShiZanBtn;
    @BindView(R.id.ming_shi_teacher_icon_img)
    RoundedImageView mingShiTeacherIconImg;
    @BindView(R.id.ming_shi_teacher_name_tv)
    TextView mingShiTeacherNameTv;
    @BindView(R.id.ming_shi_teacher_teach_tv)
    TextView mingShiTeacherTeachTv;
    @BindView(R.id.ming_shi_guan_zhu_btn)
    Button mingShiGuanZhuBtn;
    @BindView(R.id.ming_shi_class_num_tv)
    TextView mingShiClassNumTv;
    @BindView(R.id.ming_shi_class_num_btn)
    LinearLayout mingShiClassNumBtn;
    @BindView(R.id.ming_shi_homework_num_tv)
    TextView mingShiHomeworkNumTv;
    @BindView(R.id.ming_shi_homework_num_btn)
    LinearLayout mingShiHomeworkNumBtn;
    @BindView(R.id.ming_shi_fu_dao_num_tv)
    TextView mingShiFuDaoNumTv;
    @BindView(R.id.ming_shi_fu_dao_num_btn)
    LinearLayout mingShiFuDaoNumBtn;
    @BindView(R.id.ming_shi_tie_zi_num_tv)
    TextView mingShiTieZiNumTv;
    @BindView(R.id.ming_shi_tie_zi_num_btn)
    LinearLayout mingShiTieZiNumBtn;
    @BindView(R.id.ming_shi_guan_zhu_num_tv)
    TextView mingShiGuanZhuNumTv;
    @BindView(R.id.ming_shi_guan_zhu_num_btn)
    LinearLayout mingShiGuanZhuNumBtn;
    @BindView(R.id.ming_shi_fen_si_num_tv)
    TextView mingShiFenSiNumTv;
    @BindView(R.id.ming_shi_fen_si_num_btn)
    LinearLayout mingShiFenSiNumBtn;
    @BindView(R.id.ming_shi_content_tv)
    TextView mingShiContentTv;
    @BindView(R.id.ming_shi_back_btn)
    ImageView mingShiBackBtn;
    @BindView(R.id.ming_shi_share_btn)
    ImageView mingShiShareBtn;
    @BindView(R.id.ming_shi_fu_dao_btn)
    LinearLayout mingShiFuDaoBtn;
    private int id;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ming_shi;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
    }

    @Override
    protected void loadDate() {
        if (id != -1) {
            presenter.loadDate(String.valueOf(id));
        }
    }

    @OnClick({R.id.ming_shi_zan_btn, R.id.ming_shi_guan_zhu_btn, R.id.ming_shi_class_num_btn, R.id.ming_shi_homework_num_btn, R.id.ming_shi_fu_dao_num_btn, R.id.ming_shi_tie_zi_num_btn, R.id.ming_shi_guan_zhu_num_btn, R.id.ming_shi_fen_si_num_btn, R.id.ming_shi_back_btn, R.id.ming_shi_share_btn, R.id.ming_shi_fu_dao_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ming_shi_zan_btn:
                break;
            case R.id.ming_shi_guan_zhu_btn:
                break;
            case R.id.ming_shi_class_num_btn:
                break;
            case R.id.ming_shi_homework_num_btn:
                break;
            case R.id.ming_shi_fu_dao_num_btn:
                break;
            case R.id.ming_shi_tie_zi_num_btn:
                break;
            case R.id.ming_shi_guan_zhu_num_btn:
                break;
            case R.id.ming_shi_fen_si_num_btn:
                break;
            case R.id.ming_shi_back_btn:
                finish();
                break;
            case R.id.ming_shi_share_btn:
                break;
            case R.id.ming_shi_fu_dao_btn:
                break;
        }
    }

    @Override
    public void showDate(MingShiBean mingShiBean) {
        MingShiBean.DataBean.UserBean user = mingShiBean.getData().getUser();
        MingShiBean.DataBean data = mingShiBean.getData();
        MingShiBean.DataBean.PraiseBean praise = mingShiBean.getData().getPraise();
        Glide.with(this).load(user.getImages()).into(mingShiImg);
        mingShiZanTv.setText(praise.getPraiseCount() + "");
        Glide.with(this).load(user.getPhoto()).placeholder(R.color.gray_prograss_bg)
                .error(R.color.gray_prograss_bg).dontAnimate().into(mingShiTeacherIconImg);
        mingShiTeacherNameTv.setText(user.getNickname());
        mingShiTeacherTeachTv.setText(user.getIntro());
        mingShiClassNumTv.setText(data.getLiveCount() + "");
        mingShiHomeworkNumTv.setText(data.getHomewokPublishCount() + "");
        mingShiTieZiNumTv.setText(data.getPostsCount() + "");
        mingShiFuDaoNumTv.setText(data.getCoachingCount() + "");
        mingShiGuanZhuNumTv.setText(data.getAttentionCount() + "");
        mingShiFenSiNumTv.setText(data.getFansCount() + "");
        mingShiContentTv.setText(user.getDetails());
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
