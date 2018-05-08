package com.jiyun.yingyuxinyuan.ui.modular.teacherlist.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.ui.modular.teacherlist.adapter.TeacherListAdapter;
import com.jiyun.yingyuxinyuan.ui.modular.teacherlist.fragment.TeacherListItemFragment;
import com.jiyun.yingyuxinyuan.view.MyViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 名师列表页面
 */
public class TeacherListActivity extends BaseActivity {

    @BindView(R.id.teacher_list_tab)
    TabLayout teacherListTab;
    @BindView(R.id.teacher_list_pager)
    MyViewPager teacherListPager;
    @BindView(R.id.teacher_list_close)
    TextView teacherListClose;
    private List<String> mTitle;
    private List<Fragment> mFragments;
    private TeacherListAdapter teacherListAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_teacher_list;
    }

    @Override
    protected void init() {
        mTitle = new ArrayList<>();
        mFragments = new ArrayList<>();
        teacherListAdapter = new TeacherListAdapter(getSupportFragmentManager(), mTitle, mFragments);
        teacherListPager.setAdapter(teacherListAdapter);
        teacherListTab.setupWithViewPager(teacherListPager);
    }

    @Override
    protected void loadDate() {
        mTitle.add("大师");
        mTitle.add("名师");
        mTitle.add("达人");
        mFragments.add(getFragment(4));
        mFragments.add(getFragment(3));
        mFragments.add(getFragment(2));
        teacherListAdapter.notifyDataSetChanged();
    }

    private TeacherListItemFragment getFragment(int userType) {
        TeacherListItemFragment teacherFragment = new TeacherListItemFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("userType", userType);
        teacherFragment.setArguments(bundle);
        return teacherFragment;
    }

    @OnClick(R.id.teacher_list_close)
    public void onViewClicked() {
        finish();
    }
}
