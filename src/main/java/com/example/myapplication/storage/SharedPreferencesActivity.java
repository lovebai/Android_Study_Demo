package com.example.myapplication.storage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.Utils.ToastUtil;

public class SharedPreferencesActivity extends AppCompatActivity {
    private EditText editText;
    private Button button,button1;
    private TextView textView;
    private SharedPreferences sharedPreferencesActivity;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        editText=findViewById(R.id.sp_ed);
        button = findViewById(R.id.sp_btn1);
        button1 = findViewById(R.id.sp_btn2);
        textView = findViewById(R.id.sp_tv);

        //实列化SharedPreferencesActivity
        sharedPreferencesActivity = getSharedPreferences("datafile",SharedPreferencesActivity.MODE_PRIVATE);
        editor = sharedPreferencesActivity.edit();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("name",editText.getText().toString()).apply();
                ToastUtil.showMsg(SharedPreferencesActivity.this,"保存成功");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(sharedPreferencesActivity.getString("name","Default"));
            }
        });
    }
}