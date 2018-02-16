package com.example.joy.gjj_smartbutler.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.joy.gjj_smartbutler.application.BaseApplication;

/**
 * Created by joy on 2018/2/16.
 * 包名：com.example.joy.gjj_smartbutler.utils
 * 描述：${CLASS_NAME}
 */

public class SharedUtil {

    public static SharedPreferences getShared(){
        return BaseApplication.mContext.getSharedPreferences(StaticClass.NAME, Context.MODE_PRIVATE);
    }

    public static void putString(String key, String value){
        getShared().edit().putString(key, value).apply();
    }

    public static String getString(String key,String defValue){
        return getShared().getString(key, defValue);
    }

    public static void putInt(String key, int value) {
        getShared().edit().putInt(key, value).apply();
    }

    public static int getInt(String key,int defInt) {
        return getShared().getInt(key, defInt);
    }

    public static void putBoolean(String key, boolean value) {
        getShared().edit().putBoolean(key,value).apply();
    }

    public static Boolean getBoolean(String key, boolean defValue) {
        return getShared().getBoolean(key, defValue);
    }


    //删除单个
    public static void remove(String key){
        getShared().edit().remove(key).apply();
    }

    //删除全部key
    public static void removeAll(){
        getShared().edit().clear().apply();
    }
}
