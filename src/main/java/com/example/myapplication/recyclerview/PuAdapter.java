package com.example.myapplication.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

public class PuAdapter extends RecyclerView.Adapter<PuAdapter.LinearViewHolder> {
    private Context context;
    private OnClickItem onClickItem;

    public PuAdapter(Context context, OnClickItem onClickItem){
        this.context= context;
        this.onClickItem = onClickItem;
    }


    @NonNull
    @Override
    public LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new LinearViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_pu_linear_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LinearViewHolder holder, @SuppressLint("RecyclerView") int position) {
//        holder.textView.setText("Hello World!");
        if (position %2==0){
            holder.imageView.setImageResource(R.mipmap.p225182044);
//            Glide.with(context).load("https://lmg.jj20.com/up/allimg/1011/10091G20P8/1G009120P8-9-lp.jpg").into(holder.imageView);
        }else {
//            Glide.with(context).load("https://img9.doubanio.com/view/group_topic/l/public/p225182044.webp").into(holder.imageView);
            holder.imageView.setImageResource(R.mipmap.dfdf);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickItem.onClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{

        //声明布局控件
        private ImageView imageView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.pu_img);
        }
    }


    /**
     * 事件
     */
    public interface OnClickItem{
        void onClick(int i);
    }
}
