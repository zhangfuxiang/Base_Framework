package com.example.fuxiangzhang.base_framwork.base.mvp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import com.example.fuxiangzhang.base_framwork.MyApp;
import com.example.fuxiangzhang.base_framwork.base.di.AppComponent;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by fuxiang.zhang on 2017/7/19.
 */

public abstract class BaseActivity<p extends BasePresenter> extends AppCompatActivity {
    public final String TAG = getClass().getSimpleName();

    @Inject
    protected p mPresenter;

    protected abstract void initData();
    protected abstract void initView();
    protected abstract int getContentViewId();
    protected abstract void componentInject(AppComponent appComponent);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        ButterKnife.bind(this);
        componentInject(((MyApp)getApplication()).getAppComponent());
        initData();
        initView();
    }



    public p getPresenter() {
        return mPresenter;
    }
}
