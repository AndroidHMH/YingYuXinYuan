package com.jiyun.yingyuxinyuan.ui.modular.treasureitemcontent.adapter;

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
import com.jiyun.yingyuxinyuan.model.bean.HomeworkContentBean;
import com.jiyun.yingyuxinyuan.model.bean.TreasureItemContentBean;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by asus on 2018/5/9.
 */

public class PingLunAdapter extends RecyclerView.Adapter<PingLunAdapter.Holder> {
    private List<TreasureItemContentBean.DataBean.CommentsBean.ListBean> list;
    private Context context;

    public PingLunAdapter(List<TreasureItemContentBean.DataBean.CommentsBean.ListBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.ping_lun_recycler_item, parent, false);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        TreasureItemContentBean.DataBean.CommentsBean.ListBean listBean = list.get(position);
        Glide.with(context).load(listBean.getPhoto()).placeholder(R.color.gray_prograss_bg)
                .error(R.color.gray_prograss_bg).dontAnimate().into(holder.pingLunRecyclerItemIconImg);
        holder.pingLunRecyclerItemNameTv.setText(listBean.getNickname());
        holder.pingLunRecyclerItemTimeTv.setText(DateUtils.getYYYYbyTimeStampMs(listBean.getCreateDate()));
        holder.pingLunRecyclerItemContentTv.setText(listBean.getContent());
        holder.pingLunRecyclerItemZanCountTv.setText(listBean.getPraiseNum() + "");
        holder.pingLunRecyclerItemHuiFuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondSend.huiFuClick();
            }
        });
        holder.pingLunRecyclerItemContentTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondSend.zanClick();
            }
        });
    }

    private SecondSend secondSend;

    public void setSecondSend(SecondSend secondSend) {
        this.secondSend = secondSend;
    }

    public interface SecondSend {
        void huiFuClick();

        void zanClick();
    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.ping_lun_recycler_item_icon_img)
        RoundedImageView pingLunRecyclerItemIconImg;
        @BindView(R.id.ping_lun_recycler_item_name_tv)
        TextView pingLunRecyclerItemNameTv;
        @BindView(R.id.ping_lun_recycler_item_time_tv)
        TextView pingLunRecyclerItemTimeTv;
        @BindView(R.id.ping_lun_recycler_item_content_tv)
        TextView pingLunRecyclerItemContentTv;
        @BindView(R.id.ping_lun_recycler_item_hui_fu_count_tv)
        TextView pingLunRecyclerItemHuiFuCountTv;
        @BindView(R.id.ping_lun_recycler_item_zan_count_tv)
        TextView pingLunRecyclerItemZanCountTv;
        @BindView(R.id.ping_lun_recycler_item_zan_count_img)
        ImageView pingLunRecyclerItemZanCountImg;
        @BindView(R.id.ping_lun_recycler_item_hui_fu_btn)
        TextView pingLunRecyclerItemHuiFuBtn;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
