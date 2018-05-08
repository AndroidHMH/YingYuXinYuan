package com.jiyun.yingyuxinyuan.model.bean;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.widget.Button;

/**
 * Created by asus on 2018/5/7.
 */

public class TimeCount extends CountDownTimer {
    Button btnGetcode;

    public TimeCount(long millisInFuture, long countDownInterval, Button btnGetcode) {
        super(millisInFuture, countDownInterval);
        this.btnGetcode = btnGetcode;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        btnGetcode.setClickable(false);
        btnGetcode.setEnabled(false);
        btnGetcode.setText(millisUntilFinished / 1000 + "");
    }

    @Override
    public void onFinish() {
        btnGetcode.setText("获取验证码");
        btnGetcode.setClickable(true);
        btnGetcode.setEnabled(true);
    }
}