package com.jiyun.yingyuxinyuan.ui.activity.my.setting.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.config.LoginShareUtils;
import com.jiyun.yingyuxinyuan.contract.ChangpswContract;
import com.jiyun.yingyuxinyuan.model.bean.TimeCount;
import com.jiyun.yingyuxinyuan.ui.activity.my.setting.presenter.ChangPswPresenter;
import com.jiyun.yingyuxinyuan.view.MyEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangePswActivity extends BaseActivity<ChangPswPresenter> implements ChangpswContract.View {


    @BindView(R.id.change_phone_aty_cancle)
    TextView changePhoneAtyCancle;
    @BindView(R.id.change_phone_aty_mobile_tv)
    TextView changePhoneAtyMobileTv;
    @BindView(R.id.change_phone_aty_getcode_et)
    MyEditText changePhoneAtyGetcodeEt;
    @BindView(R.id.change_phone_aty_getcode_reset)
    Button changePhoneAtyGetcodeReset;
    @BindView(R.id.change_phone_aty_loginbtn)
    Button changePhoneAtyLoginbtn;
    private TimeCount timeCount;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_change_psw;
    }

    @Override
    protected void init() {
        timeCount = new TimeCount(60000, 1000, changePhoneAtyGetcodeReset);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String phone = LoginShareUtils.getUserMessage(this, LoginShareUtils.MOBILE);
        changePhoneAtyMobileTv.setText(phone);
    }

    @Override
    protected void loadDate() {

    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startTime() {
        timeCount.start();
        changePhoneAtyLoginbtn.setEnabled(true);
    }

    @Override
    public void next() {
        startActivity(new Intent(this, ChangePswNextActivity.class));
        finish();
    }


    @OnClick({R.id.change_phone_aty_cancle, R.id.change_phone_aty_loginbtn, R.id.change_phone_aty_getcode_reset})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.change_phone_aty_cancle:
                finish();
                break;
            case R.id.change_phone_aty_getcode_reset:
                presenter.getYanZheng(changePhoneAtyMobileTv.getText().toString());
                break;
            case R.id.change_phone_aty_loginbtn:
                next();
                break;
        }
    }
}
