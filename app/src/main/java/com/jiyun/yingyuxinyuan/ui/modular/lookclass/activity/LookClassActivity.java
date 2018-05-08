package com.jiyun.yingyuxinyuan.ui.modular.lookclass.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.ui.modular.lookclass.fragment.LookClassItemFragment;
import com.jiyun.yingyuxinyuan.ui.modular.teacherlist.adapter.TeacherListAdapter;
import com.jiyun.yingyuxinyuan.ui.modular.teacherlist.fragment.TeacherListItemFragment;
import com.jiyun.yingyuxinyuan.view.MyViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 直播课程页面
 */
public class LookClassActivity extends BaseActivity {

    @BindView(R.id.look_class_close)
    TextView lookClassClose;
    @BindView(R.id.look_class_tab)
    TabLayout lookClassTab;
    @BindView(R.id.look_class_pager)
    MyViewPager lookClassPager;
    private List<String> mTitle;
    private List<Fragment> mFragments;
    private TeacherListAdapter teacherListAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_look_class;
    }

    @Override
    protected void init() {
        mTitle = new ArrayList<>();
        mFragments = new ArrayList<>();
        teacherListAdapter = new TeacherListAdapter(getSupportFragmentManager(), mTitle, mFragments);
        lookClassPager.setAdapter(teacherListAdapter);
        lookClassTab.setupWithViewPager(lookClassPager);
    }

    @Override
    protected void loadDate() {
        mTitle.add("课程");
        mTitle.add("直播live");
        mFragments.add(getFragment("讲堂"));
        mFragments.add(getFragment("私塾"));
        teacherListAdapter.notifyDataSetChanged();
    }

    private LookClassItemFragment getFragment(String type) {
        LookClassItemFragment lookClassItemFragment = new LookClassItemFragment();
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        lookClassItemFragment.setArguments(bundle);
        return lookClassItemFragment;
    }

    @OnClick(R.id.look_class_close)
    public void onViewClicked() {
        fileList();
    }
}
