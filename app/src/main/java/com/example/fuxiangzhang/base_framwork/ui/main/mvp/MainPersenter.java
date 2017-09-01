package com.example.fuxiangzhang.base_framwork.ui.main.mvp;



import android.util.Log;

import com.example.fuxiangzhang.base_framwork.base.mvp.BasePresenter;
import com.example.fuxiangzhang.base_framwork.entity.DouBan;
import com.orhanobut.logger.Logger;


import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Created by zhangfuxiang on 2017/7/19.
 */

public class MainPersenter extends BasePresenter<MainContract.Model,MainContract.View> {

    @Inject
    public MainPersenter(MainContract.Model model, MainContract.View mView) {
        super(model, mView);
    }

    public void submitData(){
        getModel().submitData().subscribe(new Action1<DouBan>() {
            @Override
            public void call(DouBan mDouBan) {
                if (mDouBan.getR()==0) {
                    getView().loginSucess(mDouBan);
                    Logger.e("information");
                }else {
                    getView().loginFailed();
                }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                getView().showMessage(throwable.getMessage());
            }
        });

    }
}
