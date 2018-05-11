package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.DingTiBean;
import com.jiyun.yingyuxinyuan.model.bean.ZanBean;

/**
 * Created by asus on 2018/5/10.
 */

public interface ZanContract {
    interface View{
        void showData(ZanBean zanBean);
    }
    interface Presenter extends BasePresenter<View>{
        void showData(String userId);
//        void showData()
    }

}
