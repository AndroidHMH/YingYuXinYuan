package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.MySelfBean;
import com.jiyun.yingyuxinyuan.model.bean.TieZiBean;

import java.util.List;

/**
 * Created by asus on 2018/5/13.
 */

public interface MySelfContract {
    interface View {
        void showUserDate(MySelfBean.DataBean.UserInfoBean userInfoBean);

        void showZuoPin(MySelfBean.DataBean.HomewokListBean homewokListBean);

        void showTieZi(List<TieZiBean.DataBean.ArtcircleListBean.ListBean> list);

        void showError(String msg);

        void showTieZiError(String msg);
    }

    interface Presenter extends BasePresenter<View> {
        void loadDate(String studentId);

        void loadTieZi(String studentId);
    }
}
