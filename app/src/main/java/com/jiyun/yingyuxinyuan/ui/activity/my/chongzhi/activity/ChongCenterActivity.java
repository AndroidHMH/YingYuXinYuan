package com.jiyun.yingyuxinyuan.ui.activity.my.chongzhi.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChongCenterActivity extends AppCompatActivity {

    @BindView(R.id.recharge_bottom)
    TextView rechargeBottom;
    @BindView(R.id.recharge_cancle)
    TextView rechargeCancle;
    @BindView(R.id.recharge_zhangdan)
    TextView rechargeZhangdan;
    @BindView(R.id.recharge_zhanghao_tv)
    TextView rechargeZhanghaoTv;
    @BindView(R.id.recharge_yue_tv)
    TextView rechargeYueTv;
    @BindView(R.id.recharge_recyclerview)
    RecyclerView rechargeRecyclerview;
    @BindView(R.id.recharge_group)
    RelativeLayout rechargeCenterAtyGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chong_center);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.recharge_cancle,R.id.recharge_zhangdan,R.id.recharge_zhanghao_tv,R.id.recharge_yue_tv,
        R.id.recharge_recyclerview,R.id.recharge_group
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
//            返回
            case R.id.recharge_cancle:
                finish();
                break;
//                账单
            case R.id.recharge_zhangdan:

                break;
//                账号
            case R.id.recharge_zhanghao_tv:
                break;
//                余额
            case R.id.recharge_yue_tv:
                break;
//                充值
            case R.id.recharge_recyclerview:
                break;
            case R.id.recharge_group:
                break;
        }
    }
}
