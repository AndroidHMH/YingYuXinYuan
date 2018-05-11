package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;

/**
 * Created by asus on 2018/5/11.
 *
 */

public interface GiftContract {
    interface View {
        void showLiWu();

        void showShouRu();

        void showLoadError();

        void showError(String msg);

    }

    interface Presenter extends BasePresenter<View> {
        void loadLiWu();

        void loadShouRu();
    }
}
