package com.example.myapplication.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.LinearViewHolder> {
    private Context context;
    private OnClickItem onClickItem;

    public GridAdapter(Context context, OnClickItem onClickItem){
        this.context= context;
        this.onClickItem = onClickItem;
    }


    @NonNull
    @Override
    public LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new LinearViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_grid_linear_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LinearViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView.setText("Hello World!");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickItem.onClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 40;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{

        //声明布局控件
        private TextView textView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView_title);
        }
    }


    /**
     * 事件
     */
    public interface OnClickItem{
        void onClick(int i);
    }
}
