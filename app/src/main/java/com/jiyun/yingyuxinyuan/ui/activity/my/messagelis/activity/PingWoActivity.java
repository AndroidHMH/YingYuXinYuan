package com.jiyun.yingyuxinyuan.ui.activity.my.messagelis.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.contract.PinWoContract;
import com.jiyun.yingyuxinyuan.model.bean.PingWoBean;
import com.jiyun.yingyuxinyuan.ui.activity.my.messagelis.presente.PinWoPresenterimp;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PingWoActivity extends BaseActivity<PinWoPresenterimp> implements PinWoContract.View {

    @BindView(R.id.ping_list_cancle)
    TextView pingListCancle;
    @BindView(R.id.ping_recycler)
    RecyclerView pingRecycler;
    @BindView(R.id.linear_ping)
    LinearLayout linearPing;
    @BindView(R.id.ping_ding_show)
    LinearLayout pingDingShow;
    private String userId;
    private List<?> list;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_ping_wo;
    }

    @Override
    protected void init() {
        SharedPreferences login = getSharedPreferences("Login", MODE_PRIVATE);
        userId = login.getString("id", null);
        if (list == null) {
            linearPing.setVisibility(View.VISIBLE);
            pingRecycler.setVisibility(View.GONE);
        } else {
            linearPing.setVisibility(View.GONE);
            pingRecycler.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void loadDate() {

    }
    @OnClick({R.id.ping_list_cancle,R.id.ping_ding_show})
    protected void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zan_list_cancle:
                finish();
                break;
            case R.id.zan_ding_show:
                presenter.showData(userId);
                break;
        }
    }
    @Override
    public void showData(PingWoBean pingWoBean) {
        list = pingWoBean.getData().getList();
        Toast.makeText(this, pingWoBean.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
