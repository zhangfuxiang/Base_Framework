package com.example.fuxiangzhang.base_framwork.common;


import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Fuxiang.Zhang on 2017/7/25.
 * 统一流装换操作，将subscribeOn()放到io线程中，将observeOn()放到主线程中。
 */

public class RxSchedulers {
    public static <T> Observable.Transformer<T,T> io_main(){
        Observable.Transformer<T,T> transformer=new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
        return transformer;
    }
}
