package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.TreasureItemContentBean;

import java.util.List;

/**
 * Created by asus on 2018/5/10.
 */

public interface TreasureItemContentContract {
    interface View {
        void showDate(TreasureItemContentBean treasureItemContentBean);

        void showPingLun(List<TreasureItemContentBean.DataBean.CommentsBean.ListBean> list);

        void showErrorPingLun();

        void showError(String msg);
    }

    interface Presenter extends BasePresenter<View> {
        void loadDate(String artcircleId);
    }
}
