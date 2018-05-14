package com.jiyun.yingyuxinyuan.ui.activity.my.myself.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.contract.MySelfContract;
import com.jiyun.yingyuxinyuan.model.bean.MySelfBean;
import com.jiyun.yingyuxinyuan.model.bean.TieZiBean;
import com.jiyun.yingyuxinyuan.ui.activity.my.myself.presenter.MySelfPresenter;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MySelfActivity extends BaseActivity<MySelfPresenter> implements MySelfContract.View {

    @BindView(R.id.myself_close)
    ImageView myselfClose;
    @BindView(R.id.myself_button)
    Button myselfButton;
    @BindView(R.id.myself_zuoping_tv)
    TextView myselfZuopingTv;
    @BindView(R.id.myslef_zuoping_line)
    TextView myslefZuopingLine;
    @BindView(R.id.myself_zuoping)
    RelativeLayout myselfZuoping;
    @BindView(R.id.myself_tiezi_tv)
    TextView myselfTieziTv;
    @BindView(R.id.myself_tiezi_line)
    TextView myselfTieziLine;
    @BindView(R.id.myself_tiezi)
    RelativeLayout myselfTiezi;
    @BindView(R.id.my_self_img)
    RoundedImageView mySelfImg;
    public static final String STUDENT_ID = "studentId";
    @BindView(R.id.my_self_name)
    TextView mySelfName;
    @BindView(R.id.my_self_guan_zhu_count)
    TextView mySelfGuanZhuCount;
    @BindView(R.id.my_self_fen_si_count)
    TextView mySelfFenSiCount;
    @BindView(R.id.my_self_recycler)
    RecyclerView mySelfRecycler;
    @BindView(R.id.my_self_error_group)
    LinearLayout mySelfErrorGroup;
    private String studentId;
    private List<?> list;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_self;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        studentId = intent.getStringExtra(STUDENT_ID);
        mySelfRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void loadDate() {
        presenter.loadDate(studentId);
    }

    @OnClick({R.id.myself_close, R.id.myself_button,
            R.id.myself_zuoping, R.id.myself_zuoping_tv, R.id.myslef_zuoping_line,
            R.id.myself_tiezi, R.id.myself_tiezi_tv, R.id.myself_tiezi_line
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.myself_close:
                finish();
                break;
            case R.id.myself_button:
                myselfButton.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("ResourceAsColor")
                    @Override
                    public void onClick(View view) {
                        myselfButton.setBackgroundColor(R.color.gray);
                        myselfButton.setText("已关注");
                    }
                });
                break;
            case R.id.myself_zuoping:
                myslefZuopingLine.setVisibility(View.VISIBLE);
                myselfTieziLine.setVisibility(View.GONE);
//                showZuoPin();
                break;
            case R.id.myself_tiezi:
                myslefZuopingLine.setVisibility(View.GONE);
                myselfTieziLine.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void showUserDate(MySelfBean.DataBean.UserInfoBean userInfoBean) {
        //头像
        String photo = userInfoBean.getPhoto();
        if (photo != null) {
            Glide.with(this).load(photo).placeholder(R.color.gray_prograss_bg)
                    .error(R.color.gray_prograss_bg).dontAnimate().into(mySelfImg);
        } else {
            mySelfImg.setBackgroundResource(R.mipmap.user_head_portrait);
        }
        mySelfName.setText(userInfoBean.getNickname());
        mySelfGuanZhuCount.setText(userInfoBean.getAttentionCount() + "");
        mySelfFenSiCount.setText(userInfoBean.getFansCount() + "");
    }

    @Override
    public void showZuoPin(MySelfBean.DataBean.HomewokListBean homewokListBean) {
        mySelfErrorGroup.setVisibility(View.GONE);
        mySelfRecycler.setVisibility(View.VISIBLE);
        List<?> list = homewokListBean.getList();
//        this.list.addAll(this);

    }

    @Override
    public void showTieZi(List<TieZiBean.DataBean.ArtcircleListBean.ListBean> list) {
        mySelfErrorGroup.setVisibility(View.GONE);
        mySelfRecycler.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String msg) {
        mySelfErrorGroup.setVisibility(View.VISIBLE);
        mySelfRecycler.setVisibility(View.GONE);
    }

    @Override
    public void showTieZiError(String msg) {
        mySelfErrorGroup.setVisibility(View.VISIBLE);
        mySelfRecycler.setVisibility(View.GONE);
    }
}
