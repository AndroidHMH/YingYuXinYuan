package com.jiyun.yingyuxinyuan.ui.activity.resgin.presenter;

import android.content.ContentResolver;
import android.content.Context;
import android.content.CursorLoader;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.nfc.tech.NfcA;
import android.provider.MediaStore;
import android.util.Log;

import com.google.gson.Gson;
import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.contract.ResginAllContract;
import com.jiyun.yingyuxinyuan.contract.ResginContract;
import com.jiyun.yingyuxinyuan.model.bean.PhoneResginAllBean;
import com.jiyun.yingyuxinyuan.model.bean.UpLoadImgBean;
import com.jiyun.yingyuxinyuan.model.biz.ResginAllService;
import com.jiyun.yingyuxinyuan.model.biz.ResginService;
import com.jiyun.yingyuxinyuan.model.http.RetrofitUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * Created by ASUS on 2018/05/05.
 */

public class ResginAllPresenterimp implements ResginAllContract.ResginAllPresenter {
    ResginAllService resginAllService;
    ResginAllContract.ResginAllView resginAllView;
    private final SharedPreferences token;

    public ResginAllPresenterimp() {
        token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        resginAllService = RetrofitUtils.getInstance().getResginAllService();
    }

    @Override
    public void actualView(ResginAllContract.ResginAllView resginAllView) {
        this.resginAllView = resginAllView;
    }

    @Override
    public void unActualView() {
        this.resginAllView = null;
    }

    @Override
    public void getResginAll(String name, int sex, String phone, String password, String imgUrl) {
        Map<String, String> map = new HashMap<>();
        if (!isPasw(password)) {
            return;
        }
        map.put("mobile", phone);
        map.put("psw", password);
        map.put("nickname", name);
        map.put("sex", sex + "");
        map.put("photo", imgUrl);
//        SharedPreferences token = App.context.getSharedPreferences("token", Context.MODE_PRIVATE);
        Map<String, String> headers = new HashMap<>();
        headers.put("apptoken", token.getString("appToken", ""));

        resginAllService.getPhoneResginAll(map, headers)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PhoneResginAllBean>() {
                    @Override
                    public void accept(PhoneResginAllBean phoneResginAllBean) throws Exception {
                        String message = phoneResginAllBean.getMessage();
                        if ("成功".equals(message)) {
                            resginAllView.gotoSetHobby();
                        } else {
                            resginAllView.showRhoneResginAllMessage(message);
                        }
                    }
                });
    }

    /**
     * 上传头像
     *
     * @param imgUrl
     */
    @Override
    public void uploadImg(String imgUrl) {
        File file = null;
//        try {
//            URL url = new URL(uri.toString());
//            file = new File(url);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
        file = new File(imgUrl);
//        File file = getFileByUri(uri, App.context);
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);

        Map<String, String> headers = new HashMap<>();
        headers.put("apptoken", token.getString("appToken", ""));
        resginAllService.upLoad(headers, requestBody)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UpLoadImgBean>() {
                    @Override
                    public void accept(UpLoadImgBean upLoadImgBean) throws Exception {
                        String message = upLoadImgBean.getMessage();
                        Log.e("ResginAllPresenterimp", message);
                        if ("成功".equals(message)) {
                            String fileName = upLoadImgBean.getData().getFileName();
                            Log.e("ResginAllPresenterimp", fileName);
                        }
                    }
                });
    }

    private static final String SCHEME_FILE = "file"; //$NON-

    public File toFile(URI uri) {
        try {
            if (!SCHEME_FILE.equalsIgnoreCase(uri.getScheme()))
                return null;
            //assume all illegal characters have been properly encoded, so use URI class to unencode
            return new File(uri);
        } catch (IllegalArgumentException e) {
            //File constructor does not support non-hierarchical URI
            String path = uri.getPath();
            //path is null for non-hierarchical URI such as file:c:/tmp
            if (path == null)
                path = uri.getSchemeSpecificPart();
            return new File(path);
        }
    }

    private File getFileByUri(Uri uri, Context context) {
        String path = null;
        if ("file".equals(uri.getScheme())) {
            path = uri.getEncodedPath();
            if (path != null) {
                path = Uri.decode(path);
                ContentResolver cr = context.getContentResolver();
                StringBuffer buff = new StringBuffer();
                buff.append("(").append(MediaStore.Images.ImageColumns.DATA).append("=").append("'" + path + "'").append(")");
                Cursor cur = cr.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{MediaStore.Images.ImageColumns._ID, MediaStore.Images.ImageColumns.DATA}, buff.toString(), null, null);
                int index = 0;
                int dataIdx = 0;
                for (cur.moveToFirst(); !cur.isAfterLast(); cur.moveToNext()) {
                    index = cur.getColumnIndex(MediaStore.Images.ImageColumns._ID);
                    index = cur.getInt(index);
                    dataIdx = cur.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                    path = cur.getString(dataIdx);
                }
                cur.close();
                if (index == 0) {
                } else {
                    Uri u = Uri.parse("content://media/external/images/media/" + index);
                    System.out.println("temp uri is :" + u);
                }
            }
            if (path != null) {
                return new File(path);
            }
        } else if ("content".equals(uri.getScheme())) {
            // 4.2.2以后
            String[] proj = {MediaStore.Images.Media.DATA};
            Cursor cursor = context.getContentResolver().query(uri, proj, null, null, null);
            if (cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                path = cursor.getString(columnIndex);
            }
            cursor.close();

            return new File(path);
        } else {
            //Log.i(TAG, "Uri Scheme:" + uri.getScheme());
        }
        return null;
    }

    /**
     * 判断密码
     *
     * @param pasw
     * @return
     */
    @Override
    public boolean isPasw(String pasw) {
        if (pasw == null) {
            resginAllView.showRhoneResginAllMessage("密码为空");
            return false;
        }
        if ("".equals(pasw)) {
            resginAllView.showRhoneResginAllMessage("密码为空");
            return false;
        }
        if (pasw.contains(" ")) {
            resginAllView.showRhoneResginAllMessage("包含非法字符");
            return false;
        }
        return true;
    }


}
