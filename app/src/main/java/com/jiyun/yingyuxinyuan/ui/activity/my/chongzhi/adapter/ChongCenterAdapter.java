package com.jiyun.yingyuxinyuan.ui.activity.my.chongzhi.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.model.bean.ChongCenterBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.http.Multipart;

/**
 * Created by asus on 2018/5/11.
 */

public class ChongCenterAdapter extends RecyclerView.Adapter<ChongCenterAdapter.Holder> implements View.OnClickListener {
    private List<ChongCenterBean.DataBean.ListBean> list;
    private Context context;

    public ChongCenterAdapter(List<ChongCenterBean.DataBean.ListBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.chong_center_recycler_item, parent, false);
        Holder holder = new Holder(inflate);
        inflate.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        ChongCenterBean.DataBean.ListBean listBean = list.get(position);
        holder.chongCenterRecyclerItemZhiTv.setText(listBean.getAmountAndroid() + "");
        holder.chongCenterRecyclerItemZhiBtn.setText("￥" + " " + listBean.getPriceAndroid());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.isEmpty() ? 0 : list.size();
    }

    public interface MyClick {
        void myClick(View view, int position);
    }

    private MyClick myClick;

    public void setMyClick(MyClick myClick) {
        this.myClick = myClick;
    }

    @Override
    public void onClick(View v) {
        if (myClick != null) {
            myClick.myClick(v, (int) v.getTag());
        }
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.chong_center_recycler_item_zhi_tv)
        TextView chongCenterRecyclerItemZhiTv;
        @BindView(R.id.chong_center_recycler_item_zhi_btn)
        TextView chongCenterRecyclerItemZhiBtn;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
