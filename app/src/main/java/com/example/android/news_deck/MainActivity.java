package com.example.android.news_deck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.news_deck.API.ArticleModel;
import com.example.android.news_deck.Fragments.HomeFragment;
import com.example.android.news_deck.Fragments.PagerAdapter;
import com.example.android.news_deck.RecyclerView.Adapter;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Fragments
    TabLayout tabLayout;
    TabItem home,science,sports,health,tech,entertain;
    PagerAdapter pagerAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // find views in activityMain.xml
        tabLayout = findViewById(R.id.category);
        home = findViewById(R.id.home_tab);
        sports = findViewById(R.id.sports_tab);
        science = findViewById(R.id.science_tab);
        health = findViewById(R.id.health_tab);
        tech = findViewById(R.id.tech_tab);
        entertain = findViewById(R.id.entertain_tab);
        // viewPager in activityMain.xml
        ViewPager viewPager = findViewById(R.id.fragment_container);


        pagerAdapter = new PagerAdapter(getSupportFragmentManager() , 6);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 ||
                        tab.getPosition() == 3 || tab.getPosition() == 4 ||
                        tab.getPosition() == 5){
                    pagerAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));







    }



}