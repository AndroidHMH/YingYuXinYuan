package com.jiyun.yingyuxinyuan.ui.modular.teacher.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.model.bean.TeacherHomePageBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by asus on 2018/5/4.
 */

public class ClassGridAdapter extends BaseAdapter {
    private List<TeacherHomePageBean.DataBean.LiveCoursesBean> liveCourses;
    private Context context;

    public ClassGridAdapter(List<TeacherHomePageBean.DataBean.LiveCoursesBean> liveCourses, Context context) {
        this.liveCourses = liveCourses;
        this.context = context;
    }
    @Override
    public int getCount() {
        return liveCourses.isEmpty() ? 0 : liveCourses.size();
    }

    @Override
    public Object getItem(int position) {
        return liveCourses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.class_recycler_item, parent, false);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        TeacherHomePageBean.DataBean.LiveCoursesBean liveCoursesBean = liveCourses.get(position);
        holder.classRecyclerItemName.setText(liveCoursesBean.getRealname());
        holder.classRecyclerItemData.setText(liveCoursesBean.getUserId() + "");
        holder.classRecyclerItemTime.setText(liveCoursesBean.getPrice() + "");
        Glide.with(context).load(liveCoursesBean.getCoverImg()).into(holder.classRecyclerItemImg);
        holder.itemView.getTag();
        return convertView;
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.class_recycler_item_img)
        ImageView classRecyclerItemImg;
        @BindView(R.id.class_recycler_item_name)
        TextView classRecyclerItemName;
        @BindView(R.id.class_recycler_item_data)
        TextView classRecyclerItemData;
        @BindView(R.id.class_recycler_item_time)
        TextView classRecyclerItemTime;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
