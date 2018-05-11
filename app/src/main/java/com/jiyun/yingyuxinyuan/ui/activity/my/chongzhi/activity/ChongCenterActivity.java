package com.jiyun.yingyuxinyuan.ui.activity.my.chongzhi.activity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.config.LoginShareUtils;
import com.jiyun.yingyuxinyuan.contract.ChongCenterContract;
import com.jiyun.yingyuxinyuan.model.bean.ChongCenterBean;
import com.jiyun.yingyuxinyuan.ui.activity.my.chongzhi.adapter.ChongCenterAdapter;
import com.jiyun.yingyuxinyuan.ui.activity.my.chongzhi.presenter.ChongCenterPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class ChongCenterActivity extends BaseActivity<ChongCenterPresenter> implements ChongCenterContract.View {

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
    private List<ChongCenterBean.DataBean.ListBean> list;
    private ChongCenterAdapter chongCenterAdapter;
    private PopupWindow popupWindow;
    private LinearLayout chong_center_popup_zhi_fu_bao_btn;
    private LinearLayout chong_center_popup_wei_xin_btn;
    private TextView chong_center_popup_qu_xiao;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_chong_center;
    }

    @Override
    protected void init() {
        initPopupWindow();
        list = new ArrayList<>();
        chongCenterAdapter = new ChongCenterAdapter(list);
        rechargeRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        rechargeRecyclerview.setAdapter(chongCenterAdapter);
        chongCenterAdapter.setMyClick(new ChongCenterAdapter.MyClick() {
            @Override
            public void myClick(View view, int position) {
                showPopup();
            }
        });
    }

    private void initPopupWindow() {
        View inflate = getLayoutInflater().inflate(R.layout.chong_center_popup, null);
        initViews(inflate);
        popupWindow = new PopupWindow(inflate, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setAnimationStyle(R.style.chong_center_animation);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
            }
        });
    }

    private void initViews(View inflate) {
        this.chong_center_popup_zhi_fu_bao_btn = (LinearLayout) inflate.findViewById(R.id.chong_center_popup_zhi_fu_bao_btn);
        this.chong_center_popup_wei_xin_btn = (LinearLayout) inflate.findViewById(R.id.chong_center_popup_wei_xin_btn);
        this.chong_center_popup_qu_xiao = (TextView) inflate.findViewById(R.id.chong_center_popup_qu_xiao);
        chong_center_popup_qu_xiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissPopup();
            }
        });
    }

    @Override
    protected void loadDate() {
        presenter.loadInfo(LoginShareUtils.getUserMessage(this, LoginShareUtils.ID));
    }

    @OnClick({R.id.recharge_cancle, R.id.recharge_zhangdan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            // 返回
            case R.id.recharge_cancle:
                finish();
                break;
            //账单
            case R.id.recharge_zhangdan:

                break;
        }
    }

    @Override
    public void showView(ChongCenterBean chongCenterBean) {
        ChongCenterBean.DataBean data = chongCenterBean.getData();
        //设置手机号
        rechargeZhanghaoTv.setText(data.getMobile());
        //设置余额
        rechargeYueTv.setText(data.getAmount() + "星豆");
        //设置列表
        list.addAll(data.getList());
        chongCenterAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPopup() {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.7f;
        getWindow().setAttributes(lp);
        View inflate = getLayoutInflater().inflate(R.layout.activity_chong_center, null);
        popupWindow.showAtLocation(inflate, Gravity.BOTTOM, 0, 0);
    }

    @Override
    public void dismissPopup() {
        popupWindow.dismiss();
    }
}
