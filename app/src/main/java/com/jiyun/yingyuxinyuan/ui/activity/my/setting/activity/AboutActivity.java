package com.jiyun.yingyuxinyuan.ui.activity.my.setting.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutActivity extends AppCompatActivity {

    @BindView(R.id.about_title_cancle)
    TextView aboutTitleCancle;
    @BindView(R.id.about_intro_group)
    RelativeLayout aboutIntroGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.about_title_cancle,R.id.about_intro_group})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.about_title_cancle:
                finish();
                break;
            case R.id.about_intro_group:
                startActivity(new Intent(AboutActivity.this,AboutIntoActivity.class));
                break;
        }
    }
}
