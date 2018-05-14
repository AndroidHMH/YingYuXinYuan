package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.DetailsSystemAdsBean;
import com.jiyun.yingyuxinyuan.model.bean.DetailsSystemAdsTwoBean;

import java.lang.reflect.Type;

/**
 * Created by asus on 2018/5/8.
 */

public interface DetailsSystemAdsContract {
    interface View {
        void showDate(DetailsSystemAdsBean detailsSystemAdsBean);

        void showError(String msg);

        void sucess(String msg);

        void error(String msg);

    }

    interface Presenter extends BasePresenter<View> {
        void loadDate(String courseId);

        void shouCang(String userId,String type);

        void quXiaoStore(String userId,String type);
    }
}
