package com.jiyun.yingyuxinyuan.ui.modular.teacherlist.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.contract.TeacherListItemContract;
import com.jiyun.yingyuxinyuan.model.bean.TeacherListBean;
import com.jiyun.yingyuxinyuan.ui.modular.teacherlist.adapter.TeacherListItemAdapter;
import com.jiyun.yingyuxinyuan.ui.modular.teacherlist.presenter.TeacherListItemPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 名师列表Item页面
 */
public class TeacherListItemFragment extends Fragment implements TeacherListItemContract.View {


    @BindView(R.id.teacher_list_item_recycler)
    RecyclerView teacherListItemRecycler;
    Unbinder unbinder;
    @BindView(R.id.teacher_list_item_error)
    LinearLayout teacherListItemError;
    private TeacherListItemContract.Presenter presenter;
    private List<TeacherListBean.DataBean.ListBean> list;
    private TeacherListItemAdapter teacherListItemAdapter;
    private int userType;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_teacher_list_item, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            presenter = new TeacherListItemPresenter(this);
            init();
            initView();
            loadDate();
        }
    }

    private void loadDate() {
        presenter.loadDate(userType);
    }

    private void initView() {
        teacherListItemAdapter = new TeacherListItemAdapter(list);
    }

    private void init() {
        Bundle arguments = getArguments();
        userType = arguments.getInt("userType");
        list = new ArrayList<>();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showDate(TeacherListBean teacherListBean) {
        teacherListItemRecycler.setVisibility(View.VISIBLE);
        teacherListItemError.setVisibility(View.GONE);

        list.clear();
        list.addAll(teacherListBean.getData().getList());
        teacherListItemRecycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
        teacherListItemRecycler.setAdapter(teacherListItemAdapter);
    }

    @Override
    public void showError(String message) {
        teacherListItemRecycler.setVisibility(View.GONE);
        teacherListItemError.setVisibility(View.VISIBLE);
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
