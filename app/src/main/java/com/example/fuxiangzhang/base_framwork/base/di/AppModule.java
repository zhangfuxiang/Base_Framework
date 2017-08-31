package com.example.fuxiangzhang.base_framwork.base.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 10109 on 2017/7/19.
 */
@Module
public class AppModule {

    Application application;

    public AppModule(Application application){this.application=application;}

    @Provides
    @Singleton
    Application providerApplication(){return application;}
}
