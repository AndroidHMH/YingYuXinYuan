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
import com.jiyun.yingyuxinyuan.contract.HomeWorkWoContract;
import com.jiyun.yingyuxinyuan.model.bean.HomeWorkWoBean;
import com.jiyun.yingyuxinyuan.ui.activity.my.messagelis.presente.HomeWorkWoPresenterimp;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeWorkWoActivity extends BaseActivity<HomeWorkWoPresenterimp> implements HomeWorkWoContract.View {

    @BindView(R.id.homework_wo_list_cancle)
    TextView homeworkWoListCancle;
    @BindView(R.id.homework_wo_recycler)
    RecyclerView homeworkWoRecycler;
    @BindView(R.id.linear_homework_wo)
    LinearLayout linearHomeworkWo;
    @BindView(R.id.homework_wo_ding_show)
    LinearLayout homeworkWoDingShow;
    private List<?> list;
    private String userId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_work_wo;
    }

    @Override
    protected void init() {
        SharedPreferences login = getSharedPreferences("Login", MODE_PRIVATE);
        userId = login.getString("id", null);

    }

    @Override
    protected void loadDate() {

    }
    @OnClick({R.id.homework_wo_list_cancle,R.id.homework_wo_ding_show})
    protected void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.homework_wo_list_cancle:
                finish();
                break;
            case R.id.homework_wo_ding_show:

                break;
        }
    }
    @Override
    public void showData(HomeWorkWoBean homeWorkWoBean) {
        list = homeWorkWoBean.getData().getList();
        if (list != null) {
            linearHomeworkWo.setVisibility(View.GONE);
            homeworkWoRecycler.setVisibility(View.VISIBLE);
        } else {
            linearHomeworkWo.setVisibility(View.VISIBLE);
            homeworkWoRecycler.setVisibility(View.GONE);
            Toast.makeText(this, homeWorkWoBean.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}
