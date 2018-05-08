package com.jiyun.yingyuxinyuan.ui.modular.lookclass.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.contract.LookClassItemContract;
import com.jiyun.yingyuxinyuan.model.bean.LookClassItemBean;
import com.jiyun.yingyuxinyuan.ui.modular.lookclass.adapter.LookClassItemAdapter;
import com.jiyun.yingyuxinyuan.ui.modular.lookclass.presenter.LookClassItemPresenter;
import com.jiyun.yingyuxinyuan.ui.modular.teacherlist.presenter.TeacherListItemPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class LookClassItemFragment extends Fragment implements LookClassItemContract.View {

    @BindView(R.id.look_class_item_recycler)
    RecyclerView lookClassItemRecycler;
    @BindView(R.id.look_class_item_error)
    LinearLayout lookClassItemError;
    Unbinder unbinder;
    private List<LookClassItemBean.DataBean.ListBean> list;
    private String type;
    private LookClassItemContract.Presenter presenter;
    private LookClassItemAdapter lookClassItemAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_look_class_item, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            presenter = new LookClassItemPresenter(this);
            init();
            initView();
            loadDate();
        }
    }

    private void loadDate() {
        presenter.loadDate(type);
    }

    private void initView() {
        lookClassItemAdapter = new LookClassItemAdapter(list);
    }

    private void init() {
        Bundle arguments = getArguments();
        type = arguments.getString("type");
        list = new ArrayList<>();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showDate(LookClassItemBean classItemBean) {
        lookClassItemRecycler.setVisibility(View.VISIBLE);
        lookClassItemError.setVisibility(View.GONE);

        list.clear();
        list.addAll(classItemBean.getData().getList());
        lookClassItemRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        lookClassItemRecycler.setAdapter(lookClassItemAdapter);
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
        lookClassItemRecycler.setVisibility(View.GONE);
        lookClassItemError.setVisibility(View.VISIBLE);
    }
}
