package com.jiyun.yingyuxinyuan.ui.modular.homework.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.contract.HomeworkItemContract;
import com.jiyun.yingyuxinyuan.model.bean.HomeworkBean;
import com.jiyun.yingyuxinyuan.ui.activity.my.myself.activity.MySelfActivity;
import com.jiyun.yingyuxinyuan.ui.modular.homework.adapter.HomeworkItemAdapter;
import com.jiyun.yingyuxinyuan.ui.modular.homework.presenter.HomeworkItemPresenter;
import com.jiyun.yingyuxinyuan.ui.modular.homeworkcontent.activity.HomeworkContentActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeworkItemFragment extends Fragment implements HomeworkItemContract.View {

    @BindView(R.id.homework_item_recycler)
    RecyclerView homeworkItemRecycler;
    @BindView(R.id.homework_item_error)
    LinearLayout homeworkItemError;
    Unbinder unbinder;
    private HomeworkItemContract.Presenter presenter;
    private int sortord;
    private int loginUserId;
    private List<HomeworkBean.DataBean.ListBean> list;
    private HomeworkItemAdapter homeworkItemAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_homework_item, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    private void initViews() {
        homeworkItemAdapter = new HomeworkItemAdapter(list);
        homeworkItemAdapter.setMyClick(new HomeworkItemAdapter.MyClick() {
            @Override
            public void myClick(View view, int position) {
                HomeworkBean.DataBean.ListBean listBean = list.get(position);
                Intent intent = new Intent(getContext(), MySelfActivity.class);
                intent.putExtra(MySelfActivity.STUDENT_ID, listBean.getId() + "");
                startActivity(intent);
            }
        });
        homeworkItemAdapter.setMyClick(new HomeworkItemAdapter.MyClick() {
            @Override
            public void myClick(View view, int position) {
                Intent intent = new Intent(getContext(), HomeworkContentActivity.class);
                HomeworkBean.DataBean.ListBean listBean = list.get(position);
                intent.putExtra("homewokId", listBean.getId() + "");
                startActivity(intent);
            }
        });
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            presenter = new HomeworkItemPresenter(this);
            init();
            initViews();
            loadDate();
        }
    }

    private void init() {
        Bundle arguments = getArguments();
        sortord = arguments.getInt("sortord");
        loginUserId = arguments.getInt("loginUserId");
        list = new ArrayList<>();
    }

    private void loadDate() {
        presenter.loadHomeworkDate(sortord, loginUserId);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showHomeworkBean(HomeworkBean homeworkBean) {
        homeworkItemRecycler.setVisibility(View.VISIBLE);
        homeworkItemError.setVisibility(View.GONE);

        list.clear();
        homeworkItemRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        list.addAll(homeworkBean.getData().getList());
        homeworkItemRecycler.setAdapter(homeworkItemAdapter);
    }

    @Override
    public void showError() {
        homeworkItemRecycler.setVisibility(View.GONE);
        homeworkItemError.setVisibility(View.VISIBLE);
    }
}
