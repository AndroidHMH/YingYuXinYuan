package com.jiyun.yingyuxinyuan.ui.activity.my.messagelis.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.ui.activity.my.messagelis.adapter.MessageListAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageActivity extends AppCompatActivity {

    @BindView(R.id.message_cancle)
    TextView messageCancle;
    @BindView(R.id.message_recycler)
    RecyclerView messageRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.message_cancle,R.id.message_recycler})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.message_cancle:
                finish();
                break;
            case R.id.message_recycler:
                break;
        }
    }
}
