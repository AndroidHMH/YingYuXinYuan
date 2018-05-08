package com.jiyun.yingyuxinyuan.contract;

/**
 * Created by ASUS on 2018/05/04.
 */

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.SetHobbyBean;

import java.util.List;

/**
 * 偏好页面的契约类
 */
public interface SetHobbyContract {
    interface sethobbyView {
        //展示专业
        void showSetData(List<SetHobbyBean.DataBean.MajorsBean> majors);

        //展示院校
        void showSchool(List<SetHobbyBean.DataBean.CollegesBean> colleges);

        void showErrorMsg(String msg);
    }

    interface sethobbyPres extends BasePresenter<sethobbyView> {
        //        获取数据
        void getSetData();
    }
}
