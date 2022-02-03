package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.gridview.GridViewActivity;
import com.example.myapplication.recyclerview.RecyclerViewActivity;
import com.example.myapplication.storage.FileActivity;
import com.example.myapplication.storage.SharedPreferencesActivity;
import com.example.myapplication.webview.WebViewActivity;

import java.sql.SQLClientInfoException;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnClick onClick = new OnClick();
        findViewById(R.id.button).setOnClickListener(onClick);
        findViewById(R.id.button_user).setOnClickListener(onClick);
        findViewById(R.id.button_reg).setOnClickListener(onClick);
        findViewById(R.id.goradio).setOnClickListener(onClick);
        findViewById(R.id.go_checkbox).setOnClickListener(onClick);
        findViewById(R.id.go_images).setOnClickListener(onClick);
        findViewById(R.id.go_list).setOnClickListener(onClick);
        findViewById(R.id.grid_view).setOnClickListener(onClick);
        findViewById(R.id.recv).setOnClickListener(onClick);
        findViewById(R.id.go_toast).setOnClickListener(onClick);
        findViewById(R.id.go_dialog).setOnClickListener(onClick);
        findViewById(R.id.go_progress).setOnClickListener(onClick);
        findViewById(R.id.dialog_1).setOnClickListener(onClick);
        findViewById(R.id.go_shared).setOnClickListener(onClick);
        findViewById(R.id.go_file).setOnClickListener(onClick);

//        btn1=findViewById(R.id.button);
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this,"我被点击了",Toast.LENGTH_SHORT).show();
//            }
//        });
//        //按钮二
//        findViewById(R.id.button_user).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, EditTextActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    /**
     * 内部类
     */
    private class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.button:
                    //测试按钮
//                    Toast.makeText(MainActivity.this,"测试按钮被点击了",Toast.LENGTH_SHORT).show();
                    Toast toast=Toast.makeText(getApplicationContext(), "测试按钮被点击了", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    break;
                    //页面跳转 登录
                case R.id.button_user:
                    startActivity(new Intent(MainActivity.this,EditTextActivity.class));
                    break;
                case R.id.button_reg:
                    //按钮
//                    Toast.makeText(MainActivity.this,"注册按钮被点击了",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, WebViewActivity.class));
                    break;
                case R.id.goradio:
                    startActivity(new Intent(MainActivity.this,RadioButtonActivity.class));
                    break;
                case R.id.go_checkbox:
                    startActivity(new Intent(MainActivity.this,CheckBoxActivity.class));
                    break;
                case R.id.go_images:
                    startActivity(new Intent(MainActivity.this,ImageViewActivity.class));
                    break;
                case R.id.go_list:
                    startActivity(new Intent(MainActivity.this,ListViewActivity.class));
                    break;
                case R.id.grid_view:
                    startActivity(new Intent(MainActivity.this, GridViewActivity.class));
                    break;
                case R.id.recv:
                    startActivity(new Intent(MainActivity.this, RecyclerViewButtonActivity.class));
                    break;
                case R.id.go_toast:
                    startActivity(new Intent(MainActivity.this, ToastButtonActivity.class));
                    break;
                case R.id.go_dialog:
                    startActivity(new Intent(MainActivity.this,DialogViewActivity.class));
                    break;
                case R.id.go_progress:
                    startActivity(new Intent(MainActivity.this,ProgressActivity.class));
                    break;
                case R.id.dialog_1:
                    startActivity(new Intent(MainActivity.this,CustomActivity.class));
                    break;
                case R.id.go_shared:
                    startActivity(new Intent(MainActivity.this, SharedPreferencesActivity.class));
                    break;
                case R.id.go_file:
                    startActivity(new Intent(MainActivity.this, FileActivity.class));
                    break;
            }


        }
    }
}