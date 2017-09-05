package com.example.fuxiangzhang.base_framwork;


import com.example.fuxiangzhang.base_framwork.entity.DouBan;

import io.reactivex.Observable;
import retrofit2.http.GET;


/**
 * Created by xiangzi on 2017/7/19.
 */
public interface ApiService {

    @GET("http://bubbler.labs.douban.com/j/user/ahbei")
    Observable<DouBan> submitData();


}
