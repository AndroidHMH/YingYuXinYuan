package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.DetailsSystemAdsBean;
import com.jiyun.yingyuxinyuan.model.bean.DetailsSystemAdsTwoBean;

/**
 * Created by asus on 2018/5/8.
 */

public interface DetailsSystemAdsContract {
    interface View {
        void showDate(DetailsSystemAdsBean detailsSystemAdsBean);

        void showError(String msg);
    }

    interface Presenter extends BasePresenter<View> {
        void loadDate(String courseId);
    }
}
