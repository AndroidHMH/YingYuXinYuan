package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.model.bean.TeacherListBean;

/**
 * Created by asus on 2018/5/8.
 */

public interface TeacherListItemContract {
    interface View {
        void showDate(TeacherListBean teacherListBean);

        void showError(String message);
    }

    interface Presenter {
        void loadDate(String loginUserId,int userType);
    }
}
