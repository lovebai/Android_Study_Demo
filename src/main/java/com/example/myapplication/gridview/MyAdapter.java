package com.example.myapplication.gridview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context context){
        this.context = context;
        this.layoutInflater =LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 12;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    static class ViewHolder{
        protected ImageView imageView;
        protected TextView textView;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder =null;
        if (view==null){
            view = layoutInflater.inflate(R.layout.activity_grid_item,null);
            holder = new ViewHolder();
            holder.imageView=view.findViewById(R.id.iv_1);
            holder.textView = view.findViewById(R.id.tv_1);
            view.setTag(holder);

        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.textView.setText("你是土狗吗？");
        Glide.with(this.context)
                .load("https://tse3-mm.cn.bing.net/th/id/OIP-C.BRvWGFNvBMiJ1BSotBtzBQAAAA?pid=ImgDet&rs=1")
                .into(holder.imageView);


        return view;
    }
}
