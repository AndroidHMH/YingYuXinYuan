package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.ChongCenterBean;

/**
 * Created by asus on 2018/5/11.
 */

public interface ChongCenterContract {
    interface View {
        void showView(ChongCenterBean chongCenterBean);

        void showError(String msg);

        void showPopup();

        void dismissPopup();
    }

    interface Presenter extends BasePresenter<View> {
        void loadInfo(String loginUserId);
    }
}
