package com.jiyun.yingyuxinyuan.contract;

import com.jiyun.yingyuxinyuan.base.BasePresenter;
import com.jiyun.yingyuxinyuan.model.bean.HomeworkContentBean;

import java.util.List;

/**
 * Created by asus on 2018/5/9.
 */

public interface HomeworkContentContract {
    interface View {
        void showDate(HomeworkContentBean homeworkContentBean);

        void showPingLun(List<HomeworkContentBean.DataBean.CommentsBean.ListBean> list);

        void showErrorPingLun();

        void success(String msg);

        void showError(String msg);
    }

    interface Presenter extends BasePresenter<View> {
        void loadDate(String homewokId);

        void zanPingLun(String userId, String id, String type);

        void quXiaoZan(String userId, String id, String type);
    }
}
