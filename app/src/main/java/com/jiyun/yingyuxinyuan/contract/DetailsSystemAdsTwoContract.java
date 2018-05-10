package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.DetailsSystemAdsBean;
import com.jiyun.yingyuxinyuan.model.bean.DetailsSystemAdsTwoBean;

/**
 * Created by asus on 2018/5/8.
 */

public interface DetailsSystemAdsTwoContract {
    interface View {
        void showDate(DetailsSystemAdsTwoBean detailsSystemAdsTwoBean);

        void showError(String msg);
    }

    interface Presenter extends BasePresenter<View> {
        void loadDate(String id);
    }
}
