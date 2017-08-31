package com.example.fuxiangzhang.base_framwork.base.app;

import android.app.Application;

import com.example.fuxiangzhang.base_framwork.BuildConfig;
import com.example.fuxiangzhang.base_framwork.base.di.AppModule;
import com.example.fuxiangzhang.base_framwork.base.di.NetModule;
import com.example.fuxiangzhang.base_framwork.base.di.ServiceModule;

import timber.log.Timber;


/**
 * Created by Fuxiang.Zhang on 2017/7/20.
 *
 * mvp
 * +dagger2
 * +retrofit
 * +rxjava
 */

public abstract class BaseApplication extends Application{
    private static AppModule appModule;
    private static NetModule netModule;
    private static ServiceModule serviceModule;
    private BaseApplication mApplication;
    protected final String TAG=this.getClass().getSimpleName();


    @Override
    public void onCreate() {
        super.onCreate();
        mApplication=this;

        //设置打印请求响应日志
        if (BuildConfig.DEBUG) {

            Timber.plant(new Timber.DebugTree());
        }
        this.appModule=new AppModule(this);
        this.netModule=new NetModule(getBaseUrl());
        this.serviceModule=new ServiceModule();
    }

    protected abstract String getBaseUrl();

    public static AppModule getAppModule(){
        return appModule;
    }

    public static NetModule getNetModule(){
        return netModule;
    }
    public static ServiceModule getServiceModule(){
        return serviceModule;
    }

}
