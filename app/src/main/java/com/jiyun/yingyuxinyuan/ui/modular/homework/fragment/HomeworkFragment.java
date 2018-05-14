package com.jiyun.yingyuxinyuan.ui.modular.homework.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseFragment;
import com.jiyun.yingyuxinyuan.ui.modular.homework.activity.FaHomeActivity;
import com.jiyun.yingyuxinyuan.ui.modular.homework.adapter.HomeworkAdapter;
import com.jiyun.yingyuxinyuan.view.MyViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 作业页面
 */
public class HomeworkFragment extends BaseFragment {

    @BindView(R.id.homework_work_iv)
    ImageView homeworkWorkIv;
    @BindView(R.id.homework_work_btn)
    RelativeLayout homeworkWorkBtn;
    @BindView(R.id.homework_submit_iv)
    ImageView homeworkSubmitIv;
    @BindView(R.id.homework_submit_btn)
    RelativeLayout homeworkSubmitBtn;
    @BindView(R.id.homework_tab)
    TabLayout homeworkTab;
    @BindView(R.id.homework_pager)
    MyViewPager homeworkPager;
    private List<Fragment> fragments;
    private List<String> titles;
    private HomeworkAdapter homeworkAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_homework;
    }

    @Override
    protected void init() {
        fragments = new ArrayList<>();
        titles = new ArrayList<>();
        homeworkTab.setupWithViewPager(homeworkPager);
        homeworkAdapter = new HomeworkAdapter(getChildFragmentManager(), fragments, titles);
        homeworkPager.setAdapter(homeworkAdapter);
    }

    @Override
    protected void loadDate() {
        titles.add("智能筛选");
        titles.add("偷听最多");
        titles.add("最新点评");
        for (int i = 0; i < 3; i++) {
            Fragment fragment = new HomeworkItemFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("sortord", i);
            bundle.putInt("loginUserId", 0);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        homeworkAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.homework_work_btn, R.id.homework_submit_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.homework_work_btn:

                break;
            case R.id.homework_submit_btn:
                startActivity(new Intent(getActivity(),FaHomeActivity.class));
                break;
        }
    }
}
