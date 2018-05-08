package com.jiyun.yingyuxinyuan.ui.activity.resgin.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.SyncStateContract;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseActivity;
import com.jiyun.yingyuxinyuan.config.GetImagePath;
import com.jiyun.yingyuxinyuan.contract.ResginAllContract;
import com.jiyun.yingyuxinyuan.contract.ResginContract;
import com.jiyun.yingyuxinyuan.ui.MainActivity;
import com.jiyun.yingyuxinyuan.ui.activity.resgin.presenter.ResginAllPresenterimp;
import com.jiyun.yingyuxinyuan.ui.activity.resgin.presenter.ResginPresenterimp;
import com.makeramen.roundedimageview.RoundedImageView;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//
//注册完善信息
public class ResginAllActivity extends BaseActivity<ResginAllPresenterimp> implements ResginAllContract.ResginAllView {

    @BindView(R.id.resgin_all_return)
    ImageView resginAllReturn;
    @BindView(R.id.resgin_all_image)
    RoundedImageView resginAllImage;
    @BindView(R.id.resgin_all_image_camera_group)
    RelativeLayout resginAllImageCameraGroup;
    @BindView(R.id.resgin_name)
    EditText resginName;
    @BindView(R.id.resgin_image_boy)
    ImageView resginImageBoy;
    @BindView(R.id.resgin_text_boy)
    TextView resginTextBoy;
    @BindView(R.id.linear_boy)
    LinearLayout linearBoy;
    @BindView(R.id.resgin_image_girl)
    ImageView resginImageGirl;
    @BindView(R.id.resgin_text_girl)
    TextView resginTextGirl;
    @BindView(R.id.linear_girl)
    LinearLayout linearGirl;
    @BindView(R.id.resgin_password)
    EditText resginPassword;
    @BindView(R.id.resgin_finish)
    Button resginFinish;
    //跳转相册
    public static final int REQUEST_CODE_PICK_IMAGE = 100;
    //权限申请
    public static final int MY_PERMISSIONS_REQUEST_CALL_PHONE2 = 1;
    private int sex;
    private String phone;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_resgin_all;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        phone = intent.getStringExtra("phone");
    }


    @Override
    protected void loadDate() {
    }

    @OnClick({R.id.resgin_all_image_camera_group, R.id.resgin_all_return, R.id.linear_boy, R.id.linear_girl, R.id.resgin_finish,})
    protected void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.resgin_all_return:
                finish();
                break;
            case R.id.resgin_all_image_camera_group:
                //拍照
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
            case R.id.linear_boy:
                sex = 1;
                changeBoyBtn();
                break;
            case R.id.linear_girl:
                sex = 0;
                changeGirlBtn();
                break;
            case R.id.resgin_finish:
                String name = resginName.getText().toString().trim();
                String pasw = resginPassword.getText().toString().trim();
//                presenter.getResginAll(name, sex, phone, pasw, "");
                gotoSetHobby();
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void onActivityResult(int req, int res, Intent data) {
        switch (req) {
            /**
             * 从相册中选取图片的请求标志
             */
            case REQUEST_CODE_PICK_IMAGE:
                if (res == RESULT_OK) {
                    String path = GetImagePath.getPath(this, data.getData());
                    Glide.with(this).load(path).asBitmap()
                            .override(185, 185).into(new BitmapImageViewTarget(resginAllImage) {
                        @Override
                        protected void setResource(Bitmap resource) {
                            RoundedBitmapDrawable drawable = RoundedBitmapDrawableFactory.create(getResources(), resource);
                            drawable.setCircular(true);
                            resginAllImage.setImageDrawable(drawable);
                        }
                    });
//                    presenter.uploadImg(path);

                } else {
                    showRhoneResginAllMessage("失败");
                }
                break;

            default:
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
                Toast.makeText(ResginAllActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void changeBoyBtn() {
        resginImageGirl.setImageResource(R.mipmap.check_woman_normal);
        resginTextGirl.setTextColor(R.color.gray);


        resginImageBoy.setImageResource(R.mipmap.check_man_active);
        resginTextBoy.setTextColor(R.color.colorPrimary);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void changeGirlBtn() {
        resginImageGirl.setImageResource(R.mipmap.check_woman_active);
        resginTextGirl.setTextColor(R.color.colorPrimary);

        resginImageBoy.setImageResource(R.mipmap.check_man_normal);
        resginTextBoy.setTextColor(R.color.gray);
    }

    @Override
    public void showRhoneResginAllMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void gotoSetHobby() {
        startActivity(new Intent(ResginAllActivity.this, SetHobbyActivity.class));
        finish();
    }

    @Override
    public void gotoPhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");//相片类型
        startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE);
    }
}
