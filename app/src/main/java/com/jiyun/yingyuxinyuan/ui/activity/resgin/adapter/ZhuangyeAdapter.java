package com.jiyun.yingyuxinyuan.ui.activity.resgin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.model.bean.SetHobbyBean;
import com.jiyun.yingyuxinyuan.view.MyTabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ASUS on 2018/05/05.
 */

public class ZhuangyeAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<SetHobbyBean.DataBean.MajorsBean> lists;
    private final LayoutInflater inflater;

    public ZhuangyeAdapter(Context context, ArrayList<SetHobbyBean.DataBean.MajorsBean> lists) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int position) {
        return lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    ViewHolder viewHolder = null;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_single_str, parent, false);
            viewHolder = new ViewHolder(convertView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.itemSingleItemName.setText(lists.get(position).getName());

        return convertView;
    }

    public class ViewHolder {
        @BindView(R.id.item_single_item_name)
        public TextView itemSingleItemName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
