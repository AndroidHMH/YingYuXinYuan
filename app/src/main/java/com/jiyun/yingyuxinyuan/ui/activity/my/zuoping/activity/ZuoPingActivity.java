package com.jiyun.yingyuxinyuan.ui.activity.my.zuoping.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.config.LoginShareUtils;
import com.jiyun.yingyuxinyuan.contract.ZuoPingContract;
import com.jiyun.yingyuxinyuan.model.bean.ZuoPingBean;
import com.jiyun.yingyuxinyuan.model.biz.ZuoPingService;
import com.jiyun.yingyuxinyuan.ui.activity.my.zuoping.presenter.ZuoPingPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZuoPingActivity extends BaseActivity<ZuoPingPresenter> implements ZuoPingContract.View {

    @BindView(R.id.zuoping_close)
    ImageView zuopingClose;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.linear_zuo)
    LinearLayout linearZuo;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zuo_ping);
        ButterKnife.bind(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_zuo_ping;
    }

    @Override
    protected void init() {
        userId = LoginShareUtils.getUserMessage(this, LoginShareUtils.ID);
    }

    @Override
    protected void loadDate() {
        presenter.loadData(userId);
    }

    @OnClick({R.id.zuoping_close})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zuoping_close:
                finish();
                break;
        }
    }

    @Override
    public void showData(ZuoPingBean zuoPingBean) {
        linearZuo.setVisibility(View.GONE);
        recycler.setVisibility(View.VISIBLE);
        Toast.makeText(this, zuoPingBean.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErroe(String msg) {
        linearZuo.setVisibility(View.VISIBLE);
        recycler.setVisibility(View.GONE);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
