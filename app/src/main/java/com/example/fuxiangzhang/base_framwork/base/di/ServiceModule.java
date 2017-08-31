package com.example.fuxiangzhang.base_framwork.base.di;



import com.example.fuxiangzhang.base_framwork.ApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by 10109 on 2017/7/19.
 */
@Module
public class ServiceModule {

    @Singleton
    @Provides
    ApiService providerApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }
}
