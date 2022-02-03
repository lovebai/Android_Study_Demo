package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.recyclerview.GridRecyclerViewActivity;
import com.example.myapplication.recyclerview.HorRecyclerViewActivity;
import com.example.myapplication.recyclerview.PuRecyclerViewActivity;
import com.example.myapplication.recyclerview.RecyclerViewActivity;

public class RecyclerViewButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_button);
        findViewById(R.id.go_on_rec).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RecyclerViewButtonActivity.this, RecyclerViewActivity.class));
            }
        });
        findViewById(R.id.go_on_rec_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RecyclerViewButtonActivity.this, HorRecyclerViewActivity.class));
            }
        });
        findViewById(R.id.go_on_rec_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RecyclerViewButtonActivity.this, GridRecyclerViewActivity.class));
            }
        });
        findViewById(R.id.go_on_rec_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RecyclerViewButtonActivity.this, PuRecyclerViewActivity.class));
            }
        });
    }
}