package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.KeyEventDispatcher;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {
    private CheckBox ck2;
    private CheckBox ck3;
    private CheckBox ck4;
    private CheckBox ck5;
    private CheckBox ck6;
    private CheckBox ck7;
    private CheckBox ck8;
    private CheckBox ck9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        ck2 = findViewById(R.id.ck_2);
        ck2.setOnCheckedChangeListener(new OnCheck());
        ck3 = findViewById(R.id.ck_3);
        ck3.setOnCheckedChangeListener(new OnCheck());
        ck4 = findViewById(R.id.ck_4);
        ck4.setOnCheckedChangeListener(new OnCheck());
        ck5 = findViewById(R.id.ck_5);
        ck5.setOnCheckedChangeListener(new OnCheck());
        ck6 = findViewById(R.id.ck_6);
        ck6.setOnCheckedChangeListener(new OnCheck());
        ck7 = findViewById(R.id.ck_7);
        ck7.setOnCheckedChangeListener(new OnCheck());
        ck8 = findViewById(R.id.ck_8);
        ck8.setOnCheckedChangeListener(new OnCheck());
        ck9 = findViewById(R.id.ck_9);
        ck9.setOnCheckedChangeListener(new OnCheck());
    }

    private class OnCheck implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            Toast.makeText(CheckBoxActivity.this,b?"已选中:"+compoundButton.getText():"取消选择："+compoundButton.getText(),Toast.LENGTH_SHORT).show();
        }
    }

}