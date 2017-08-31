package com.example.fuxiangzhang.base_framwork.base.mvp;

import java.lang.ref.WeakReference;

/**
 * Created by Fuxiang.Zhang on 2017/7/19.
 */

public class BasePresenter<M ,V> {
    protected  final String TAG=this.getClass().getSimpleName();
    protected  M mModel;
    protected  V mView;

    WeakReference IviewWeakReference = new WeakReference(mView);

    public BasePresenter(M model, V mView) {
        this.mModel = model;
        this.mView = mView;
        onStart();
    }

    public M getModel() {
        return mModel;
    }

    public V getView() {
        return mView;
    }

    public BasePresenter(V rootView) {
        this.mView = rootView;
        onStart();
    }
    public void onStart() {


    }

    public void ondestory() {
        IviewWeakReference.clear();
    }
}

