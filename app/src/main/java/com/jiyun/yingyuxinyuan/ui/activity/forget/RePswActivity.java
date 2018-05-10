package com.jiyun.yingyuxinyuan.ui.activity.forget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.contract.RePswContract;
import com.jiyun.yingyuxinyuan.ui.MainActivity;
import com.jiyun.yingyuxinyuan.ui.activity.LoginActivity;
import com.jiyun.yingyuxinyuan.ui.activity.forget.presenter.RePswPresenterimp;
import com.jiyun.yingyuxinyuan.ui.modular.homework.fragment.HomeworkFragment;
import com.jiyun.yingyuxinyuan.ui.modular.person.fragment.PersonFragment;
import com.jiyun.yingyuxinyuan.ui.modular.preview.fragment.PreviewFragment;
import com.jiyun.yingyuxinyuan.ui.modular.teacher.fragment.TeacherFragment;
import com.jiyun.yingyuxinyuan.ui.modular.treasure.fragment.TreasureFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RePswActivity extends BaseActivity<RePswPresenterimp> implements RePswContract.RePswView {

    @BindView(R.id.resetpass_aty_cancle)
    TextView resetpassAtyCancle;
    @BindView(R.id.resetpass_aty_et)
    EditText resetpassAtyEt;
    @BindView(R.id.resetpass_aty_rp_et)
    EditText resetpassAtyRpEt;
    @BindView(R.id.resetpass_aty_loginbtn)
    Button resetpassAtyLoginbtn;
    private String psw_et;
    private String psw_re_et;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_re_psw;
    }

    @Override
    protected void init() {
    }

    @Override
    protected void loadDate() {

    }

    @OnClick({R.id.resetpass_aty_loginbtn,R.id.resetpass_aty_cancle})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.resetpass_aty_cancle:
                finish();
                break;
//                完成
            case R.id.resetpass_aty_loginbtn:
                psw_et = resetpassAtyEt.getText().toString();
                psw_re_et = resetpassAtyRpEt.getText().toString();
                if (TextUtils.isEmpty(psw_et) || TextUtils.isEmpty(psw_re_et)){
                    return;
                }
                startActivity(new Intent(RePswActivity.this,PersonFragment.class));
//                ressetPsw();
                break;
        }
    }

    private void ressetPsw() {
        Intent intent = getIntent();
        String jump_phone = intent.getStringExtra("Jump_phone");
        if (!psw_et.equals(psw_re_et)|| psw_et.toString().length()<6){
            Toast.makeText(this, "两次密码输入不正确", Toast.LENGTH_SHORT).show();
        }
        presenter.finish(jump_phone,psw_et);
    }
    @Override
    public void showMessage(String mesage) {
        Toast.makeText(this, "完成", Toast.LENGTH_SHORT).show();
    }
}
