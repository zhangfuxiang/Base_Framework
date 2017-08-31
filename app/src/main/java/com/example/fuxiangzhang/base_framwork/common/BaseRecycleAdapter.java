package com.example.fuxiangzhang.base_framwork.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * Created by Fuxiang.Zhang on 2017/8/28.
 */

public abstract class BaseRecycleAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {


    private List<T> data;
    private int layoutId;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private OnItemClickListener mOnItemClickListener;



    public BaseRecycleAdapter(List<T> data, int layoutId, Context context) {
        this.data = data;
        this.layoutId = layoutId;
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    /**
     *
     * @param holder
     * @param item
     * @param position
     */
    protected abstract void convert(BaseViewHolder holder, T item, int position);


    /**
     * 设置点击事件
     */
    public interface OnItemClickListener{

        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }





    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mInflate = mLayoutInflater.inflate(layoutId, parent, false);
        return new BaseViewHolder(mInflate);
    }



    //统计item个数
    @Override
    public int getItemCount() {
        return  data==null?0:data.size();
    }

    @Override
    public void onBindViewHolder(final BaseViewHolder holder, final int position) {
        convert(holder, data.get(position), position);
        setItemEvent(holder);

    }

    public void setItemEvent(final BaseViewHolder holder) {
        if (mOnItemClickListener !=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //这个获取位置的方法，防止添加删除导致位置不变
                    int layoutPosition = holder.getAdapterPosition();
                    mOnItemClickListener.onItemClick(holder.itemView,layoutPosition);
                }
            });
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int layoutPosotion=holder.getAdapterPosition();
                    mOnItemClickListener.onItemLongClick(holder.itemView,layoutPosotion);
                    return false;
                }
            });

        }
    }

    public void addData(int position,T datas){
        data.add(position,datas);
        notifyItemInserted(position);
    }

    public void deleteData(int position){
        data.remove(position);
        notifyItemRemoved(position);
    }




}
