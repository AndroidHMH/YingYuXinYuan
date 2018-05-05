package com.jiyun.yingyuxinyuan.ui.modular.treasure.fragment;


import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseFragment;
import com.jiyun.yingyuxinyuan.contract.TreasureContract;
import com.jiyun.yingyuxinyuan.model.bean.TreasureRollPagerBean;
import com.jiyun.yingyuxinyuan.model.bean.TreasureTitleBean;
import com.jiyun.yingyuxinyuan.ui.modular.homework.fragment.HomeworkItemFragment;
import com.jiyun.yingyuxinyuan.ui.modular.treasure.adapter.RollPagerAdapter;
import com.jiyun.yingyuxinyuan.ui.modular.treasure.adapter.TreasureAdapter;
import com.jiyun.yingyuxinyuan.ui.modular.treasure.presenter.TreasurePresenter;
import com.jiyun.yingyuxinyuan.view.MyViewPager;
import com.jude.rollviewpager.RollPagerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 宝典页面
 */
public class TreasureFragment extends BaseFragment<TreasurePresenter> implements TreasureContract.View {

    @BindView(R.id.treasure_rollPager)
    RollPagerView treasureRollPager;
    @BindView(R.id.collapsing_tool_bar_test_ctl)
    CollapsingToolbarLayout collapsingToolBarTestCtl;
    @BindView(R.id.treasure_tab)
    TabLayout treasureTab;
    @BindView(R.id.homework_appbar)
    AppBarLayout homeworkAppbar;
    @BindView(R.id.treasure_pager)
    MyViewPager treasurePager;
    @BindView(R.id.scrollview)
    CoordinatorLayout scrollview;
    private List<Fragment> fragments;
    private List<String> titles;
    private TreasureAdapter treasureAdapter;
    private List<TreasureRollPagerBean.DataBean.ListBean> list;
    private RollPagerAdapter rollPagerAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_treasure;
    }

    @Override
    protected void init() {
        list = new ArrayList<>();
        fragments = new ArrayList<>();
        titles = new ArrayList<>();
        treasureAdapter = new TreasureAdapter(getChildFragmentManager(), fragments, titles);
        treasureTab.setupWithViewPager(treasurePager);
        treasurePager.setAdapter(treasureAdapter);

        rollPagerAdapter = new RollPagerAdapter(list);
        treasureRollPager.setAdapter(rollPagerAdapter);
    }

    @Override
    protected void loadDate() {
        presenter.loadRollPager();
        presenter.loadTitle();
    }

    @Override
    public void addTitle(TreasureTitleBean treasureTitleBean) {
        titles.add("智能筛选");
        titles.add("赞数最多");
        titles.add("最新评论");
        List<TreasureTitleBean.DataBean.ListBean> list = treasureTitleBean.getData().getList();
        for (TreasureTitleBean.DataBean.ListBean listBean : list) {
            titles.add(listBean.getName());
        }
        for (int i = 0; i < titles.size(); i++) {
            Fragment fragment = new TreasureItemFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("sortord", i);
            bundle.putInt("loginUserId", 0);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        treasureAdapter.notifyDataSetChanged();
    }

    @Override
    public void showRollPager(TreasureRollPagerBean treasureRollPagerBean) {
        list.addAll(treasureRollPagerBean.getData().getList());
        rollPagerAdapter.notifyDataSetChanged();
    }
}
