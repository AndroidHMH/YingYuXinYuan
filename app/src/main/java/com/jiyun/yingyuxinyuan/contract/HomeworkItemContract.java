package com.jiyun.yingyuxinyuan.contract;

/**
 * Created by asus on 2018/5/3.
 */

import com.jiyun.yingyuxinyuan.model.bean.HomeworkBean;

/**
 * 作业页面的契约类
 */
public interface HomeworkItemContract {
    interface View {
        void showHomeworkBean(HomeworkBean homeworkBean);

        void showError();
    }

    interface Presenter {
        void loadHomeworkDate(int sortord, int loginUserId);
    }
}
