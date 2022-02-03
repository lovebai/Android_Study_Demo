package com.example.myapplication.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.R;

public class GridRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        recyclerView = findViewById(R.id.grid_view_12);
        Log.d(null, "onCreate: -----------------------------");
        recyclerView.setLayoutManager(new GridLayoutManager(GridRecyclerViewActivity.this,3));
        recyclerView.setAdapter(new GridAdapter(GridRecyclerViewActivity.this, new GridAdapter.OnClickItem() {
            @Override
            public void onClick(int i) {
                Toast.makeText(GridRecyclerViewActivity.this, "点击了第"+(i+1)+"个", Toast.LENGTH_SHORT).show();
            }
        }));

    }
}