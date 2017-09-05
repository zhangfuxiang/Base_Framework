package com.example.fuxiangzhang.base_framwork.ui.main.mvp;


import com.example.fuxiangzhang.base_framwork.entity.DouBan;
import com.example.fuxiangzhang.base_framwork.entity.User;

import io.reactivex.Observable;


/**
 * Created by zhangfuxiang on 2017/7/19.
 */

public interface MainContract {



    interface View {
        void loginSucess(DouBan mDouBan);
        void loginFailed();
        void showMessage(String message);
    }

    interface Model{

        Observable<DouBan> submitData();
    }

}
