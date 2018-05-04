package com.jiyun.yingyuxinyuan.ui.modular.teacher.fragment;


import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;
import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseFragment;
import com.jiyun.yingyuxinyuan.contract.TeacherContract;
import com.jiyun.yingyuxinyuan.model.bean.EventBean;
import com.jiyun.yingyuxinyuan.model.bean.TeacherHomePageBean;
import com.jiyun.yingyuxinyuan.ui.MainActivity;
import com.jiyun.yingyuxinyuan.ui.modular.homework.fragment.HomeworkFragment;
import com.jiyun.yingyuxinyuan.ui.modular.lookclass.activity.LookClassActivity;
import com.jiyun.yingyuxinyuan.ui.modular.teacher.adapter.ClassGridAdapter;
import com.jiyun.yingyuxinyuan.ui.modular.teacher.adapter.RollPagerAdapter;
import com.jiyun.yingyuxinyuan.ui.modular.teacher.adapter.TeacherRecyclerAdapter;
import com.jiyun.yingyuxinyuan.ui.modular.teacher.adapter.WorkRecyclerAdapter;
import com.jiyun.yingyuxinyuan.ui.modular.teacher.presenter.TeacherPresenter;
import com.jiyun.yingyuxinyuan.ui.modular.teacherlist.activity.TeacherListActivity;
import com.jiyun.yingyuxinyuan.ui.modular.treasure.fragment.TreasureFragment;
import com.jiyun.yingyuxinyuan.view.MyGridView;
import com.jiyun.yingyuxinyuan.view.MyScrollView;
import com.jiyun.yingyuxinyuan.view.TeacherWorkLinearLayout;
import com.jude.rollviewpager.RollPagerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 名师页面
 */
public class TeacherFragment extends BaseFragment<TeacherPresenter> implements TeacherContract.View {


    @BindView(R.id.teacher_pollPager)
    RollPagerView teacherPollPager;
    @BindView(R.id.teacher_findTeacher_iv)
    ImageView teacherFindTeacherIv;
    @BindView(R.id.teacher_findTeacher_btn)
    RelativeLayout teacherFindTeacherBtn;
    @BindView(R.id.teacher_lookClass_iv)
    ImageView teacherLookClassIv;
    @BindView(R.id.teacher_lookClass_btn)
    RelativeLayout teacherLookClassBtn;
    @BindView(R.id.teacher_work_iv)
    ImageView teacherWorkIv;
    @BindView(R.id.teacher_work_btn)
    RelativeLayout teacherWorkBtn;
    @BindView(R.id.teacher_chat_iv)
    ImageView teacherChatIv;
    @BindView(R.id.teacher_chat_btn)
    RelativeLayout teacherChatBtn;
    @BindView(R.id.teacher_learn_iv)
    ImageView teacherLearnIv;
    @BindView(R.id.teacher_learn_btn)
    RelativeLayout teacherLearnBtn;
    @BindView(R.id.teacher_moreTeacher_btn)
    TextView teacherMoreTeacherBtn;
    @BindView(R.id.teacher_teacher_recycler)
    RecyclerView teacherTeacherRecycler;
    @BindView(R.id.teacher_moreClass_btn)
    TextView teacherMoreClassBtn;
    @BindView(R.id.teacher_class_recycler)
    MyGridView teacherClassRecycler;
    @BindView(R.id.teacher_moreWork_btn)
    TextView teacherMoreWorkBtn;
    @BindView(R.id.teacher_Work_recycler)
    RecyclerView teacherWorkRecycler;
    @BindView(R.id.teacher_scroll)
    MyScrollView teacherScroll;
    @BindView(R.id.teacher_pull_refresh)
    PullRefreshLayout teacherPullRefresh;
    private List<TeacherHomePageBean.DataBean.HomewoksBean> homewoks;
    private List<TeacherHomePageBean.DataBean.LiveCoursesBean> liveCourses;
    private List<TeacherHomePageBean.DataBean.SystemAdsBean> systemAds;
    private List<TeacherHomePageBean.DataBean.UsersBean> users;
    private RollPagerAdapter rollPagerAdapter;
    private TeacherRecyclerAdapter teacherRecyclerAdapter;
    private WorkRecyclerAdapter workRecyclerAdapter;
    private ClassGridAdapter classGridAdapter;

    @Override
    protected int getLayoutId() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        return R.layout.fragment_teacher;
    }

    @Override
    protected void init() {
        homewoks = new ArrayList<>();
        liveCourses = new ArrayList<>();
        systemAds = new ArrayList<>();
        users = new ArrayList<>();


        //轮播图
        rollPagerAdapter = new RollPagerAdapter(systemAds);
        teacherPollPager.setAdapter(rollPagerAdapter);

        //名师推荐
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        teacherTeacherRecycler.setLayoutManager(linearLayoutManager);
        teacherRecyclerAdapter = new TeacherRecyclerAdapter(users);
        teacherTeacherRecycler.setAdapter(teacherRecyclerAdapter);

        //课堂推荐
        classGridAdapter = new ClassGridAdapter(liveCourses, getContext());
        teacherClassRecycler.setAdapter(classGridAdapter);

        //推荐作业
        TeacherWorkLinearLayout teacherWorkLinearLayout = new TeacherWorkLinearLayout(getContext());
        teacherWorkLinearLayout.setScrollEnabled(false);
        teacherWorkRecycler.setLayoutManager(teacherWorkLinearLayout);
        workRecyclerAdapter = new WorkRecyclerAdapter(homewoks);
        teacherWorkRecycler.setAdapter(workRecyclerAdapter);

    }

    @Override
    protected void loadDate() {
        presenter.loadHomePageDate(0);
    }

    @OnClick({R.id.teacher_scroll, R.id.teacher_findTeacher_btn, R.id.teacher_lookClass_btn, R.id.teacher_work_btn, R.id.teacher_chat_btn, R.id.teacher_learn_btn, R.id.teacher_moreTeacher_btn, R.id.teacher_moreClass_btn, R.id.teacher_moreWork_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.teacher_findTeacher_btn:
                startActivity(new Intent(getContext(), TeacherListActivity.class));
                break;
            case R.id.teacher_lookClass_btn:
                startActivity(new Intent(getContext(), LookClassActivity.class));
                break;
            case R.id.teacher_work_btn:
                EventBus.getDefault().post(new EventBean("作业"));
                break;
            case R.id.teacher_chat_btn:
                EventBus.getDefault().post(new EventBean("宝典"));
                break;
            case R.id.teacher_learn_btn:
                EventBus.getDefault().post(new EventBean("预告"));
                break;
            case R.id.teacher_moreTeacher_btn:
                break;
            case R.id.teacher_moreClass_btn:
                break;
            case R.id.teacher_moreWork_btn:
                break;
            case R.id.teacher_scroll:
                break;
        }
    }
    @Subscribe
    public void onEventMainThread(EventBean eventBean) {

    }

    @Override
    public void showRollPager(List<TeacherHomePageBean.DataBean.SystemAdsBean> systemAds) {
        this.systemAds.addAll(systemAds);
        rollPagerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showTeacherRecycler(List<TeacherHomePageBean.DataBean.UsersBean> users) {
        this.users.addAll(users);
        teacherRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void showClassRecycler(List<TeacherHomePageBean.DataBean.LiveCoursesBean> liveCourses) {
        this.liveCourses.addAll(liveCourses);
        classGridAdapter.notifyDataSetChanged();
    }

    @Override
    public void showWorkRecycler(List<TeacherHomePageBean.DataBean.HomewoksBean> homewoks) {
        this.homewoks.addAll(homewoks);
        workRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void setHomeView() {

    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
