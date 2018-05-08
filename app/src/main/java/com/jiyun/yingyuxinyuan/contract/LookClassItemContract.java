package com.jiyun.yingyuxinyuan.contract;

import android.os.IInterface;

import com.jiyun.yingyuxinyuan.model.bean.LookClassItemBean;

/**
 * Created by asus on 2018/5/8.
 */

public interface LookClassItemContract {
    interface View {
        void showDate(LookClassItemBean classItemBean);

        void showError(String msg);
    }

    interface Presenter {
        void loadDate(String type);
    }
}
