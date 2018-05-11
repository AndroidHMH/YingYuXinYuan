package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.LoginBean;

/**
 * Created by ASUS on 2018/05/05.
 */

public interface LoginContract {
    interface LoginView {
        void gotoMain();

        void showError(String msg);
    }

    interface LoginPresenter extends BasePresenter<LoginView> {
        void getLogin(String phone, String password);

        boolean isPhone(String phone);

        boolean isPsw(String password);

        void loadUserInfo(int id);
    }
}
