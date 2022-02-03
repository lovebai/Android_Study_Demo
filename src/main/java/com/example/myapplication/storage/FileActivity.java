package com.example.myapplication.storage;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.Utils.ToastUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileActivity extends AppCompatActivity {
    private EditText editText;
    private Button button,button1;
    private TextView textView;
    private final String fileName = "test.txt";

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        editText=findViewById(R.id.fl_ed);
        button = findViewById(R.id.fl_btn1);
        button1 = findViewById(R.id.fl_btn2);
        textView = findViewById(R.id.fl_tv);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save(editText.getText().toString());
                ToastUtil.showMsg(FileActivity.this,"保存成功");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(read());
            }
        });
    }
    //存储数据
    private void save(String string){
        FileOutputStream fileOutputStream = null;

        try {
            //内部存储
//            fileOutputStream = openFileOutput(fileName, MODE_PRIVATE);
            //外部存储
            //创建文件夹
            File dir = new File(Environment.getExternalStorageDirectory(), "Download/xiaobai");
            Log.d(null, "save: "+Environment.getExternalStorageDirectory());
            if (!dir.exists()){
                dir.mkdirs();
            }
            Log.i(null, "save: -----"+dir.exists());
            //创建文件
            File file = new File(dir, fileName);
            if (!file.exists()){
                file.createNewFile();
            }
            Log.i(null, "save: ---*--");
            //存储
            fileOutputStream = new FileOutputStream(file);

            fileOutputStream.write(string.getBytes(StandardCharsets.UTF_8));
        }  catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileOutputStream!=null) {
                try {
//                assert fileOutputStream != null;
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }



    //读取数据
    private String read(){
        FileInputStream fileInputStream = null;
        try {
            //内部存储
//            fileInputStream = openFileInput(fileName);
            //外部存储
            File file = new File(Environment.getExternalStorageDirectory().getAbsoluteFile()+File.separator + "Download/xiaobai", fileName);
            fileInputStream = new FileInputStream(file);
            //
            byte[] bytes = new byte[1024];
            StringBuilder builder = new StringBuilder("");
            int len=0;
            while ((len=fileInputStream.read(bytes))>0){
                builder.append(new String(bytes,0,len));
            }
            return builder.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream!=null) {
                try {
//                assert fileInputStream != null;
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }
}