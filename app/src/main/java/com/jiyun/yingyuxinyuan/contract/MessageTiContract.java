package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.config.LoginShareUtils;
import com.jiyun.yingyuxinyuan.model.bean.DingTiBean;

/**
 * Created by asus on 2018/5/10.
 */

public interface MessageTiContract {
    interface View {
        void showData(DingTiBean dingTiBean);

        void showError(String msg);
    }

    interface Presenter extends BasePresenter<View> {
        void loadDate(String userId);
//        void showData()
    }

}
