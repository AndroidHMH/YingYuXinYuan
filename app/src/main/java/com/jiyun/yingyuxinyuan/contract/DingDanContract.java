package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.DingDanBean;

/**
 * Created by asus on 2018/5/11.
 */

public interface DingDanContract {
    interface View {

        void showDate(DingDanBean dingDanBean);

        void showError();
    }

    interface Presenter extends BasePresenter<View> {
        void loadDate(String status);
    }
}
