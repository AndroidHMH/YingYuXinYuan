package com.jiyun.yingyuxinyuan.ui.activity.my.fensi.activity;

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
import com.jiyun.yingyuxinyuan.contract.FenSiContract;
import com.jiyun.yingyuxinyuan.model.bean.FenSiBean;
import com.jiyun.yingyuxinyuan.ui.activity.my.fensi.adapter.FenSiAdapter;
import com.jiyun.yingyuxinyuan.ui.activity.my.fensi.presenter.FenSiPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FenSiActivity extends BaseActivity<FenSiPresenter> implements FenSiContract.View {

    @BindView(R.id.fen_si_close)
    ImageView fenSiClose;
    @BindView(R.id.fen_si_linear)
    LinearLayout fenSiLinear;
    @BindView(R.id.fen_si_recycler)
    RecyclerView fenSiRecycler;
    private String userId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fen_si;
    }

    @Override
    protected void init() {
        userId = LoginShareUtils.getUserMessage(this, LoginShareUtils.ID);
    }

    @Override
    protected void loadDate() {
        presenter.loadData(userId);
    }
    @OnClick(R.id.fen_si_close)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.fen_si_close:
                finish();
                break;
        }
    }

    @Override
    public void showData(FenSiBean fenSiBean) {
        fenSiRecycler.setVisibility(View.VISIBLE);
        fenSiLinear.setVisibility(View.GONE);
        Toast.makeText(this, fenSiBean.getMessage(), Toast.LENGTH_SHORT).show();
        List<FenSiBean.DataBean.ListBean> list = fenSiBean.getData().getList();
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        fenSiRecycler.setLayoutManager(manager);
        FenSiAdapter fenSiAdapter = new FenSiAdapter(FenSiActivity.this, list);
        fenSiRecycler.setAdapter(fenSiAdapter);
    }


    @Override
    public void showError(String msg) {
        fenSiLinear.setVisibility(View.VISIBLE);
        fenSiRecycler.setVisibility(View.GONE);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
