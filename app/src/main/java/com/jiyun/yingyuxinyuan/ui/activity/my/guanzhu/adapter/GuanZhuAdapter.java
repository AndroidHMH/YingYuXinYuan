package com.jiyun.yingyuxinyuan.ui.activity.my.guanzhu.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.model.bean.GuanZhuBean;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

/**
 * Created by ASUS on 2018/05/13.
 */

public class GuanZhuAdapter extends RecyclerView.Adapter<GuanZhuAdapter.ViewHolder> {
    private List<GuanZhuBean.DataBean.ListBean> list;
    private Context context;

    public GuanZhuAdapter(List<GuanZhuBean.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.guan_zhu_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.guan_zhu_name.setText(list.get(position).getNickname());
        Glide.with(context).load(list.get(position).getPhoto()).into(holder.guan_zhu_image);
//        holder.guan_zhu_btn.setText(list.get(position).getUserType());

        holder.guan_zhu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final RoundedImageView guan_zhu_image;
        private final TextView guan_zhu_name;
        private final Button guan_zhu_btn;

        public ViewHolder(View itemView) {
            super(itemView);

            guan_zhu_image = itemView.findViewById(R.id.guan_zhu_image);
            guan_zhu_name = itemView.findViewById(R.id.guan_zhu_name);
            guan_zhu_btn = itemView.findViewById(R.id.guan_zhu_btn);
        }
    }
}
