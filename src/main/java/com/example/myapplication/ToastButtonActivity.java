package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Utils.ToastUtil;

public class ToastButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_button);
        findViewById(R.id.btn_1).setOnClickListener(new OnClick());
        findViewById(R.id.btn_2).setOnClickListener(new OnClick());
        findViewById(R.id.btn_3).setOnClickListener(new OnClick());
        findViewById(R.id.btn_4).setOnClickListener(new OnClick());
    }

    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_1:
                    Toast.makeText(ToastButtonActivity.this, "这是默认样式", Toast.LENGTH_SHORT).show();
                    break;
                    case R.id.btn_2:
                        Toast toast= Toast.makeText(ToastButtonActivity.this, "这是居中样式，安卓11不会正常显示", Toast.LENGTH_SHORT);
                        toast.setGravity(17,0,0);
                        toast.show();
                    break;
                case R.id.btn_3:
                        Toast toast1= new Toast(getApplicationContext());
                    LayoutInflater layoutInflater = LayoutInflater.from(ToastButtonActivity.this);
                    View inflate = layoutInflater.inflate(R.layout.layout_toast, null);
                    ImageView imageView = inflate.findViewById(R.id.iv_toast);
                    TextView textView = inflate.findViewById(R.id.tv_toast);
                    textView.setText("这是提示内容");
                    imageView.setImageResource(R.mipmap.expression);
                    toast1.setView(inflate);
                    toast1.show();
                    break;
                case R.id.btn_4:
                    ToastUtil.showMsg(ToastButtonActivity.this,"调用了封装的工具类");
                    break;
            }
        }
    }
}