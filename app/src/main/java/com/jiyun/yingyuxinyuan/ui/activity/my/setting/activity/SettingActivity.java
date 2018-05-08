package com.jiyun.yingyuxinyuan.ui.activity.my.setting.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 设置
 */
public class SettingActivity extends BaseActivity {

    @BindView(R.id.setting_close)
    ImageView settingClose;
    @BindView(R.id.change_phone)
    LinearLayout changePhone;
    @BindView(R.id.change_shejiao)
    LinearLayout changeShejiao;
    @BindView(R.id.change_psw)
    LinearLayout changePsw;
    @BindView(R.id.clean)
    LinearLayout clean;
    @BindView(R.id.about)
    LinearLayout about;
    @BindView(R.id.clean_login)
    LinearLayout cleanLogin;
    Unbinder unbinder;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadDate() {

    }

    @OnClick({R.id.setting_close,R.id.change_phone,R.id.change_shejiao,R.id.change_psw,R.id.clean,R.id.about,R.id.clean_login})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.setting_close:
                finish();
                break;
            case R.id.change_phone:
                startActivity(new Intent(SettingActivity.this,ChangePhoneActivity.class));
                break;
            case R.id.change_shejiao:
                startActivity(new Intent(SettingActivity.this,ChangeSheJiaoActivity.class));
                break;
            case R.id.change_psw:
                startActivity(new Intent(SettingActivity.this,ChangePswActivity.class));
                break;
            case R.id.clean:
                break;
            case R.id.about:
                break;
            case R.id.clean_login:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
