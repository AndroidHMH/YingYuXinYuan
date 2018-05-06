package com.jiyun.yingyuxinyuan.ui.activity.resgin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.model.bean.SetHobbyBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2018/05/05.
 */

public class YuanXiaoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<SetHobbyBean.DataBean.CollegesBean> list;
    private final LayoutInflater inflater;

    public YuanXiaoAdapter(Context context, ArrayList<SetHobbyBean.DataBean.CollegesBean> list) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.item_single_str, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.mTextView = (TextView) convertView.findViewById(R.id.id_tv_title);
            convertView.setTag(viewHolder);
        } else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mTextView.setText(list.get(position).getName());
        return convertView;
    }


    private final class ViewHolder {
        TextView mTextView;
    }
}
