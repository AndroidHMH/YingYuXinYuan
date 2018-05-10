package com.jiyun.yingyuxinyuan.ui.activity.my.zuoping.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jiyun.yingyuxinyuan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZuoPingActivity extends AppCompatActivity {

    @BindView(R.id.zuoping_close)
    ImageView zuopingClose;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.linear_zuo)
    LinearLayout linearZuo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zuo_ping);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.zuoping_close, R.id.recycler,R.id.linear_zuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zuoping_close:
                finish();
                break;
            case R.id.recycler:
                break;
            case R.id.linear_zuo:
                break;
        }
    }
}
