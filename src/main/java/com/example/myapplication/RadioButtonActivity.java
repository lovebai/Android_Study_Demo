package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioGroup radioGroup1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        radioGroup = findViewById(R.id.rg_1);
        radioGroup1 = findViewById(R.id.rg_2);
        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radio = (RadioButton) radioGroup.findViewById(i);
                Log.d(new String(""), "onCheckedChanged: "+radio.getText());
                Toast.makeText(RadioButtonActivity.this,"上面您选择了："+radio.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        radioGroup1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radio = (RadioButton) radioGroup.findViewById(i);
                Toast.makeText(RadioButtonActivity.this,"下面您选择了："+radio.getText(),Toast.LENGTH_SHORT).show();
            }
        });




    }

}