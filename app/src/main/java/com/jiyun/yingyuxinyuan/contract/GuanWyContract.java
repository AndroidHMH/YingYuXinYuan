package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.GuanMyBean;
import com.jiyun.yingyuxinyuan.model.bean.PingWoBean;

/**
 * Created by asus on 2018/5/10.
 */

public interface GuanWyContract {
    interface View{
        void showData(GuanMyBean guanMyBean);
    }
    interface Presenter extends BasePresenter<View>{
        void showData(String userId);
//        void showData()
    }

}
