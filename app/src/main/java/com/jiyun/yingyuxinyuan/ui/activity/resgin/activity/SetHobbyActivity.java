package com.jiyun.yingyuxinyuan.ui.activity.resgin.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.contract.SetHobbyContract;
import com.jiyun.yingyuxinyuan.model.bean.SetHobbyBean;
import com.jiyun.yingyuxinyuan.ui.activity.resgin.presenter.SetPresenterimp;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//设置偏好页面
public class SetHobbyActivity extends BaseActivity implements SetHobbyContract.sethobbyView {

    @BindView(R.id.usermajor_select_aty_num)
    TextView usermajorSelectAtyNum;
    @BindView(R.id.usermajor_select_aty_unistar_btn)
    TextView usermajorSelectAtyUnistarBtn;
    @BindView(R.id.usermajor_select_aty_bottombar)
    RelativeLayout usermajorSelectAtyBottombar;
    @BindView(R.id.complete_userinfo_aty_cancle)
    TextView completeUserinfoAtyCancle;
    @BindView(R.id.usermajor_select_aty_jump)
    TextView usermajorSelectAtyJump;
    @BindView(R.id.usermajor_select_atygridview)
    GridView usermajorSelectAtygridview;
    @BindView(R.id.userschool_select_atygridview)
    GridView userschoolSelectAtygridview;
    private SetPresenterimp setPresenterimp;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_set_hobby;
    }

    @Override
    protected void init() {
        setPresenterimp = new SetPresenterimp(this);
    }

    @Override
    protected void loadDate() {
        setPresenterimp.getSetData();
    }

    @OnClick({R.id.usermajor_select_aty_num,R.id.usermajor_select_aty_unistar_btn,
            R.id.usermajor_select_aty_bottombar,R.id.complete_userinfo_aty_cancle,
            R.id.usermajor_select_aty_jump,R.id.usermajor_select_atygridview,R.id.userschool_select_atygridview})
    protected void onViewClicked(View view){
        switch (view.getId()){
//            底部状态栏  请选择
            case R.id.usermajor_select_aty_num:
                break;
//            底部状态栏   选好了
            case R.id.usermajor_select_aty_unistar_btn:
                break;
//             底部确认栏
            case R.id.usermajor_select_aty_bottombar:
                break;
//             返回按钮
            case R.id.complete_userinfo_aty_cancle:
                finish();
                break;
//              跳过
            case R.id.usermajor_select_aty_jump:
                break;
//              专业GridView
            case R.id.usermajor_select_atygridview:

                break;
//              院校GridView
            case R.id.userschool_select_atygridview:
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void showSetData(final SetHobbyBean setHobbyBean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.e("SET", setHobbyBean.getData()+"");
            }
        });

    }
}
