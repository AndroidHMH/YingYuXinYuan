package com.jiyun.yingyuxinyuan.ui.activity.my.store.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.contract.StoreContract;
import com.jiyun.yingyuxinyuan.model.bean.StoreBean;
import com.jiyun.yingyuxinyuan.ui.activity.my.store.adapter.StoreAdapter;
import com.jiyun.yingyuxinyuan.ui.activity.my.store.presenter.StorePresenterimp;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *
 */
public class StoreActivity extends BaseActivity<StorePresenterimp> implements StoreContract.View {

    @BindView(R.id.store_list_cancle)
    TextView storeListCancle;
    @BindView(R.id.store_list_zhi_tv)
    TextView storeListZhiTv;
    @BindView(R.id.store_list_zhi_line)
    TextView storeListZhiLine;
    @BindView(R.id.store_list_al1)
    RelativeLayout storeListAl1;
    @BindView(R.id.store_list_ti_tv)
    TextView storeListTiTv;
    @BindView(R.id.store_list_ti_line)
    TextView storeListTiLine;
    @BindView(R.id.store_list_ti)
    RelativeLayout storeListTi;
    @BindView(R.id.store_list_work_tv)
    TextView storeListWorkTv;
    @BindView(R.id.store_list_work_line)
    TextView storeListWorkLine;
    @BindView(R.id.store_list_work)
    RelativeLayout storeListWork;
    @BindView(R.id.store_list_tie_tv)
    TextView storeListTieTv;
    @BindView(R.id.store_list_tie_line)
    TextView storeListTieLine;
    @BindView(R.id.store_list_tie)
    RelativeLayout storeListTie;
    @BindView(R.id.store_list_relative)
    RelativeLayout storeListRelative;
    @BindView(R.id.store_list_recycler)
    RecyclerView storeListRecycler;
    private List<?> list;
    private int type =1;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_store;
    }

    @Override
    protected void init() {
        list = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        storeListRecycler.setLayoutManager(manager);
        StoreAdapter storeAdapter = new StoreAdapter(list,StoreActivity.this);
        storeListRecycler.setAdapter(storeAdapter);
    }

    @Override
    protected void loadDate() {
        presenter.showData(type);
    }
    @OnClick({R.id.store_list_cancle, R.id.store_list_al1, R.id.store_list_ti, R.id.store_list_work, R.id.store_list_tie})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.store_list_cancle:
                finish();
                break;
            case R.id.store_list_al1:
                storeListZhiLine.setVisibility(View.VISIBLE);
                storeListTiLine.setVisibility(View.INVISIBLE);
                storeListWorkLine.setVisibility(View.INVISIBLE);
                storeListTieLine.setVisibility(View.INVISIBLE);
                type = 1;
                break;
            case R.id.store_list_ti:
                storeListZhiLine.setVisibility(View.INVISIBLE);
                storeListTiLine.setVisibility(View.VISIBLE);
                storeListWorkLine.setVisibility(View.INVISIBLE);
                storeListTieLine.setVisibility(View.INVISIBLE);
                type = 2;
                break;
            case R.id.store_list_work:
                storeListZhiLine.setVisibility(View.INVISIBLE);
                storeListTiLine.setVisibility(View.INVISIBLE);
                storeListWorkLine.setVisibility(View.VISIBLE);
                storeListTieLine.setVisibility(View.INVISIBLE);
                type = 3;
                break;
            case R.id.store_list_tie:
                storeListZhiLine.setVisibility(View.INVISIBLE);
                storeListTiLine.setVisibility(View.INVISIBLE);
                storeListWorkLine.setVisibility(View.INVISIBLE);
                storeListTieLine.setVisibility(View.VISIBLE);
                type = 4;
                break;
        }
    }
    @Override
    public void showData(StoreBean storeBean) {
//        store_list_recycler
//        store_list_relative
        storeListRecycler.setVisibility(View.VISIBLE);
        storeListRecycler.setVisibility(View.GONE);

        list = storeBean.getData().getList();
    }
    @Override
    public void showError() {
        storeListRecycler.setVisibility(View.GONE);
        storeListRecycler.setVisibility(View.VISIBLE);
    }
}
