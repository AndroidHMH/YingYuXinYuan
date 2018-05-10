package com.jiyun.yingyuxinyuan.ui.modular.homeworkcontent.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.config.DateUtils;
import com.jiyun.yingyuxinyuan.contract.HomeworkContentContract;
import com.jiyun.yingyuxinyuan.model.bean.HomeworkContentBean;
import com.jiyun.yingyuxinyuan.ui.modular.homeworkcontent.adapter.DaShangAdapter;
import com.jiyun.yingyuxinyuan.ui.modular.homeworkcontent.adapter.PingLunAdapter;
import com.jiyun.yingyuxinyuan.ui.modular.homeworkcontent.presenter.HomeworkContentPresenter;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 推荐作业的点击事件
 */
public class HomeworkContentActivity extends BaseActivity<HomeworkContentPresenter> implements HomeworkContentContract.View, PingLunAdapter.SecondSend {


    @BindView(R.id.homework_content_close_btn)
    TextView homeworkContentCloseBtn;
    @BindView(R.id.homeworl_content_more_btn)
    ImageView homeworlContentMoreBtn;
    @BindView(R.id.homework_content_icon_img)
    RoundedImageView homeworkContentIconImg;
    @BindView(R.id.homework_content_name_tv)
    TextView homeworkContentNameTv;
    @BindView(R.id.homework_content_time_tv)
    TextView homeworkContentTimeTv;
    @BindView(R.id.homework_content_content_tv)
    TextView homeworkContentContentTv;
    @BindView(R.id.homework_content_img)
    ImageView homeworkContentImg;
    @BindView(R.id.homework_content_da_shang_btn)
    Button homeworkContentDaShangBtn;
    @BindView(R.id.homework_content_da_shang_recycler)
    RecyclerView homeworkContentDaShangRecycler;
    @BindView(R.id.homework_content_ping_lun_recycler)
    RecyclerView homeworkContentPingLunRecycler;
    @BindView(R.id.homework_content_input_btn)
    TextView homeworkContentInputBtn;
    @BindView(R.id.homework_content_dianzan_btn)
    TextView homeworkContentDianzanBtn;
    @BindView(R.id.homework_content_dianzan_num_tv)
    TextView homeworkContentDianzanNumTv;
    @BindView(R.id.homework_content_dianzan_group)
    RelativeLayout homeworkContentDianzanGroup;
    @BindView(R.id.homework_content_ping_lun_btn)
    TextView homeworkContentPingLunBtn;
    @BindView(R.id.homework_content_ping_lun_num_tv)
    TextView homeworkContentPingLunNumTv;
    @BindView(R.id.homework_content_ping_lun_group)
    RelativeLayout homeworkContentPingLunGroup;
    @BindView(R.id.wok_detail_aty_input_group)
    RelativeLayout wokDetailAtyInputGroup;
    @BindView(R.id.homework_content_source_tv)
    TextView homeworkContentSourceTv;
    @BindView(R.id.homework_content_error_group)
    LinearLayout homeworkContentErrorGroup;
    @BindView(R.id.homework_load_more_ping_lun_btn)
    TextView homeworkLoadMorePingLunBtn;
    private List<HomeworkContentBean.DataBean.CommentsBean.ListBean> list;
    private List<HomeworkContentBean.DataBean.RewardUserListBean> rewardUserList;
    private DaShangAdapter daShangAdapter;
    private PingLunAdapter pingLunAdapter;
    private String homewokId;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_homework_content;
    }

    @Override
    protected void init() {
        list = new ArrayList<>();
        rewardUserList = new ArrayList<>();
        Intent intent = getIntent();
        homewokId = intent.getStringExtra("homewokId");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        homeworkContentDaShangRecycler.setLayoutManager(linearLayoutManager);
        daShangAdapter = new DaShangAdapter(rewardUserList);
        homeworkContentDaShangRecycler.setAdapter(daShangAdapter);

        homeworkContentPingLunRecycler.setLayoutManager(new LinearLayoutManager(this));
        pingLunAdapter = new PingLunAdapter(list);
        homeworkContentPingLunRecycler.setAdapter(pingLunAdapter);
        pingLunAdapter.setSecondSend(this);
    }


    @Override
    protected void loadDate() {
        presenter.loadDate(homewokId);
    }

    @OnClick({R.id.homework_load_more_ping_lun_btn, R.id.homework_content_close_btn, R.id.homeworl_content_more_btn, R.id.homework_content_da_shang_btn, R.id.homework_content_input_btn, R.id.homework_content_dianzan_btn, R.id.homework_content_ping_lun_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.homework_content_close_btn:
                finish();
                break;
            case R.id.homeworl_content_more_btn:
                break;
            case R.id.homework_content_da_shang_btn:
                break;
            case R.id.homework_content_input_btn:
                break;
            case R.id.homework_content_dianzan_btn:
                break;
            case R.id.homework_content_ping_lun_btn:
                break;
            case R.id.homework_load_more_ping_lun_btn:
                break;
        }
    }

    @Override
    public void showDate(HomeworkContentBean homeworkContentBean) {
        HomeworkContentBean.DataBean data = homeworkContentBean.getData();
        HomeworkContentBean.DataBean.HomewokBean homewok = data.getHomewok();

        //打上的集合
        rewardUserList.addAll(data.getRewardUserList());
        daShangAdapter.notifyDataSetChanged();

        Glide.with(this).load(homewok.getPhoto()).placeholder(R.color.gray_prograss_bg)
                .error(R.color.gray_prograss_bg).dontAnimate().into(homeworkContentIconImg);

        homeworkContentNameTv.setText(homewok.getNickname());
        homeworkContentSourceTv.setText(homewok.getSource());
        homeworkContentTimeTv.setText(DateUtils.getYYYYbyTimeStampMs(homewok.getCreateDate()));
        homeworkContentContentTv.setText(homewok.getContent());
        Glide.with(this).load(homewok.getCoverImg()).into(homeworkContentImg);
    }

    @Override
    public void showPingLun(List<HomeworkContentBean.DataBean.CommentsBean.ListBean> list) {
        homeworkContentErrorGroup.setVisibility(View.GONE);
        homeworkContentPingLunRecycler.setVisibility(View.VISIBLE);
        homeworkLoadMorePingLunBtn.setVisibility(View.VISIBLE);

        this.list.addAll(list);
        pingLunAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorPingLun() {
        homeworkContentErrorGroup.setVisibility(View.VISIBLE);
        homeworkContentPingLunRecycler.setVisibility(View.GONE);
        homeworkLoadMorePingLunBtn.setVisibility(View.GONE);
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 点击回复
     */
    @Override
    public void huiFuClick() {

    }

    /**
     * 点击赞
     */
    @Override
    public void zanClick() {

    }
}
