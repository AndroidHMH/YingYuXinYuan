package com.jiyun.yingyuxinyuan.ui.modular.preview.fragment;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseFragment;
import com.jiyun.yingyuxinyuan.contract.PreviewContract;
import com.jiyun.yingyuxinyuan.model.bean.PreviewBean;
import com.jiyun.yingyuxinyuan.ui.MainActivity;
import com.jiyun.yingyuxinyuan.ui.modular.detailssystemads.activity.DetailsSystemAdsActivity;
import com.jiyun.yingyuxinyuan.ui.modular.preview.adapter.PreviewAdapter;
import com.jiyun.yingyuxinyuan.ui.modular.preview.presenter.PreviewPresenter;

import java.util.ArrayList;
import java.util.Calendar;
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
    @BindView(R.id.preview_error_group)
    LinearLayout previewErrorGroup;
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
        screenPopup = initScreenPopup(screenView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        screenPopup.setOnDismissListener(new PopupWindow.OnDismissListener() {


            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onDismiss() {
                previewRecycler.setBackground(new ColorDrawable(Color.WHITE));
                isShow = !isShow;
                previewScreenBtn.setText("时间筛选");
            }
        });

        list = new ArrayList<>();
        previewRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        previewAdapter = new PreviewAdapter(list);
        previewRecycler.setAdapter(previewAdapter);
        previewAdapter.setMyCLick(new PreviewAdapter.MyCLick() {
            @Override
            public void myClick(View view, int position) {
                PreviewBean.DataBean.ListBean listBean = list.get(position);
                Intent intent = new Intent(getContext(), DetailsSystemAdsActivity.class);
                intent.putExtra("mobileUrl", listBean.getId() + "");
                startActivity(intent);
            }
        });
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
                presenter.loadDate(0, "", "");
                dismissScreenPopup();
                break;
            case R.id.preview_determine_btn:
                String startTime = preview_start_time_tv.getText().toString();
                String endTime = preview_end_time_tv.getText().toString();
                presenter.loadDate(0, startTime, endTime);
                dismissScreenPopup();
                break;
            case R.id.preview_start_time_tv:
                showDatePickDlg(preview_start_time_tv);
                break;
            case R.id.preview_end_time_tv:
                showDatePickDlg(preview_end_time_tv);
                break;
        }
    }

    protected void showDatePickDlg(final TextView textView) {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                textView.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    private PopupWindow initScreenPopup(View view, int width, int height) {
        PopupWindow popupWindow = new PopupWindow(view, width, height, true);
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
        previewRecycler.setVisibility(View.VISIBLE);
        previewErrorGroup.setVisibility(View.GONE);
        list.clear();
        list.addAll(previewBean.getData().getList());
        previewAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
        previewRecycler.setVisibility(View.GONE);
        previewErrorGroup.setVisibility(View.VISIBLE);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void showScreenPopup() {
        previewRecycler.setBackground(new ColorDrawable(Color.parseColor("#aa000000")));

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
