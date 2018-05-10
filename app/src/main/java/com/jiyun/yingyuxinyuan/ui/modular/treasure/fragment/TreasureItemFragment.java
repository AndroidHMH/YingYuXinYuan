package com.jiyun.yingyuxinyuan.ui.modular.treasure.fragment;


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
import com.jiyun.yingyuxinyuan.contract.TreasureItemContract;
import com.jiyun.yingyuxinyuan.model.bean.TreasureItemBean;
import com.jiyun.yingyuxinyuan.ui.modular.homework.presenter.HomeworkItemPresenter;
import com.jiyun.yingyuxinyuan.ui.modular.treasure.adapter.TreasureItemAdapter;
import com.jiyun.yingyuxinyuan.ui.modular.treasure.presenter.TreasureItemPresenter;
import com.jiyun.yingyuxinyuan.ui.modular.treasureitemcontent.activity.TreasureItemContentActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 宝典页面的子页面
 */
public class TreasureItemFragment extends Fragment implements TreasureItemContract.View {


    @BindView(R.id.homework_item_recycler)
    RecyclerView homeworkItemRecycler;
    @BindView(R.id.homework_item_error)
    LinearLayout homeworkItemError;
    Unbinder unbinder;
    private int sortord;
    private int loginUserId;
    private List<TreasureItemBean.DataBean.ArtcircleListBean.ListBean> list;
    private TreasureItemContract.Presenter presenter;
    private TreasureItemAdapter treasureItemAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homework_item, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            presenter = new TreasureItemPresenter(this);
            init();
            initViews();
            loadDate();
        }
    }

    private void loadDate() {
        presenter.loadDate(sortord, loginUserId);
    }

    private void initViews() {
        treasureItemAdapter = new TreasureItemAdapter(list);
        treasureItemAdapter.setMyClick(new TreasureItemAdapter.MyClick() {
            @Override
            public void myClick(View view, int position) {
                TreasureItemBean.DataBean.ArtcircleListBean.ListBean listBean = list.get(position);
                Intent intent = new Intent(getContext(), TreasureItemContentActivity.class);
                intent.putExtra("artcircleId", listBean.getId() + "");
                startActivity(intent);
            }
        });
    }

    private void init() {
        Bundle arguments = getArguments();
        sortord = arguments.getInt("sortord");
        loginUserId = arguments.getInt("loginUserId");
        list = new ArrayList<>();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showDate(TreasureItemBean treasureItemBean) {
        homeworkItemRecycler.setVisibility(View.VISIBLE);
        homeworkItemError.setVisibility(View.GONE);

        list.clear();
        list.addAll(treasureItemBean.getData().getArtcircleList().getList());
        homeworkItemRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        homeworkItemRecycler.setAdapter(treasureItemAdapter);
    }

    @Override
    public void showError() {
        homeworkItemRecycler.setVisibility(View.GONE);
        homeworkItemError.setVisibility(View.VISIBLE);
    }
}
