package com.example.fuxiangzhang.base_framwork.common;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Fuxiang.Zhang on 2017/8/28.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder{


    SparseArray<View> mViewSparseArray = new SparseArray<>();
    public View itemView;
    public BaseViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
    }
    public <T extends View> T getView(int resId){
        View mView=mViewSparseArray.get(resId);
        if (mView==null) {
            mView=itemView.findViewById(resId);
            mViewSparseArray.put(resId,mView);
        }
        return (T) mView;
    }

    public BaseViewHolder setText(int resId,String text){
        TextView mTextView=getView(resId);
        mTextView.setText(text);
        return this;
    }

    public BaseViewHolder setImageResource(int viewId,int resId){
        ImageView view= getView(viewId);
        view.setImageResource(resId);
        return this;
    }
    public BaseViewHolder setImageBitamp(int viewId,Bitmap bitmap){
        ImageView view= getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }
    public BaseViewHolder setImageURI(int viewId,String uri){
        ImageView view= getView(viewId);
//        Imageloader.getInstance().loadImg(view,uri);
        return this;
    }

    public BaseViewHolder setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    public BaseViewHolder setOnLongClickListener(int viewId, View.OnLongClickListener listener) {
        View view = getView(viewId);
        view.setOnLongClickListener(listener);
        return this;
    }


}
