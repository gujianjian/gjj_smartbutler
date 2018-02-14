package com.example.joy.gjj_smartbutler;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.joy.gjj_smartbutler.fragment.ButlerFragment;
import com.example.joy.gjj_smartbutler.fragment.GirlFragment;
import com.example.joy.gjj_smartbutler.fragment.UserFragment;
import com.example.joy.gjj_smartbutler.fragment.WechatFragment;
import com.example.joy.gjj_smartbutler.ui.SettingActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private FloatingActionButton fab_setting;

    private List<String> mListTitle;
    private List<Fragment> mListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //去掉actionbar阴影
        getSupportActionBar().setElevation(0);

        initData();
        initView();

    }

    private void initData() {
        mListTitle = new ArrayList<>();
        mListTitle.add(getResources().getString(R.string.string_butler));
        mListTitle.add(getResources().getString(R.string.string_girl));
        mListTitle.add(getResources().getString(R.string.string_wechat));
        mListTitle.add(getResources().getString(R.string.string_user));

        mListFragment = new ArrayList<>();
        mListFragment.add(new ButlerFragment());
        mListFragment.add(new GirlFragment());
        mListFragment.add(new WechatFragment());
        mListFragment.add(new UserFragment());



    }

    private void initView() {
        mTabLayout = findViewById(R.id.mTabLayout);
        mViewPager = findViewById(R.id.mViewPager);
        fab_setting = findViewById(R.id.fab_setting);
        fab_setting.setVisibility(View.GONE);
//        mViewPager.setOffscreenPageLimit(mListFragment.size());

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mListFragment.get(position);
            }

            @Override
            public int getCount() {
                return mListFragment.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mListTitle.get(position);
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //当选项页在第一页的时候隐藏floattinActionBar
                if (position == 0) {
                    fab_setting.setVisibility(View.GONE);
                } else {
                    fab_setting.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mTabLayout.setupWithViewPager(mViewPager);

        fab_setting.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_setting:
                SettingActivity.createIntent(MainActivity.this);
                break;
            default:
                break;
        }
    }
}
