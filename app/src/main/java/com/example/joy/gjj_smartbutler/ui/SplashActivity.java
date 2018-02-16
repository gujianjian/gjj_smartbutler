package com.example.joy.gjj_smartbutler.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.joy.gjj_smartbutler.MainActivity;
import com.example.joy.gjj_smartbutler.R;
import com.example.joy.gjj_smartbutler.utils.SharedUtil;
import com.example.joy.gjj_smartbutler.utils.StaticClass;

import java.util.TreeMap;


/**
 * Created by joy on 2018/2/16.
 * 包名：com.example.joy.gjj_smartbutler.ui
 * 描述：${CLASS_NAME}
 */

public class SplashActivity extends AppCompatActivity {

    public  Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case StaticClass.HANDLER_MSG:
                    if(isFirst()){
                        Intent intent = new Intent(SplashActivity.this, GuideActivity.class);
                        startActivity(intent);
                    }else{
                        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    break;
            }
            super.handleMessage(msg);
        }
    };


    private TextView tv_splash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();
        initData();
    }

    private void initView() {
        tv_splash = findViewById(R.id.tv_splash);
    }

    private void initData() {
        //发送延迟，并进入主页面或者导航页
        handler.sendEmptyMessageDelayed(StaticClass.HANDLER_MSG, StaticClass.HANDLER_TIME);
        //设置字体
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/FONT.TTF");
        tv_splash.setTypeface(typeface);
    }


    private boolean isFirst() {
        Boolean is_first = SharedUtil.getBoolean(StaticClass.IS_FIRST, true);
        if(is_first){
            SharedUtil.putBoolean(StaticClass.IS_FIRST,false);
            return true;
        }else{
            return false;
        }

    }
}
