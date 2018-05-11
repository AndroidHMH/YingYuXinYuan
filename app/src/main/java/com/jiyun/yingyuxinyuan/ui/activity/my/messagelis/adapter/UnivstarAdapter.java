package com.jiyun.yingyuxinyuan.ui.activity.my.messagelis.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.model.bean.UnivstarBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ASUS on 2018/05/10.
 */

public class UnivstarAdapter extends RecyclerView.Adapter<UnivstarAdapter.ViewHolder> {
    private List<UnivstarBean.DataBean.ListBean> list;
    private Context context;

    public UnivstarAdapter(List<UnivstarBean.DataBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public UnivstarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.univstar_recycler, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull UnivstarAdapter.ViewHolder holder, int position) {
       SimpleDateFormat sdf = new SimpleDateFormat("d"+"天前");
        Date date = new Date(list.get(position).getCreateDate());
        holder.message_time.setText(sdf.format(date));
        holder.content.setText("  "+list.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView message_time;
        private final EditText content;

        public ViewHolder(View itemView) {
            super(itemView);
            message_time = itemView.findViewById(R.id.message_time);
            content = itemView.findViewById(R.id.content);
        }
    }
}
