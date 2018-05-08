package com.jiyun.yingyuxinyuan.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.model.bean.EventBean;
import com.jiyun.yingyuxinyuan.ui.activity.LoginActivity;
import com.jiyun.yingyuxinyuan.ui.modular.homework.fragment.HomeworkFragment;
import com.jiyun.yingyuxinyuan.ui.modular.person.fragment.LoginPersonFragment;
import com.jiyun.yingyuxinyuan.ui.modular.person.fragment.PersonFragment;
import com.jiyun.yingyuxinyuan.ui.modular.preview.fragment.PreviewFragment;
import com.jiyun.yingyuxinyuan.ui.modular.teacher.fragment.TeacherFragment;
import com.jiyun.yingyuxinyuan.ui.modular.treasure.fragment.TreasureFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 首页
 */
public class MainActivity extends BaseActivity {
    @BindView(R.id.relative)
    RelativeLayout relative;
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
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        return R.layout.activity_main;
    }

    @Override
    protected void init() {

        titleIconIv.setImageResource(R.mipmap.title_logo);
        titleDrawIv.setVisibility(View.GONE);
        setTeacherView();
        setCreateView(R.id.main_content, TeacherFragment.class);
    }

    @Override
    protected void loadDate() {

    }

    @OnClick({R.id.title_message_iv, R.id.main_teacher_btn, R.id.main_homework_btn, R.id.main_valuable_btn, R.id.main_notice_btn, R.id.main_myself_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_message_iv:
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
            case R.id.main_teacher_btn:
                setTeacherView();
                setCreateView(R.id.main_content, TeacherFragment.class);
                break;
            case R.id.main_homework_btn:
                setHomeworkView();
                setCreateView(R.id.main_content, HomeworkFragment.class);
                break;
            case R.id.main_valuable_btn:
                setValuableView();
                setCreateView(R.id.main_content, TreasureFragment.class);
                break;
            case R.id.main_notice_btn:
                setNoticeView();
                setCreateView(R.id.main_content, PreviewFragment.class);
                break;
            case R.id.main_myself_btn:
                setMyself();
//                setCreateView(R.id.main_content, PersonFragment.class);
                setCreateView(R.id.main_content, LoginPersonFragment.class);
                break;
        }
    }
    @Subscribe
    public void onEventMainThread(EventBean eventBean){
        String fragmentName = eventBean.getFragmentTitle();
        if ("宝典".equals(fragmentName)) {
            setValuableView();
            setCreateView(R.id.main_content, TreasureFragment.class);
        } else if ("作业".equals(fragmentName)) {
            setHomeworkView();
            setCreateView(R.id.main_content, HomeworkFragment.class);
        } else if ("预告".equals(fragmentName)) {
            setNoticeView();
            setCreateView(R.id.main_content, PreviewFragment.class);
        }
    }

    @SuppressLint("ResourceAsColor")
    private void setNoticeView() {
        relative.setVisibility(View.VISIBLE);

        mainTeacherIv.setImageResource(R.mipmap.home_master_normal);
        mainTeacherTv.setTextColor(R.color.gray);

        mainHomeworkIv.setImageResource(R.mipmap.home_work_normal);
        mainHomeworkTv.setTextColor(R.color.gray);

        mainValuableIv.setImageResource(R.mipmap.home_valuable_normal);
        mainValuableTv.setTextColor(R.color.gray);

        mainNoticeIv.setImageResource(R.mipmap.home_notice_active);
        mainNoticeTv.setTextColor(R.color.colorPrimary);


        mainMyselfIv.setImageResource(R.mipmap.home_myself_normal);
        mainMyselfTv.setTextColor(R.color.gray);
    }

    @SuppressLint("ResourceAsColor")
    private void setMyself() {
        relative.setVisibility(View.GONE);

        mainTeacherIv.setImageResource(R.mipmap.home_master_normal);
        mainTeacherTv.setTextColor(R.color.gray);

        mainHomeworkIv.setImageResource(R.mipmap.home_work_normal);
        mainHomeworkTv.setTextColor(R.color.gray);

        mainValuableIv.setImageResource(R.mipmap.home_valuable_normal);
        mainValuableTv.setTextColor(R.color.gray);

        mainNoticeIv.setImageResource(R.mipmap.home_notice_normal);
        mainNoticeTv.setTextColor(R.color.gray);


        mainMyselfIv.setImageResource(R.mipmap.home_myself_active);
        mainMyselfTv.setTextColor(R.color.colorPrimary);
    }

    @SuppressLint("ResourceAsColor")
    private void setValuableView() {
        relative.setVisibility(View.VISIBLE);

        mainTeacherIv.setImageResource(R.mipmap.home_master_normal);
        mainTeacherTv.setTextColor(R.color.gray);

        mainHomeworkIv.setImageResource(R.mipmap.home_work_normal);
        mainHomeworkTv.setTextColor(R.color.gray);

        mainValuableIv.setImageResource(R.mipmap.home_valuable_active);
        mainValuableTv.setTextColor(R.color.colorPrimary);

        mainNoticeIv.setImageResource(R.mipmap.home_notice_normal);
        mainNoticeTv.setTextColor(R.color.gray);

        mainMyselfIv.setImageResource(R.mipmap.home_myself_normal);
        mainMyselfTv.setTextColor(R.color.gray);
    }

    @SuppressLint("ResourceAsColor")
    private void setHomeworkView() {
        relative.setVisibility(View.VISIBLE);

        mainTeacherIv.setImageResource(R.mipmap.home_master_normal);
        mainTeacherTv.setTextColor(R.color.gray);

        mainHomeworkIv.setImageResource(R.mipmap.home_work_active);
        mainHomeworkTv.setTextColor(R.color.colorPrimary);

        mainValuableIv.setImageResource(R.mipmap.home_valuable_normal);
        mainValuableTv.setTextColor(R.color.gray);

        mainNoticeIv.setImageResource(R.mipmap.home_notice_normal);
        mainNoticeTv.setTextColor(R.color.gray);

        mainMyselfIv.setImageResource(R.mipmap.home_myself_normal);
        mainMyselfTv.setTextColor(R.color.gray);
    }

    @SuppressLint("ResourceAsColor")
    private void setTeacherView() {
        relative.setVisibility(View.VISIBLE);

        mainTeacherIv.setImageResource(R.mipmap.home_master_active);
        mainTeacherTv.setTextColor(R.color.colorPrimary);

        mainHomeworkIv.setImageResource(R.mipmap.home_work_normal);
        mainHomeworkTv.setTextColor(R.color.gray);

        mainValuableIv.setImageResource(R.mipmap.home_valuable_normal);
        mainValuableTv.setTextColor(R.color.gray);

        mainNoticeIv.setImageResource(R.mipmap.home_notice_normal);
        mainNoticeTv.setTextColor(R.color.gray);

        mainMyselfIv.setImageResource(R.mipmap.home_myself_normal);
        mainMyselfTv.setTextColor(R.color.gray);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
