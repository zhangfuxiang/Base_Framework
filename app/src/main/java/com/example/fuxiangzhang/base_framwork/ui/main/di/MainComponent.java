package com.example.fuxiangzhang.base_framwork.ui.main.di;



import com.example.fuxiangzhang.base_framwork.base.di.AppComponent;
import com.example.fuxiangzhang.base_framwork.scope.ActivityScope;
import com.example.fuxiangzhang.base_framwork.ui.main.MainActivity;

import dagger.Component;

/**
 * Created by zhangfuxiang on 2017/7/19.
 */
@ActivityScope
@Component(modules = MainModule.class,dependencies = AppComponent.class)
public interface MainComponent {

    void inject(MainActivity activity);
}
