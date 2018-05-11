package com.jiyun.yingyuxinyuan.ui.activity.my.dingdan.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.config.DateUtils;
import com.jiyun.yingyuxinyuan.model.bean.DingDanBean;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by asus on 2018/5/11.
 */

public class DingDanAdapter extends RecyclerView.Adapter<DingDanAdapter.Holder> {
    private List<DingDanBean.DataBean.ListBean> list;
    private Context context;

    public DingDanAdapter(List<DingDanBean.DataBean.ListBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.ding_dan_recycler_item, parent, false);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        final DingDanBean.DataBean.ListBean listBean = list.get(position);
        holder.dingDanRecyclerItemPriceTv.setText("￥ " + listBean.getPrice());
        holder.dingDanRecyclerItemTimeTv.setText(DateUtils.getYYYYbyTimeStampMs(listBean.getStartDate()));
        holder.dingDanRecyclerItemTitleTv.setText(listBean.getTitle());
        Glide.with(context).load(listBean.getCoverImg()).into(holder.dingDanRecyclerItemZhuangTaiBtn);
        holder.dingDanRecyclerItemXiangQingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myClick.xiangQing(listBean.getRefId() + "");
            }
        });
        holder.dingDanRecyclerItemZhuangTaiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myClick.zhuangTai(listBean.getOid() + "", listBean.getType() + "课");
            }
        });
    }

    private MyClick myClick;

    public void setMyClick(MyClick myClick) {
        this.myClick = myClick;
    }

    public interface MyClick {
        void xiangQing(String courseId);

        void zhuangTai(String oid, String courseType);
    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.ding_dan_recycler_item_title_tv)
        TextView dingDanRecyclerItemTitleTv;
        @BindView(R.id.ding_dan_recycler_item_zhuang_tai_tv)
        TextView dingDanRecyclerItemZhuangTaiTv;
        @BindView(R.id.ding_dan_recycler_item_xiang_qing_btn)
        LinearLayout dingDanRecyclerItemXiangQingBtn;
        @BindView(R.id.ding_dan_recycler_item_zhuang_tai_btn)
        ImageView dingDanRecyclerItemZhuangTaiBtn;
        @BindView(R.id.ding_dan_recycler_item_time_tv)
        TextView dingDanRecyclerItemTimeTv;
        @BindView(R.id.ding_dan_recycler_item_price_tv)
        TextView dingDanRecyclerItemPriceTv;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
