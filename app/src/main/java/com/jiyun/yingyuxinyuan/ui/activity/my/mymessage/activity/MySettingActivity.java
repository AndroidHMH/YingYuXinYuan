package com.jiyun.yingyuxinyuan.ui.activity.my.mymessage.activity;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.config.GetImagePath;
import com.jiyun.yingyuxinyuan.config.LoginShareUtils;
import com.jiyun.yingyuxinyuan.ui.activity.resgin.activity.ResginAllActivity;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MySettingActivity extends BaseActivity {

    @BindView(R.id.setting_close)
    TextView settingClose;
    @BindView(R.id.change_image_my)
    RoundedImageView changeImageMy;
    @BindView(R.id.touxiang_my)
    RelativeLayout touxiangMy;
    @BindView(R.id.change_name_my)
    TextView changeNameMy;
    @BindView(R.id.name_my)
    RelativeLayout nameMy;
    @BindView(R.id.change_sex_my)
    TextView changeSexMy;
    @BindView(R.id.sex_my)
    RelativeLayout sexMy;
    @BindView(R.id.change_address_my)
    TextView changeAddressMy;
    @BindView(R.id.address_my)
    RelativeLayout addressMy;
    @BindView(R.id.change_birthday_my)
    TextView changeBirthdayMy;
    @BindView(R.id.birthday_my)
    RelativeLayout birthdayMy;
    private int sex = 0;
    //跳转相册
    public static final int REQUEST_CODE_PICK_IMAGE = 100;
    //权限申请
    public static final int MY_PERMISSIONS_REQUEST_CALL_PHONE2 = 1;
    //更改昵称的
    public static final int CHANGE_NAME_REQUEST_CODE = 2;
    public static final int CHANGE_NAME_RESULT_CODE = 3;
    //更改地址的
    public static final int CHANGE_ADDRESS_REQUEST_CODE = 4;
    public static final int CHANGE_ADDRESS_RESULT_CODE = 5;
    private Intent intent;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_setting;
    }

    @Override
    protected void init() {
        String userName = LoginShareUtils.getUserMessage(this, LoginShareUtils.NICKNAME);
        changeNameMy.setText(userName);
        String userAddress = LoginShareUtils.getUserMessage(this, LoginShareUtils.ADDRESS);
        changeAddressMy.setText(userAddress);
        intent = new Intent(MySettingActivity.this, SingleActivity.class);
    }

    @Override
    protected void loadDate() {

    }

    @OnClick({R.id.setting_close, R.id.touxiang_my,
            R.id.change_name_my, R.id.name_my, R.id.sex_my,
            R.id.change_address_my, R.id.address_my, R.id.change_birthday_my, R.id.birthday_my
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
//            返回
            case R.id.setting_close:
                finish();
                break;
//                更改头像
            case R.id.touxiang_my:
                SharedPreferences login = getSharedPreferences("Login", MODE_PRIVATE);
                String nickname = login.getString("nickname", null);
                String photo = login.getString("photo", null);

                if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                    Manifest.permission.READ_EXTERNAL_STORAGE
                            }, MY_PERMISSIONS_REQUEST_CALL_PHONE2);
                } else {
                    gotoPhoto();
                }
                break;
            // 更改昵称
            case R.id.name_my:
                intent.putExtra("Name", changeNameMy.getText().toString());
                intent.putExtra("type", "name");
                startActivityForResult(intent, CHANGE_NAME_REQUEST_CODE);
                break;
            // 更改性别
            case R.id.sex_my:
                final String[] items = new String[]{"男", "女"};
                new AlertDialog.Builder(this)
                        .setTitle("请选择")
                        .setItems(items, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                sex = which;
                                changeSexMy.setText(items[which]);
//                                postUserInfo();
                            }
                        })
                        .create().show();
                break;
//                更改地址
            case R.id.change_address_my:
                break;
            case R.id.address_my:
                intent.putExtra("Address", changeAddressMy.getText().toString());
                intent.putExtra("type", "address");
                startActivityForResult(intent, CHANGE_ADDRESS_REQUEST_CODE);
                break;
//                更改生日
            case R.id.birthday_my:
                DatePickerDialog dp = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int iyear, int monthOfYear, int dayOfMonth) {
                        long maxDate = datePicker.getMaxDate();//日历最大能设置的时间的毫秒值
                        int year = datePicker.getYear();//年
                        int month = datePicker.getMonth();//月-1
                        int dayOfMonth1 = datePicker.getDayOfMonth();//日*
                        changeBirthdayMy.setText(iyear + ":" + (monthOfYear + 1) + ":" + dayOfMonth);
                    }
                }, 1990, 1, 1);//2013:初始年份，2：初始月份-1 ，1：初始日期
                dp.show();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            /**
             * 从相册中选取图片的请求标志
             */
            case REQUEST_CODE_PICK_IMAGE:
                if (resultCode == RESULT_OK) {
                    String path = GetImagePath.getPath(this, data.getData());
                    Glide.with(this).load(path).asBitmap()
                            .override(85, 85).into(new BitmapImageViewTarget(changeImageMy) {
                        @Override
                        protected void setResource(Bitmap resource) {
                            RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getResources(), resource);
                            drawable.setCircular(true);
                            changeImageMy.setImageDrawable(drawable);
                        }
                    });
//                    presenter.uploadImg(path);

                } else {
                    showRhoneSettingMessage("失败");
                }
                break;
            case CHANGE_NAME_REQUEST_CODE:
                if (resultCode == CHANGE_NAME_RESULT_CODE) {
                    String name = data.getStringExtra("name");
                    changeNameMy.setText(name);
                }
                break;
            case CHANGE_ADDRESS_REQUEST_CODE:
                if (resultCode == CHANGE_ADDRESS_RESULT_CODE) {
                    String name = data.getStringExtra("address");
                    changeAddressMy.setText(name);
                }
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == MY_PERMISSIONS_REQUEST_CALL_PHONE2) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                gotoPhoto();
            } else {
                // Permission Denied
                Toast.makeText(MySettingActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void showRhoneSettingMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void gotoPhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");//相片类型
        startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE);
    }
}
