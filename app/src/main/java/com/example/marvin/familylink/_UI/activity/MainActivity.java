package com.example.marvin.familylink._UI.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.marvin.familylink.R;
import com.example.marvin.familylink._UI.adapter.MainFragmentAdapter;
import com.example.marvin.familylink._UI.pager.CirclePageIndicator;
import com.melnykov.fab.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private Context context = MainActivity.this;
    private FragmentPagerAdapter adapter;
    private View mainActionBarView;
    private FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initActionBar();
        initView();
    }

    private void initView() {
        adapter = new MainFragmentAdapter(getSupportFragmentManager(), this);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(adapter);

        CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);

        floatingActionButton =
                (FloatingActionButton) findViewById(R.id.button_floating_action);

    }

    private void initActionBar() {
        ActionBar actionBar = getSupportActionBar();

        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

        mainActionBarView = LayoutInflater.from(this).inflate(
                R.layout.main_action_bar, null);
        TextView nameView = (TextView) mainActionBarView.findViewById(R.id.yochat_name);
        nameView.setText(R.string.app_name);

        actionBar.setCustomView(mainActionBarView);
    }


}
