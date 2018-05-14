package com.jiyun.yingyuxinyuan.ui.activity.my.store.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.yingyuxinyuan.R;

import java.util.List;

/**
 * Created by ASUS on 2018/05/11.
 */

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder>{
    private List<?> list;
    Context context;

    public StoreAdapter(List<?> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public StoreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.store_list_a, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StoreAdapter.ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
