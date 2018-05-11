package com.jiyun.yingyuxinyuan.ui.activity.my.messagelis.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.contract.GuanWyContract;
import com.jiyun.yingyuxinyuan.model.bean.GuanMyBean;
import com.jiyun.yingyuxinyuan.ui.activity.my.messagelis.presente.GuanMyPresenterimp;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GuanZhuMyActivity extends BaseActivity<GuanMyPresenterimp> implements GuanWyContract.View{

    @BindView(R.id.guan_list_cancle)
    TextView guanListCancle;
    @BindView(R.id.guan_recycler)
    RecyclerView guanRecycler;
    @BindView(R.id.linear_guan)
    LinearLayout linearGuan;
    @BindView(R.id.guan_ding_show)
    LinearLayout guanDingShow;
    private String userId;
    private List<?> list;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_guan_zhu_my;
    }

    @Override
    protected void init() {
        SharedPreferences login = getSharedPreferences("Login", MODE_PRIVATE);
        userId = login.getString("id", "");
        Log.e("ID",userId);
        presenter.showData(userId);
    }

    @Override
    protected void loadDate() {

    }
    @OnClick({R.id.guan_list_cancle,R.id.guan_ding_show})
    protected void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.guan_list_cancle:
                finish();
                break;
            case R.id.guan_ding_show:

                break;
        }
    }
    @Override
    public void showData(GuanMyBean guanMyBean) {
        list = guanMyBean.getData().getList();
        if (list == null) {
            linearGuan.setVisibility(View.VISIBLE);
            guanRecycler.setVisibility(View.GONE);
        } else {
            linearGuan.setVisibility(View.GONE);
            guanRecycler.setVisibility(View.VISIBLE);
            Toast.makeText(this, guanMyBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
