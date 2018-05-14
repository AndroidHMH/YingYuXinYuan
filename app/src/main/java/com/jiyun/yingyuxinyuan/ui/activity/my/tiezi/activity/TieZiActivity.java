package com.jiyun.yingyuxinyuan.ui.activity.my.tiezi.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.config.LoginShareUtils;
import com.jiyun.yingyuxinyuan.contract.TieZiContract;
import com.jiyun.yingyuxinyuan.model.bean.TieZiBean;
import com.jiyun.yingyuxinyuan.ui.activity.my.tiezi.presenter.TieZiPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TieZiActivity extends BaseActivity<TieZiPresenter> implements TieZiContract.View {

    @BindView(R.id.tiezi_close)
    ImageView tieziClose;
    @BindView(R.id.tiezi_linear)
    LinearLayout tieziLinear;
    @BindView(R.id.tiezi_recycler)
    RecyclerView tieziRecycler;
    private String userId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_tie_zi;
    }

    @Override
    protected void init() {
        userId = LoginShareUtils.getUserMessage(this, LoginShareUtils.ID);
    }

    @Override
    protected void loadDate() {
        presenter.loadData(userId);
    }

    @OnClick({R.id.tiezi_close})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tiezi_close:
                finish();
                break;
        }
    }
    @Override
    public void showData(TieZiBean tieZiBean) {
        tieziLinear.setVisibility(View.GONE);
        tieziRecycler.setVisibility(View.VISIBLE);
        Toast.makeText(this, tieZiBean.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErroe(String msg) {
        tieziRecycler.setVisibility(View.GONE);
        tieziLinear.setVisibility(View.VISIBLE);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
