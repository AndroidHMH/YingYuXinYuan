package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;

/**
 * Created by asus on 2018/5/10.
 */

public interface ChangePswNextContract {
    interface View {
        void showError(String msg);

        void success();
    }

    interface Presenter extends BasePresenter<View> {
        void loadPsw(String psw, String newPsw);

        boolean psw2psw(String psw, String newPsw);

        boolean isPsw(String psw);
    }
}
