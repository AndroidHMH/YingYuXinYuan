package com.jiyun.yingyuxinyuan.ui.modular.homework.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作业页面
 */
public class HomeworkFragment extends BaseFragment {


    @BindView(R.id.asd)
    TextView asd;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_homework;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadDate() {

    }
}
