package com.example.joy.gjj_smartbutler.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.joy.gjj_smartbutler.R;

/**
 * Created by joy on 2018/2/14.
 * 包名：com.example.joy.gjj_smartbutler.ui
 * 描述：${CLASS_NAME}
 */

public class SettingActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
    }

    public static void createIntent(Context context){
        context.startActivity(new Intent(context,SettingActivity.class));
    }
}
