package com.example.fuxiangzhang.base_framwork.common;


import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Fuxiang.Zhang on 2017/7/25.
 * 统一流装换操作，将subscribeOn()放到io线程中，将observeOn()放到主线程中。
 */

public class RxSchedulers {
    public static <T> ObservableTransformer<T,T> io_main(){
        ObservableTransformer<T,T> transformer=new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(io.reactivex.Observable<T> mObservable) {
                return mObservable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }

        };
        return transformer;
    }
}
