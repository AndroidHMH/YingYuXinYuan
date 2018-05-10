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
import com.jiyun.yingyuxinyuan.ui.modular.person.fragment.PersonFragment;

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
    Unbinder unbinder;
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
    }

    @Override
    protected void loadDate() {

    }

    @OnClick({R.id.setting_close,
            R.id.setting_aty_phone_tv, R.id.change_phone, R.id.change_shejiao, R.id.change_psw,
            R.id.clean,R.id.setting_glide_cahce_tv, R.id.about, R.id.clean_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setting_close:
                finish();
                break;
            case R.id.change_phone:
                SharedPreferences login = getSharedPreferences("Login", MODE_PRIVATE);
                String nickname = login.getString("nickname", null);
                if (nickname != null){
                    settingAtyPhoneTv.setText(nickname);
                }
                startActivity(new Intent(SettingActivity.this, ChangePhoneActivity.class));
                break;
            case R.id.change_shejiao:
                startActivity(new Intent(SettingActivity.this, ChangeSheJiaoActivity.class));
                break;
            case R.id.change_psw:
                startActivity(new Intent(SettingActivity.this, ChangePswActivity.class));
                break;
            case R.id.clean:
                CacheUtil.clearAllCache(SettingActivity.this);
                settingGlideCahceTv.setText("0.0K");
                Toast.makeText(SettingActivity.this,"缓存已清理",Toast.LENGTH_SHORT).show();
                break;
            case R.id.about:
                startActivity(new Intent(SettingActivity.this, AboutActivity.class));
                break;
            case R.id.clean_login:
                startActivity(new Intent(SettingActivity.this, PersonFragment.class));
                finish();
                break;
        }
    }
}
