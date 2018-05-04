package com.jiyun.yingyuxinyuan.ui.activity.resgin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.contract.ResginContract;
import com.jiyun.yingyuxinyuan.ui.MainActivity;
import com.jiyun.yingyuxinyuan.ui.activity.resgin.presenter.ResginPresenterimp;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//注册完善信息
public class ResginAllActivity extends BaseActivity implements ResginContract.resginView{

    @BindView(R.id.resgin_all_return)
    ImageView resginAllReturn;
    @BindView(R.id.resgin_all_image)
    ImageView resginAllImage;
    @BindView(R.id.resgin_name)
    EditText resginName;
    @BindView(R.id.resgin_name_delete)
    ImageView resginNameDelete;
    @BindView(R.id.resgin_image_boy)
    ImageView resginImageBoy;
    @BindView(R.id.resgin_text_boy)
    TextView resginTextBoy;
    @BindView(R.id.linear_boy)
    LinearLayout linearBoy;
    @BindView(R.id.resgin_image_girl)
    ImageView resginImageGirl;
    @BindView(R.id.resgin_text_girl)
    TextView resginTextGirl;
    @BindView(R.id.linear_girl)
    LinearLayout linearGirl;
    @BindView(R.id.resgin_password)
    EditText resginPassword;
    @BindView(R.id.resgin_psw_delete)
    ImageView resginPswDelete;
    @BindView(R.id.resgin_finish)
    Button resginFinish;
    private ResginPresenterimp resginPresenterimp;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_resgin_all;
    }

    @Override
    protected void init() {
        setBoyView();
    }


    @Override
    protected void loadDate() {
        resginPresenterimp = new ResginPresenterimp(this);
        resginPresenterimp.getResginAll(resginPassword.getText().toString().trim());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.resgin_all_return,R.id.linear_boy,R.id.linear_girl,R.id.resgin_password,R.id.resgin_finish,})
    protected void onViewClicked(View view){
        switch (view.getId()){
            case R.id.resgin_all_return:
                finish();
                break;
            case R.id.linear_boy:
                setBoyView();
                break;
            case R.id.linear_girl:
                setGirlView();
                break;
            case R.id.resgin_password:
                break;
            case R.id.resgin_finish:
                resginPresenterimp.getResginAll(resginPassword.getText().toString().trim());
//                startActivity(new Intent(ResginAllActivity.this,SetHobbyActivity.class));
                break;
        }
    }

    private void setGirlView() {
        resginImageGirl.setImageResource(R.mipmap.check_woman_active);
        resginTextGirl.setTextColor(R.color.colorPrimary);

        resginImageBoy.setImageResource(R.mipmap.check_man_normal);
        resginTextBoy.setTextColor(R.color.gray);
    }

    private void setBoyView() {
        resginImageGirl.setImageResource(R.mipmap.check_woman_normal);
        resginTextGirl.setTextColor(R.color.gray);


        resginImageBoy.setImageResource(R.mipmap.check_man_active);
        resginTextBoy.setTextColor(R.color.colorPrimary);
    }

    @Override
    public void showPhone() {
    }

    @Override
    public void showPhoneYzmMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPhoneResginMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showRhoneResginAllMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
