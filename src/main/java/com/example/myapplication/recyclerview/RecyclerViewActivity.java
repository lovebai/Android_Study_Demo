package com.example.myapplication.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.R;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView = findViewById(R.id.rvc_l);
        recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerViewActivity.this));
        //设置分割线
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
            }
        });
        recyclerView.setAdapter(new LinearAdapter(RecyclerViewActivity.this, new LinearAdapter.OnClickItem() {
            @Override
            public void onClick(int i) {
                Toast.makeText(RecyclerViewActivity.this, "点击了第"+(i+1)+"个", Toast.LENGTH_SHORT).show();
            }
        }));

    }

}