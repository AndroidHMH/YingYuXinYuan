package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.TieZiBean;
import com.jiyun.yingyuxinyuan.model.bean.ZuoPingBean;

/**
 * Created by ASUS on 2018/05/13.
 */

public interface TieZiContract {
    interface View{
        void showData(TieZiBean tieZiBean);
        void showErroe(String msg);
    }
    interface Presenter extends BasePresenter<TieZiContract.View> {
        void loadData(String userId);
    }
}
