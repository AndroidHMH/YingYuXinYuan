package com.jiyun.yingyuxinyuan.ui.activity.my.setting.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.contract.ChangePhoneNextContract;
import com.jiyun.yingyuxinyuan.model.bean.TimeCount;
import com.jiyun.yingyuxinyuan.ui.activity.my.setting.presenter.ChangePhoneNextPresenter;
import com.jiyun.yingyuxinyuan.view.MyEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangePhoneNextActivity extends BaseActivity<ChangePhoneNextPresenter> implements ChangePhoneNextContract.View {

    @BindView(R.id.change_phone_cancle)
    TextView changePhoneCancle;
    @BindView(R.id.change_phone_ed)
    MyEditText changePhoneEd;
    @BindView(R.id.change_phone_getcode_et)
    MyEditText changePhoneGetcodeEt;
    @BindView(R.id.change_phone_getcode_reset)
    Button changePhoneGetcodeReset;
    @BindView(R.id.change_phone_loginbtn)
    Button changePhoneLoginbtn;
    private TimeCount timeCount;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_change_phone_next;
    }

    @Override
    protected void init() {
        timeCount = new TimeCount(60000, 1000, changePhoneGetcodeReset);
    }

    @Override
    protected void loadDate() {
    }

    @OnClick({R.id.change_phone_cancle, R.id.change_phone_getcode_reset, R.id.change_phone_loginbtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.change_phone_cancle:
                finish();
                break;
            case R.id.change_phone_getcode_reset:
                String phone = changePhoneEd.getText().toString().trim();
                presenter.loadYanZheng(phone);
                break;
            case R.id.change_phone_loginbtn:
                presenter.changePhone(changePhoneEd.getText().toString().trim(), changePhoneGetcodeEt.getText().toString().trim());
                break;
        }
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startTime() {
        timeCount.start();
        changePhoneLoginbtn.setEnabled(true);
    }

    @Override
    public void success() {
        setResult(SettingActivity.CHANGE_PHONE_RESULT);
        finish();
    }
}
