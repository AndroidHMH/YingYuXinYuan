package com.jiyun.yingyuxinyuan.ui.activity.my.myself.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MySelfActivity extends AppCompatActivity {

    @BindView(R.id.myself_close)
    ImageView myselfClose;
    @BindView(R.id.myself_button)
    Button myselfButton;
    @BindView(R.id.myself_zuoping_tv)
    TextView myselfZuopingTv;
    @BindView(R.id.myslef_zuoping_line)
    TextView myslefZuopingLine;
    @BindView(R.id.myself_zuoping)
    RelativeLayout myselfZuoping;
    @BindView(R.id.myself_tiezi_tv)
    TextView myselfTieziTv;
    @BindView(R.id.myself_tiezi_line)
    TextView myselfTieziLine;
    @BindView(R.id.myself_tiezi)
    RelativeLayout myselfTiezi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_self);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.myself_close,R.id.myself_button,
            R.id.myself_zuoping,R.id.myself_zuoping_tv,R.id.myslef_zuoping_line,
            R.id.myself_tiezi,R.id.myself_tiezi_tv,R.id.myself_tiezi_line
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.myself_close:
                finish();
                break;
            case R.id.myself_button:
                myselfButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        myselfButton.setBackgroundColor(R.color.gray);
                        myselfButton.setText("已关注");
                    }
                });
                break;
            case R.id.myself_zuoping:
                myselfZuopingTv.getText().toString();
                myslefZuopingLine.setVisibility(View.VISIBLE);
                break;
            case R.id.myself_tiezi:
                myselfTieziTv.getText().toString();
                myselfTieziLine.setVisibility(View.VISIBLE);
                break;
        }
    }
}
