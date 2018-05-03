package com.jiyun.yingyuxinyuan.ui.modular.treasure.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.yingyuxinyuan.R;

/**
 * 宝典页面
 */
public class TreasureFragment extends Fragment {


    public TreasureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_treasure, container, false);
    }

}
