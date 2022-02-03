package com.example.myapplication.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.R;

public class PuRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_recycler_view);
        recyclerView = findViewById(R.id.purc_1);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
//        recyclerView.setAdapter();
        recyclerView.setAdapter(new PuAdapter(PuRecyclerViewActivity.this, new PuAdapter.OnClickItem() {
            @Override
            public void onClick(int i) {
                Toast.makeText(PuRecyclerViewActivity.this, "点击了第"+(i+1)+"个", Toast.LENGTH_SHORT).show();
            }
        }));

    }
}