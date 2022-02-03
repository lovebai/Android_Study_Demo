package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;

import com.example.myapplication.Utils.ToastUtil;

import java.util.Random;

public class ProgressActivity extends AppCompatActivity {

    private ProgressBar pb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        pb3 = findViewById(R.id.pb3);
//        pb3.setProgress(45);

        findViewById(R.id.btn_progress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MyHandel(pb3).sendEmptyMessage(0);
            }

        });
    }

    class MyHandel extends Handler{
        private ProgressBar pb;

        public MyHandel(ProgressBar pb){
            this.pb = pb;
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (pb.getProgress()<100){
                new MyHandel(pb).postDelayed(runnable,500);
            }else {
                ToastUtil.showMsg(ProgressActivity.this,"加载完成,重置进度条");
                pb.setProgress(0);
            }
        }
    }
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            pb3.setProgress(pb3.getProgress()+5);
            new MyHandel(pb3).sendEmptyMessage(0);

        }
    };
}