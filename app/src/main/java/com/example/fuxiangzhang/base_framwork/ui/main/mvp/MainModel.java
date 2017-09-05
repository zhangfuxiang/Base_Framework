package com.example.fuxiangzhang.base_framwork.ui.main.mvp;



import com.example.fuxiangzhang.base_framwork.ApiService;
import com.example.fuxiangzhang.base_framwork.base.mvp.BaseModel;
import com.example.fuxiangzhang.base_framwork.common.RxSchedulers;
import com.example.fuxiangzhang.base_framwork.entity.DouBan;
import com.example.fuxiangzhang.base_framwork.entity.User;

import io.reactivex.Observable;


/**
 * Created by zhangfuxiang on 2017/7/19.
 */

public class MainModel extends BaseModel<ApiService> implements MainContract.Model{

    public MainModel(ApiService apiService) {
        super(apiService);
    }

    @Override
    public Observable<DouBan> submitData() {
        return getService().submitData().compose(RxSchedulers.<DouBan>io_main());
    }
}
