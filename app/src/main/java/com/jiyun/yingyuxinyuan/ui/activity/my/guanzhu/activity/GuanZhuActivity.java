package com.jiyun.yingyuxinyuan.ui.activity.my.guanzhu.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.config.LoginShareUtils;
import com.jiyun.yingyuxinyuan.contract.GuanZhuContract;
import com.jiyun.yingyuxinyuan.model.bean.GuanZhuBean;
import com.jiyun.yingyuxinyuan.ui.activity.my.guanzhu.adapter.GuanZhuAdapter;
import com.jiyun.yingyuxinyuan.ui.activity.my.guanzhu.presenter.GuanZhuPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GuanZhuActivity extends BaseActivity<GuanZhuPresenter> implements GuanZhuContract.View {


    @BindView(R.id.zuoping_close)
    ImageView zuopingClose;
    @BindView(R.id.guanzhu_linear)
    LinearLayout guanzhuLinear;
    @BindView(R.id.guanzhu_recycler)
    RecyclerView guanzhuRecycler;
    private String userId;
    private List<GuanZhuBean.DataBean.ListBean> list;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_guan_zhu;
    }

    @Override
    protected void init() {
        userId = LoginShareUtils.getUserMessage(this, LoginShareUtils.ID);

    }

    @OnClick(R.id.zuoping_close)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zuoping_close:
                finish();
                break;
        }
    }

    @Override
    protected void loadDate() {
        presenter.loadData(userId);
    }

    @Override
    public void showData(GuanZhuBean guanZhuBean) {
        guanzhuRecycler.setVisibility(View.VISIBLE);
        guanzhuLinear.setVisibility(View.GONE);
        Toast.makeText(this, guanZhuBean.getMessage(), Toast.LENGTH_SHORT).show();
        list = guanZhuBean.getData().getList();
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        guanzhuRecycler.setLayoutManager(manager);
        GuanZhuAdapter guanZhuAdapter = new GuanZhuAdapter(list,GuanZhuActivity.this);
        guanzhuRecycler.setAdapter(guanZhuAdapter);
    }

    @Override
    public void showError(String msg) {
        guanzhuRecycler.setVisibility(View.GONE);
        guanzhuLinear.setVisibility(View.VISIBLE);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
