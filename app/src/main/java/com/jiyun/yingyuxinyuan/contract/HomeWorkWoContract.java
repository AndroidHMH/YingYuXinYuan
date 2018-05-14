package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.HomeWorkWoBean;
import com.jiyun.yingyuxinyuan.model.bean.PingWoBean;

/**
 * Created by asus on 2018/5/10.
 */

public interface HomeWorkWoContract {
    interface View {
        void showData(HomeWorkWoBean homeWorkWoBean);

        void showError(String msg);
    }

    interface Presenter extends BasePresenter<View> {
        void loadDate(String userId);
//        void showData()
    }

}
