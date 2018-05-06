package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.model.bean.TreasureItemBean;

/**
 * Created by asus on 2018/5/5.
 */

public interface TreasureItemContract {
    interface View {
        void showDate(TreasureItemBean treasureItemBean);

        void showError();
    }

    interface Presenter {
        void loadDate(int sortord, int loginUserId);
    }
}
