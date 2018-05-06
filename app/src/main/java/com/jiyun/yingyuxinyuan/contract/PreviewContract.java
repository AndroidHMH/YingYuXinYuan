package com.jiyun.yingyuxinyuan.contract;

/**
 * Created by asus on 2018/5/3.
 */

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.PreviewBean;

/**
 * 预告页面的契约类
 */
public interface PreviewContract {
    interface View {
        void showDate(PreviewBean previewBean);

        void showError(String error);

        void showScreenPopup();
        void dismissScreenPopup();
    }

    interface Presenter extends BasePresenter<View> {
        void loadDate(int loginUserId, String startTime, String endTime);
    }

}
