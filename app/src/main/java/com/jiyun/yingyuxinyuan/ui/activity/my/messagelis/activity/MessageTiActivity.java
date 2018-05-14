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
import com.jiyun.yingyuxinyuan.contract.MessageTiContract;
import com.jiyun.yingyuxinyuan.model.bean.DingTiBean;
import com.jiyun.yingyuxinyuan.ui.activity.my.messagelis.presente.MessageTiPresenterimp;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *
 */
public class MessageTiActivity extends BaseActivity<MessageTiPresenterimp> implements MessageTiContract.View {

    @BindView(R.id.ding_list_cancle)
    TextView dingListCancle;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.linear_ding)
    LinearLayout linearDing;
    @BindView(R.id.linear_ding_show)
    LinearLayout linearDingShow;
    private List<?> list;
    private String userId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_message_ti;
    }

    @Override
    protected void init() {
        userId = LoginShareUtils.getUserMessage(this, LoginShareUtils.ID);
    }

    @Override
    protected void loadDate() {
        presenter.loadDate(userId);
    }

    @OnClick({R.id.ding_list_cancle, R.id.linear_ding_show})
    protected void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ding_list_cancle:
                finish();
                break;
            case R.id.linear_ding_show:

                break;
        }
    }

    @Override
    public void showData(DingTiBean dingTiBean) {
//        list = dingTiBean.getData().getList();
        linearDing.setVisibility(View.GONE);
        recycler.setVisibility(View.VISIBLE);
        Toast.makeText(this, dingTiBean.getMessage() + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        linearDing.setVisibility(View.VISIBLE);
        recycler.setVisibility(View.GONE);
    }
}
