package com.jiyun.yingyuxinyuan.ui.modular.preview.fragment;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseFragment;
import com.jiyun.yingyuxinyuan.contract.PreviewContract;
import com.jiyun.yingyuxinyuan.model.bean.PreviewBean;
import com.jiyun.yingyuxinyuan.ui.modular.preview.adapter.PreviewAdapter;
import com.jiyun.yingyuxinyuan.ui.modular.preview.presenter.PreviewPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 预告页面
 */
public class PreviewFragment extends BaseFragment<PreviewPresenter> implements PreviewContract.View, View.OnClickListener {


    @BindView(R.id.preview_recycler)
    RecyclerView previewRecycler;
    @BindView(R.id.preview_screen_btn)
    Button previewScreenBtn;
    private List<PreviewBean.DataBean.ListBean> list;
    private PreviewAdapter previewAdapter;
    private PopupWindow screenPopup;
    public TextView preview_start_time_tv;
    public TextView preview_end_time_tv;
    public Button preview_reset_btn;
    public Button preview_determine_btn;
    public LinearLayout preview_screen_group;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_preview;
    }

    @Override
    protected void init() {
        View screenView = getLayoutInflater().inflate(R.layout.preview_screen_popup, null);
        initScreenViews(screenView);
        screenPopup = initScreenPopup(screenView, LinearLayout.LayoutParams.MATCH_PARENT);
        screenPopup.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {

                WindowManager.LayoutParams lp = getActivity().getWindow().getAttributes();
                lp.alpha = 1f;
                getActivity().getWindow().setAttributes(lp);
                isShow = !isShow;
                previewScreenBtn.setText("时间筛选");
            }
        });

        list = new ArrayList<>();
        previewRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        previewAdapter = new PreviewAdapter(list);
        previewRecycler.setAdapter(previewAdapter);
    }

    private void initScreenViews(View rootView) {
        preview_start_time_tv = (TextView) rootView.findViewById(R.id.preview_start_time_tv);
        preview_end_time_tv = (TextView) rootView.findViewById(R.id.preview_end_time_tv);
        preview_reset_btn = (Button) rootView.findViewById(R.id.preview_reset_btn);
        preview_determine_btn = (Button) rootView.findViewById(R.id.preview_determine_btn);
        preview_screen_group = (LinearLayout) rootView.findViewById(R.id.preview_screen_group);
        preview_reset_btn.setOnClickListener(this);
        preview_determine_btn.setOnClickListener(this);
        preview_start_time_tv.setOnClickListener(this);
        preview_end_time_tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.preview_reset_btn:
                preview_start_time_tv.setText("");
                preview_end_time_tv.setText("");
                dismissScreenPopup();
                break;
            case R.id.preview_determine_btn:
                dismissScreenPopup();
                break;
            case R.id.preview_start_time_tv:
                break;
            case R.id.preview_end_time_tv:
                break;
        }
    }

    private PopupWindow initScreenPopup(View view, int width) {
        PopupWindow popupWindow = new PopupWindow(view, width, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        return popupWindow;
    }


    @Override
    protected void loadDate() {
        presenter.loadDate(0, "", "");
    }

    @Override
    public void showDate(PreviewBean previewBean) {
        list.addAll(previewBean.getData().getList());
        previewAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    public PopupWindow.OnDismissListener touchoutsidedismiss = new PopupWindow.OnDismissListener() {

        @Override
        public void onDismiss() {
//            // TODO Auto-generated method stub
//            android.support.design.R.attr lp.alpha=1.0f;
//            getWindow().setAttributes(lp);

        }
    };

    @Override
    public void showScreenPopup() {
        WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
        params.alpha = 0.7f;
        getActivity().getWindow().setAttributes(params);

        screenPopup.showAsDropDown(previewScreenBtn);
    }

    @Override
    public void dismissScreenPopup() {


        screenPopup.dismiss();
    }

    private boolean isShow = true;

    @OnClick(R.id.preview_screen_btn)
    public void onViewClicked() {
        if (isShow) {
            showScreenPopup();
            previewScreenBtn.setText("完成");
        } else {
            previewScreenBtn.setText("时间筛选");
        }
        isShow = !isShow;
    }
}
