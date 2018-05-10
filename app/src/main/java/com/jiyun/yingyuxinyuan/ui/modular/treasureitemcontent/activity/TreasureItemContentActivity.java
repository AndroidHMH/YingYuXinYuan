package com.jiyun.yingyuxinyuan.ui.modular.treasureitemcontent.activity;

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
import com.jiyun.yingyuxinyuan.contract.TreasureItemContentContract;
import com.jiyun.yingyuxinyuan.model.bean.TreasureItemContentBean;
import com.jiyun.yingyuxinyuan.ui.modular.treasureitemcontent.adapter.PingLunAdapter;
import com.jiyun.yingyuxinyuan.ui.modular.treasureitemcontent.presneter.TreasureItemContentPresenter;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 宝典页面的点击事件
 */
public class TreasureItemContentActivity extends BaseActivity<TreasureItemContentPresenter> implements TreasureItemContentContract.View, PingLunAdapter.SecondSend {

    @BindView(R.id.treasure_item_content_close_btn)
    TextView treasureItemContentCloseBtn;
    @BindView(R.id.treasure_item_content_more_btn)
    ImageView treasureItemContentMoreBtn;
    @BindView(R.id.treasure_item_content_icon_img)
    RoundedImageView treasureItemContentIconImg;
    @BindView(R.id.treasure_item_content_name_tv)
    TextView treasureItemContentNameTv;
    @BindView(R.id.treasure_item_content_time_tv)
    TextView treasureItemContentTimeTv;
    @BindView(R.id.treasure_item_content_content_tv)
    TextView treasureItemContentContentTv;
    @BindView(R.id.treasure_item_content_img)
    ImageView treasureItemContentImg;
    @BindView(R.id.treasure_item_content_da_shang_btn)
    Button treasureItemContentDaShangBtn;
    @BindView(R.id.treasure_item_content_ping_lun_recycler)
    RecyclerView treasureItemContentPingLunRecycler;
    @BindView(R.id.treasure_item_content_error_group)
    LinearLayout treasureItemContentErrorGroup;
    @BindView(R.id.treasure_item_content_load_more_ping_lun_btn)
    TextView treasureItemContentLoadMorePingLunBtn;
    @BindView(R.id.treasure_item_content_input_btn)
    TextView treasureItemContentInputBtn;
    @BindView(R.id.treasure_item_content_dianzan_btn)
    TextView treasureItemContentDianzanBtn;
    @BindView(R.id.treasure_item_content_dianzan_num_tv)
    TextView treasureItemContentDianzanNumTv;
    @BindView(R.id.treasure_item_content_dianzan_group)
    RelativeLayout treasureItemContentDianzanGroup;
    @BindView(R.id.treasure_item_content_ping_lun_btn)
    TextView treasureItemContentPingLunBtn;
    @BindView(R.id.treasure_item_content_ping_lun_num_tv)
    TextView treasureItemContentPingLunNumTv;
    @BindView(R.id.treasure_item_content_ping_lun_group)
    RelativeLayout treasureItemContentPingLunGroup;
    @BindView(R.id.treasure_item_content_input_group)
    RelativeLayout treasureItemContentInputGroup;
    private List<TreasureItemContentBean.DataBean.CommentsBean.ListBean> list;
    private PingLunAdapter pingLunAdapter;
    private String artcircleId;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_treasure_item_content;
    }

    @Override
    protected void init() {
        list = new ArrayList<>();
        pingLunAdapter = new PingLunAdapter(list);
        treasureItemContentPingLunRecycler.setLayoutManager(new LinearLayoutManager(this));
        treasureItemContentPingLunRecycler.setAdapter(pingLunAdapter);
        Intent intent = getIntent();
        artcircleId = intent.getStringExtra("artcircleId");

        pingLunAdapter.setSecondSend(this);
    }

    @Override
    protected void loadDate() {
        presenter.loadDate(artcircleId);
    }

    @OnClick({R.id.treasure_item_content_close_btn, R.id.treasure_item_content_more_btn, R.id.treasure_item_content_da_shang_btn, R.id.treasure_item_content_load_more_ping_lun_btn, R.id.treasure_item_content_input_btn, R.id.treasure_item_content_dianzan_btn, R.id.treasure_item_content_ping_lun_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.treasure_item_content_close_btn:
                finish();
                break;
            case R.id.treasure_item_content_more_btn:
                break;
            case R.id.treasure_item_content_da_shang_btn:
                break;
            case R.id.treasure_item_content_load_more_ping_lun_btn:
                break;
            case R.id.treasure_item_content_input_btn:
                break;
            case R.id.treasure_item_content_dianzan_btn:
                break;
            case R.id.treasure_item_content_ping_lun_btn:
                break;
        }
    }

    @Override
    public void showDate(TreasureItemContentBean treasureItemContentBean) {
        TreasureItemContentBean.DataBean data = treasureItemContentBean.getData();
        TreasureItemContentBean.DataBean.ArtcircleBean artcircle = data.getArtcircle();

        Glide.with(this).load(artcircle.getPhoto()).placeholder(R.color.gray_prograss_bg)
                .error(R.color.gray_prograss_bg).dontAnimate().into(treasureItemContentIconImg);
        treasureItemContentNameTv.setText(artcircle.getNickname());
        treasureItemContentTimeTv.setText(DateUtils.getYYYYbyTimeStampMs(artcircle.getCreateDate()));
        treasureItemContentContentTv.setText(artcircle.getContent());
        Glide.with(this).load(artcircle.getCoverImg()).into(treasureItemContentImg);
    }

    @Override
    public void showPingLun(List<TreasureItemContentBean.DataBean.CommentsBean.ListBean> list) {
        treasureItemContentErrorGroup.setVisibility(View.GONE);
        treasureItemContentPingLunRecycler.setVisibility(View.VISIBLE);
        treasureItemContentLoadMorePingLunBtn.setVisibility(View.VISIBLE);

        this.list.addAll(list);
        pingLunAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrorPingLun() {
        treasureItemContentErrorGroup.setVisibility(View.VISIBLE);
        treasureItemContentPingLunRecycler.setVisibility(View.GONE);
        treasureItemContentLoadMorePingLunBtn.setVisibility(View.GONE);
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void huiFuClick() {

    }

    @Override
    public void zanClick() {

    }
}
