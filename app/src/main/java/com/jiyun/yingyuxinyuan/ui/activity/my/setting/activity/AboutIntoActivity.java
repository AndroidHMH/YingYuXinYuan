package com.jiyun.yingyuxinyuan.ui.activity.my.setting.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutIntoActivity extends AppCompatActivity {

    @BindView(R.id.about_into_title_cancle)
    TextView aboutIntoTitleCancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_into);
        ButterKnife.bind(this);
    }
    @OnClick(R.id.about_into_title_cancle)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.about_into_title_cancle:
                finish();
                break;
        }
    }
}
