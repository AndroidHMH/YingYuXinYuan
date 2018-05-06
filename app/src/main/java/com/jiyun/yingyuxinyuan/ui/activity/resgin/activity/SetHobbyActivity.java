package com.jiyun.yingyuxinyuan.ui.activity.resgin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.contract.SetHobbyContract;
import com.jiyun.yingyuxinyuan.model.bean.SetHobbyBean;
import com.jiyun.yingyuxinyuan.ui.MainActivity;
import com.jiyun.yingyuxinyuan.ui.activity.resgin.adapter.YuanXiaoAdapter;
import com.jiyun.yingyuxinyuan.ui.activity.resgin.adapter.ZhuangyeAdapter;
import com.jiyun.yingyuxinyuan.ui.activity.resgin.presenter.SetPresenterimp;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 设置偏好页面
 */

public class SetHobbyActivity extends BaseActivity<SetPresenterimp> implements SetHobbyContract.sethobbyView {

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
    private ArrayList<SetHobbyBean.DataBean.CollegesBean> list;
    private ArrayList<SetHobbyBean.DataBean.MajorsBean> lists;
    private YuanXiaoAdapter yuanXiaoAdapter;
    private ZhuangyeAdapter zhuangyeAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_set_hobby;
    }

    @Override
    protected void init() {
    }

    @Override
    protected void loadDate() {
        presenter.getSetData();
    }

    @OnClick({R.id.usermajor_select_aty_num,R.id.usermajor_select_aty_unistar_btn,
            R.id.usermajor_select_aty_bottombar,R.id.complete_userinfo_aty_cancle,
            R.id.usermajor_select_aty_jump
           })
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
                startActivity(new Intent(SetHobbyActivity.this, MainActivity.class));
                finish();
                break;
//              专业GridView
            case R.id.usermajor_select_atygridview:
//                presenter.getSetData();
                zhuangyeAdapter = new ZhuangyeAdapter(SetHobbyActivity.this, lists);
                usermajorSelectAtygridview.setAdapter(zhuangyeAdapter);
                break;
//              院校GridView
            case R.id.userschool_select_atygridview:
                yuanXiaoAdapter = new YuanXiaoAdapter(SetHobbyActivity.this, list);
                usermajorSelectAtygridview.setAdapter(yuanXiaoAdapter);
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
        List<SetHobbyBean.DataBean.CollegesBean> colleges = setHobbyBean.getData().getColleges();
        list = new ArrayList<>();
        list.addAll(colleges);

        List<SetHobbyBean.DataBean.MajorsBean> majors = setHobbyBean.getData().getMajors();
        lists = new ArrayList<>();
        lists.addAll(majors);

    }
}
