package com.jiyun.yingyuxinyuan.ui.activity.my.dingdan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.contract.DingDanContract;
import com.jiyun.yingyuxinyuan.model.bean.DingDanBean;
import com.jiyun.yingyuxinyuan.ui.activity.my.dingdan.adapter.DingDanAdapter;
import com.jiyun.yingyuxinyuan.ui.activity.my.dingdan.presenter.DingDanPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DingDanActivity extends BaseActivity<DingDanPresenter> implements DingDanContract.View {

    @BindView(R.id.ding_list_cancle)
    TextView dingListCancle;
    @BindView(R.id.ding_list_all_tv)
    TextView dingListAllTv;
    @BindView(R.id.ding_list_all_line)
    TextView dingListAllLine;
    @BindView(R.id.indentlist_aty_recyclerview_empty)
    RelativeLayout indentlistAtyRecyclerviewEmpty;
    @BindView(R.id.ding_list_al1)
    RelativeLayout dingListAl1;
    @BindView(R.id.ding_list_fu_tv)
    TextView dingListFuTv;
    @BindView(R.id.ding_list_fu_line)
    TextView dingListFuLine;
    @BindView(R.id.ding_list_fu)
    RelativeLayout dingListFu;
    @BindView(R.id.ding_list_use_tv)
    TextView dingListUseTv;
    @BindView(R.id.ding_list_use_line)
    TextView dingListUseLine;
    @BindView(R.id.ding_list_use)
    RelativeLayout dingListUse;
    @BindView(R.id.ding_list_tui_tv)
    TextView dingListTuiTv;
    @BindView(R.id.ding_list_tui_line)
    TextView dingListTuiLine;
    @BindView(R.id.ding_list_tui)
    RelativeLayout dingListTui;
    @BindView(R.id.indentlist_aty_recycler)
    RecyclerView indentlistAtyRecycler;
    private List<DingDanBean.DataBean.ListBean> list;
    private String show;
    private DingDanAdapter dingDanAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ding_dan;
    }

    @Override
    protected void init() {
        list = new ArrayList<>();
        Intent intent = getIntent();
        show = intent.getStringExtra("show");
        dingDanAdapter = new DingDanAdapter(list);
        indentlistAtyRecycler.setLayoutManager(new LinearLayoutManager(this));
        indentlistAtyRecycler.setAdapter(dingDanAdapter);
    }

    @Override
    protected void loadDate() {
        presenter.loadDate(show);
    }

    @OnClick({R.id.ding_list_cancle, R.id.ding_list_al1, R.id.ding_list_fu, R.id.ding_list_use, R.id.ding_list_tui})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ding_list_cancle:
                finish();
                break;
            case R.id.ding_list_al1:
                dingListAllLine.setVisibility(View.VISIBLE);
                dingListFuLine.setVisibility(View.INVISIBLE);
                dingListTuiLine.setVisibility(View.INVISIBLE);
                dingListUseLine.setVisibility(View.INVISIBLE);
                presenter.loadDate("-1");
                break;
            case R.id.ding_list_fu:
                dingListAllLine.setVisibility(View.INVISIBLE);
                dingListFuLine.setVisibility(View.VISIBLE);
                dingListTuiLine.setVisibility(View.INVISIBLE);
                dingListUseLine.setVisibility(View.INVISIBLE);
                presenter.loadDate("0");
                break;
            case R.id.ding_list_use:
                dingListAllLine.setVisibility(View.INVISIBLE);
                dingListFuLine.setVisibility(View.INVISIBLE);
                dingListTuiLine.setVisibility(View.INVISIBLE);
                dingListUseLine.setVisibility(View.VISIBLE);
                presenter.loadDate("1");
                break;
            case R.id.ding_list_tui:
                dingListAllLine.setVisibility(View.INVISIBLE);
                dingListFuLine.setVisibility(View.INVISIBLE);
                dingListTuiLine.setVisibility(View.VISIBLE);
                dingListUseLine.setVisibility(View.INVISIBLE);
                presenter.loadDate("4");
                break;
        }
    }

    @Override
    public void showDate(DingDanBean dingDanBean) {
        indentlistAtyRecycler.setVisibility(View.VISIBLE);
        indentlistAtyRecyclerviewEmpty.setVisibility(View.GONE);

        list.clear();
        list.addAll(dingDanBean.getData().getList());
        dingDanAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError() {
        indentlistAtyRecycler.setVisibility(View.GONE);
        indentlistAtyRecyclerviewEmpty.setVisibility(View.VISIBLE);
    }
}
