package com.jiyun.yingyuxinyuan.ui.modular.teacherlist.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.model.bean.TeacherListBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by asus on 2018/5/8.
 */

public class TeacherListItemAdapter extends RecyclerView.Adapter<TeacherListItemAdapter.Holder> implements View.OnClickListener {
    private List<TeacherListBean.DataBean.ListBean> list;
    private Context context;

    public TeacherListItemAdapter(List<TeacherListBean.DataBean.ListBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.teacher_list_item_recycler_item, parent, false);
        Holder holder = new Holder(inflate);
        inflate.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        TeacherListBean.DataBean.ListBean listBean = list.get(position);
        holder.teacherListItemRecyclerItemDiWei.setText(listBean.getIntro());
        holder.teacherListItemRecyclerItemName.setText(listBean.getNickname());
        Glide.with(context).load(listBean.getPhoto()).into(holder.teacherListItemRecyclerItemImg);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    public interface MyClick {
        void myClick(View view, int position);
    }

    private MyClick myClick;

    public void setMyClick(MyClick myClick) {
        this.myClick = myClick;
    }

    @Override
    public void onClick(View v) {
        if (myClick != null) {
            myClick.myClick(v, (int) v.getTag());
        }
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.teacher_list_item_recycler_item_img)
        ImageView teacherListItemRecyclerItemImg;
        @BindView(R.id.teacher_list_item_recycler_item_name)
        TextView teacherListItemRecyclerItemName;
        @BindView(R.id.teacher_list_item_recycler_item_vip)
        ImageView teacherListItemRecyclerItemVip;
        @BindView(R.id.teacher_list_item_recycler_item_di_wei)
        TextView teacherListItemRecyclerItemDiWei;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
