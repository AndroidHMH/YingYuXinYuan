package com.jiyun.yingyuxinyuan.ui.activity.my.setting.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.contract.ChangePswNextContract;
import com.jiyun.yingyuxinyuan.model.bean.TimeCount;
import com.jiyun.yingyuxinyuan.ui.activity.my.setting.presenter.ChangePswNextPresenter;
import com.jiyun.yingyuxinyuan.view.MyEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangePswNextActivity extends BaseActivity<ChangePswNextPresenter> implements ChangePswNextContract.View {

    @BindView(R.id.change_phone_next_aty_cancle)
    TextView changePhoneNextAtyCancle;
    @BindView(R.id.change_psw_next_new_pasw_et)
    MyEditText changePswNextNewPaswEt;
    @BindView(R.id.change_psw_next_new_pasw_pasw_et)
    MyEditText changePswNextNewPaswPaswEt;
    @BindView(R.id.change_psw_next_send_btn)
    Button changePswNextSendBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_change_psw_next;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadDate() {

    }

    @OnClick({R.id.change_phone_next_aty_cancle, R.id.change_psw_next_send_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.change_phone_next_aty_cancle:
                finish();
                break;
            case R.id.change_psw_next_send_btn:
                presenter.loadPsw(changePswNextNewPaswEt.getText().toString().trim(), changePswNextNewPaswPaswEt.getText().toString().trim());
                break;
        }
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success() {
        setResult(SettingActivity.CHANGE_PSW_RESULT);
        finish();
    }
}
