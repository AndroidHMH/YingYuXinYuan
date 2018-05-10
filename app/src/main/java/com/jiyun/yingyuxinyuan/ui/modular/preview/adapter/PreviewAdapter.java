package com.jiyun.yingyuxinyuan.ui.modular.preview.adapter;

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
import com.jiyun.yingyuxinyuan.model.bean.PreviewBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by asus on 2018/5/6.
 */

public class PreviewAdapter extends RecyclerView.Adapter<PreviewAdapter.Holder> implements View.OnClickListener {
    private List<PreviewBean.DataBean.ListBean> list;
    private Context context;

    public PreviewAdapter(List<PreviewBean.DataBean.ListBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.preview_recycler_item, parent, false);
        Holder holder = new Holder(inflate);
        inflate.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        PreviewBean.DataBean.ListBean listBean = list.get(position);
        holder.previewRecyclerItemAllCountTv.setText(listBean.getSubscribeNum() + "");
        holder.previewRecyclerItemNowCountTv.setText(listBean.getReservationNum() + "");
        holder.previewRecyclerItemPriceTv.setText(listBean.getPrice() + "");
        holder.previewRecyclerItemStartTimeTv.setText(DateUtils.getYYYYbyTimeStampMs(listBean.getStartDate()));
        holder.previewRecyclerItemTitleTv.setText("地址：" + listBean.getAddress());
        Glide.with(context).load(listBean.getCoverImg()).into(holder.previewRecyclerItemImg);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    public interface MyCLick {
        void myClick(View view, int position);
    }

    private MyCLick myCLick;

    public void setMyCLick(MyCLick myCLick) {
        this.myCLick = myCLick;
    }

    @Override
    public void onClick(View v) {
        if (myCLick != null) {
            myCLick.myClick(v, (int) v.getTag());
        }
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.preview_recycler_item_img)
        ImageView previewRecyclerItemImg;
        @BindView(R.id.preview_recycler_item_start_time_tv)
        TextView previewRecyclerItemStartTimeTv;
        @BindView(R.id.preview_recycler_item_now_count_tv)
        TextView previewRecyclerItemNowCountTv;
        @BindView(R.id.preview_recycler_item_all_count_tv)
        TextView previewRecyclerItemAllCountTv;
        @BindView(R.id.preview_recycler_item_price_tv)
        TextView previewRecyclerItemPriceTv;
        @BindView(R.id.preview_recycler_item_title_tv)
        TextView previewRecyclerItemTitleTv;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
