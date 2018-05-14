package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.ZuoPingBean;

/**
 * Created by ASUS on 2018/05/13.
 */

public interface ZuoPingContract {
    interface View{
        void showData(ZuoPingBean zuoPingBean);
        void showErroe(String msg);
    }
    interface Presenter extends BasePresenter<View>{
        void loadData(String userId);
    }
}
