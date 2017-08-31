package com.example.fuxiangzhang.base_framwork;


import com.example.fuxiangzhang.base_framwork.base.app.BaseApplication;
import com.example.fuxiangzhang.base_framwork.base.di.AppComponent;
import com.example.fuxiangzhang.base_framwork.base.di.DaggerAppComponent;

/**
 * Created by 10109 on 2017/7/19.
 */

public class MyApp extends BaseApplication {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent= DaggerAppComponent.builder()
                .appModule(getAppModule())
                .netModule(getNetModule())
                .serviceModule(getServiceModule())
                .build();

    }

    @Override
    protected String getBaseUrl() {
        return "https://api.github.com/";
    }

    public AppComponent getAppComponent(){return appComponent;}


}
