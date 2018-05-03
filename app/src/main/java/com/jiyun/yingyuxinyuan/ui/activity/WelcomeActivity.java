package com.jiyun.yingyuxinyuan.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.ui.MainActivity;

import butterknife.BindView;

public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.num)
    TextView num;
    private int number = 3;
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            num.setText(number--+"");
            if (number==0){
                handler.postDelayed(runnable2,500);
            }else{
                handler.postDelayed(runnable,1000);
            }

        }
    };
    private Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
            finish();
        }
    };
    @Override
    protected int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void init() {
        handler.postDelayed(runnable,1000);
    }

    @Override
    protected void loadDate() {

    }
}
