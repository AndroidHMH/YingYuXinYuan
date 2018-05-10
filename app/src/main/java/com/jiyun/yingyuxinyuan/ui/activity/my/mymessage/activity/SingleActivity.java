package com.jiyun.yingyuxinyuan.ui.activity.my.mymessage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SingleActivity extends AppCompatActivity {

    @BindView(R.id.single_title_cancle)
    TextView singleTitleCancle;
    @BindView(R.id.single_title_tv)
    TextView singleTitleTv;
    @BindView(R.id.single_savebtn)
    TextView singleSavebtn;
    @BindView(R.id.single_input)
    EditText singleInput;
    public static final int NAME = 0;
    public static final int TITLE = 1;
    public static final int DETAIL = 2;
    public static final int CITY = 3;
    private int type;
    private String singleinput;
    private String name;
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        Intent intent = getIntent();
        name = intent.getStringExtra("Name");
        address = intent.getStringExtra("Address");
    }

    @OnClick({R.id.single_title_cancle,R.id.single_title_tv,R.id.single_input,R.id.single_savebtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.single_title_cancle:
                break;
            case R.id.single_title_tv:
                if (type == NAME){
                    singleTitleTv.setText("编辑昵称");
                }else if (type == TITLE){
                    singleTitleTv.setText("");
                }else if (type == CITY){
                    singleTitleTv.setText("编辑详细地址");
                }
                break;
            case R.id.single_input:

                break;
            case R.id.single_savebtn:
                singleinput = singleInput.getText().toString();

                break;
        }
    }
}
