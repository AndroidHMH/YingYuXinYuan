package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.UnivstarBean;

/**
 * Created by ASUS on 2018/05/10.
 */

public interface UnivastarContract {
    interface View{
        void showData(UnivstarBean univstarBean);
    }
    interface Presenter extends BasePresenter<View>{
        void showData(String userId);
    }
}
