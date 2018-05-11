package com.jiyun.yingyuxinyuan.ui.activity.my.setting.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.config.CacheUtil;
import com.jiyun.yingyuxinyuan.config.LoginShareUtils;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;
import com.jiyun.yingyuxinyuan.ui.modular.person.fragment.LoginPersonFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 设置   。。。
 */
public class SettingActivity extends BaseActivity {


    @BindView(R.id.setting_close)
    TextView settingClose;
    @BindView(R.id.setting_aty_phone_tv)
    TextView settingAtyPhoneTv;
    @BindView(R.id.change_phone)
    RelativeLayout changePhone;
    @BindView(R.id.change_shejiao)
    RelativeLayout changeShejiao;
    @BindView(R.id.change_psw)
    RelativeLayout changePsw;
    @BindView(R.id.setting_glide_cahce_tv)
    TextView settingGlideCahceTv;
    @BindView(R.id.clean)
    RelativeLayout clean;
    @BindView(R.id.about)
    RelativeLayout about;
    @BindView(R.id.clean_login)
    RelativeLayout cleanLogin;
    public static final int CHANGE_PHONE = 1;
    public static final int CHANGE_PHONE_RESULT = 2;
    public static final int CHANGE_PSW = 3;
    public static final int CHANGE_PSW_RESULT = 4;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void init() {
        try {
            settingGlideCahceTv.setText(CacheUtil.getTotalCacheSize(SettingActivity.this));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //设置手机号
        settingAtyPhoneTv.setText(LoginShareUtils.getUserMessage(this, LoginShareUtils.MOBILE));
    }

    @Override
    protected void onResume() {
        super.onResume();
        //设置手机号
        settingAtyPhoneTv.setText(LoginShareUtils.getUserMessage(this, LoginShareUtils.MOBILE));
    }

    @Override
    protected void loadDate() {

    }

    @OnClick({R.id.setting_close,
            R.id.setting_aty_phone_tv, R.id.change_phone, R.id.change_shejiao, R.id.change_psw,
            R.id.clean, R.id.setting_glide_cahce_tv, R.id.about, R.id.clean_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setting_close:
                finish();
                break;
            case R.id.change_phone:
                startActivityForResult(new Intent(SettingActivity.this,
                        ChangePhoneActivity.class), CHANGE_PHONE);
                break;
            case R.id.change_shejiao:
                startActivity(new Intent(SettingActivity.this,
                        ChangeSheJiaoActivity.class));
                break;
            case R.id.change_psw:
                startActivityForResult(new Intent(SettingActivity.this,
                        ChangePswActivity.class), CHANGE_PSW);
                break;
            case R.id.clean:
                CacheUtil.clearAllCache(SettingActivity.this);
                settingGlideCahceTv.setText("0.0K");
                Toast.makeText(SettingActivity.this, "缓存已清理", Toast.LENGTH_SHORT).show();
                break;
            case R.id.about:
                startActivity(new Intent(SettingActivity.this, AboutActivity.class));
                break;
            case R.id.clean_login:
                LoginShareUtils.tuiChu(this);
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CHANGE_PHONE && resultCode == CHANGE_PHONE_RESULT) {

        } else if (CHANGE_PSW == requestCode && resultCode == CHANGE_PSW_RESULT) {

        }
    }
}
