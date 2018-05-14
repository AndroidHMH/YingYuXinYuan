package com.jiyun.yingyuxinyuan.ui.activity.my.mymessage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.contract.SingleContract;
import com.jiyun.yingyuxinyuan.ui.activity.my.mymessage.presenter.SinglePresenter;
import com.jiyun.yingyuxinyuan.view.MyEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SingleActivity extends BaseActivity<SinglePresenter> implements SingleContract.View {

    @BindView(R.id.single_title_cancle)
    TextView singleTitleCancle;
    @BindView(R.id.single_title_tv)
    TextView singleTitleTv;
    @BindView(R.id.single_savebtn)
    TextView singleSavebtn;
    @BindView(R.id.single_input)
    MyEditText singleInput;
    private String name;
    private String address;
    private String type;
    private String message;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_single;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        type = intent.getStringExtra("type");
        if ("name".equals(type)) {
            name = intent.getStringExtra("Name");
            singleInput.setText(name);
            singleTitleTv.setText("编辑昵称");
        } else {
            address = intent.getStringExtra("Address");
            singleInput.setText(address);
            singleTitleTv.setText("编辑详细地址");
        }
    }

    @Override
    protected void loadDate() {

    }

    @OnClick({R.id.single_title_cancle, R.id.single_title_tv, R.id.single_input, R.id.single_savebtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.single_title_cancle:
                finish();
                break;
            case R.id.single_savebtn:
                message = this.singleInput.getText().toString();
                if ("name".equals(type)) {
                    presenter.sendChangeMsg(SinglePresenter.NICKNAME,message);
                } else {
                    presenter.sendChangeMsg(SinglePresenter.ADDRESS,message);
                }
                break;
        }
    }

    @Override
    public void returnActivity() {
        Intent intent = new Intent();
        if ("name".equals(type)) {
            intent.putExtra("name", message);
            setResult(MySettingActivity.CHANGE_NAME_RESULT_CODE);
        } else {
            intent.putExtra("address", message);
            setResult(MySettingActivity.CHANGE_ADDRESS_RESULT_CODE);
        }
        finish();
    }
}
