package com.example.myapplication.other;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

public class MyListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;

    public MyListAdapter(Context context){
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        Log.d(null, "MyListAdapter: ------------------------------");
    }


    @Override
    public int getCount() {
        //返回列表数
        return 10;
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
        public ImageView imageView;
        public TextView lit1,lit2,lit3;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder= null;
        if (view==null){
            view=layoutInflater.inflate(R.layout.activity_list_item,null);
            holder = new ViewHolder();
            holder.imageView = view.findViewById(R.id.lav_1);
            holder.lit1 = view.findViewById(R.id.ltv_1);
            holder.lit2 = view.findViewById(R.id.ltv_2);
            holder.lit3 = view.findViewById(R.id.ltv_3);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        //控件赋值
        holder.lit1.setText("这是一个什么怎么样的什么");
        holder.lit2.setText("2021-02-08 02:08:30");
        holder.lit3.setText("这是一个什么怎么样的什么内容哈哈哈");
        Glide.with(this.context)
                .load("https://tse1-mm.cn.bing.net/th/id/R-C.d727b4984728dd38fd366fa8711b05df?rik=RmWLnTnrktGyew&riu=http%3a%2f%2ffile.qqtouxiang.com%2fnvsheng%2f2019-08-02%2f05c81957a9c5b61bcc2c048c6ac524b1.jpg&ehk=SOpRVKF4CjMv8I53N3Y%2fVMd2E8gZw4JE6x8Y1cB%2bjo8%3d&risl=&pid=ImgRaw&r=0&sres=1&sresct=1")
                .into(holder.imageView);
        return view;

    }
}
