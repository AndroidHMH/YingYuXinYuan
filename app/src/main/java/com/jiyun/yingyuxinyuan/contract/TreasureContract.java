package com.jiyun.yingyuxinyuan.contract;

/**
 * Created by asus on 2018/5/3.
 */

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.TreasureRollPagerBean;
import com.jiyun.yingyuxinyuan.model.bean.TreasureTitleBean;

/**
 * 宝典页面的契约类
 */
public interface TreasureContract {
    interface View {
        void addTitle(TreasureTitleBean treasureTitleBean);
        void showRollPager(TreasureRollPagerBean treasureRollPagerBean);
    }

    interface Presenter extends BasePresenter<View> {
        void loadTitle();
        void loadRollPager();
    }
}
