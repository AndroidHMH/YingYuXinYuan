package com.jiyun.yingyuxinyuan.ui.activity.my.store.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseFragment;
import com.jiyun.yingyuxinyuan.contract.StoreContract;
import com.jiyun.yingyuxinyuan.model.bean.StoreBean;
import com.jiyun.yingyuxinyuan.ui.activity.my.store.presenter.StorePresenterimp;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhiBoFragment extends BaseFragment  implements StoreContract.View{


    @BindView(R.id.linear_tu)
    LinearLayout linearTu;
    @BindView(R.id.recycler_)
    RecyclerView recycler;
    Unbinder unbinder;

    public ZhiBoFragment() {
        // Required empty public constructor
    }
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhi_bo;
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadDate() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @Override
    public void showData(StoreBean storeBean) {

    }

    @Override
    public void showError() {

    }
}
