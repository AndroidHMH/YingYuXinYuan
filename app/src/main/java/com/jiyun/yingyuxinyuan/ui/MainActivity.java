package com.jiyun.yingyuxinyuan.ui;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.ui.modular.homework.fragment.HomeworkFragment;
import com.jiyun.yingyuxinyuan.ui.modular.teacher.fragment.TeacherFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 首页
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.title_icon_iv)
    ImageView titleIconIv;
    @BindView(R.id.title_title_tv)
    TextView titleTitleTv;
    @BindView(R.id.title_message_iv)
    ImageView titleMessageIv;
    @BindView(R.id.title_draw_iv)
    ImageView titleDrawIv;
    @BindView(R.id.main_teacher_iv)
    ImageView mainTeacherIv;
    @BindView(R.id.main_teacher_tv)
    TextView mainTeacherTv;
    @BindView(R.id.main_teacher_btn)
    RelativeLayout mainTeacherBtn;
    @BindView(R.id.main_homework_iv)
    ImageView mainHomeworkIv;
    @BindView(R.id.main_homework_tv)
    TextView mainHomeworkTv;
    @BindView(R.id.main_homework_btn)
    RelativeLayout mainHomeworkBtn;
    @BindView(R.id.main_valuable_iv)
    ImageView mainValuableIv;
    @BindView(R.id.main_valuable_tv)
    TextView mainValuableTv;
    @BindView(R.id.main_valuable_btn)
    RelativeLayout mainValuableBtn;
    @BindView(R.id.main_notice_iv)
    ImageView mainNoticeIv;
    @BindView(R.id.main_notice_tv)
    TextView mainNoticeTv;
    @BindView(R.id.main_notice_btn)
    RelativeLayout mainNoticeBtn;
    @BindView(R.id.main_myself_iv)
    ImageView mainMyselfIv;
    @BindView(R.id.main_myself_tv)
    TextView mainMyselfTv;
    @BindView(R.id.main_myself_btn)
    RelativeLayout mainMyselfBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        titleIconIv.setImageResource(R.mipmap.title_logo);
        titleDrawIv.setVisibility(View.GONE);
    }

    @Override
    protected void loadDate() {

    }

    @OnClick({R.id.title_message_iv, R.id.main_teacher_btn, R.id.main_homework_btn, R.id.main_valuable_btn, R.id.main_notice_btn, R.id.main_myself_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_message_iv:
                break;
            case R.id.main_teacher_btn:
                setCreateView(R.id.main_content, TeacherFragment.class);
                mainTeacherIv.setImageResource(R.mipmap.home_master_active);
                mainTeacherTv.setTextColor(R.color.colorPrimary);
                break;
            case R.id.main_homework_btn:
                setCreateView(R.id.main_content, HomeworkFragment.class);
                mainHomeworkIv.setImageResource(R.mipmap.home_work_active);
                mainHomeworkTv.setTextColor(R.color.colorPrimary);
                mainTeacherIv.setImageResource(R.mipmap.home_master_normal);
                mainTeacherTv.setTextColor(R.color.gray);
                break;
            case R.id.main_valuable_btn:
                break;
            case R.id.main_notice_btn:
                break;
            case R.id.main_myself_btn:
                break;
        }
    }
}
