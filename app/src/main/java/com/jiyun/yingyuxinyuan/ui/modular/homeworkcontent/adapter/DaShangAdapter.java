package com.jiyun.yingyuxinyuan.ui.modular.homeworkcontent.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.model.bean.HomeworkContentBean;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by asus on 2018/5/9.
 */

public class DaShangAdapter extends RecyclerView.Adapter<DaShangAdapter.Holder> {
    private List<HomeworkContentBean.DataBean.RewardUserListBean> rewardUserList;
    private Context context;

    public DaShangAdapter(List<HomeworkContentBean.DataBean.RewardUserListBean> rewardUserList) {
        this.rewardUserList = rewardUserList;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.da_shang_recycler_item, parent, false);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Glide.with(context).load(rewardUserList.get(position).getUserPhoto()).placeholder(R.color.gray_prograss_bg)
                .error(R.color.gray_prograss_bg).dontAnimate().into(holder.daShangRecyclerItemImg);
    }

    @Override
    public int getItemCount() {
        return rewardUserList.isEmpty() ? 0 : rewardUserList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.da_shang_recycler_item_img)
        RoundedImageView daShangRecyclerItemImg;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
