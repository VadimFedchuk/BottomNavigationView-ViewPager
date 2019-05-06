package com.vadimfedchuk1994gmail.bottomnavigationviewpager;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.vadimfedchuk1994gmail.bottomnavigationviewpager.Fragment.Fragment_One;
import com.vadimfedchuk1994gmail.bottomnavigationviewpager.Fragment.Fragment_Two;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    List<Fragment> mFragmentList = new ArrayList<>();
    MenuItem mMenuItem;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentList.add(Fragment_One.newInstance("фрагмент 1"));
        mFragmentList.add(Fragment_Two.newInstance("фрагмент 2"));
        viewPager = findViewById(R.id.main_view_pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int i) {
                return mFragmentList.get(i);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
        });
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.action_exchange:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.action_history:
                        viewPager.setCurrentItem(1);
                }
                return false;
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                if (mMenuItem != null) {
                    mMenuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: " + i);
                bottomNavigationView.getMenu().getItem(i).setChecked(true);
                mMenuItem = bottomNavigationView.getMenu().getItem(i);

            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });
    }
}

