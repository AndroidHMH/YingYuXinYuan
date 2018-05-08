package com.jiyun.yingyuxinyuan.ui.modular.person.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseFragment;
import com.jiyun.yingyuxinyuan.ui.activity.LoginActivity;
import com.jiyun.yingyuxinyuan.ui.activity.ResginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 个人页面
 */
public class PersonFragment extends BaseFragment {


    @BindView(R.id.myself_setting)
    ImageView myselfSetting;
    @BindView(R.id.title_message_iv)
    ImageView titleMessageIv;
    @BindView(R.id.myself_resgin)
    Button myselfResgin;
    @BindView(R.id.myself_login)
    Button myselfLogin;
    @BindView(R.id.linear_myself1)
    LinearLayout linearMyself1;
    Unbinder unbinder;
    int Code;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_person;
    }

    @Override
    protected void init() {
    }

    @Override
    protected void loadDate() {

    }
    @OnClick({R.id.myself_setting,R.id.title_message_iv,R.id.myself_resgin,R.id.myself_login,R.id.linear_myself1})
    protected void onViewClicked(View view){
        switch (view.getId()){
            case R.id.linear_myself1:
                break;
            case R.id.myself_setting:
//                    myselfSetting.setVisibility();
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.title_message_iv:
                startActivity(new Intent(getActivity(),LoginActivity.class));
                break;
            case R.id.myself_resgin:
                startActivity(new Intent(getActivity(), ResginActivity.class));
                break;
            case R.id.myself_login:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
