package com.jiyun.yingyuxinyuan.contract;

/**
 * Created by ASUS on 2018/05/04.
 */

import com.jiyun.yingyuxinyuan.model.bean.SetHobbyBean;

/**
 * 偏好页面的契约类
 */
public interface SetHobbyContract {
    interface sethobbyView{
        void showSetData(SetHobbyBean setHobbyBean);
    }
    interface sethobbyPres{
//        获取数据
        void getSetData();
    }
}
