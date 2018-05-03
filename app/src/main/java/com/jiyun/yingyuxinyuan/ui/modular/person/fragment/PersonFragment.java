package com.jiyun.yingyuxinyuan.ui.modular.person.fragment;


import android.content.Intent;
import android.view.View;
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
    @BindView(R.id.title_draw_iv)
    ImageView title_draw_iv;
    @BindView(R.id.my_login)
    Button my_login;
    @BindView(R.id.my_resgin)
    Button my_resgin;


    @OnClick({R.id.title_draw_iv,R.id.my_login,R.id.my_resgin})
    protected void onViewClicked(View view){
        switch (view.getId()){
//            更换图标
            case R.id.title_draw_iv:
                startActivity(new Intent(getActivity(),LoginActivity.class));
                break;
//             进入登陆页面
            case R.id.my_login:
                startActivity(new Intent(getActivity(),LoginActivity.class));
                break;
//             进入注册页面
            case R.id.my_resgin:
                startActivity(new Intent(getActivity(),ResginActivity.class));
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
