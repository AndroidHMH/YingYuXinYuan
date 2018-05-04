package com.jiyun.yingyuxinyuan.ui.modular.teacher.adapter;

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
import com.jiyun.yingyuxinyuan.model.bean.TeacherHomePageBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by asus on 2018/5/4.
 */

public class TeacherRecyclerAdapter extends RecyclerView.Adapter<TeacherRecyclerAdapter.Holder> implements View.OnClickListener {
    private List<TeacherHomePageBean.DataBean.UsersBean> users;
    private Context context;

    public TeacherRecyclerAdapter(List<TeacherHomePageBean.DataBean.UsersBean> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.teacher_recycler_item, parent, false);
        Holder holder = new Holder(inflate);
        inflate.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        TeacherHomePageBean.DataBean.UsersBean usersBean = users.get(position);
        holder.teacherRecyclerName.setText(usersBean.getNickname());
        holder.teacherRecyclerIntro.setText(usersBean.getIntro());
        Glide.with(context).load(usersBean.getPhoto()).into(holder.teacherRecyclerItemImg);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return users.isEmpty() ? 0 : users.size();
    }

    private MyClick myClick;

    public void setMyClick(MyClick myClick) {
        this.myClick = myClick;
    }

    public interface MyClick {
        void myClick(View view, int position);
    }

    @Override
    public void onClick(View v) {
        if (myClick != null) {
            myClick.myClick(v, (int) v.getTag());
        }
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.teacher_recycler_item_img)
        ImageView teacherRecyclerItemImg;
        @BindView(R.id.teacher_recycler_name)
        TextView teacherRecyclerName;
        @BindView(R.id.teacher_recycler_intro)
        TextView teacherRecyclerIntro;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
