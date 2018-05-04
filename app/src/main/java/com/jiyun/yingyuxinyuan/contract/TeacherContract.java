package com.jiyun.yingyuxinyuan.contract;

/**
 * Created by asus on 2018/5/3.
 */

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.TeacherHomePageBean;

import java.util.List;

/**
 * 名师页面的契约类
 */
public interface TeacherContract {

    interface View {
        void showRollPager(List<TeacherHomePageBean.DataBean.SystemAdsBean> systemAds);

        void showTeacherRecycler(List<TeacherHomePageBean.DataBean.UsersBean> users);

        void showClassRecycler(List<TeacherHomePageBean.DataBean.LiveCoursesBean> liveCourses);

        void showWorkRecycler(List<TeacherHomePageBean.DataBean.HomewoksBean> homewoks);

        void setHomeView();

        void showError(String msg);
    }

    interface Presenter extends BasePresenter<View> {
        void loadHomePageDate(Integer userId);
    }
}
