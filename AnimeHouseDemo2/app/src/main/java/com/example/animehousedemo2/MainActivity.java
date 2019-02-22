package com.example.animehousedemo2;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //for the tabbar
    PagerAdapter pageAdapter;
    TabLayout tabLayout;
    TabItem tabTop;
    TabItem tabSearch;
    TabItem tabWatch;
    ViewPager viewPager;
    LinearLayout toolbar;
    Button api_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar= findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tablayout);
        tabTop = findViewById(R.id.tabTop);
        tabSearch = findViewById(R.id.tabSearch);
        tabWatch = findViewById(R.id.tabWatch);
        viewPager = findViewById(R.id.viewPager);
        api_btn = (Button) findViewById(R.id.api_btn);

        api_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,the_rest_apis.class);
                startActivity(intent);
            }
        });

        pageAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout = findViewById(R.id.tablayout);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 1) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                            R.color.colorAccent));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                            R.color.colorAccent));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,
                                R.color.colorAccent));
                    }
                } else if (tab.getPosition() == 2) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                            R.color.trying));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                            R.color.trying));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,
                                R.color.trying));
                    }
                } else {
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                            R.color.colorPrimaryDark));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                            R.color.colorPrimaryDark));
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,
                                R.color.colorPrimaryDark));
                    }
                }
            }


            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }

}
