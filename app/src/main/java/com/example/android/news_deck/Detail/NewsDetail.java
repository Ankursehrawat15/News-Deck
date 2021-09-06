package com.example.android.news_deck.Detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.android.news_deck.R;



public class NewsDetail extends AppCompatActivity {

    String title,desc,content,imageUrl ,url;
    private TextView news_title , subDesc , news_content;
    private ImageView img;
    private Button full_article;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_detail);

        title = getIntent().getStringExtra("title");
        desc = getIntent().getStringExtra("description");
        content = getIntent().getStringExtra("content");
        imageUrl = getIntent().getStringExtra("image");
        url = getIntent().getStringExtra("url");

        news_title = findViewById(R.id.news_detail_title);
        subDesc = findViewById(R.id.newsDescribe);
        news_content = findViewById(R.id.newsContent);
        img = findViewById(R.id.news_detail_img);
        full_article = findViewById(R.id.news_detail_btn);

        news_title.setText(title);
        subDesc.setText(desc);
        news_content.setText(content);
        Glide.with(this).load(imageUrl).into(img);

        full_article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

    }
}
