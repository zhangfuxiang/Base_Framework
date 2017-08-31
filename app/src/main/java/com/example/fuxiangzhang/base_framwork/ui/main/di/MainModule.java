package com.example.fuxiangzhang.base_framwork.ui.main.di;



import com.example.fuxiangzhang.base_framwork.ApiService;
import com.example.fuxiangzhang.base_framwork.scope.ActivityScope;
import com.example.fuxiangzhang.base_framwork.ui.main.mvp.MainContract;
import com.example.fuxiangzhang.base_framwork.ui.main.mvp.MainModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhangfuxiang on 2017/7/19.
 */
@Module
public class MainModule {

    MainContract.View view;

    public MainModule(MainContract.View view){this.view=view;}

    @ActivityScope
    @Provides
    MainContract.View providerView(){return view;}

    @ActivityScope
    @Provides
    MainContract.Model providerModel(ApiService apiService){
        return new MainModel(apiService);
    }
}
