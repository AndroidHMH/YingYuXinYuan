package com.jiyun.yingyuxinyuan.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.jiyun.yingyuxinyuan.app.App;
import com.jiyun.yingyuxinyuan.ui.MainActivity;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import butterknife.ButterKnife;

/**
 * Created by asus on 2018/5/3.
 */

/**
 * 统一管理Activity
 */
public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {
    private Fragment lastFragment;
    protected T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);

        App.context = this;
//        presenter = getPresenter();
        if (presenter != null) {
            presenter.actualView(this);
        }
        init();
        loadDate();
    }

    private T getPresenter() {

        Type type = getClass().getGenericSuperclass();
        if (MainActivity.class.equals(type)) {
            return null;
        }
        Type[] arguments = ((ParameterizedType) type).getActualTypeArguments();

        Class<T> tClass = (Class<T>) arguments[0];
        try {
            return tClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPause() {
        super.onPause();
        App.context = null;
        if (presenter != null) {
            presenter.unActualView();
        }
    }

    /**
     * 加载布局
     *
     * @return 要加载的布局文件
     */
    protected abstract int getLayoutId();

    /**
     * 统一初始化数据
     */
    protected abstract void init();

    /**
     * 统一加载数据
     */
    protected abstract void loadDate();

    /**
     * 切换Fragment
     *
     * @param layoutId      Fragment要显示的布局id
     * @param fragmentClass 要显示的Fragment
     */
    protected void setCreateView(int layoutId, Class<? extends BaseFragment> fragmentClass) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        String simpleName = fragmentClass.getSimpleName();
        Fragment fragment = fragmentManager.findFragmentByTag(simpleName);
        if (fragment == null) {
            try {
                fragment = fragmentClass.newInstance();
                transaction.add(layoutId, fragment, simpleName);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (lastFragment != null) {
            transaction.hide(lastFragment);
        }
        transaction.show(fragment);
        lastFragment = fragment;
        transaction.commit();
    }
}
