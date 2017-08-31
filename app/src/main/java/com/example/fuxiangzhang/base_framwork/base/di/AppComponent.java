package com.example.fuxiangzhang.base_framwork.base.di;

import android.app.Application;
import android.content.SharedPreferences;


import com.example.fuxiangzhang.base_framwork.ApiService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by 10109 on 2017/7/19.
 */
@Singleton
@Component(modules = {AppModule.class,NetModule.class,ServiceModule.class})
public interface AppComponent {

    Application application();

    ApiService apiService();

    SharedPreferences sharedPreferences();
}
