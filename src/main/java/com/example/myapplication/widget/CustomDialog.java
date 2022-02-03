package com.example.myapplication.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;
import com.example.myapplication.Utils.ToastUtil;

public class CustomDialog extends Dialog implements View.OnClickListener {
    private TextView textTitle,textMessage,textCancel,textConfirm;

    private String title,message,cancel,confirm;

    private IOnCancelListener iOnCancelListener;
    private IOnConfirmListener iOnConfirmListener;

    public String getTitle() {
        return title;
    }

    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getCancel() {
        return cancel;
    }

    public CustomDialog setCancel(String cancel,IOnCancelListener iOnCancelListener) {
        this.cancel = cancel;
        this.iOnCancelListener = iOnCancelListener;
        return this;
    }

    public String getConfirm() {
        return confirm;
    }

    public CustomDialog setConfirm(String confirm,IOnConfirmListener iOnConfirmListener) {
        this.confirm = confirm;
        this.iOnConfirmListener = iOnConfirmListener;
        return this;
    }

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CustomDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);
        //设置宽度
        WindowManager manager = getWindow().getWindowManager();
        Display display = manager.getDefaultDisplay();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        Point point = new Point();
        display.getSize(point);
        attributes.width = (int) (point.x*0.8);
        getWindow().setAttributes(attributes);


        textTitle=findViewById(R.id.tv_title);
        textMessage=findViewById(R.id.tv_msg);
        textCancel=findViewById(R.id.tv_cancel);
        textConfirm=findViewById(R.id.tv_ok);
        if (!TextUtils.isEmpty(title)){
            textTitle.setText(title);
        }
        if (!TextUtils.isEmpty(message)){
            textMessage.setText(message);
        }
        if (!TextUtils.isEmpty(cancel)){
            textCancel.setText(cancel);
        }
        if (!TextUtils.isEmpty(confirm)){
            textConfirm.setText(confirm);
        }
        textCancel.setOnClickListener(this);
        textConfirm.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_cancel:
                if (iOnCancelListener!=null){
                    iOnCancelListener.onCancel(this);
                    dismiss();
                }
                break;
            case R.id.tv_ok:
                if (iOnConfirmListener!=null){
                    iOnConfirmListener.onClick(this);
                    dismiss();
                }
                break;
        }
    }

    public interface IOnCancelListener{
        void onCancel(CustomDialog customDialog);

    }    public interface IOnConfirmListener{
        void onClick(CustomDialog customDialog);
    }

}
