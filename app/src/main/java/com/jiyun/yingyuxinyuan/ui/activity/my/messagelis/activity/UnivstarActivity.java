package com.jiyun.yingyuxinyuan.ui.activity.my.messagelis.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.config.LoginShareUtils;
import com.jiyun.yingyuxinyuan.contract.UnivastarContract;
import com.jiyun.yingyuxinyuan.model.bean.UnivstarBean;
import com.jiyun.yingyuxinyuan.ui.activity.my.messagelis.adapter.UnivstarAdapter;
import com.jiyun.yingyuxinyuan.ui.activity.my.messagelis.presente.UnivstarPresenterimp;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UnivstarActivity extends BaseActivity<UnivstarPresenterimp> implements UnivastarContract.View {

    @BindView(R.id.univstar_list_cancle)
    TextView univstarListCancle;
    @BindView(R.id.univstar_recycler)
    RecyclerView univstarRecycler;
    @BindView(R.id.linear_univstar)
    LinearLayout linearUnivstar;
    @BindView(R.id.univstar_ding_show)
    LinearLayout univstarDingShow;
    private String userId;
    private List<UnivstarBean.DataBean.ListBean> list;
    private LinearLayoutManager manager;
    private UnivstarAdapter univstarAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_univstar;
    }

    @Override
    protected void init() {

          /*      univstarAdapter = new UnivstarAdapter(list, UnivstarActivity.this);
           manager = new LinearLayoutManager(UnivstarActivity.this,LinearLayoutManager.VERTICAL,false);*/
          /*  univstarRecycler.setLayoutManager(manager);
            univstarRecycler.setAdapter(univstarAdapter);*/

        userId = LoginShareUtils.getUserMessage(this, LoginShareUtils.ID);
    }

    @Override
    protected void loadDate() {
        presenter.loadDate(userId);
    }

    @OnClick({R.id.univstar_list_cancle, R.id.univstar_ding_show})
    protected void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.univstar_list_cancle:
                finish();
                break;
        }
    }

    @Override
    public void showData(UnivstarBean univstarBean) {
        list = univstarBean.getData().getList();
        linearUnivstar.setVisibility(View.GONE);
        univstarRecycler.setVisibility(View.VISIBLE);
        Toast.makeText(this, univstarBean.getMessage(), Toast.LENGTH_SHORT).show();
        univstarAdapter = new UnivstarAdapter(list, UnivstarActivity.this);
        manager = new LinearLayoutManager(UnivstarActivity.this, LinearLayoutManager.VERTICAL, false);
        univstarRecycler.setLayoutManager(manager);
        univstarRecycler.setAdapter(univstarAdapter);
        univstarAdapter.notifyDataSetChanged();
        univstarAdapter.notifyDataSetChanged();

    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        linearUnivstar.setVisibility(View.VISIBLE);
        univstarRecycler.setVisibility(View.GONE);
    }
}
