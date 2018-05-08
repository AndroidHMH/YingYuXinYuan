package com.jiyun.yingyuxinyuan.ui.activity.resgin.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.contract.SetHobbyContract;
import com.jiyun.yingyuxinyuan.model.bean.EventBean;
import com.jiyun.yingyuxinyuan.model.bean.SetHobbyBean;
import com.jiyun.yingyuxinyuan.ui.MainActivity;
import com.jiyun.yingyuxinyuan.ui.activity.resgin.adapter.YuanXiaoAdapter;
import com.jiyun.yingyuxinyuan.ui.activity.resgin.adapter.ZhuangyeAdapter;
import com.jiyun.yingyuxinyuan.ui.activity.resgin.presenter.SetPresenterimp;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 设置偏好页面----
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
    private ArrayList<SetHobbyBean.DataBean.CollegesBean> collegesBeans;
    private ArrayList<SetHobbyBean.DataBean.MajorsBean> majorsBeans;
    private ZhuangyeAdapter zhuangyeAdapter;
    private YuanXiaoAdapter yuanXiaoAdapter;
    //专业被点击
    private boolean usermajorIsClick = false;
    //学院被点击
    private boolean schoolIsClick = false;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_set_hobby;
    }

    @Override
    protected void init() {
        collegesBeans = new ArrayList<>();
        majorsBeans = new ArrayList<>();
        zhuangyeAdapter = new ZhuangyeAdapter(this, majorsBeans);
        yuanXiaoAdapter = new YuanXiaoAdapter(this, collegesBeans);
        usermajorSelectAtygridview.setAdapter(zhuangyeAdapter);
        usermajorSelectAtygridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View childAt = usermajorSelectAtygridview.getChildAt(position);
                ZhuangyeAdapter.ViewHolder tag = (ZhuangyeAdapter.ViewHolder) childAt.getTag();
                if (usermajorIsClick) {
                    tag.itemSingleItemName.setBackgroundResource(R.drawable.text_view_bg);
                } else {
                    tag.itemSingleItemName.setBackgroundResource(R.drawable.text_view_click_bg);
                }
                usermajorIsClick = !usermajorIsClick;
            }
        });
        userschoolSelectAtygridview.setAdapter(yuanXiaoAdapter);
        userschoolSelectAtygridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View childAt = userschoolSelectAtygridview.getChildAt(position);
                YuanXiaoAdapter.ViewHolder tag = (YuanXiaoAdapter.ViewHolder) childAt.getTag();
                if (schoolIsClick) {
                    tag.itemSingleItemName.setBackgroundResource(R.drawable.text_view_bg);
                } else {
                    tag.itemSingleItemName.setBackgroundResource(R.drawable.text_view_click_bg2);
                }
                schoolIsClick = !schoolIsClick;
            }
        });
    }

    @Override
    protected void loadDate() {
        presenter.getSetData();
    }

    @OnClick({R.id.usermajor_select_aty_num, R.id.usermajor_select_aty_unistar_btn,
            R.id.usermajor_select_aty_bottombar, R.id.complete_userinfo_aty_cancle,
            R.id.usermajor_select_aty_jump
    })
    protected void onViewClicked(View view) {
        switch (view.getId()) {
            // 底部状态栏  请选择
            case R.id.usermajor_select_aty_num:
                break;
            // 底部状态栏   选好了
            case R.id.usermajor_select_aty_unistar_btn:
                break;
            // 底部确认栏
            case R.id.usermajor_select_aty_bottombar:
                break;
            // 返回按钮
            case R.id.complete_userinfo_aty_cancle:
                finish();
                break;
            //   跳过
            case R.id.usermajor_select_aty_jump:
//                EventBus.getDefault().register(new EventBean(""));
//                startActivity(new Intent(SetHobbyActivity.this, MainActivity.class));
                finish();
                break;
        }
    }

    @Override
    public void showSetData(List<SetHobbyBean.DataBean.MajorsBean> majors) {
        majorsBeans.addAll(majors);
        zhuangyeAdapter.notifyDataSetChanged();
    }

    @Override
    public void showSchool(List<SetHobbyBean.DataBean.CollegesBean> colleges) {
        collegesBeans.addAll(colleges);
        yuanXiaoAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


}
