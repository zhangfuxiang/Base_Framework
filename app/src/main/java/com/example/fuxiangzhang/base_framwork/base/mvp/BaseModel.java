package com.example.fuxiangzhang.base_framwork.base.mvp;

/**
 * Created by Fuxiang.Zhang on 2017/7/19.
 */

public class BaseModel<T> {

    private T t;

    public BaseModel(T t){
        this.t=t;
    }

    public T getService(){
        return t;
    }

}
