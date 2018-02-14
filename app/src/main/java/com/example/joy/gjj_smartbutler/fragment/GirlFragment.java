package com.example.joy.gjj_smartbutler.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.joy.gjj_smartbutler.R;

/**
 * Created by joy on 2018/2/14.
 * 包名：com.example.joy.gjj_smartbutler.fragment
 * 描述：${CLASS_NAME}
 */

public class GirlFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_girl,null);
        return view;
    }
}
