package com.jiyun.yingyuxinyuan.ui.activity.my.messagelis.adapter;

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
import com.jiyun.yingyuxinyuan.model.bean.SystemMessageListModel;

import java.util.List;

/**
 * Created by ASUS on 2018/05/10.
 */

public class MessageListAdapter extends RecyclerView.Adapter<MessageListAdapter.ViewHolder>{
    List<SystemMessageListModel.DataBean> dataBeans;
    Context context;

    public MessageListAdapter(List<SystemMessageListModel.DataBean> dataBeans, Context context) {
        this.dataBeans = dataBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.messagelist_recy, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.content.setText(dataBeans.get(position).getContent());
        holder.time.setText(dataBeans.get(position).getCreateDate()+"");
        Glide.with(context).load(dataBeans.get(position).getIsRead()).into(holder.typeimg);
        holder.flag.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView content;
        private final TextView flag;
        private final ImageView newimg;
        private final TextView time;
        private final TextView title;
        private final ImageView typeimg;

        public ViewHolder(View itemView) {
            super(itemView);

            content = itemView.findViewById(R.id.messagelist_recy_content);
            flag = itemView.findViewById(R.id.messagelist_recy_flag);
            newimg = itemView.findViewById(R.id.messagelist_recy_newimg);
            time = itemView.findViewById(R.id.messagelist_recy_time);
            title = itemView.findViewById(R.id.messagelist_recy_title);
            typeimg = itemView.findViewById(R.id.messagelist_recy_typeimg);
        }
    }
}
