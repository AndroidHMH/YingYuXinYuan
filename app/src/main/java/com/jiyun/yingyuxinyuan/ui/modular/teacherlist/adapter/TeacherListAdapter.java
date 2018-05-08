package com.jiyun.yingyuxinyuan.ui.modular.teacherlist.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by asus on 2018/5/8.
 */

public class TeacherListAdapter extends FragmentPagerAdapter {
    private List<String> mTitle;
    private List<Fragment> mFragments;

    public TeacherListAdapter(FragmentManager fm, List<String> mTitle, List<Fragment> mFragments) {
        super(fm);
        this.mTitle = mTitle;
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.isEmpty() ? 0 : mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
