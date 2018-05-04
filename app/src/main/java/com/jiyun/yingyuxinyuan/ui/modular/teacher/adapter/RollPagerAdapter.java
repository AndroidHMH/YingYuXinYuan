package com.jiyun.yingyuxinyuan.ui.modular.teacher.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.model.bean.TeacherHomePageBean;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;

import java.util.List;

/**
 * Created by asus on 2018/5/4.
 */

public class RollPagerAdapter extends StaticPagerAdapter {
    private List<TeacherHomePageBean.DataBean.SystemAdsBean> systemAds;
    private Context context;

    public RollPagerAdapter(List<TeacherHomePageBean.DataBean.SystemAdsBean> systemAds) {
        this.systemAds = systemAds;
    }

    @Override
    public View getView(ViewGroup container, int position) {
        context = container.getContext();
        ImageView view = new ImageView(context);
        Glide.with(context).load(systemAds.get(position).getMobileImgUrl()).into(view);
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return view;
    }


    @Override
    public int getCount() {
        return systemAds.isEmpty() ? 0 : systemAds.size();
    }
}
