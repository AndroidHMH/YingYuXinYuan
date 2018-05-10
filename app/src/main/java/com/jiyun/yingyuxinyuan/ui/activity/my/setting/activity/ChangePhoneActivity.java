package com.jiyun.yingyuxinyuan.ui.activity.my.setting.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.contract.ChangePhoneContract;
import com.jiyun.yingyuxinyuan.model.bean.ChangePhoneBean;
import com.jiyun.yingyuxinyuan.model.bean.TimeCount;
import com.jiyun.yingyuxinyuan.ui.activity.my.setting.presenter.ChangePhonePresenterimp;
import com.jiyun.yingyuxinyuan.view.MyEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangePhoneActivity extends BaseActivity<ChangePhonePresenterimp> implements ChangePhoneContract.ChangeView {

    @BindView(R.id.new_phone_cancle)
    TextView newPhoneCancle;
    @BindView(R.id.new_phone_et)
    MyEditText newPhoneEt;
    @BindView(R.id.new_phone_getcode_et)
    MyEditText newPhoneGetcodeEt;
    @BindView(R.id.new_phone_getcode_reset)
    Button newPhoneGetcodeReset;
    @BindView(R.id.new_phone_loginbtn)
    Button newPhoneLoginbtn;
    private TimeCount timeCount;
    private String phone;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_change_phone;
    }

    @Override
    protected void init() {
        timeCount = new TimeCount(60000, 1000, newPhoneGetcodeReset);
    }

    @Override
    protected void loadDate() {

    }

    @OnClick({R.id.new_phone_cancle,R.id.new_phone_et,
            R.id.new_phone_getcode_et,R.id.new_phone_getcode_reset,R.id.new_phone_loginbtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
//            关闭
            case R.id.new_phone_cancle:
                finish();
                break;
//                获取验证码
            case R.id.new_phone_getcode_reset:
                presenter.getChangeYzm(newPhoneEt.getText().toString());
                break;
//                下一步
            case R.id.new_phone_loginbtn:
                presenter.gotoNext(newPhoneEt.getText().toString(),newPhoneGetcodeEt.getText().toString());
                break;
        }
    }
    @Override
    public void showNewPhoneYzmMessage(String msg) {
        Toast.makeText(this, "获取验证码成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startTime() {
        timeCount.start();
    }

    @Override
    public void gotoNext(ChangePhoneBean changePhoneBean) {
        startActivity(new Intent(ChangePhoneActivity.this,SettingActivity.class));
        finish();
    }

    @Override
    public void next() {
        startActivity(new Intent(this,ChangePhoneNextActivity.class));
    }
}
