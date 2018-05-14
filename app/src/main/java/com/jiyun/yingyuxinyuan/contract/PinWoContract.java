package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.PingWoBean;
import com.jiyun.yingyuxinyuan.model.bean.ZanBean;

/**
 * Created by asus on 2018/5/10.
 */

public interface PinWoContract {
    interface View {
        void showData(PingWoBean pingWoBean);

        void showError(String msg);
    }

    interface Presenter extends BasePresenter<View> {
        void loadDate(String userId);
//        void showData()
    }

}
