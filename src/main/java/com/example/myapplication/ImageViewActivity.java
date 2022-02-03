package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        imageView=findViewById(R.id.imageView_2);
//        Glide.with(this).load("https://www.baidu.com/img/PCfb_5bf082d29588c07f842ccde3f97243ea.png").into(imageView);
        Glide.with(this).load("https://www.baidu.com/img/flexible/logo/pc/result.png").into(imageView);
    }
}
