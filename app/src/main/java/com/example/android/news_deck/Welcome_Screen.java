package com.example.android.news_deck;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Welcome_Screen extends AppCompatActivity {

    TextInputEditText userName;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_screen);

        userName = findViewById(R.id.user_name);
        btn = findViewById(R.id.welcome_btn);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userName.getText().toString().equals("")){
                    Toast.makeText(Welcome_Screen.this, "Enter your Name", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(Welcome_Screen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });



    }
}
