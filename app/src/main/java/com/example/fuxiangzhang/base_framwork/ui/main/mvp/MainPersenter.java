package com.example.fuxiangzhang.base_framwork.ui.main.mvp;





import com.example.fuxiangzhang.base_framwork.base.mvp.BasePresenter;
import com.example.fuxiangzhang.base_framwork.entity.DouBan;
import com.orhanobut.logger.Logger;


import javax.inject.Inject;

import io.reactivex.functions.Consumer;


/**
 * Created by zhangfuxiang on 2017/7/19.
 */

public class MainPersenter extends BasePresenter<MainContract.Model,MainContract.View> {

    @Inject
    public MainPersenter(MainContract.Model model, MainContract.View mView) {
        super(model, mView);
    }

    public void submitData(){
        getModel().submitData().subscribe(new Consumer<DouBan>() {
            @Override
            public void accept(DouBan mDouBan) throws Exception {
                if (mDouBan.getR()==0) {
                    getView().loginSucess(mDouBan);
                    Logger.e("information");
                }else {
                    getView().loginFailed();
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable mThrowable) throws Exception {
                getView().showMessage(mThrowable.getMessage());
            }
        });

    }
}
