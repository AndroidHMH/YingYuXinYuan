package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;

/**
 * Created by ASUS on 2018/05/08.
 */

public interface RePswContract {
    interface RePswView{
        void showMessage(String mesage);
    }
    interface RePswPresenter extends BasePresenter<RePswView>{
        void finish(String phone,String psw);
    }
}
