package com.jiyun.yingyuxinyuan.ui.activity.my.store.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.ui.activity.my.store.StoreFragmentAdapter;
import com.jiyun.yingyuxinyuan.ui.activity.my.store.fragment.StoreListFragment;
import com.jiyun.yingyuxinyuan.ui.activity.my.store.fragment.TiYanFragment;
import com.jiyun.yingyuxinyuan.ui.activity.my.store.fragment.TieZiFragment;
import com.jiyun.yingyuxinyuan.ui.activity.my.store.fragment.WorkFragment;
import com.jiyun.yingyuxinyuan.ui.activity.my.store.fragment.ZhiBoFragment;
import com.jiyun.yingyuxinyuan.view.MyTabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 */
public class StoreActivity extends AppCompatActivity {

    @BindView(R.id.store_cancle)
    TextView storeCancle;
    @BindView(R.id.store_level1_tv)
    TextView storeLevel1Tv;
    @BindView(R.id.store_level1_line)
    TextView storeLevel1Line;
    @BindView(R.id.store_level1)
    RelativeLayout storeLevel1;
    @BindView(R.id.store_level2_tv)
    TextView storeLevel2Tv;
    @BindView(R.id.store_level2_line)
    TextView storeLevel2Line;
    @BindView(R.id.store_level2)
    RelativeLayout storeLevel2;
    @BindView(R.id.store_level3_tv)
    TextView storeLevel3Tv;
    @BindView(R.id.store_level3_line)
    TextView storeLevel3Line;
    @BindView(R.id.store_level3)
    RelativeLayout storeLevel3;
    @BindView(R.id.store_level4_tv)
    TextView storeLevel4Tv;
    @BindView(R.id.store_level4_line)
    TextView storeLevel4Line;
    @BindView(R.id.store_level4)
    RelativeLayout storeLevel4;
    @BindView(R.id.store_tablayout)
    TabLayout storeTablayout;
    @BindView(R.id.store_Viewpager)
    ViewPager storeViewpager;
    private List<String> title;
    private List<Fragment> fragment;
    private StoreFragmentAdapter storeFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        ButterKnife.bind(this);
        initData();
    }

    private void initAdapter() {
        storeFragmentAdapter = new StoreFragmentAdapter(getSupportFragmentManager(), fragment, title);
        storeTablayout.setupWithViewPager(storeViewpager);
        storeViewpager.setAdapter(storeFragmentAdapter);

    }

    private void initData() {
        title = new ArrayList<>();
        fragment = new ArrayList<>();
        title.add("直播课程");
        title.add("体验课程");
        title.add("偷听作业");
        title.add("帖子");
       /* fragment.add(new ZhiBoFragment());
        fragment.add(new TiYanFragment());
        fragment.add(new WorkFragment());
        fragment.add(new TieZiFragment());*/
        for (int i = 0; i < title.size(); i++) {
            fragment.add(new ZhiBoFragment());
        }
        initAdapter();
        storeFragmentAdapter.notifyDataSetChanged();

    }
}
