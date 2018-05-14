package com.jiyun.yingyuxinyuan.ui.activity.my.fensi.adapter;

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
import com.jiyun.yingyuxinyuan.model.bean.FenSiBean;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

/**
 * Created by ASUS on 2018/05/13.
 */

public class FenSiAdapter extends RecyclerView.Adapter<FenSiAdapter.ViewHolder> {
    private Context context;
    private List<FenSiBean.DataBean.ListBean> list;

    public FenSiAdapter(Context context, List<FenSiBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
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
        Glide.with(context).load(list.get(position).getPhoto()).into(holder.fen_si_image);
        holder.fen_si_name.setText(list.get(position).getNickname());
//        holder.fen_si_btn.setText(list.get(position).getUserType());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final RoundedImageView fen_si_image;
        private final TextView fen_si_name;
        private final Button fen_si_btn;

        public ViewHolder(View itemView) {
            super(itemView);
            fen_si_image = itemView.findViewById(R.id.guan_zhu_image);
            fen_si_name = itemView.findViewById(R.id.guan_zhu_name);
            fen_si_btn = itemView.findViewById(R.id.guan_zhu_btn);

        }
    }
}
