package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.GuanZhuBean;

/**
 * Created by ASUS on 2018/05/13.
 */

public interface GuanZhuContract {
    interface View{
        void showData(GuanZhuBean guanZhuBean);
        void showError(String msg);
    }
    interface Presenter extends BasePresenter<View>{
        void loadData(String userId);
    }
}
