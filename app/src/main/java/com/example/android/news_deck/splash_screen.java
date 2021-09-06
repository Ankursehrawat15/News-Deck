package com.example.android.news_deck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        Thread td = new Thread(){

            public void run(){
                try {
                    sleep(1700);
                }catch (Exception e){
                   e.printStackTrace();
                }finally {
                    Intent intent = new Intent(splash_screen.this , Welcome_Screen.class);
                    startActivity(intent);
                    finish(); // only one time we can see this
                }
            }



        };td.start();

    }
}