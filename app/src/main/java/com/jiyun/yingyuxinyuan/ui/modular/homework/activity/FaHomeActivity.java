package com.jiyun.yingyuxinyuan.ui.modular.homework.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FaHomeActivity extends AppCompatActivity {

    @BindView(R.id.fa_home_cancle)
    TextView faHomeCancle;
    @BindView(R.id.fa_home_title_group)
    RelativeLayout faHomeTitleGroup;
    @BindView(R.id.fa_home_ti_jiao_btn)
    TextView faHomeTiJiaoBtn;
    @BindView(R.id.fa_home_recyclerview)
    RecyclerView faHomeRecyclerview;
    @BindView(R.id.fa_home_teachername_tv)
    TextView faHomeTeachernameTv;
    @BindView(R.id.fa_home_teacherhint_tv)
    TextView faHomeTeacherhintTv;
    @BindView(R.id.fa_home_select_teacher)
    RelativeLayout faHomeSelectTeacher;
    @BindView(R.id.fa_home_add_img)
    ImageView faHomeAddImg;
    @BindView(R.id.fa_home_genghuan_btn)
    LinearLayout faHomeGenghuanBtn;
    @BindView(R.id.fa_home_progressBar)
    ProgressBar faHomeProgressBar;
    @BindView(R.id.fa_home_genghuan_group)
    LinearLayout faHomeGenghuanGroup;
    @BindView(R.id.fa_home_music_iv)
    ImageView faHomeMusicIv;
    @BindView(R.id.fa_home_music_time)
    TextView faHomeMusicTime;
    @BindView(R.id.fa_home_music_group)
    LinearLayout faHomeMusicGroup;
    @BindView(R.id.fa_home_video_time)
    TextView faHomeVideoTime;
    @BindView(R.id.fa_home_video_group)
    LinearLayout faHomeVideoGroup;
    @BindView(R.id.fa_home_add_btn)
    LinearLayout faHomeAddBtn;
    @BindView(R.id.fa_home_add_group)
    RelativeLayout faHomeAddGroup;
    @BindView(R.id.fa_home_input)
    EditText faHomeInput;
    @BindView(R.id.fa_home_select_tv)
    TextView faHomeSelectTv;
    @BindView(R.id.fa_home_selecttype)
    LinearLayout faHomeSelecttype;
    @BindView(R.id.fa_home_price)
    TextView faHomePrice;
    @BindView(R.id.fa_home_pushload)
    RelativeLayout faHomePushload;
    @BindView(R.id.publishredactwok_detail_group)
    RelativeLayout publishredactwokDetailGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fa_home);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.fa_home_cancle,R.id.fa_home_ti_jiao_btn,R.id.fa_home_recyclerview,R.id.fa_home_teacherhint_tv,
        R.id.fa_home_add_group})
    public void onViewClicked(View view) {
        switch (view.getId()) {
//            取消
            case R.id.fa_home_cancle:
                finish();
                break;
//                提交
            case R.id.fa_home_ti_jiao_btn:
                break;
//                专业Recycler
            case R.id.fa_home_recyclerview:
                break;
//            名师不指定
            case R.id.fa_home_teacherhint_tv:
                break;
//              添加
            case R.id.fa_home_add_group:
                break;
        }
    }
}
