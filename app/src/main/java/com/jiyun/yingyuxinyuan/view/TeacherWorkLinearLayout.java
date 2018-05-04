package com.jiyun.yingyuxinyuan.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

/**
 * Created by asus on 2018/5/4.
 */

public class TeacherWorkLinearLayout extends LinearLayoutManager {
    private boolean isScrollEnabled = true;

    public TeacherWorkLinearLayout(Context context) {
        super(context);
    }

    public void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }

    @Override
    public boolean canScrollVertically() {
        //Similarly you can customize "canScrollHorizontally()" for managing horizontal scroll
        return isScrollEnabled && super.canScrollVertically();
    }
}