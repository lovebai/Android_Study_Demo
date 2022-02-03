package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.Utils.ToastUtil;

public class DialogViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_view);
        findViewById(R.id.btn_dialog1).setOnClickListener(new OnClick());
        findViewById(R.id.btn_dialog2).setOnClickListener(new OnClick());
        findViewById(R.id.btn_dialog3).setOnClickListener(new OnClick());
        findViewById(R.id.btn_dialog4).setOnClickListener(new OnClick());
        findViewById(R.id.btn_dialog5).setOnClickListener(new OnClick());
    }
    class ItemsClick implements DialogInterface.OnMultiChoiceClickListener{

        private String[] strings;

        public ItemsClick(String[] strings){
            this.strings = strings;
        }
        public ItemsClick(){

        }

        @Override
        public void onClick(DialogInterface dialogInterface, int i, boolean b) {
            ToastUtil.showMsg(DialogViewActivity.this,"选择了："+b);
        }
    }

    class OnClick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_dialog1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(DialogViewActivity.this);
                    builder.setTitle("提示信息").setMessage("你觉得这个app怎么样？")
                            .setIcon(R.mipmap.expression)
                            .setPositiveButton("很棒", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    ToastUtil.showMsg(DialogViewActivity.this,"和不错哦你");
                                }
                            }).setNeutralButton("还行", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(DialogViewActivity.this,"要不在好好看看");
                        }
                    })
                            .setNegativeButton("差评", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ToastUtil.showMsg(DialogViewActivity.this,"瞎扯淡");
                        }
                    }).show();
                    break;
                    case R.id.btn_dialog2:
                        String[] strings = new String[]{"男","女"};
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(DialogViewActivity.this);
                        builder1.setItems(strings, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ToastUtil.showMsg(DialogViewActivity.this,"选择了："+strings[i]);
                            }
                        }).setTitle("请选择性别")
                                .show();
                    break;
                    case R.id.btn_dialog3:
                        String[] strings1 = new String[]{"男","女"};
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(DialogViewActivity.this);
                        builder2.setSingleChoiceItems(strings1, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ToastUtil.showMsg(DialogViewActivity.this,"选择了："+strings1[i]);
                            }
                        }).setTitle("请选择性别").show();
                        //setCancelable(false) 选择后选择之后才消失对话框
                    break;
                    case R.id.btn_dialog4:
//                        String[] strings2 = new String[]{"唱歌","跳舞","打篮球"};
                        Integer[] arr = new Integer[]{1,2,3};
                        Boolean[] booleans = new Boolean[]{false,false,true};
                        AlertDialog.Builder builder3 = new AlertDialog.Builder(DialogViewActivity.this);
                        builder3.setTitle("请选择你的兴趣").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //
                            }
                        }).show();
                    break;
                case R.id.btn_dialog5:
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(DialogViewActivity.this);
                    View inflate = LayoutInflater.from(DialogViewActivity.this).inflate(R.layout.activity_dialog_login,null);
                    EditText username = inflate.findViewById(R.id.et_username_1);
                    EditText password = inflate.findViewById(R.id.et_password_1);
                    Button button = inflate.findViewById(R.id.login_login_dialog);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            ToastUtil.showMsg(DialogViewActivity.this,"登录事件");
                        }
                    });

                    builder4.setTitle("请登录").setView(inflate)
                            .show();

                    break;

            }
        }
    }
}