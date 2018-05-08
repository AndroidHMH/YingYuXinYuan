package com.jiyun.yingyuxinyuan.ui.modular.lookclass.adapter;

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
import com.jiyun.yingyuxinyuan.config.DateUtils;
import com.jiyun.yingyuxinyuan.model.bean.LookClassItemBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by asus on 2018/5/8.
 */

public class LookClassItemAdapter extends RecyclerView.Adapter<LookClassItemAdapter.Holder> implements View.OnClickListener {
    private List<LookClassItemBean.DataBean.ListBean> list;
    private Context context;

    public LookClassItemAdapter(List<LookClassItemBean.DataBean.ListBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.look_class_item_recycler_item, parent, false);
        Holder holder = new Holder(inflate);
        inflate.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        LookClassItemBean.DataBean.ListBean listBean = list.get(position);
        Glide.with(context).load(listBean.getCoverImg()).into(holder.lookClassItemRecyclerItemImg);
        holder.lookClassItemRecyclerItemAllCountTv.setText(listBean.getSubscribeNum() + "");
        holder.lookClassItemRecyclerItemNowCountTv.setText(listBean.getIsSubscribe() + "");
        holder.lookClassItemRecyclerItemName.setText(listBean.getNickname());
        holder.lookClassItemRecyclerItemPriceTv.setText(listBean.getPrice() + "");
        holder.lookClassItemRecyclerItemTime.setText(DateUtils.getYYYYbyTimeStampMs(listBean.getStartDate()));
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    public interface  MyClick{
        void myClick(View view,int position);
    }
    private MyClick myClick;

    public void setMyClick(MyClick myClick) {
        this.myClick = myClick;
    }

    @Override
    public void onClick(View v) {
        if (myClick != null) {
            myClick.myClick(v,(int)v.getTag());
        }
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.look_class_item_recycler_item_img)
        ImageView lookClassItemRecyclerItemImg;
        @BindView(R.id.look_class_item_recycler_item_time)
        TextView lookClassItemRecyclerItemTime;
        @BindView(R.id.look_class_item_recycler_item_name)
        TextView lookClassItemRecyclerItemName;
        @BindView(R.id.look_class_item_recycler_item_now_count_tv)
        TextView lookClassItemRecyclerItemNowCountTv;
        @BindView(R.id.look_class_item_recycler_item_all_count_tv)
        TextView lookClassItemRecyclerItemAllCountTv;
        @BindView(R.id.look_class_item_recycler_item_price_tv)
        TextView lookClassItemRecyclerItemPriceTv;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
