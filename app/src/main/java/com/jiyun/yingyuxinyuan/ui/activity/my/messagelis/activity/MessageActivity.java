package com.jiyun.yingyuxinyuan.ui.activity.my.messagelis.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.ui.activity.my.dingdan.activity.DingDanActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageActivity extends BaseActivity {


    @BindView(R.id.message_cancle)
    TextView messageCancle;
    @BindView(R.id.message_ding_dan_tv)
    TextView messageDingDanTv;
    @BindView(R.id.message_ding_dan_btn)
    LinearLayout messageDingDanBtn;
    @BindView(R.id.message_zan_wo_tv)
    TextView messageZanWoTv;
    @BindView(R.id.message_zan_wo_btn)
    LinearLayout messageZanWoBtn;
    @BindView(R.id.message_ping_lun_tv)
    TextView messagePingLunTv;
    @BindView(R.id.message_ping_lun_btn)
    LinearLayout messagePingLunBtn;
    @BindView(R.id.message_homework_tv)
    TextView messageHomeworkTv;
    @BindView(R.id.message_homework_btn)
    LinearLayout messageHomeworkBtn;
    @BindView(R.id.message_univstar_tv)
    TextView messageUnivstarTv;
    @BindView(R.id.message_univstar_btn)
    LinearLayout messageUnivstarBtn;
    @BindView(R.id.message_guan_zhu_ti_xing_tv)
    TextView messageGuanZhuTiXingTv;
    @BindView(R.id.message_guan_zhu_ti_xing_btn)
    LinearLayout messageGuanZhuTiXingBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_message;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadDate() {

    }

    @OnClick({R.id.message_cancle, R.id.message_ding_dan_btn, R.id.message_zan_wo_btn, R.id.message_ping_lun_btn, R.id.message_homework_btn, R.id.message_univstar_btn, R.id.message_guan_zhu_ti_xing_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.message_cancle:
                finish();
                break;
            case R.id.message_ding_dan_btn:
                startActivity(new Intent(MessageActivity.this, MessageTiActivity.class));
                break;
            case R.id.message_zan_wo_btn:
                break;
            case R.id.message_ping_lun_btn:
                break;
            case R.id.message_homework_btn:
                break;
            case R.id.message_univstar_btn:
                break;
            case R.id.message_guan_zhu_ti_xing_btn:
                break;
        }
    }
}
