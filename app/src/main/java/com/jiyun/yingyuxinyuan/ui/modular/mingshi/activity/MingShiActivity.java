package com.jiyun.yingyuxinyuan.ui.modular.mingshi.activity;

import android.annotation.SuppressLint;
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
import com.jiyun.yingyuxinyuan.config.LoginShareUtils;
import com.jiyun.yingyuxinyuan.contract.MingShiContract;
import com.jiyun.yingyuxinyuan.model.bean.MingShiBean;
import com.jiyun.yingyuxinyuan.ui.modular.dianzan.DianZan;
import com.jiyun.yingyuxinyuan.ui.modular.guanzhu.GuanZhu;
import com.jiyun.yingyuxinyuan.ui.modular.mingshi.persenter.MingShiPresenter;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jiyun.yingyuxinyuan.R.color.gray;

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
    //老师id
    private int id150;
    private int znaCount;
    private int isPraise;
    //    是否关注
    private int id120;
    private int isGuan;
    private int attentionCount;

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
            String userId = LoginShareUtils.getUserMessage(this, LoginShareUtils.ID);
            if ("未获取到值".equals(userId)) {
                presenter.loadDate(String.valueOf(id), "");
            } else {
                presenter.loadDate(String.valueOf(id), userId);
            }
        }
    }


    @SuppressLint("ResourceAsColor")
    @OnClick({R.id.ming_shi_zan_btn, R.id.ming_shi_guan_zhu_btn, R.id.ming_shi_class_num_btn, R.id.ming_shi_homework_num_btn, R.id.ming_shi_fu_dao_num_btn, R.id.ming_shi_tie_zi_num_btn, R.id.ming_shi_guan_zhu_num_btn, R.id.ming_shi_fen_si_num_btn, R.id.ming_shi_back_btn, R.id.ming_shi_share_btn, R.id.ming_shi_fu_dao_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ming_shi_zan_btn:
                if (0 == isPraise) {
                    presenter.dianZan(id150 + "", id150 + "", DianZan.LAO_SHI);
                    mingShiZanImg.setImageResource(R.mipmap.detail_praisse_active);
                    isPraise = 1;
                } else {
                    presenter.quXiao(id150 + "", id150 + "", DianZan.LAO_SHI);
                    mingShiZanImg.setImageResource(R.mipmap.detail_praisse_normal);
                    isPraise = 0;
                }
                break;
            case R.id.ming_shi_guan_zhu_btn:
                if (0 == isGuan) {
                    presenter.guanZhu(id150 + "");
                    isGuan = 1;
                } else {
                    presenter.quXiaoGuan(id150 + "");
                    isGuan = 0;
                }
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

    @SuppressLint("ResourceAsColor")
    @Override
    public void showDate(MingShiBean mingShiBean) {
        MingShiBean.DataBean.UserBean user = mingShiBean.getData().getUser();
        MingShiBean.DataBean data = mingShiBean.getData();
        MingShiBean.DataBean.PraiseBean praise = mingShiBean.getData().getPraise();
        //老师id
        id150 = user.get_$Id150();
        Glide.with(this).load(user.getImages()).into(mingShiImg);
        znaCount = praise.getPraiseCount();
        mingShiZanTv.setText(znaCount + "");
        isPraise = praise.getIsPraise();
        if (0 == isPraise) {
            mingShiZanImg.setImageResource(R.mipmap.detail_praisse_normal);
        } else {
            mingShiZanImg.setImageResource(R.mipmap.detail_praisse_active);
        }
//        关注
        attentionCount = data.getAttentionCount();
        mingShiGuanZhuBtn.setText(attentionCount + "");
        if (0 == isGuan) {
            mingShiGuanZhuBtn.setText("关注");
            mingShiGuanZhuBtn.setBackgroundColor(R.color.blue);
        } else {
            mingShiGuanZhuBtn.setText("已关注");
            mingShiGuanZhuBtn.setBackgroundColor(R.color.gray);
        }
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

    @SuppressLint("ResourceAsColor")
    @Override
    public void showSuccess(String msg) {
        if ("已赞".equals(msg)) {
            znaCount++;
            mingShiZanTv.setText((znaCount) + "");
        } else if ("已取消".equals(msg)) {
            znaCount--;
            mingShiZanTv.setText((znaCount) + "");
        } else if ("已关注".equals(msg)) {
            mingShiGuanZhuBtn.setBackgroundColor(R.color.gray);
            mingShiGuanZhuBtn.setText("已关注");
        } else {
            mingShiGuanZhuBtn.setBackgroundColor(R.color.colorblue);
            mingShiGuanZhuBtn.setText("关注");
        }
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
