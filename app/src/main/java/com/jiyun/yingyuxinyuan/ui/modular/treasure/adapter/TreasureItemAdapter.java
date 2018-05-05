package com.jiyun.yingyuxinyuan.ui.modular.treasure.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.model.bean.TreasureItemBean;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by asus on 2018/5/5.
 */

public class TreasureItemAdapter extends RecyclerView.Adapter<TreasureItemAdapter.Holder> {
    private List<TreasureItemBean.DataBean.ArtcircleListBean.ListBean> list;
    private Context context;

    public TreasureItemAdapter(List<TreasureItemBean.DataBean.ArtcircleListBean.ListBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.treasure_item_recycler_item, parent, false);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {
        TreasureItemBean.DataBean.ArtcircleListBean.ListBean listBean = list.get(position);
        //设置头像
        Glide.with(context).load(listBean.getPhoto()).asBitmap()
                .placeholder(R.mipmap.user_head_portrait).error(R.mipmap.user_head_portrait)
                .dontAnimate()
                .into(new BitmapImageViewTarget(holder.treasureItemRecyclerItemTitleImg) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        holder.treasureItemRecyclerItemTitleImg.setImageBitmap(resource);
                    }
                });
        //设置姓名
        holder.treasureItemRecyclerItemStudentNameTv.setText(listBean.getNickname());
        //设置时间
        holder.treasureItemRecyclerItemSendTimeTv.setText(listBean.getCommentNum() + "");
        //设置标题
        holder.treasureItemRecyclerItemContentTitleTv.setText(listBean.getTitle());
        //设置内容
        holder.treasureItemRecyclerItemContentTv.setText(listBean.getContent());
        //设置图片
        Glide.with(context).load(listBean.getCoverImg()).into(holder.treasureItemRecyclerItemContentImg);
        //设置赞数
        int commentNum = listBean.getCommentNum();
        if (commentNum != 0) {
            holder.workRecyclerItemPraiseCb.setText(commentNum + "");
        } else {
            holder.workRecyclerItemPraiseCb.setText("");
        }
        //设置是否点赞
        int isPraise = listBean.getIsPraise();
        if (isPraise == 0) {
            holder.workRecyclerItemPraiseCb.setChecked(false);
        } else {
            holder.workRecyclerItemPraiseCb.setChecked(true);
        }
    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.treasure_item_recycler_item_title_img)
        RoundedImageView treasureItemRecyclerItemTitleImg;
        @BindView(R.id.treasure_item_recycler_item_student_name_tv)
        TextView treasureItemRecyclerItemStudentNameTv;
        @BindView(R.id.treasure_item_recycler_item_send_time_tv)
        TextView treasureItemRecyclerItemSendTimeTv;
        @BindView(R.id.treasure_item_recycler_item_content_title_tv)
        TextView treasureItemRecyclerItemContentTitleTv;
        @BindView(R.id.treasure_item_recycler_item_content_tv)
        TextView treasureItemRecyclerItemContentTv;
        @BindView(R.id.treasure_item_recycler_item_content_img)
        ImageView treasureItemRecyclerItemContentImg;
        @BindView(R.id.treasure_item_recycler_item_work_type_tv)
        TextView treasureItemRecyclerItemWorkTypeTv;
        @BindView(R.id.treasure_item_recycler_item_reply_cb)
        CheckBox treasureItemRecyclerItemReplyCb;
        @BindView(R.id.treasure_item_recycler_item_reply_group)
        LinearLayout treasureItemRecyclerItemReplyGroup;
        @BindView(R.id.work_recycler_item_praise_cb)
        CheckBox workRecyclerItemPraiseCb;
        @BindView(R.id.treasure_item_recycler_item_praise_group)
        LinearLayout treasureItemRecyclerItemPraiseGroup;
        @BindView(R.id.treasure_item_recycler_item_reward_cb)
        CheckBox treasureItemRecyclerItemRewardCb;
        @BindView(R.id.treasure_item_recycler_item_reward_group)
        LinearLayout treasureItemRecyclerItemRewardGroup;
        @BindView(R.id.treasure_item_recycler_item_share)
        LinearLayout treasureItemRecyclerItemShare;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
