package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.UnivstarBean;

/**
 * Created by ASUS on 2018/05/10.
 */

public interface UnivastarContract {
    interface View {
        void showData(UnivstarBean univstarBean);

        void showError(String msh);
    }

    interface Presenter extends BasePresenter<View> {
        void loadDate(String userId);
    }
}
