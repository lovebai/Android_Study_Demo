package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.myapplication.Utils.ToastUtil;
import com.example.myapplication.widget.CustomDialog;

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        findViewById(R.id.btn_dialog_custom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog customDialog = new CustomDialog(CustomActivity.this);
                customDialog.setTitle("小白提示").setMessage("您确定要删除吗？").setConfirm("确定删除", new CustomDialog.IOnConfirmListener() {
                    @Override
                    public void onClick(CustomDialog customDialog) {
                        ToastUtil.showMsg(CustomActivity.this,"选择了确认删除");
                    }
                }).setCancel("取消", new CustomDialog.IOnCancelListener() {
                    @Override
                    public void onCancel(CustomDialog customDialog) {
                        ToastUtil.showMsg(CustomActivity.this,"取消了操作");
                    }
                }).show();
            }
        });
    }
}