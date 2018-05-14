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
import com.jiyun.yingyuxinyuan.config.LoginShareUtils;
import com.jiyun.yingyuxinyuan.contract.ZanContract;
import com.jiyun.yingyuxinyuan.model.bean.ZanBean;
import com.jiyun.yingyuxinyuan.ui.activity.my.messagelis.presente.ZanPresenterimp;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZanWoActivity extends BaseActivity<ZanPresenterimp> implements ZanContract.View {

    @BindView(R.id.zan_list_cancle)
    TextView zanListCancle;
    @BindView(R.id.zan_recycler)
    RecyclerView zanRecycler;
    @BindView(R.id.linear_zan)
    LinearLayout linearZan;
    @BindView(R.id.zan_ding_show)
    LinearLayout zanDingShow;
    private List<?> list;
    private String userId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_zan_wo;
    }

    @Override
    protected void init() {
        userId = LoginShareUtils.getUserMessage(this, LoginShareUtils.ID);
    }

    @Override
    protected void loadDate() {
        presenter.loadData(userId);
    }

    @OnClick({R.id.zan_list_cancle, R.id.zan_ding_show})
    protected void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zan_list_cancle:
                finish();
                break;
            case R.id.zan_ding_show:

                break;
        }
    }

    @Override
    public void showData(ZanBean zanBean) {
//        list = zanBean.getData().getList();
        linearZan.setVisibility(View.GONE);
        zanRecycler.setVisibility(View.VISIBLE);
        Toast.makeText(this, zanBean.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        linearZan.setVisibility(View.VISIBLE);
        zanRecycler.setVisibility(View.GONE);
    }
}
