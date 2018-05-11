package com.jiyun.yingyuxinyuan.ui.activity.my.gift.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GiftActivity extends BaseActivity {

    @BindView(R.id.gift_bill_center_aty_cancle)
    TextView giftBillCenterAtyCancle;
    @BindView(R.id.gift_bill_center_aty_liwu_tv)
    TextView giftBillCenterAtyLiwuTv;
    @BindView(R.id.gift_bill_center_aty_liwu_line)
    TextView giftBillCenterAtyLiwuLine;
    @BindView(R.id.gift_bill_center_aty_liwu_group)
    RelativeLayout giftBillCenterAtyLiwuGroup;
    @BindView(R.id.gift_bill_center_aty_xianjin_tv)
    TextView giftBillCenterAtyXianjinTv;
    @BindView(R.id.gift_bill_center_aty_xianjin_line)
    TextView giftBillCenterAtyXianjinLine;
    @BindView(R.id.gift_bill_center_aty_xianjin_group)
    RelativeLayout giftBillCenterAtyXianjinGroup;
    @BindView(R.id.gift_bill_center_aty_recyclerview)
    RecyclerView giftBillCenterAtyRecyclerview;
    @BindView(R.id.gift_bill_center_aty_recyclerview_empty)
    RelativeLayout giftBillCenterAtyRecyclerviewEmpty;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_gift;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadDate() {

    }

    @OnClick({R.id.gift_bill_center_aty_cancle, R.id.gift_bill_center_aty_liwu_group, R.id.gift_bill_center_aty_xianjin_group})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.gift_bill_center_aty_cancle:
                break;
            case R.id.gift_bill_center_aty_liwu_group:
                break;
            case R.id.gift_bill_center_aty_xianjin_group:
                break;
        }
    }
}
