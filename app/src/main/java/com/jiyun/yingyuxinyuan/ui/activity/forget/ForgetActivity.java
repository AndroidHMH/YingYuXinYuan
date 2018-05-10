package com.jiyun.yingyuxinyuan.ui.activity.forget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.contract.ForgetContract;
import com.jiyun.yingyuxinyuan.model.bean.TimeCount;
import com.jiyun.yingyuxinyuan.ui.activity.forget.presenter.ForgetPresenterimp;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *
 */
public class ForgetActivity extends BaseActivity<ForgetPresenterimp> implements ForgetContract.ForgetView {

    @BindView(R.id.resgin_close)
    ImageView resginClose;
    @BindView(R.id.forget_phone)
    EditText forgetPhone;
    @BindView(R.id.forget_yzm)
    EditText forgetYzm;
    @BindView(R.id.forget_getyzm)
    Button forgetGetyzm;
    @BindView(R.id.forgetnext)
    Button forgetNext;
    private TimeCount timeCount;
    private String phone;
    @OnClick({R.id.resgin_close,R.id.forget_phone,R.id.forget_yzm,R.id.forget_getyzm,R.id.forgetnext})
    protected void onViewClicked(View view){
        switch (view.getId()) {
            case R.id.resgin_close:
                finish();
                break;
            case R.id.forget_getyzm:
                presenter.getPhoneCode(forgetPhone.getText().toString());
                break;
            case R.id.forgetnext:
                phone = forgetPhone.getText().toString();
                gotoNext(phone);
                break;
        }
    }

    private void gotoNext(String phone) {
        Intent intent = new Intent(ForgetActivity.this, RePswActivity.class);
        intent.putExtra("Jump_phone", phone);
        startActivity(intent);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_forget;
    }

    @Override
    protected void init() {
        timeCount = new TimeCount(60000, 1000, forgetGetyzm);
    }

    @Override
    protected void loadDate() {

    }

    @Override
    public void showPhoneYzmMessage(String msg) {

    }

    @Override
    public void startTime() {
        timeCount.start();
    }
}
