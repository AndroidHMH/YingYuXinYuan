package com.jiyun.yingyuxinyuan.ui.modular.person.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseFragment;
import com.jiyun.yingyuxinyuan.ui.activity.LoginActivity;
import com.jiyun.yingyuxinyuan.ui.activity.ResginActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 个人页面
 */
public class PersonFragment extends BaseFragment {

    @BindView(R.id.myself_setting)
    ImageView myself_setting;
    @BindView(R.id.title_message_iv)
    ImageView title_message_iv;
    @BindView(R.id.myself_resgin)
    Button myself_resgin;
    @BindView(R.id.myself_login)
    Button myself_login;

    @OnClick({R.id.myself_login,R.id.myself_resgin,R.id.myself_setting,R.id.title_message_iv})
    protected void onViewClicked(View view){
        switch (view.getId()){
            case R.id.myself_setting:
                startActivity(new Intent(getActivity(),LoginActivity.class));
                break;
            case R.id.title_message_iv:
                startActivity(new Intent(getActivity(),LoginActivity.class));
                break;
            case R.id.myself_login:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.myself_resgin:
                startActivity(new Intent(getActivity(), ResginActivity.class));
                break;
        }
    }

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
}
